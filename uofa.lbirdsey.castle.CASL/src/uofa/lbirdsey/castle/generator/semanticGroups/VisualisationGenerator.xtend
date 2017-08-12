package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.CASL_Macro_Display
import uofa.lbirdsey.castle.casl.CASL_Macro_Visualize
import static uofa.lbirdsey.castle.generator.semanticGroups.helpers.Constants.*;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers

class VisualisationGenerator {

	static def String generateVisualiser(CASL_Macro_Visualize v){
		
		return "";
	}
	
	
	//This is going to be a very large and ugly switch statement
	static def String generateDisplayer(CASL_Macro_Display d){
		val rep =  d.representationType.toString;
		print("The Rep: " + rep+"\n")
		switch (rep){
			case "GRID":
				return "//SOME GRID CODE GENERATION"
			default:
				throwCASLError("Unknown representation type", "generateDisplayer", "VisualisationGenerator")
				
		}
	}
}