package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.MacroCall
import uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours
import uofa.lbirdsey.castle.casl.WorldType
import uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction
import uofa.lbirdsey.castle.casl.CASL_Macro_CountConditions
import uofa.lbirdsey.castle.casl.CASL_Macro_Random
import uofa.lbirdsey.castle.casl.CASL_Macro_Print
import uofa.lbirdsey.castle.casl.CASL_Macro_ForEach
import uofa.lbirdsey.castle.casl.CASL_Macro_MetricSwitch
import uofa.lbirdsey.castle.casl.CASL_Macro_Populate
import uofa.lbirdsey.castle.casl.Expression
import uofa.lbirdsey.castle.casl.Entity
import java.util.List
import uofa.lbirdsey.castle.casl.CASL_Macro
import uofa.lbirdsey.castle.casl.CASL_Macro_TODO
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.RandomType
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions
import org.eclipse.emf.common.util.EList

class MacroGenerator {
//Highly Repast Specific
	static def parseMacro(MacroCall mc, String name) {
		var output = "";		
		var macro = mc.macroCall.macro
		if (macro instanceof CASL_Macro_Neighbours) {
			output += "null;\n"
			var ngh = (macro as CASL_Macro_Neighbours)
			if (ngh.worldType == WorldType.GRID) {
//				output += "GridPoint pt = grid.getLocation(this);\nGridCellNgh<"+ngh.searchType.name.toFirstUpper+"> nghCreator;\n"
//				output += "nghCreator = new GridCellNgh<"+ngh.searchType.name.toFirstUpper+">(grid, pt, "+ngh.searchType.name.toFirstUpper+".class, "+ngh.dist+", "+ngh.dist+");\n"
//				output += "List<GridCell<"+ngh.searchType.name.toFirstUpper+">> gridCells = nghCreator.getNeighborhood(false);\n"
//				output += "List<"+ngh.searchType.name.toFirstUpper+"> "+name+" = new ArrayList<"+ngh.searchType.name.toFirstUpper+">();\n"
//				output += "for (GridCell<"+ngh.searchType.name.toFirstUpper+"> "+ngh.searchType.name.toFirstLower+"s : grid"+ngh.searchType.name.toFirstUpper+"s) {\n"	
//				output += "\t"+ngh.searchType.name.toFirstUpper+" tmp"+ngh.searchType.name.toFirstUpper+" = "+ngh.searchType.name.toFirstLower+"s.items().iterator().next();\n"
//				output += "\t"+name+".add(tmpCell);\n}"

		
			} else if (ngh.worldType == WorldType.SPACE) {
				
			}

		} else if (macro instanceof CASL_Macro_FilterAndFunction) {
			var mac = (macro as CASL_Macro_FilterAndFunction)
			if (mac.sym !== null) {
				var decl = mac.sym
				output += decl.name+".stream().filter("+Printers.printExpression(mac.cond)+")."+mac.misc.toString
			}
		} else if (macro instanceof CASL_Macro_CountConditions) {
			var mac = (macro as CASL_Macro_CountConditions)
			if (mac.sym !== null) {
				output += "(int)"+mac.sym.name+".stream().filter(entity -> entity.get"+Printers.printExpression(mac.cond)+"()"+").count()"
			}
		} else if (macro instanceof CASL_Macro_Random) {
			var mac = (macro as CASL_Macro_Random)
			if (mac.type == RandomType.INT) {
				if (mac.high === null) {
					output += "RandomGen.generateRandomRangeInteger(0,"+Printers.printExpression(mac.low)+");"
				} else {
					output += "RandomGen.generateRandomRangeInteger("+Printers.printExpression(mac.low)+","+Printers.printExpression(mac.high)+");"
				}
				
			} else if (mac.type == RandomType.FLOAT) {
				if (mac.high === null) {
					output += "RandomGen.generateRandomRangeDouble(0,"+Printers.printExpression(mac.low)+");"
				} else {
					output += "RandomGen.generateRandomRangeDouble("+Printers.printExpression(mac.low)+","+Printers.printExpression(mac.high)+");"
				}
			} else if (mac.type == RandomType.BOOL){
				//TODO this
			}
		} else if (macro instanceof CASL_Macro_ForEach) {
			var mac = (macro as CASL_Macro_ForEach)
			if (mac.sym !== null) {
				var entityType = mac.sym.name //TODO: Make this better
				output += mac.sym.name+".forEach("+"Function<"+entityType+",Void> fn = new Function<"+entityType+",Void>() {"
				+"\n\tpublic Void apply("+entityType+" o) {"
				+"\n\t\to."+Printers.printExpression(mac.expr)+";"
				+"\n\t\treturn null;"
				+"\n\t}"
				+"\n}"+")"
			}
		} else if (macro instanceof CASL_Macro_Print) {
			var mac = (macro as CASL_Macro_Print)
			output += "System.out.println(\""+mac.str+"\");\n"
			
		} else if (macro instanceof CASL_Macro_MetricSwitch){
			var mac = (macro as CASL_Macro_MetricSwitch);
			val isEnabled = (mac.sw == true)
			if (isEnabled){
				return generateMetricSender(name);
//				return "laslsl"
			}
			
		} else if (macro instanceof CASL_Macro_Populate){
			return entitySetup(macro as CASL_Macro_Populate);
		} else if (macro instanceof CASL_Macro_TODO){
			val mac = (macro as CASL_Macro_TODO);
			return "//TODO: "+mac.str+'\n';
		}
		return output;
	}
	
	/**
	 * This is the wonder populate function.
	 * It takes in the stuff from CASL.POPULATE and churns out some perfectly working
	 * code to populate the entities specified.
	 * This is so not a hard thing to write...
	 */
	static def String entitySetup(CASL_Macro_Populate pop){
		var output = "//Generated Entity Populator\n//This is unfortunately prone to error for the moment";
		output += ""
		val layoutLocation = pop.layoutLocation;
		val EList<Expression> layoutInitParams = pop.layoutInitParams;
		val entityCall = pop.ent;
		val EList<Expression> entityInitParams = pop.entityInitParams;
		
		//Initialize the layout type
		output += layoutLocation+".initialize("+HelperFunctions.printFunctionArgs(layoutInitParams)+");\n";
		//Now create the entities...
		
		

		return output;
	}
	
	/**
	 * 
	 */
	static def String generateMetricSender(String name){
		//How to do this:
			/* 1: Figure out what type of thing the block is
			 * 2: Check what the switch is (True/false)
			 * 3: If false, do nothing. If true: Add this function to the data collector
			 */
		var output = "gms " 
		output += name;
		return output;
		
	}
	
	//TODO: MISSING: MacroCall Return Types
	static def String macroCallReturnType(MacroCall mc){
		return "void";
	}
}