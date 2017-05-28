package uofa.lbirdsey.castle.generator.semanticGroups

import java.util.List
import uofa.lbirdsey.castle.casl.DataTypeDeclaration
import uofa.lbirdsey.castle.casl.Field
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers

class InitializationParametersGenerator {
	
	//<parameter name="randomSeed" displayName="Default Random Seed" type="int" defaultValue="__NULL__" />
	static val basicParam = "<parameter name=\"XXX\" displayName=\"XXX\" type=\"YYY\" defaultValue=\"ZZZ\"/>"	
	static def String generateFile(List<EObject> params){
		var output = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<parameters>\n";		
		output += "<parameter name=\"randomSeed\" displayName=\"Default Random Seed\" type=\"int\" defaultValue=\"__NULL__\" />\n"
		for (paramOld : params){
			var param = paramOld as Field
			if (param.declaration != null){
				var dtd = param.declaration as DataTypeDeclaration;
					var copy = basicParam;
					if (dtd.initInclude != null){
						var type = dtd.type.name;
						var name = dtd.name;
						var initVal = "__NULL__";
						if (dtd.expr !== null){
							initVal = Printers.printExpression(dtd.expr).toString();
						}
						copy = copy.replaceAll("XXX",name.toString()).replaceAll("YYY",type.toString())
						if (type == "string" || initVal == "__NULL__"){
							copy = copy.replaceAll("ZZZ","\""+initVal+"\"");
						} else {
							copy = copy.replaceAll("ZZZ",initVal);
						}
						output += "\t" + copy + "\n";
					}
			}
		}		
		return output+"\n</parameters>";
	}
}