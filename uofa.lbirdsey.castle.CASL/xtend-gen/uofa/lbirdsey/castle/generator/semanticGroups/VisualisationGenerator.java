package uofa.lbirdsey.castle.generator.semanticGroups;

import org.eclipse.emf.common.util.EList;
import uofa.lbirdsey.castle.casl.CASL_Macro_Display;
import uofa.lbirdsey.castle.casl.CASL_Macro_Visualize;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Constants;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Helpers;

@SuppressWarnings("all")
public class VisualisationGenerator {
  public static String generateVisualiser(final CASL_Macro_Visualize v) {
    return "";
  }
  
  public static String generateDisplayer(final CASL_Macro_Display d) {
    String _xblockexpression = null;
    {
      final String rep = d.getRepresentationType().toString();
      String output = "";
      String _xifexpression = null;
      boolean _equalsIgnoreCase = rep.equalsIgnoreCase("GRID");
      if (_equalsIgnoreCase) {
        output = "GridFactory gridFactory = GridFactoryFinder.createGridFactory(null);\n";
        EList<Expression> _toProject = d.getToProject();
        for (final Expression a : _toProject) {
          {
            String nameOfProjection = Helpers.getNameFromExpression(a);
            String _output = output;
            String _lowerCase = nameOfProjection.toLowerCase();
            String _plus = ("\trepast.simphony.space.grid.Grid<Entity> " + _lowerCase);
            String _plus_1 = (_plus + "_Grid = gridFactory.createGrid(\"");
            String _plus_2 = (_plus_1 + nameOfProjection);
            String _plus_3 = (_plus_2 + "\", repastContext, ");
            String _plus_4 = (_plus_3 + 
              "new GridBuilderParameters<Entity>(new StrictBorders(),new SimpleGridAdder<Entity>(), false, ");
            String _plus_5 = (_plus_4 + nameOfProjection);
            String _plus_6 = (_plus_5 + ".getX(), ");
            String _plus_7 = (_plus_6 + nameOfProjection);
            String _plus_8 = (_plus_7 + ".getY()));");
            output = (_output + _plus_8);
          }
        }
        return output;
      } else {
        _xifexpression = Constants.throwCASLError("Unknown representation type", "generateDisplayer", "VisualisationGenerator");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
