package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.MacroCall
import uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours
import uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction
import uofa.lbirdsey.castle.casl.CASL_Macro_CountConditions
import uofa.lbirdsey.castle.casl.CASL_Macro_Random
import uofa.lbirdsey.castle.casl.CASL_Macro_Print
import uofa.lbirdsey.castle.casl.CASL_Macro_ForEach
import uofa.lbirdsey.castle.casl.CASL_Macro_MetricSwitch
import uofa.lbirdsey.castle.casl.CASL_Macro_Populate
import uofa.lbirdsey.castle.casl.Expression
import uofa.lbirdsey.castle.casl.CASL_Macro_TODO
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.casl.RandomType
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions
import org.eclipse.emf.common.util.EList
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Helpers
import static uofa.lbirdsey.castle.generator.semanticGroups.helpers.Constants.*;
import uofa.lbirdsey.castle.casl.CASL_Macro_Visualize
import uofa.lbirdsey.castle.casl.CASL_Macro_Display
import uofa.lbirdsey.castle.casl.CASL_Macro_Log
import uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger
import uofa.lbirdsey.castle.casl.LayoutType
import uofa.lbirdsey.castle.casl.FeatureCall
import uofa.lbirdsey.castle.casl.CASL_Macro_GET_ID
import uofa.lbirdsey.castle.casl.CASL_Macro_GET_TIME
import uofa.lbirdsey.castle.casl.CASL_Macro_COLOR
import uofa.lbirdsey.castle.casl.CASL_Macro_Viz
import uofa.lbirdsey.castle.casl.CASL_Macro_COLOR_FLAG
import uofa.lbirdsey.castle.casl.CASL_Macro_NEW

class MacroGenerator {
	static def parseMacro(MacroCall mc, String name) {
		var output = "";
		val macro = mc.macroCall.macro
		if (macro instanceof CASL_Macro_Neighbours) {
			output += "null;\n"
			var ngh = (macro as CASL_Macro_Neighbours)
			if (ngh.worldType == LayoutType.GRID) {
			}

		} else if (macro instanceof CASL_Macro_FilterAndFunction) {
			var mac = (macro as CASL_Macro_FilterAndFunction)
			if (mac.sym !== null) {
				var decl = mac.sym
				output +=
					decl.name + ".stream().filter(" + Printers.printExpression(mac.cond) + ")." + mac.misc.toString
			}
		} else if (macro instanceof CASL_Macro_CountConditions) {
			var mac = (macro as CASL_Macro_CountConditions)
			if (mac.sym !== null) {
				output +=
					"(int)" + mac.sym.name + ".stream().filter(entity -> entity." +
						FeatureCallGenerator.printFeatureCall(mac.cond as FeatureCall) + ").count()"
			}
		} else if (macro instanceof CASL_Macro_Random) {
			var mac = (macro as CASL_Macro_Random)
			if (mac.type == RandomType.INT) {
				if (mac.high === null) {
					output += "RandomGen.generateRandomRangeInteger(0," + Printers.printExpression(mac.low) + ");"
				} else {
					output +=
						"RandomGen.generateRandomRangeInteger(" + Printers.printExpression(mac.low) + "," +
							Printers.printExpression(mac.high) + ")"
				}

			} else if (mac.type == RandomType.DOUBLE) {
				if (mac.high === null) {
					output += "RandomGen.generateRandomRangeDouble(0," + Printers.printExpression(mac.low) + ");"
				} else {
					output +=
						"RandomGen.generateRandomRangeDouble(" + Printers.printExpression(mac.low) + "," +
							Printers.printExpression(mac.high) + ")"
				}
			} else if (mac.type == RandomType.BOOL) {
				output += "RandomGen.generateBiasedCoinFlip(" + Printers.printExpression(mac.low) + ")"
			} else if (mac.type == RandomType.VECTOR2) {
				output +=
					"RandomGen.randomiseVectorDouble(" + Printers.printExpression(mac.low) + "," +
						Printers.printExpression(mac.high) + ")"
			}
		} else if (macro instanceof CASL_Macro_ForEach) {
			var mac = (macro as CASL_Macro_ForEach)
			if (mac.sym !== null) {
				var entityType = mac.sym.name // TODO: Make this better
				output +=
					mac.sym.name + ".forEach(" + "Function<" + entityType + ",Void> fn = new Function<" + entityType +
						",Void>() {" + "\n\tpublic Void apply(" + entityType + " o) {" + "\n\t\to." +
						Printers.printExpression(mac.expr) + ";" + "\n\t\treturn null;" + "\n\t}" + "\n}" + ")"
			}
		} else if (macro instanceof CASL_Macro_Print) {
			output += "System.out.println(\"" + (macro as CASL_Macro_Print).str + "\");\n"
		} else if (macro instanceof CASL_Macro_Log) {
//			output += "log(\""+(macro as CASL_Macro_Log).str+"\");\n"
			var String str = "";
			var int numArgs = (macro as CASL_Macro_Log).expr.size;
			for (var i = 0; i < numArgs; i++) {
				str += Printers.printExpression((macro as CASL_Macro_Log).expr.get(i))
				if (i != numArgs - 1) {
					str += " + ";
				}
			}
			output += "log(" + str + ");\n"
		} else if (macro instanceof CASL_Macro_InitLogger) {
			val il = (macro as CASL_Macro_InitLogger);
			val isMuted = (il.mute == true)
			val isToConsole = (il.toConsole == true)
			val isToFile = (il.toFile == true)
			val infoIsToFile = (il.infoToFile == true)
			val infoIsToConsole = (il.infoToConsole == true)
			val infoIsToDB = (il.infoToDB == true)
			var filePath = "\"\"";
			if (isToFile) {
				filePath = Printers.printExpression(il.filePath) as String;
			}
			output +=
				"output.setup(" + isMuted + ',' + isToConsole + ',' + isToFile + ',' + filePath + "," + infoIsToFile +
					"," + infoIsToConsole + "," + infoIsToDB + ")"
		} else if (macro instanceof CASL_Macro_MetricSwitch) {
			var mac = (macro as CASL_Macro_MetricSwitch);
			val isEnabled = (mac.sw == true)
			if (isEnabled) {
				return generateMetricSender(name);
			}
		} else if (macro instanceof CASL_Macro_Populate) {
			return MacroGenerator.populator(macro as CASL_Macro_Populate);
		} else if (macro instanceof CASL_Macro_TODO) {
			val mac = (macro as CASL_Macro_TODO);
			return "//TODO: " + mac.str + '\n';
		} else if (macro instanceof CASL_Macro_Visualize) {
			return VisualisationGenerator.generateVisualiser(macro as CASL_Macro_Visualize);
		} else if (macro instanceof CASL_Macro_Display) {
			return VisualisationGenerator.generateDisplayer(macro as CASL_Macro_Display);
		} else if (macro instanceof CASL_Macro_GET_ID) {
			return "getEntityID()"
		} else if (macro instanceof CASL_Macro_GET_TIME) {
			return "getCurrentStep()"
		} else if (macro instanceof CASL_Macro_COLOR) {
			// TODO
			val col = macro as CASL_Macro_COLOR;
			return generateEntityColor(col);
		} else if (macro instanceof CASL_Macro_Viz) {
			// TODO
			val active = (macro as CASL_Macro_Viz).sw;
			if (active == true) {
			} else {
			}

		} else if (macro instanceof CASL_Macro_NEW) {
			val exp = (macro as CASL_Macro_NEW).exp;
			val type = HelperFunctions.inferExpressionType(exp)
			return "new " + type + "()"
		}
		return output;
	}

	/**
	 * This is the wonder populate function.
	 * It takes in the stuff from CASL.POPULATE and churns out some perfectly working
	 * code to populate the entities specified.
	 * This is sooooo not a hard thing to write...
	 */
	static def String populator(CASL_Macro_Populate pop) {
		var output = "//Generated Entity Populator\n//This is unfortunately prone to error for the moment\n";
//		output += ""
		val layoutLocation = pop.layoutLocation;
		val EList<Expression> layoutInitParams = pop.layoutInitParams;
		val counter = pop.count;
		var String counterName = Helpers.getNameFromExpression(counter);
		val String counterAsString = HelperFunctions.inferExpressionType(counter) as String;
		val entityCall = pop.ent;
		val String entityName = Helpers.getEntityNameFromCall(entityCall);
		val String entityType = Helpers.getEntityTypeFromCall(entityCall);
		val String tmpEntityName = "tmp_" + entityName.toLowerCase
		val EList<Expression> entityInitParams = pop.entityInitParams;

		// Initialize the layout type
		output +=
			Printers.printExpression(layoutLocation) + ".initialize(" +
				HelperFunctions.printFunctionArgs(layoutInitParams) + ");\n";

		// Now create the entities...
		// Something needs to happen here before initializing the entities
		output +=
			"ArrayList<" + entityName + ">" + entityName.toLowerCase + "List = new ArrayList<" + entityName + ">();\n"

		// Determine the type of counter range
		// println(counterAsString) //This is very useful
		if (counterAsString.equalsIgnoreCase("vector2")) {
			output +=
				"int xRange = (int)" + counterName + ".getX();\nint yRange = (int)" + counterName + ".getY()" + SC +
					NL + "for (int i = 0; i < xRange; i++){\n\tfor (int j = 0; j < yRange; j++){" + NL
			// Do the cycling
			output +=
				TAB + TAB + entityName + " " + tmpEntityName + " = new " + entityName + "(EntityIDFactory.getNewID(\"" +
					entityName + "\"))" + LINE_END
			// Add to the Repast Context
//			output += TAB + TAB + addRepastContextAdder(entityType, tmpEntityName);
			output += TAB + TAB + tmpEntityName + ".setOutput(output);" + LINE_END
//			output += TAB + TAB + tmpEntityName +".setDBOut(dbOut);"+LINE_END
			output +=
				TAB + TAB + tmpEntityName + ".initialize(" + printInitializeParams(entityInitParams) + ")" + LINE_END
			output += TAB + TAB + tmpEntityName + ".initialise()" + LINE_END

			output += TAB + TAB + tmpEntityName + ".setPosition(new Vector2(i,j))" + LINE_END
			output += TAB + TAB + entityName.toLowerCase + "List.add(" + tmpEntityName + ")" + LINE_END
			output += TAB + TAB + printContainerAdd(entityType, tmpEntityName) + LINE_END
			output +=
				TAB + TAB + Printers.printExpression(layoutLocation) + ".addEntity(" + tmpEntityName + ", " +
					tmpEntityName + ".getPosition())" + LINE_END

			output += TAB + "}\n}\n"
		} else if (Helpers.isANumber(counterAsString)) {
			output += "int limit = (int)" + counterName + LINE_END
			output += "for (int i = 0; i < limit; i++) { " + NL
			output +=
				TAB + TAB + entityName + " " + tmpEntityName + " = new " + entityName + "(EntityIDFactory.getNewID(\"" +
					entityName + "\"))" + LINE_END
			// Add to the Repast Context
//			output += TAB + TAB + addRepastContextAdder(entityType, tmpEntityName);
			output += TAB + TAB + tmpEntityName + ".setOutput(output);" + LINE_END
//			output += TAB + TAB + tmpEntityName +".setDBOut(dbOut);"+LINE_END
			output +=
				TAB + TAB + tmpEntityName + ".initialize(" + printInitializeParams(entityInitParams) + ")" + LINE_END
			output += TAB + TAB + tmpEntityName + ".initialise()" + LINE_END

			output += TAB + TAB + tmpEntityName + ".setPosition(new Vector2(0, 0))" + LINE_END
			output += TAB + TAB + entityName.toLowerCase + "List.add(" + tmpEntityName + ")" + LINE_END
			output += TAB + TAB + printContainerAdd(entityType, tmpEntityName) + LINE_END
			output +=
				TAB + TAB + Printers.printExpression(layoutLocation) + ".addEntity(" + tmpEntityName + ")" + LINE_END

			output += TAB + "}\n"
		}

		// Add the entities to the layout parameter class as well
		// TODO: This doesn't work
		// output += Printers.printExpression(layoutLocation)+".addEntities("+entityName.toLowerCase+"List);\n";
		return output;
	}

	static def String addRepastContextAdder(String entityType, String tmpEntityName) {
		if (entityType == AGENT) {
			return "repastContext.add(" + tmpEntityName + ")" + LINE_END
		} else if (entityType == ENVIRONMENT) {
			return tmpEntityName + ".setRepastContext(repastContext);\nrepastContext.add(" + tmpEntityName + ")" +
				LINE_END
		} else if (entityType == GROUP) {
			return tmpEntityName + ".setRepastContext(repastContext.getSubContext);repastContext.addSubContext(" +
				tmpEntityName + ")" + LINE_END
		} else {
			throwCASLError("invalid entity type", "addRepastContextAdder", "MacroGenerator");
		}
	}

	static def String printContainerAdd(String entityType, String tmpEntityName) {
		if (entityType == AGENT) {
			return "storedAgents.add(" + tmpEntityName + ")"
		} else if (entityType == ENVIRONMENT) {
			return "storedEnvironments.add(" + tmpEntityName + ")"
		} else if (entityType == GROUP) {
			return "storedGroups.add(" + tmpEntityName + ")" + LINE_END
		} else {
			throwCASLError("invalid entity type", "printContainerAdd", "MacroGenerator");
		}
	}

	// This is for the populator
	// TODO: Figure out what the sticky parts are (e.g. function passes)
	static def String printInitializeParams(EList<Expression> params) {
		val parameterSize = params.size
		var strOut = "";
		if (parameterSize == 0) {
			return ""
		} else {
			for (i : 0 ..< parameterSize - 1) {
				strOut += Printers.printExpression(params.get(i) as Expression) + ", "
			}
			strOut += Printers.printExpression(params.get(parameterSize - 1) as Expression)
			return strOut
		}
	}

	/**
	 * 
	 */
	static def String generateMetricSender(String name) {
		// Note: This is actually done in the HelperFunctions class for some readosn.
		// How to do this:
		/* 1: Figure out what type of thing the block is
		 * 2: Check what the switch is (True/false)
		 * 3: If false, do nothing. If true: Add this function to the data collector
		 */
		var output = "gms "
		output += name;
		return output;

	}

	static def String generateEntityColor(CASL_Macro_COLOR cmc) {
		// TODO
		val flag = cmc.flag;
		val target = Printers.printExpression(cmc.target);
		val params = cmc.params;
		val pos = Printers.printExpression(cmc.pos);
		var String out = "entityColor = new EntityDisplay(\""
		out += target + "\",\"" + flag + "\");\n"

		// Add all parameters to the Parameters thing
		// Position
		out += "addParameter(" + pos + ",\"" + pos + "\");\n"
		out += "entityColor.setPositionParam(\"" + pos + "\");\n"

		if (flag == CASL_Macro_COLOR_FLAG.BOOLEAN) {
			// Should be 2 params
			if (params.size != 2) {
				// Warn
			}
			val trueParam = Printers.printExpression(params.get(0));
			val falseParam = Printers.printExpression(params.get(1));

			out += "entityColor.addSet(\"true\"," + trueParam + ");\n"
			out += "addParameter(" + target + ",\"" + target + "\");\n"
			out += "entityColor.addSet(\"false\"," + falseParam + ");\n"

		} else if (flag == CASL_Macro_COLOR_FLAG.SET) {
			// Should be an even number
			if (params.size % 2 != 0) {
				// Warn
			}
			for (var i = 0; i < params.size(); i += 2) {
				val value = Printers.printExpression(params.get(i));
				val col = Printers.printExpression(params.get(i + 1));
				out += "entityColor.addSet(\"" + value + "\"," + col + ");\n"
				out += "parameters.addParameter(" + value + ",\"" + value + "\");\n"
			}

		} else if (flag == CASL_Macro_COLOR_FLAG.RANGE) {
			// Should contain 4 params
			if (params.size != 4) {
				// Warn
			}
			val min = Printers.printExpression(params.get(0));
			val max = Printers.printExpression(params.get(1));
			val minC = Printers.printExpression(params.get(2));
			val maxC = Printers.printExpression(params.get(3));
			out += "entityColor.setRange(\"" + min + "\",\"" + max + "\"," + minC + "," + maxC + ");\n"

		}
		return out;

	}

	// TODO: MISSING: MacroCall Return Types
	static def String macroCallReturnType(MacroCall mc) {
		return "void";
	}
}
