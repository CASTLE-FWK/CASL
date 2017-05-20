package uofa.lbirdsey.castle.generator.semanticGroups;
import java.util.ArrayList;
import uofa.lbirdsey.castle.casl.AbstractElement;
import uofa.lbirdsey.castle.casl.PackageDeclaration;
import uofa.lbirdsey.castle.casl.Type;
import uofa.lbirdsey.castle.casl.PrimitiveType;
import uofa.lbirdsey.castle.casl.Object;
import uofa.lbirdsey.castle.casl.Field;
import uofa.lbirdsey.castle.casl.FunctionParameter;
import uofa.lbirdsey.castle.casl.Function;
import uofa.lbirdsey.castle.casl.Enum;
import uofa.lbirdsey.castle.casl.Import
import java.util.HashSet

class CustomObjectGeneration {
	
	AbstractElement theAbstractElement = null;
	var objsPkg = "";
	var systemRoot = "";
	var fileContents = "";
	var ArrayList<String> libImports = null;
	var HashSet<String> importsToPrint = null;
	
	new(AbstractElement o, String systemRoot, String objsPkg){
		theAbstractElement = o;
		this.systemRoot = systemRoot;
		this.objsPkg = objsPkg;
		libImports = new ArrayList<String>();
		importsToPrint = new HashSet<String>();
	}
	
	def setup(){
		var imports = "//Automated Custom Object Import Generation"
		for (String iC : libImports){
			if (iC !== null){
				//imports += HelperFunctions.parseTypesAsString(iC, systemRoot);
				var str = HelperFunctions.parseTypesAsString(iC, systemRoot);
				var String[] splt = str.split(";");
				for (String s : splt){
					if (s.length() > 0){
						importsToPrint.add(s+";");						
					}	
				}				
			}
		}
		
		for (String iC : importsToPrint){
			imports += iC+"\n";
		}
		fileContents = "package "+objsPkg+";\n\n";
		fileContents += imports +"\n\n"
		fileContents += printLocal() as String;
	}
	def String printLocal(){
		var output = "";
		if (theAbstractElement instanceof PackageDeclaration){
			output = (theAbstractElement as PackageDeclaration).name
		} else if (theAbstractElement instanceof Type){
			var typ = theAbstractElement as Type
			if (typ instanceof PrimitiveType){
				
			} else if (typ instanceof Object) {
				var obj = typ as Object
				output += "import interLib.CASObject;\n\npublic class "+obj.name +" extends CASObject {\n"
				output += "\tpublic " + obj.name+"() {\n"
				output +="\t\tsuper(\""+obj.name+"\");\n"
				output += "\t}\n"
				for (field : obj.fields){
					if (field instanceof Field){
						output += "\tpublic "+HelperFunctions.printFieldDeclarations(field)+";\n"
						output += "\t"+HelperFunctions.generateGettersSetters(field) +"\n"
					} else if (field instanceof Function){
						val func = field as Function
						output  += "\t"
						if (func.returnType != null) {
//							output += (func.returnType as FunctionParameter).type.name
							output += HelperFunctions.inferFunctionParameterType((func.returnType as FunctionParameter))
						} else {
							output += "void"
						}
						output += " "+func.name+"("+HelperFunctions.printFunctionParameters(func.functionParameters)+") {\n"
						for (statement : func.body){
							output += "\t\t"+HelperFunctions.parseBodyElement(statement, func)+"\n"
						}
						if (func.returnType != null) {
							output += "\treturn " + func.returnType.name + "\n"
						} 
						output += "\t}\n"
					}
				}
				output += "\n}"
			} else if (typ instanceof Enum){
				//TODO: How do we handle Enums?
				var obj = typ as Enum
				output += "public class "+obj.name +"_ENUM {\n"
				output += "\tpublic " + obj.name+"_ENUM() {\n"
				output += "\t}\n"
				output += "\tpublic enum "+obj.name +"{\n"
				output += "\t\t"
				for (fi : obj.enum_fields) {
					output += fi.name+","
				}
				
				output = output.substring(0,output.length-1)
				output += "\n\t}"
				output += "\n}"
			}
		} else if (theAbstractElement instanceof Import){
			
		}
		return output
	}
	
	def String print(){
		return fileContents;
	}
	
}