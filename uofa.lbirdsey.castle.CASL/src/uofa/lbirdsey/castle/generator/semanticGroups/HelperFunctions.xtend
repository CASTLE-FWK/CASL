package uofa.lbirdsey.castle.generator.semanticGroups

import java.util.ArrayList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.AdaptiveProcess
import uofa.lbirdsey.castle.casl.Addition
import uofa.lbirdsey.castle.casl.Agent
import uofa.lbirdsey.castle.casl.AgentFieldReference
import uofa.lbirdsey.castle.casl.AgentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.Agent_Call
import uofa.lbirdsey.castle.casl.ArithmeticSigned
import uofa.lbirdsey.castle.casl.Behavior
import uofa.lbirdsey.castle.casl.BooleanExpression
import uofa.lbirdsey.castle.casl.BooleanNegation
import uofa.lbirdsey.castle.casl.BooleanType
import uofa.lbirdsey.castle.casl.CASL_Macro_MetricSwitch
import uofa.lbirdsey.castle.casl.CAS_Rule_Exception
import uofa.lbirdsey.castle.casl.Comparison
import uofa.lbirdsey.castle.casl.DataTypeDeclaration
import uofa.lbirdsey.castle.casl.Entity_Feature
import uofa.lbirdsey.castle.casl.Enum
import uofa.lbirdsey.castle.casl.EnumCallExpr
import uofa.lbirdsey.castle.casl.Environment
import uofa.lbirdsey.castle.casl.EnvironmentFieldReference
import uofa.lbirdsey.castle.casl.Environment_Call
import uofa.lbirdsey.castle.casl.Equals
import uofa.lbirdsey.castle.casl.Expression
import uofa.lbirdsey.castle.casl.FeatureCall
import uofa.lbirdsey.castle.casl.FeatureCallExp
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.FloatType
import uofa.lbirdsey.castle.casl.ForEachLoop
import uofa.lbirdsey.castle.casl.ForLoop
import uofa.lbirdsey.castle.casl.Formula
import uofa.lbirdsey.castle.casl.FunctionCall
import uofa.lbirdsey.castle.casl.FunctionCallExpr
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.Group
import uofa.lbirdsey.castle.casl.GroupFieldReference
import uofa.lbirdsey.castle.casl.GroupInternal
import uofa.lbirdsey.castle.casl.GroupInternalsFeatureCall
import uofa.lbirdsey.castle.casl.Group_Call
import uofa.lbirdsey.castle.casl.Group_Transmission
import uofa.lbirdsey.castle.casl.IfStatement
import uofa.lbirdsey.castle.casl.IntType
import uofa.lbirdsey.castle.casl.Interaction
import uofa.lbirdsey.castle.casl.InteractionFeatureCall
import uofa.lbirdsey.castle.casl.MacroCall
import uofa.lbirdsey.castle.casl.Multiplication
import uofa.lbirdsey.castle.casl.NullTypeLiteral
import uofa.lbirdsey.castle.casl.NumberLiteral
import uofa.lbirdsey.castle.casl.Object
import uofa.lbirdsey.castle.casl.Raw_Java_Block
import uofa.lbirdsey.castle.casl.SelfAssignedFormula
import uofa.lbirdsey.castle.casl.SelfCall
import uofa.lbirdsey.castle.casl.SelfCallExpr
import uofa.lbirdsey.castle.casl.StringLiteral
import uofa.lbirdsey.castle.casl.StringType
import uofa.lbirdsey.castle.casl.Subtraction
import uofa.lbirdsey.castle.casl.Symbol
import uofa.lbirdsey.castle.casl.SystemCallObj
import uofa.lbirdsey.castle.casl.Type
import uofa.lbirdsey.castle.casl.TypeRef
import uofa.lbirdsey.castle.casl.impl.AgentImpl
import uofa.lbirdsey.castle.casl.impl.EnvironmentImpl
import uofa.lbirdsey.castle.casl.impl.GroupImpl
import uofa.lbirdsey.castle.casl.impl.ObjectImpl
import uofa.lbirdsey.castle.casl.impl.SystemImpl

class HelperFunctions {
	static var ArrayList<EObject> types = new ArrayList<EObject>();
	static var systemName = "";
	static def setSystemName(String n){
		systemName = n;
	}
	static val String TAB = '\t';
	static val String NL = '\n';
	static val RETURN_ = "return ";
	static val SC = ';';
	static def initTypesList() {
		types = new ArrayList<EObject>();
	}
	static def addToTypesArray(EObject type) {
		types.add(type);
	}
	
	//There's clearly a better way to do this
	static def String inferMethodType(EList<EObject> body) {
		val finalTerm = body.reverseView.head
		var output = "";
		output = inferGeneralType(finalTerm)
		return output;
	} 
	
	static def inferTypeFromDeclaration(DataTypeDeclaration dtd) {
		var output = "";
		if (dtd.type !== null) {
			output = dtd.type.name;
		} else if (dtd.obj !== null) {
			if (dtd.obj instanceof Object) {
				output = (dtd.obj as Object).name;
			} else {
				output = (dtd.obj as Enum).name;
			}
			if (dtd.useObj !== null){
				output += "<"+dtd.useObj.name+">";
			} else if (dtd.useType !== null){
				output += "<"+dtd.useType.name+">";
			} else if (dtd.useGroup !== null){
				output += "<"+dtd.useGroup.name+">";
			} else if (dtd.useAgent !== null){
				output += "<"+dtd.useAgent.name+">";
			} else if (dtd.useEnv !== null){
				output += "<"+dtd.useEnv.name+">";
			}
		} 
		return output;
	}
	
	static def inferFunctionParameterType(FunctionParameter fp) {
		var output = "";
		if (fp.type !== null) {
			output = fp.type.name
		} else if (fp.obj !== null) {
			if (fp.obj instanceof Object) {
				output = (fp.obj as Object).name;
			} else {
				output = (fp.obj as Enum).name;				
			}
			
			if (fp.useObj !== null){
				output += "<"+fp.useObj.name+">";
			} else if (fp.useType !== null){
				output += "<"+fp.useType.name+">";
			} else if (fp.useGroup !== null){
				output += "<"+fp.useGroup.name+">";
			} else if (fp.useAgent !== null){
				output += "<"+fp.useAgent.name+">";
			} else if (fp.useEnv !== null){
				output += "<"+fp.useEnv.name+">";
			}
		} else if (fp.agent !== null) {
			output = fp.agent.name
		} else if (fp.env !== null) {
			output = fp.env.name
		} else if (fp.grp !== null) {
			output = fp.grp.name
		}
		return output;
	}
	

	
	static def inferExpressionType(Expression expr) {
		var output = ""
		if (expr instanceof Expression) { //is this needed, feels redundant
			if (expr instanceof SelfCallExpr) {
				output = "selfcall"
				var sce = (expr as SelfCallExpr).selfCall;
				if (sce.ref !== null) {					
					output = inferSymbolType(sce.ref) //????
				} else if (sce.fc !== null) {
					if (sce.fc.func.returnType !== null){
						output = inferSymbolType(sce.fc.func.returnType);
					} else {
						output = "void"
					}
				} else if (sce.fec !== null) {
					if (sce.fec instanceof InteractionFeatureCall) {
						output = ""+HelperFunctions.inferMethodType( ((expr as FeatureCallExp).func as InteractionFeatureCall).process.body) 
					} else {
						output = "void"
					}
				}
			} else if (expr instanceof NumberLiteral)
				output = "float"
			else if (expr instanceof BooleanType)
				output = "bool"
			else if (expr instanceof SystemCallObj)
				output = "systemcall" //TODO
			else if (expr instanceof StringLiteral)
				output = "string"
			else if (expr instanceof TypeRef)			
				output = inferSymbolType((expr as TypeRef).type)
			else if (expr instanceof FeatureCallExp)
				output = FeatureCallGenerator.inferFeatureCallType(expr as FeatureCallExp)
			else if (expr instanceof IfStatement)
				output = inferIfStatementReturnType(expr as IfStatement)	
			else if (expr instanceof BooleanExpression)
				output = "andor"
			else if (expr instanceof Comparison)
				output = "comparison"
			else if (expr instanceof Equals)
				output = "equals"
			else if (expr instanceof Addition)
				output = "addition"
			else if (expr instanceof Subtraction)
				output = "subtraction"
			else if (expr instanceof Multiplication)
				output = "multi"
			else if (expr instanceof BooleanNegation)
				output = "boolean"
			else if (expr instanceof ArithmeticSigned)
				output = "arithmeticsigned"
			else if (expr instanceof MacroCall)
				output = MacroGenerator.macroCallReturnType(expr as MacroCall)
			else 
				output = "void"
			}
			return output
	}
	
		static def String inferGeneralType(EObject eobj){
		var output = "";
		if (eobj instanceof Field) {
			val ftf = eobj as Field
			if (ftf.declaration !== null) {
				output = inferTypeFromDeclaration(ftf.declaration as DataTypeDeclaration);
			} else if (ftf.agentFieldRef !== null) {
				output = (ftf.agentFieldRef as AgentFieldReference).agent.name
			} else if (ftf.envFieldRef !== null) {
				output = (ftf.envFieldRef as EnvironmentFieldReference).env.name
			}
		} else if (eobj instanceof Formula) {
			val ftf = eobj as Formula
			if (ftf.sym instanceof AgentFieldReference) {
				output = (ftf.sym as AgentFieldReference).agent.name;
			} else if (ftf.sym instanceof EnvironmentFieldReference) {
				output = (ftf.sym as EnvironmentFieldReference).env.name;
			} else if (ftf.sym instanceof DataTypeDeclaration) {
				var dtd = ftf.sym as DataTypeDeclaration
				output = inferTypeFromDeclaration(dtd as DataTypeDeclaration);
			} else if (ftf.sym instanceof FunctionParameter) {
				var fp = ftf.sym as FunctionParameter
				output = inferFunctionParameterType(fp);
			}
		} else if (eobj instanceof SelfAssignedFormula) {
			val ftf = eobj as SelfAssignedFormula
			if (ftf.ref instanceof AgentFieldReference) {
				output = (ftf.ref as AgentFieldReference).agent.name;
			} else if (ftf.ref instanceof EnvironmentFieldReference) {
				output = (ftf.ref as EnvironmentFieldReference).env.name;
			} else if (ftf.ref instanceof DataTypeDeclaration) {
				var dtd = ftf.ref as DataTypeDeclaration
				output = inferTypeFromDeclaration(dtd as DataTypeDeclaration);
			} else if (ftf.ref instanceof FunctionParameter) {
				var fp = ftf.ref as FunctionParameter
				output = inferFunctionParameterType(fp);
			}
		} else if (eobj instanceof FunctionCall) {
			if ((eobj as FunctionCall).func.returnType !== null){
				output = inferSymbolType((eobj as FunctionCall).func.returnType)
			} else {
				output = "void"
			} 
		} else if (eobj instanceof FeatureCallExp){
			output = FeatureCallGenerator.inferFeatureCallType(eobj as FeatureCallExp);			
		} else if (eobj instanceof Expression) {
			output = inferExpressionType(eobj as Expression)
		} else if (eobj instanceof Enum) {
			output = (eobj as Enum).name
		} else if (eobj instanceof SelfCall) {
			output = "selfcall"
		} else {
			output = "void"
		}
		return output;
	}
	
	static def String inferIfStatementReturnType(IfStatement ifstate) {
		val finalTerm = ifstate.then.reverseView.head
		var returnType = inferGeneralType(finalTerm);
		var output = "";
		output = returnType;
		if (ifstate.elseifexpr !== null) {
			for (elseif : ifstate.elseifexpr) {
				var tmpReturn = inferGeneralType(elseif.elseifthen.reverseView.head)
				if (tmpReturn.compareTo(returnType) != 0 && returnType.length == 0){
					output = returnType+"_ERROR"
				} else {
					returnType = tmpReturn;
				}
			}
		}
		if (ifstate.elseexp !== null) {
			var tmpReturn = inferGeneralType(ifstate.elseexp.reverseView.head)
			if (tmpReturn.compareTo(returnType) != 0  && returnType.length == 0){
				output = returnType+"_ERROR"
			} else {
				returnType = tmpReturn;
			}
		}
		return output;
	}
	
	static def parseBodyElement(EObject statement, Entity_Feature caller) {
		var strOut = "";
		if (statement instanceof Field) {
			strOut += printFieldDeclarations(statement as Field)+";"
		} else if (statement instanceof FunctionCall) {
			var st = statement as FunctionCall;
			if (st.func !== null) {
				strOut += (statement as FunctionCall).func.name + "(THINGS TO PASS)"			
			} else if (st.fields !== null) {
				//do something else
			}
		} else if (statement instanceof MacroCall){
			val mc = (statement as MacroCall).macroCall.macro;
			if (mc instanceof CASL_Macro_MetricSwitch)	
				strOut += metric_ToOutput(caller);
		} else if (statement instanceof Expression) {
			strOut += printExpression(statement as Expression)
		} else if (statement instanceof Formula) {
			strOut += HelperFunctions.printFormula((statement as Formula))
		} else if (statement instanceof SelfAssignedFormula) {
			strOut += HelperFunctions.printSelfAssignedFormula((statement as SelfAssignedFormula))
		} else if (statement instanceof Raw_Java_Block) {
			strOut += "//Raw Java Block: "+(statement as Raw_Java_Block).name+"\n {"
			for (rawJava : (statement as Raw_Java_Block).rawStatements) {
				strOut += rawJava.toString +"\n"
			}
			strOut += "}"			
		} else {
			strOut += "ERROR WITH BODY ELEMENT"
		}
		return (strOut + ";");	
	}


	static def printFunctionParameter (FunctionParameter fp) {
		return inferFunctionParameterType(fp) + " "+fp.name;
	}
		
	static def String printFunctionParameters(EList<Symbol> fps) {
		val parameterSize = fps.size
		var strOut = "";
		if (parameterSize == 0) {
			return ""
		} else {
			for (i : 0 ..< parameterSize -1) {
				strOut += printFunctionParameter(fps.get(i) as FunctionParameter)+", "							
			}
			strOut += printFunctionParameter(fps.get(parameterSize-1) as FunctionParameter)
			return strOut
		}		
	}
	
	static def String printRuleExceptionArgs(EList<CAS_Rule_Exception> ruleArgs) {
		val parameterSize = ruleArgs.size
		var strOut = "";
		if (parameterSize == 0) {
			return ""
		} else {
			for (i : 0 ..< parameterSize -1) {
				strOut += "CAS_Rule_Exception."+(ruleArgs.get(i) as CAS_Rule_Exception).toString.toUpperCase+', '				
			}	

			strOut += "CAS_Rule_Exception."+(ruleArgs.get(parameterSize - 1) as CAS_Rule_Exception).toString.toUpperCase
			return strOut
		}
	}
	
	static def String printFunctionArgs(EList<Expression> far) {
		val parameterSize = far.size
		var strOut = "";
		if (parameterSize == 0) {
			return ""
		} else {
			for (i : 0 ..< parameterSize -1) {
				strOut += printExpression(far.get(i) as Expression)+", "			
			}
			strOut += printExpression(far.get(parameterSize-1) as Expression)
			return strOut
		}	
	}

	static def printExpression(EObject expr) {
		if (expr instanceof Expression) { //is this needed, feels redundant
			if (expr instanceof SelfCallExpr)
				return HelperFunctions.printSelfCall(expr as SelfCallExpr)
			else if (expr instanceof NumberLiteral)
				return (expr as NumberLiteral).value
			else if (expr instanceof BooleanType)
				return (expr as BooleanType).bool
			else if (expr instanceof SystemCallObj)
				return systemName+".get"+((expr as SystemCallObj).sysCall.call.toFirstUpper)+"()"
			else if (expr instanceof StringLiteral)
				return "\""+(expr as StringLiteral).value+"\""
			else if (expr instanceof TypeRef)
				return (expr as TypeRef).type.name
			else if (expr instanceof FeatureCallExp)
				return FeatureCallGenerator.printFeatureCall((expr as FeatureCallExp).func)
			else if (expr instanceof IfStatement)
				return printIfStatement((expr as IfStatement))	
			else if (expr instanceof BooleanExpression)
				'''«printExpression((expr as BooleanExpression).left)» «(expr as BooleanExpression).op» «printExpression((expr as BooleanExpression).right)»'''
			else if (expr instanceof Comparison)
				'''«printExpression((expr as Comparison).left)» «(expr as Comparison).op» «printExpression((expr as Comparison).right)»'''
			else if (expr instanceof Equals)
				'''«printExpression((expr as Equals).left)» == «printExpression((expr as Equals).right)»'''
			else if (expr instanceof Addition)
				'''«printExpression((expr as Addition).left)» «(expr as Addition).op» «printExpression((expr as Addition).right)»'''
			else if (expr instanceof Subtraction)
				'''«printExpression((expr as Subtraction).left)» «(expr as Subtraction).op» «printExpression((expr as Subtraction).right)»'''	
			else if (expr instanceof Multiplication)
				'''«printExpression((expr as Multiplication).left)» «(expr as Multiplication).op» «printExpression((expr as Multiplication).right)»'''
			else if (expr instanceof BooleanNegation)
				'''!«printExpression((expr as BooleanNegation).expression)»'''
			else if (expr instanceof ArithmeticSigned)
				'''-«printExpression((expr as ArithmeticSigned).expression)»'''
			else if (expr instanceof MacroCall)
				return MacroGenerator.parseMacro((expr as MacroCall), null)
			else if (expr instanceof NullTypeLiteral)
				return "null"
			else if (expr instanceof FunctionCallExpr)
				return HelperFunctions.printFunctionCall((expr as FunctionCallExpr).funcCall)
			else if (expr instanceof EnumCallExpr)
				'''«(expr as EnumCallExpr).enumCall.en.name».«(expr as EnumCallExpr).enumCall.entype.name»'''
			else if (expr instanceof Agent_Call)
				return (expr as Agent_Call).agentCall.agent.name+".class"
			else if (expr instanceof Environment_Call)
				return (expr as Environment_Call).env.name+".class"
			else if (expr instanceof Group_Call)
				return (expr as Group_Call).groupCall.grp.name+".class"
			else if (expr instanceof ForLoop)
				return printForLoop((expr as ForLoop))
			else if (expr instanceof ForEachLoop)
				return printForEachLoop((expr as ForEachLoop))
			else '''ERROR: Unknown expression''' 
		} 
	}

	static def printExpression(Expression expr, String name) {
		if (expr instanceof MacroCall)
			'''«MacroGenerator.parseMacro((expr as MacroCall), name)»'''
		else
			printExpression(expr)
	}		
	
	static def printFormula(Formula formula) {
		var strOut = "";
		strOut += formula.sym.name
		if (formula.objField !== null) {
			strOut += "."+formula.objField.name
		} 
		strOut += " = "+printExpression(formula.expr)
		return strOut;
	}
	
	static def printSelfAssignedFormula(SelfAssignedFormula saf) {
		var strOut = "";
		strOut += "this."+saf.ref.name;
		if (saf.objField !== null) {
			strOut += "."+saf.objField.name
		}
		strOut += " = "+printExpression(saf.expr)
		return strOut;
	}
	
	static def printSelfCall(SelfCallExpr sce) {
		val sc = sce.selfCall
		var output = "this"
		if (sc.fc !== null) {
			output += "."+HelperFunctions.printFunctionCall(sc.fc)
		} else if (sc.ref !== null) {
			output += "."+ sc.ref.name
		} else if (sc.fec !== null) {
			output += "."+FeatureCallGenerator.printFeatureCall(sc.fec)
		}
		return output
	}
	
	static def printFunctionCall(FunctionCall fc) { 
		var output = "";
		output += fc.obj.name
		if (fc.func !== null) {
			output += "."+fc.func.name
			output +="("+printFunctionArgs(fc.inputs) +")"
		} else if (fc.fields !== null) {
			for (fields : fc.fields) {
				output += "."+fields.name
			}
		}		
		return output
	}
	
	//TODO: 23/06/16: I think the dynamic import problem lies in here
	static def inferSymbolType(Symbol sym) {
		var output = "";
		if (sym instanceof AgentFieldReference) {
			output = "sym=afr"
		} else if (sym instanceof EnvironmentFieldReference) {
			output = "sym=efr"
		} else if (sym instanceof FunctionParameter) {
			var fp = sym as FunctionParameter;
			output = inferFunctionParameterType(fp);
		} else if (sym instanceof DataTypeDeclaration) {
			var dtd = sym as DataTypeDeclaration;
			output = inferTypeFromDeclaration(dtd);
		}
		return output;
	}
	
	static def String getFieldType(Field f) {
		//Prints out the type, var name
		var String output = "";		
		if (f.declaration !== null) {
			val fdt = f.declaration as DataTypeDeclaration
			if (fdt.obj !== null) {
				if (fdt.obj instanceof Enum) {
					if ((fdt.obj as Enum).custom !== null){
						output = "CUSTOM:";
					}
					if (fdt.useObj !== null) {
						output += "Enums."+fdt.obj.name;
					} else {
						output += "Enums."+fdt.obj.name;	
					}									
				} else if (fdt.obj instanceof Object) {
					if ((fdt.obj as Object).custom !== null){
						output = "CUSTOM:";
					}
					if (fdt.useObj !== null) {
						output += fdt.obj.name+"<"+fdt.useObj.name+">"
					} else if (fdt.useGroup !== null) {
						output += fdt.obj.name+"<"+fdt.useGroup.name.toFirstUpper+">"
					} else if (fdt.useAgent !== null) {
						output += fdt.obj.name+"<"+fdt.useAgent.name.toFirstUpper+">"
					} else if (fdt.useEnv !== null) {
						output += fdt.obj.name+"<"+fdt.useEnv.name.toFirstUpper+">"
					} else {
						output += fdt.obj.name	
					}	
				}
			} else if (fdt.type !== null){
				output += fdt.type.name
			}
		} else if (f.agentFieldRef !== null) {
			val afr = f.agentFieldRef as AgentFieldReference		
				output = "agents."+afr.agent.name.toFirstUpper
		} else if (f.envFieldRef !== null) {
			val efr = f.envFieldRef as EnvironmentFieldReference
			output = "environments."+efr.env.name.toFirstUpper		
		} else if (f.grpFieldRef !== null) {
			val gfr = f.grpFieldRef as GroupFieldReference
			output = "groups."+gfr.grp.name.toFirstUpper
		}
		return output;
	}
	
	static def printFieldDeclarations(Field f) {
		//Prints out the type, var name and expression if it has one.
		var output = "";		
		if (f.declaration !== null) {
			val fdt = f.declaration as DataTypeDeclaration
			if (fdt.type !== null) {
				if (fdt.expr !== null) {
					output += fdt.type.name +" "+fdt.name+" = "+printExpression(fdt.expr,fdt.name)
				} else { 
					if (fdt.type.name.compareTo(StringType.name) == 0) {
						output += fdt.type.name+" "+fdt.name+" = \"\""
					} else {
						output += fdt.type.name+" "+fdt.name
					}
				}
			} else if (fdt.obj !== null) {
				if (fdt.obj instanceof Enum) {
					if (fdt.expr !== null) {
						output += fdt.obj.name+" "+fdt.name+" = "+printExpression(fdt.expr,fdt.name)
					} else {
						if (fdt.useObj !== null) {
							output += fdt.obj.name+"<"+fdt.useObj.name+"> "+fdt.name+" = new "+fdt.obj.name+"<"+fdt.useObj.name+">()"
						} else {
							output += fdt.obj.name+" "+fdt.name	
						}									
					}
				} else if (fdt.obj instanceof Object) {
					if (fdt.expr !== null) {
						if (fdt.useObj !== null) {
							output += fdt.obj.name+"<"+fdt.useObj.name+"> "+fdt.name+" = "+printExpression(fdt.expr,fdt.name)
						} else if (fdt.useGroup !== null) {
							output += fdt.obj.name+"<"+fdt.useGroup.name.toFirstUpper+"> "+fdt.name+" = "+printExpression(fdt.expr,fdt.name)
						} else if (fdt.useAgent !== null) {
							output += fdt.obj.name+"<"+fdt.useAgent.name.toFirstUpper+"> "+fdt.name+" = "+printExpression(fdt.expr,fdt.name) 
						} else if (fdt.useEnv !== null) {
							output += fdt.obj.name+"<"+fdt.useEnv.name.toFirstUpper+"> "+fdt.name+" = "+printExpression(fdt.expr,fdt.name)
						} else {
							output += fdt.obj.name+" "+fdt.name+" = "+printExpression(fdt.expr,fdt.name)
						}
					} else {
						if (fdt.useObj !== null) {
							output += fdt.obj.name+"<"+fdt.useObj.name+"> "+fdt.name+" = new "+fdt.obj.name+"<"+fdt.useObj.name+">()"
						} else if (fdt.useGroup !== null) {
							output += fdt.obj.name+"<"+fdt.useGroup.name.toFirstUpper+"> "+fdt.name+" = new " + fdt.obj.name+"<"+fdt.useGroup.name.toFirstUpper+">()"
						} else if (fdt.useAgent !== null) {
							output += fdt.obj.name+"<"+fdt.useAgent.name.toFirstUpper+"> "+fdt.name+" = new " + fdt.obj.name+"<"+fdt.useAgent.name.toFirstUpper+">()"
						} else if (fdt.useEnv !== null) {
							output += fdt.obj.name+"<"+fdt.useEnv.name.toFirstUpper+"> "+fdt.name+" = new " + fdt.obj.name+"<"+fdt.useEnv.name.toFirstUpper+">()"
						} else {
							output += fdt.obj.name+" "+fdt.name+" = new "+fdt.obj.name+"()"	
						}									
					}
				}
			}
		} else if (f.agentFieldRef !== null) {
			val afr = f.agentFieldRef as AgentFieldReference		
				output += afr.agent.name.toFirstUpper+" "+afr.name
				if (afr.assignment !== null) {
					output += " = "+printExpression(afr.assignment)
				}
				output += ";"
		} else if (f.envFieldRef !== null) {
			val efr = f.envFieldRef as EnvironmentFieldReference
			output += efr.env.name.toFirstUpper + " "+ efr.name
			if (efr.assignment !== null) {
					output += " = "+printExpression(efr.assignment)
			}
			output += ";"			
		} else if (f.grpFieldRef !== null) {
			val gfr = f.grpFieldRef as GroupFieldReference
			output += gfr.grp.name.toFirstUpper + " "+gfr.name
			if (gfr.assignment !== null) {
				output += " = "+printExpression(gfr.assignment)
			}
			output += ";"
		}
	}

	//TODO: Indentation levels are wrong
	static def String printIfStatement(IfStatement iff, int depth, boolean returns) {
		var output = "";
		var TABS = TAB;		
		for (var i = 0; i < depth; i++){
			TABS += TAB;
		}
		output += "if (" + printExpression(iff.condition) +") {\n"
		for (i : 0 ..< iff.then.size()){
			var obj = iff.then.get(i);
			if (returns && i == (iff.then.size() -1)){
				//Condition that this can happen
				//Check for IfStatement or ForLoop
				if (obj instanceof IfStatement){
					output += TABS+printIfStatement(obj as IfStatement, depth+1, true);
				} else {
					output += TABS+"return "+autoPrinter(obj)+SC+NL; 
				}
				
			} else {
				output +=  TABS+autoPrinter(obj)+SC+NL;	
			}
			
		}
		output += "}"
		if (iff.elseifexpr !== null) {
			for (cond : iff.elseifexpr) {
				output += " else if (" + printExpression(cond.elseifCond) +") {\n"
				for (i : 0 ..< cond.elseifthen.size()){
					var obj = cond.elseifthen.get(i);
					if (returns && i == (cond.elseifthen.size() -1)){
						//Condition that this can happen
						if (obj instanceof IfStatement){
							output += TABS+printIfStatement(obj as IfStatement, depth+1, true);
						} else {
							output += TABS+"return "+autoPrinter(obj)+SC+NL;
						}
					} else {
						output +=  TABS+autoPrinter(obj)+SC+NL;	
					}
					
				}
				output += TABS+'}'
			}
		}
		
		if (!iff.elseexp.isEmpty) {
			output += " else {\n"
			for (i : 0 ..< iff.elseexp.size()){
					var obj = iff.elseexp.get(i);
					if (returns && i == (iff.elseexp.size() -1)){
						if (obj instanceof IfStatement){
							output += printIfStatement(obj as IfStatement, depth+1,true);
						} else {
							output += TABS+"return "+autoPrinter(obj)+SC+NL;
						}
					} else {
						output +=  TABS+autoPrinter(obj)+SC+NL;	
					}
				}
			output += "}"
		}		
		return output;
	}
	
	static def printIfStatement(IfStatement is){
		return printIfStatement(is, 1, false);
	}
	
	static def String autoPrinter(EObject expr){
		if (expr instanceof Expression) {
			return printExpression(expr).toString();		
		} else if (expr instanceof Formula) {
			return HelperFunctions.printFormula(expr as Formula);
		} else if (expr instanceof SelfAssignedFormula) {
			return HelperFunctions.printSelfAssignedFormula(expr as SelfAssignedFormula)
		} else if (expr instanceof Field) {
			return printFieldDeclarations(expr as Field);
		} else {
			return expr.toString();
		}
	}
	
	static def String printForLoop(ForLoop loop) {
		var output = "";
		output += "for ("+autoPrinter(loop.init)+"; "+printExpression(loop.condition)+";"+
			autoPrinter(loop.shifter)+") {\n"
		for (expr : loop.body) {
			output += "\t\t"+autoPrinter(expr)+";\n"
		} 
//		output += "\t\t"+autoPrinter(loop.shifter)+";\n}\n" //20/05/17: why are you printing the shifter again here?
		output += "\t\t\n}\n"
		return output;
	}
	
	static def String printForEachLoop(ForEachLoop loop) {
		var output = "";
		output += "for ("+loop.ty +' '+loop.item.name+" : "+printExpression(loop.list)+") {\n"
		for (expr : loop.body) {
			output += "\t\t"+autoPrinter(expr)+";\n"
		} 
		output += "\t}\n"
		return output;
	}
	
	static def String newLine() {
		return "\n";
	}
	
	//TODO: Ahh crap
	static def getSymbolType(Symbol t) {		
		if (t instanceof Field) {
			return getFieldType(t as Field);
		} else {
			val fp = t as FunctionParameter
			if (fp.obj !== null) {
				if (fp.obj instanceof Object) {
					return fp.obj.name	
				} else if (fp.obj instanceof Enum) {
					return "Enums."+fp.obj.name	
				}
			} else if (fp.agent !== null) {
				return fp.agent.name;
			} else if (fp.env !== null) {
				return fp.env.name;
			} else if (fp.grp !== null) {
				return fp.grp.name;
			} 
		}
	}
	
	static def generateGettersSetters(Field field) { 
		var output = "";
		if (field.declaration !== null) {
			var fiedecl = field.declaration as DataTypeDeclaration;
			if (fiedecl.initInclude != null){
				output += "public static void set"+fiedecl.name.toFirstUpper+"("	
			} else {
				output += "public void set"+fiedecl.name.toFirstUpper+"("
			}			
			if (fiedecl.type !== null) {
				output += fiedecl.type.name
			} else if (fiedecl.obj !== null) {
				if (fiedecl.obj instanceof Object) {
					var npt = fiedecl.obj as Object 
					output += npt.name
					if (fiedecl.useObj !== null) {
						output += "<"+fiedecl.useObj.name+">"
					} else if (fiedecl.useType !== null) {
						output += "<"+fiedecl.useType.name+">"
					} else if (fiedecl.useGroup !== null) {
						output += "<"+fiedecl.useGroup.name+">"
					} else if (fiedecl.useAgent !== null) {
						output += "<"+fiedecl.useAgent.name+">"
					} else if (fiedecl.useEnv !== null) {
						output += "<"+fiedecl.useEnv.name+">"
					}
					
				} else if (fiedecl.obj instanceof Enum) {
					output += fiedecl.obj.name
				}
			}
			
			if (fiedecl.initInclude != null){
				output += " "+fiedecl.name+"_) {\n\t"+fiedecl.name +" = "+fiedecl.name+"_;\n}\n"
				output += "public static "
				
			} else {
				output += " "+fiedecl.name+"_) {\n\tthis."+fiedecl.name +" = "+fiedecl.name+"_;\n}\n"
				output += "public "
				
			}
			if (fiedecl.type !== null) {
				output += fiedecl.type.name
			} else if (fiedecl.obj !== null) {
				if (fiedecl.obj instanceof Object) {
					var npt = fiedecl.obj as Object 
					output += npt.name
					if (fiedecl.useObj !== null) {
						output += "<"+fiedecl.useObj.name+">"
					} else if (fiedecl.useType !== null) {
						output += "<"+fiedecl.useType.name+">"
					} else if (fiedecl.useGroup !== null) {
						output += "<"+fiedecl.useGroup.name+">"
					} else if (fiedecl.useAgent !== null) {
						output += "<"+fiedecl.useAgent.name+">"
					} else if (fiedecl.useEnv !== null) {
						output += "<"+fiedecl.useEnv.name+">"
					}					
				} else if (fiedecl.obj instanceof Enum) {
					output += fiedecl.obj.name					
				}
			} 
			if (fiedecl.initInclude != null){
				output += " get"+fiedecl.name.toFirstUpper+"() {\n\treturn "+fiedecl.name+";\n}\n"
			} else {
				output += " get"+fiedecl.name.toFirstUpper+"() {\n\treturn this."+fiedecl.name+";\n}\n"
			}
						
					
		} else if (field.agentFieldRef !== null) {
			var fieagent = field.agentFieldRef as AgentFieldReference
			output += "public void set"+fieagent.name.toFirstUpper+"("+fieagent.agent.name+" "+fieagent.name+")" 
			output += "{\n\t\tthis."+fieagent.name+" = "+fieagent.name+";\n}\n"			
			output += "public "+fieagent.agent.name+" get"+fieagent.name.toFirstUpper+"() {\n\treturn this."+fieagent.name+";\n}\n"
		} else if (field.envFieldRef !== null) {
			var fieenv = field.envFieldRef as EnvironmentFieldReference
			output += "public void set"+fieenv.name.toFirstUpper+"("+fieenv.env.name+" "+fieenv.name+") {\n\t\tthis."+fieenv.name+" = "+fieenv.name+";\n}\n"
			output += "public "+fieenv.env.name+" get"+fieenv.name.toFirstUpper+"() {\n\treturn this."+fieenv.name+";\n}\n"	
		}
		return output;
	}

	//TODO: Determine what type of THING a string is
	//22/06/16: what does this actually do?
	//23/06/16: I know what this does and I'm making it better
	static def locateType(String candidate) {
		for (EObject type : types) {
//			var String str = "";
//			if (type.contains('.')) {
//				str = type.split("\\.").get(1).trim();			
//			} else {
//				str = type;
//			}
			if (type instanceof Type){
				var tat = type as Type;
				if (tat instanceof Object){
					if ((tat as Object).custom !== null){
						if ((type as Type).name.compareToIgnoreCase(candidate) == 0) {
							return "CUSTOM:"+type.name;
						}
					}
				}
				if ((type as Type).name.compareToIgnoreCase(candidate) == 0) {
					return type.name;
				}
			} else if (type instanceof Agent){
				if ((type as Agent).name.compareToIgnoreCase(candidate) == 0) {
					return "agents."+type.name;
				}
			} else if (type instanceof Environment){
				if ((type as Environment).name.compareToIgnoreCase(candidate) == 0) {
					return "environments."+type.name;
				}
			} else if (type instanceof Group){
				if ((type as Group).name.compareToIgnoreCase(candidate) == 0) {
					return "groups."+type.name;
				}
			}			
		}
		return "TYPE NOT FOUND: "+candidate;
	}
	
	//Order of precedence is super important here...
	static def String parseTypesAsString(String iC, String systemRoot) {
		var output = "";
		//We have to handle a lot of accidental importing here. Should re-work this. Will just do lazy things instead.
		if (iC.contains("List")){
			//Ignore
			output = "import java.util.List;"
			return output;
		}
		if (iC.contains("LayoutParameters")){
			return output
		}
		
		if (iC.startsWith("agents.") || iC.startsWith("groups.") || iC.startsWith("environments.")) {
				output += "import "+systemRoot+"."+iC+";";
		} else if (iC.startsWith("CUSTOM:")){
			var object = iC.split(":").get(1);
			if (object.startsWith("Enums")){
				output += "import "+systemRoot+"."+object+";";	
			} else {
				output += "import "+systemRoot+".objects."+object+";";
			}				
		} else if (iC.contains("<")) {
			var typeBegin = iC.indexOf('<');
			output += "import castleComponents.objects."+iC.substring(0,typeBegin) + ";"				
			var typeEnd = iC.indexOf('>');
			output += HelperFunctions.parseTypesAsString( locateType(iC.substring(typeBegin+1, typeEnd)), systemRoot);
		} else if (iC.startsWith("Enums.")) { 
			output += "import castleComponents."+iC+";"
		} else if (iC.startsWith("int") || (iC.startsWith("bool") || (iC.startsWith("float")))){
			output = "";
		}  else if (iC.length() > 0) {
			output += "import castleComponents.objects."+iC+";";
		}
		return output;
	}

	//TODO: HERE 22/06/16
	static def String parseTypesAsType(EObject iC, String systemRoot) {
		var output = "";
		//1: Figure out what type iC is (ag/gr/en, object, enum, primitive, unknown)
//		if (iC instanceof Field){
//			var ss = getFieldType(iC);
//		}
		var ss = getFieldType(iC as Field);
		//2: Figure out if its part of standard library or custom
		
		
//		var owner = determineOwner(iC);
		println("testing: " + ss);
		
		return output;
	}
	
	//Generate correct new statements
	static def String initialiseFunctionParameterReturn(FunctionParameter fp){
		if (fp.type !== null) {
			if (fp.type instanceof IntType){
				return "-0";
			} else if (fp.type instanceof FloatType){
				return "-0.0";
			} else if (fp.type instanceof BooleanType){
				return "false";
			} else if (fp.type instanceof StringType){
				return "";
			}
		} else if (fp.obj !== null) {
			return "null";
		}
	}
	
	//Walk up
	static def String determineOwner(EObject eo){
		if (eo instanceof AgentImpl){
			return (eo as AgentImpl).name
		} else if (eo instanceof GroupImpl){
			return (eo as GroupImpl).name
		} else if (eo instanceof EnvironmentImpl){
			return (eo as EnvironmentImpl).name
		} else if (eo instanceof SystemImpl) {
			return (eo as SystemImpl).name
		} else {
			return determineOwner(eo.eContainer);
		}
	}
	
	//Find out what type the EObject is
	static def String determineEntityType(EObject eo){
		if (eo instanceof AgentImpl){
			return "agent";
		} else if (eo instanceof GroupImpl){
			return "group";
		} else if (eo instanceof EnvironmentImpl){
			return "environment";
		} else if (eo instanceof SystemImpl) {
			return "system";
		} else if (eo instanceof ObjectImpl){
			return "object"
		} else {
			return "ERROR 3"
		}
	}	
	
	//Pointless consistent print
	static def String getNameForTrigger(String s){
		return s+"_Trigger";
	}
	
	
	
	static def String metric_ToOutput(Entity_Feature ef) {
		var output = "";
		//Determine type of EF
		if (ef instanceof Interaction){
			//0: Is it from or is it to? COMMUNICATE or QUERY			
			val in = ef as Interaction
			val interType = in.interaction_type;
			//1: Build a list of entities that are mentioned (e.g. parameters, things in the body)
			//2: Pull out all Entities
			//3: Set interactionTo for each of them
			//4: For the recipient, set to interactionFrom

			//1: Function parameters
			for (p : in.functionParameters){
				//Function parameters
				val fp = p as FunctionParameter
				if (fp.agent !== null || fp.env !== null || fp.grp !== null) {
					output += "interactionTo("+fp.name+", \""+ in.name+"\");"  
				}
			}
			
			//1: Body
			//If the body element contains an interaction call of some type, then is should be listed
			//A body can have a Field, Expression, Formula, or SelfAssignmentFormula
			//TODO: NEED TO CONTINUE THIS BUT I HAVE TO CHANGE THE COMPARISON TEST FIRST
			for (b : in.body){
				if (b instanceof Expression){
//					val be = b as Expression
					println(b);
					if ((inferExpressionType(b).compareToIgnoreCase = "featurecallexp") == 0){
						val fc = (b as FeatureCall).fc
						if (fc instanceof AgentInteractionFeatureCall){
							println("AIFC")
						} else if (fc instanceof GroupInternalsFeatureCall){
							println("GIFC")
						}
					}				
				}				
			}
			
		} else if (ef instanceof Behavior) {
			//Get list of all parameters and called updateParameter on each of them
			val be = ef as Behavior;
			for (beb : be.body){
				
			}
		} else if (ef instanceof AdaptiveProcess) {
			
		} else if (ef instanceof Group_Transmission) {
			
		} else if (ef instanceof GroupInternal) {
			
		}
		
		
		return output;
	}
	
	
	//********For phase assignments
	
	//Behaviors
	
	//Interactions
	
	//Transmissions 
	
	//Useful for debugging
	static def String debug_PrintBehavior(Behavior b){
		return "Behavior: "+b.name+", "+b.behavior_type+", "+b.behavior_reaction_time
	}	
	
	static def String debug_PrintInteraction(Interaction i){
		return "Interaction: "+i.name+", "+i.interaction_type+", "+i.trigger_type
	}
	
	
	//Copyright printing
	static def String copyrightPrint(String fname){
		var copyrightNote = "";	
	
		var output = "/*******************\n"+
		"*\n"+
		"*\tThis class file \""+fname+"\" was generated by CASTLE\n"+
		"*\tCASTLE was created by Lachlan Birdsey as part of his PhD work\n"+
		"*\tAt the University of Adelaide (www.adelaide.edu.au)\n"+
		"*\tCASTLE Project: http://github.com/castle-fwk\n"+
		"*\tContact: lachlan.birdsey@adelaide.edu.au\n"+
		"*\t"+copyrightNote+"\n"+		
		"*******************/\n";
		
		return output;
	}
	
	
	/**
	 * We are going about this in the wrong way
	 * 1: Figure out return types
	 * 2: Make sure each possible return location matches the same type
	 * 3: Place "return" where these locations are as going through the body instead of this poor approach
	 * Logic: 
	 * 	1: Go through the body.
	 * 	2: 
	 */
	static def String printMethodBody(EList<EObject> body, Entity_Feature caller){
		var output = "";
		var returnType = inferMethodType(body);
		var returnPrint = "";
		
		if (returnType == "void"){
			for (statement : body){
				output += TAB + parseBodyElement(statement, caller) + NL;
			}
		} else {
			for (var int i = 0; i < body.size() - 1; i++){
				var statement = body.get(i);
				output += TAB + parseBodyElement(statement, caller) + NL;
			}
			var finalLine = body.reverseView.head;
			if (finalLine instanceof Field){
				output += TAB + parseBodyElement(finalLine, caller) + NL;
				var ff = finalLine as Field;
				if (ff.declaration !== null) {					
					returnPrint += TAB+RETURN_+(ff.declaration as DataTypeDeclaration).name;	
				} else if (ff.agentFieldRef !== null){
					returnPrint += TAB+RETURN_+(ff.agentFieldRef as AgentFieldReference).name;
				} else if (ff.envFieldRef !== null){
					returnPrint += TAB+RETURN_+(ff.envFieldRef as EnvironmentFieldReference).name;
				} else if (ff.grpFieldRef !== null){
					returnPrint += TAB+RETURN_+(ff.grpFieldRef as GroupFieldReference).name;
				}
			} else if (finalLine instanceof Expression){
				var ee = finalLine as Expression
				//If IfStatement do something nutty (insert returns into the final line of each then block)
				if (ee instanceof IfStatement){
					returnPrint += TAB+printIfStatement(ee as IfStatement, 1, true);
				} else if (ee instanceof ForLoop){
					
				} else if (ee instanceof ForEachLoop){
					
				} else {
					returnPrint += RETURN_+printExpression(ee)
				}
				//What we need to do:
				/*
				 * We need to recursively dig through IfStatements, 
				 * ForEachLoops and ForLoops to find terminating statements
				 * 
				 * 
				 * 
				 */
				
				//If ForLoop or ForEachLoop *shrugs*
				
				//If BooleanExpression
//				if (ee instanceof FunctionCallExpr){
//					var ff = ee.funcCall as FunctionCall
//					
//					
//				} else if (ee instanceof FeatureCallExp){
//					var ff = ee.func as FeatureCall
//					returnPrint += FeatureCallGenerator.printFeatureCall(ff);
//				}
				
			} else if (finalLine instanceof SelfAssignedFormula) {
				var saf = finalLine as SelfAssignedFormula;
				output += TAB+printSelfAssignedFormula(saf)+NL;
				returnPrint += TAB+RETURN_+"this."+saf.ref.name;
			} else if (finalLine instanceof Formula){
				var saf = finalLine as Formula;
				output += TAB+printFormula(saf)+NL;
				returnPrint += TAB+RETURN_+"this."+saf.sym.name;
			} else {
				println("FL: "+ finalLine)
			}

			output += TAB + returnPrint+';'+NL
		}
		
		//Check what each final line is, 
			//If its an expression, print
			//if its a declaratation or field, return the assigned name
		
		
		
		return output;
		
	}
	
	static def ArrayList<String> populateImports(EList<EObject> body){
		var ArrayList<String> out = new ArrayList<String>();
		for (statement : body){
			if (statement instanceof Field)
				out.add(getFieldType(statement as Field));
		}
		return out;
	}
	
//	static def String printMethodReturnStatement(EList<EObject> body) {
//		val finalTerm = body.reverseView.head
//		var output = "";
//		if (finalTerm instanceof Field) {
//			val ftf = finalTerm as Field
//			if (ftf.declaration !== null) {
//				output = ftf.declaration.name
//			} else if (ftf.agentFieldRef !== null) {
//				output = ftf.agentFieldRef.name
//			} else if (ftf.envFieldRef !== null) {
//				output = ftf.envFieldRef.name
//			}
//		} else if (finalTerm instanceof Formula) {
//			val ftf = finalTerm as Formula
//			output = ftf.sym.name
//		}  else if (finalTerm instanceof SelfAssignedFormula) {
//			val ftf = finalTerm as SelfAssignedFormula
//			if (ftf.ref instanceof AgentFieldReference) {
//				output = (ftf.ref as AgentFieldReference).agent.name;
//			} else if (ftf.ref instanceof EnvironmentFieldReference) {
//				output = (ftf.ref as EnvironmentFieldReference).env.name;
//			} else if (ftf.ref instanceof DataTypeDeclaration) {
//				var dtd = ftf.ref as DataTypeDeclaration
//				if (dtd.type !== null) {		
//					output = dtd.type.name+"RIV_ERROR1"; //TODO: HOW DOES THIS HAPPEN
//				} else if (dtd.obj !== null) {
//					output = dtd.name;
//				}
//			} else if (ftf.ref instanceof FunctionParameter) {
//				var fp = ftf.ref as FunctionParameter
//				if (fp.type !== null) {		
//					output = fp.type.name
//				} else if (fp.obj !== null) {
//					output = fp.obj.name;
//				}
//			}			
//		} else if (finalTerm instanceof FunctionCallExpr) {
//			if ((finalTerm as FunctionCallExpr).funcCall.func !== null) {
//				if ((finalTerm as FunctionCallExpr).funcCall.func.returnType !== null) {
//					output = HelperFunctions.printFunctionCall((finalTerm as FunctionCallExpr).funcCall)
//				}
//			}						
//		} else if (finalTerm instanceof SelfCallExpr) {
//			val ftsce = finalTerm as SelfCallExpr;
//			if (ftsce.selfCall.fc !== null){
//				if (ftsce.selfCall.fc.func.returnType !== null){
//					output = HelperFunctions.printSelfCall(finalTerm as SelfCallExpr);
//				} else {
//					output = "";
//				}
//			} else {
//				output = "";
//			}
//			
//			
//		} else if (finalTerm instanceof Enum) {
//			output = (finalTerm as Enum).name
//		} else if (finalTerm instanceof FeatureCall){
//			output = FeatureCallGenerator.inferFeatureCallType((finalTerm as FeatureCallExp)) as String;
//		} 
//		
//		return "return "+output;
//	}
	
}