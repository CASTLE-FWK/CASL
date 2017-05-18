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
import static uofa.lbirdsey.castle.generator.semanticGroups.HelperFunctions.*;
import uofa.lbirdsey.castle.casl.numType
import uofa.lbirdsey.castle.casl.CASL_Macro_EntitySetup
import uofa.lbirdsey.castle.casl.Expression
import uofa.lbirdsey.castle.casl.Entity
import java.util.List
import uofa.lbirdsey.castle.casl.CASL_Macro
import uofa.lbirdsey.castle.casl.CASL_Macro_TODO

class MacroGenerator {
//Highly Repast Specific
	static def parseMacro(MacroCall mc, String name) {
		var output = "";		
		var macro = mc.macroCall.macro
		if (macro instanceof CASL_Macro_Neighbours) {
			output += "null;\n"
			var ngh = (macro as CASL_Macro_Neighbours)
			if (ngh.worldType == WorldType.GRID) {
				output += "GridPoint pt = grid.getLocation(this);\nGridCellNgh<"+ngh.searchType.name.toFirstUpper+"> nghCreator;\n"
				output += "nghCreator = new GridCellNgh<"+ngh.searchType.name.toFirstUpper+">(grid, pt, "+ngh.searchType.name.toFirstUpper+".class, "+ngh.dist+", "+ngh.dist+");\n"
				output += "List<GridCell<"+ngh.searchType.name.toFirstUpper+">> gridCells = nghCreator.getNeighborhood(false);\n"
				output += "List<"+ngh.searchType.name.toFirstUpper+"> "+name+" = new ArrayList<"+ngh.searchType.name.toFirstUpper+">();\n"
				output += "for (GridCell<"+ngh.searchType.name.toFirstUpper+"> "+ngh.searchType.name.toFirstLower+"s : grid"+ngh.searchType.name.toFirstUpper+"s) {\n"	
				output += "\t"+ngh.searchType.name.toFirstUpper+" tmp"+ngh.searchType.name.toFirstUpper+" = "+ngh.searchType.name.toFirstLower+"s.items().iterator().next();\n"
				output += "\t"+name+".add(tmpCell);\n}"
		
			} else if (ngh.worldType == WorldType.SPACE) {
				
			}

		} else if (macro instanceof CASL_Macro_FilterAndFunction) {
			var mac = (macro as CASL_Macro_FilterAndFunction)
			if (mac.sym != null) {
				var decl = mac.sym
				output += decl.name+".stream().filter("+printExpression(mac.cond)+")."+mac.misc.toString
			}
		} else if (macro instanceof CASL_Macro_CountConditions) {
			var mac = (macro as CASL_Macro_CountConditions)
			if (mac.sym != null) {
				output += "(int)"+mac.sym.name+".stream().filter(entity -> entity.get"+printExpression(mac.cond)+"()"+").count()"
			}
		} else if (macro instanceof CASL_Macro_Random) {
			var mac = (macro as CASL_Macro_Random)
			if (mac.type == numType.INT) {
				if (mac.high == null) {
					output += "Utilities.generateRandomRangeInteger(0,"+printExpression(mac.low)+");"
				} else {
					output += "Utilities.generateRandomRangeInteger("+printExpression(mac.low)+","+printExpression(mac.high)+");"
				}
				
			} else if (mac.type == numType.FLOAT) {
				if (mac.high == null) {
					output += "Utilities.generateRandomRangeDouble(0,"+printExpression(mac.low)+");"
				} else {
					output += "Utilities.generateRandomRangeDouble("+printExpression(mac.low)+","+printExpression(mac.high)+");"
				}
			}
		} else if (macro instanceof CASL_Macro_ForEach) {
			var mac = (macro as CASL_Macro_ForEach)
			if (mac.sym != null) {
				var entityType = mac.sym.name //TODO: Make this better
				output += mac.sym.name+".forEach("+"Function<"+entityType+",Void> fn = new Function<"+entityType+",Void>() {"
				+"\n\tpublic Void apply("+entityType+" o) {"
				+"\n\t\to."+printExpression(mac.expr)+";"
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
			
		} else if (macro instanceof CASL_Macro_EntitySetup){
			val es = macro as CASL_Macro_EntitySetup;
			return entitySetup(es.initNum, es.ent, es.params);
		} else if (macro instanceof CASL_Macro_TODO){
			val mac = (macro as CASL_Macro_TODO);
			return "//TODO: "+mac.str+'\n';
		}
		return output;
	}
	
	static def String entitySetup(Expression initNum, Entity ent, List<Expression> params){
		var output = "//Auto Entity Generator";
		output += '''
			for (int i = 0; i < «initNum»; i++) {
				
			}
		'''
		
		return output;
	}
	
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