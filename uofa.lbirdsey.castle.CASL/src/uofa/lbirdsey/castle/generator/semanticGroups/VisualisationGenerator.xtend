package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.CASL_Macro_Display
import uofa.lbirdsey.castle.casl.CASL_Macro_Visualize
import static uofa.lbirdsey.castle.generator.semanticGroups.helpers.Constants.*;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Helpers

class VisualisationGenerator {

	static def String generateVisualiser(CASL_Macro_Visualize v){
		
		return "";
	}
	
	/*
	 * 
	 */
	//This is going to be a very large and ugly switch statement
	static def String generateDisplayer(CASL_Macro_Display d){
		val String rep =  d.representationType.toString;
		var output = "";
		
		
		if (rep.equalsIgnoreCase("GRID")){
			output = "GridFactory gridFactory = GridFactoryFinder.createGridFactory(null);\n"
			
				//Cycle through each of the things we want to project
				for (a : d.toProject) {
					
					var nameOfProjection = Helpers.getNameFromExpression(a);
					
					
//					output += "\trepast.simphony.space.grid.Grid<Entity> "+nameOfProjection.toLowerCase+"_Grid = gridFactory.createGrid(\""+nameOfProjection+ "\", repastContext, "+
//						"new GridBuilderParameters<Entity>(new StrictBorders(),new SimpleGridAdder<Entity>(), false, "+nameOfProjection+".getX(), "+nameOfProjection+".getY()));" 
				}
				return output;
		} else {
			throwCASLError("Unknown representation type", "generateDisplayer", "VisualisationGenerator")	
		}
	}
}