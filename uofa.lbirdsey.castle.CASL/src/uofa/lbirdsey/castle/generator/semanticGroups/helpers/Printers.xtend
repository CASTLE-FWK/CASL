package uofa.lbirdsey.castle.generator.semanticGroups.helpers

import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.Addition
import uofa.lbirdsey.castle.casl.AgentFieldReference
import uofa.lbirdsey.castle.casl.Agent_Call
import uofa.lbirdsey.castle.casl.ArithmeticSigned
import uofa.lbirdsey.castle.casl.BooleanExpression
import uofa.lbirdsey.castle.casl.BooleanNegation
import uofa.lbirdsey.castle.casl.BooleanType
import uofa.lbirdsey.castle.casl.Comparison
import uofa.lbirdsey.castle.casl.DataTypeDeclaration
import uofa.lbirdsey.castle.casl.Enum
import uofa.lbirdsey.castle.casl.EnumCallExpr
import uofa.lbirdsey.castle.casl.EnvironmentFieldReference
import uofa.lbirdsey.castle.casl.Environment_Call
import uofa.lbirdsey.castle.casl.Equals
import uofa.lbirdsey.castle.casl.Expression
import uofa.lbirdsey.castle.casl.FeatureCallExp
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.ForEachLoop
import uofa.lbirdsey.castle.casl.ForLoop
import uofa.lbirdsey.castle.casl.Formula
import uofa.lbirdsey.castle.casl.FunctionCallExpr
import uofa.lbirdsey.castle.casl.GroupFieldReference
import uofa.lbirdsey.castle.casl.Group_Call
import uofa.lbirdsey.castle.casl.IfStatement
import uofa.lbirdsey.castle.casl.MacroCall
import uofa.lbirdsey.castle.casl.Multiplication
import uofa.lbirdsey.castle.casl.NullTypeLiteral
import uofa.lbirdsey.castle.casl.NumberLiteral
import uofa.lbirdsey.castle.casl.Object
import uofa.lbirdsey.castle.casl.SelfAssignedFormula
import uofa.lbirdsey.castle.casl.SelfCallExpr
import uofa.lbirdsey.castle.casl.StringLiteral
import uofa.lbirdsey.castle.casl.StringType
import uofa.lbirdsey.castle.casl.Subtraction
import uofa.lbirdsey.castle.casl.SystemCallObj
import uofa.lbirdsey.castle.casl.TypeRef
import uofa.lbirdsey.castle.generator.semanticGroups.FeatureCallGenerator
import uofa.lbirdsey.castle.generator.semanticGroups.MacroGenerator

class Printers {

	static val String TAB = '\t';
	static val String NL = '\n';
	static val RETURN_ = "return ";
	static val SC = ';';

	// Copyright printing
	static def String copyrightPrint(String fname) {
		var copyrightNote = "";
		var fileName = fname.replaceAll(" ", "").trim();

		var output = "/*******************\n" + "*\n" + "*\tThis class file \"" + fileName +
			".java\" was generated by CASTLE\n" + "*\tCASTLE was created by Lachlan Birdsey as part of his PhD work\n" +
			"*\tAt The University of Adelaide (www.adelaide.edu.au)\n" +
			"*\tCASTLE Project: http://github.com/castle-fwk\n" + "*\tContact: lachlan.birdsey@adelaide.edu.au\n" +
			"*\t" + copyrightNote + "\n" + "*******************/\n";

		return output;
	}

	// Pointless consistent print
	static def String getNameForTrigger(String s) {
		return s + "_Trigger";
	}

	static def String printFieldDeclarations(Field f) {
		// Prints out the type, var name and expression if it has one.
		var output = "";
		if (f.declaration !== null) {
			val fdt = f.declaration as DataTypeDeclaration
			if (fdt.type !== null) {
				if (fdt.expr !== null) {
					output += fdt.type.name + " " + fdt.name + " = " + printExpression(fdt.expr, fdt.name)
				} else {
					if (fdt.type.name.compareTo(StringType.name) == 0) {
						output += fdt.type.name + " " + fdt.name + " = \"\""
					} else {
						output += fdt.type.name + " " + fdt.name
					}
				}
			} else if (fdt.obj !== null) {
				if (fdt.obj instanceof Enum) {
					if (fdt.expr !== null) {
						output += fdt.obj.name + " " + fdt.name + " = " + printExpression(fdt.expr, fdt.name)
					} else {
						if (fdt.useObj !== null) {
							output +=
								fdt.obj.name + "<" + fdt.useObj.name + "> " + fdt.name + " = new " + fdt.obj.name +
									"<" + fdt.useObj.name + ">()"
						} else {
							output += fdt.obj.name + " " + fdt.name
						}
					}
				} else if (fdt.obj instanceof Object) {
					if (fdt.expr !== null) {
						if (fdt.useObj !== null) {
							output += fdt.obj.name + "<" + fdt.useObj.name + "> " + fdt.name + " = " +
								printExpression(fdt.expr, fdt.name)
						} else if (fdt.useGroup !== null) {
							output += fdt.obj.name + "<" + fdt.useGroup.name.toFirstUpper + "> " + fdt.name + " = " +
								printExpression(fdt.expr, fdt.name)
						} else if (fdt.useAgent !== null) {
							output += fdt.obj.name + "<" + fdt.useAgent.name.toFirstUpper + "> " + fdt.name + " = " +
								printExpression(fdt.expr, fdt.name)
						} else if (fdt.useEnv !== null) {
							output += fdt.obj.name + "<" + fdt.useEnv.name.toFirstUpper + "> " + fdt.name + " = " +
								printExpression(fdt.expr, fdt.name)
						} else {
							output += fdt.obj.name + " " + fdt.name + " = " + printExpression(fdt.expr, fdt.name)
						}
					} else {
						if (fdt.useObj !== null) {
							output +=
								fdt.obj.name + "<" + fdt.useObj.name + "> " + fdt.name + " = new " + fdt.obj.name +
									"<" + fdt.useObj.name + ">()"
						} else if (fdt.useGroup !== null) {
							output +=
								fdt.obj.name + "<" + fdt.useGroup.name.toFirstUpper + "> " + fdt.name + " = new " +
									fdt.obj.name + "<" + fdt.useGroup.name.toFirstUpper + ">()"
						} else if (fdt.useAgent !== null) {
							output +=
								fdt.obj.name + "<" + fdt.useAgent.name.toFirstUpper + "> " + fdt.name + " = new " +
									fdt.obj.name + "<" + fdt.useAgent.name.toFirstUpper + ">()"
						} else if (fdt.useEnv !== null) {
							output +=
								fdt.obj.name + "<" + fdt.useEnv.name.toFirstUpper + "> " + fdt.name + " = new " +
									fdt.obj.name + "<" + fdt.useEnv.name.toFirstUpper + ">()"
						} else {
							output += fdt.obj.name + " " + fdt.name + " = new " + fdt.obj.name + "()"
						}
					}
				}
			}
		} else if (f.agentFieldRef !== null) {
			val afr = f.agentFieldRef as AgentFieldReference
			output += afr.agent.name.toFirstUpper + " " + afr.name
			if (afr.assignment !== null) {
				output += " = " + printExpression(afr.assignment)
			}
			output += ";"
		} else if (f.envFieldRef !== null) {
			val efr = f.envFieldRef as EnvironmentFieldReference
			output += efr.env.name.toFirstUpper + " " + efr.name
			if (efr.assignment !== null) {
				output += " = " + printExpression(efr.assignment)
			}
			output += ";"
		} else if (f.grpFieldRef !== null) {
			val gfr = f.grpFieldRef as GroupFieldReference
			output += gfr.grp.name.toFirstUpper + " " + gfr.name
			if (gfr.assignment !== null) {
				output += " = " + printExpression(gfr.assignment)
			}
			output += ";"
		}
	}

	static def String autoPrinter(EObject expr) {
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
		output +=
			"for (" + autoPrinter(loop.init) + "; " + printExpression(loop.condition) + ";" +
				autoPrinter(loop.shifter) + ") {\n"
		for (expr : loop.body) {
			output += "\t\t" + autoPrinter(expr) + ";\n"
		}
		output += "\t\t\n}\n"
		return output;
	}

	static def printExpression(EObject expr) {
		if (expr instanceof Expression) { // is this needed, feels redundant
			if (expr instanceof SelfCallExpr)
				return HelperFunctions.printSelfCall(expr as SelfCallExpr)
			else if (expr instanceof NumberLiteral)
				return (expr as NumberLiteral).value
			else if (expr instanceof BooleanType)
				return (expr as BooleanType).bool
			else if (expr instanceof SystemCallObj)
				return Helpers.getSystemName().replaceAll(" ", "") + ".get" +
					((expr as SystemCallObj).sysCall.call.toFirstUpper) + "()"
			else if (expr instanceof StringLiteral)
				return "\"" + (expr as StringLiteral).value + "\""
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
				return (expr as Agent_Call).agentCall.agent.name + ".class"
			else if (expr instanceof Environment_Call)
				return (expr as Environment_Call).environmentCall.env.name + ".class"
			else if (expr instanceof Group_Call)
				return (expr as Group_Call).groupCall.grp.name + ".class"
			else if (expr instanceof ForLoop)
				return printForLoop((expr as ForLoop))
			else if (expr instanceof ForEachLoop)
				return printForEachLoop((expr as ForEachLoop))
			else
				'''ERROR: Unknown expression'''
		}
	}

	static def printExpression(Expression expr, String name) {
		if (expr instanceof MacroCall) {
			'''«MacroGenerator.parseMacro((expr as MacroCall), name)»'''
		} else {
			printExpression(expr)
		}
	}

	static def String printForEachLoop(ForEachLoop loop) {
		var output = "";
		output += "for (" + loop.ty + ' ' + loop.item.name + " : " + printExpression(loop.list) + ") {\n"
		for (expr : loop.body) {
			output += "\t\t" + autoPrinter(expr) + ";\n"
		}
		output += "\t}\n"
		return output;
	}

	// TODO: Indentation levels are wrong
	static def String printIfStatement(IfStatement iff, int depth, boolean returns) {
		var output = "";
		var TABS = TAB;
		for (var i = 0; i < depth; i++) {
			TABS += TAB;
		}
		output += "if (" + Printers.printExpression(iff.condition) + ") {\n"
		for (i : 0 ..< iff.then.size()) {
			var obj = iff.then.get(i);
			if (returns && i == (iff.then.size() - 1)) {
				// Condition that this can happen
				// Check for IfStatement or ForLoop
				if (obj instanceof IfStatement) {
					output += TABS + printIfStatement(obj as IfStatement, depth + 1, true);
				} else {
					output += TABS + "return " + autoPrinter(obj) + SC + NL;
				}

			} else {
				output += TABS + autoPrinter(obj) + SC + NL;
			}

		}
		output += "}"
		if (iff.elseifexpr !== null) {
			for (cond : iff.elseifexpr) {
				output += " else if (" + Printers.printExpression(cond.elseifCond) + ") {\n"
				for (i : 0 ..< cond.elseifthen.size()) {
					var obj = cond.elseifthen.get(i);
					if (returns && i == (cond.elseifthen.size() - 1)) {
						// Condition that this can happen
						if (obj instanceof IfStatement) {
							output += TABS + printIfStatement(obj as IfStatement, depth + 1, true);
						} else {
							output += TABS + "return " + autoPrinter(obj) + SC + NL;
						}
					} else {
						output += TABS + autoPrinter(obj) + SC + NL;
					}

				}
				output += TABS + '}'
			}
		}

		if (!iff.elseexp.isEmpty) {
			output += " else {\n"
			for (i : 0 ..< iff.elseexp.size()) {
				var obj = iff.elseexp.get(i);
				if (returns && i == (iff.elseexp.size() - 1)) {
					if (obj instanceof IfStatement) {
						output += printIfStatement(obj as IfStatement, depth + 1, true);
					} else {
						output += TABS + "return " + autoPrinter(obj) + SC + NL;
					}
				} else {
					output += TABS + autoPrinter(obj) + SC + NL;
				}
			}
			output += "}"
		}
		return output;
	}

	static def String printIfStatement(IfStatement is) {
		return printIfStatement(is, 1, false);
	}
}
