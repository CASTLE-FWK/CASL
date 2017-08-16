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
        EList<Expression> _toProject = d.getToProject();
        for (final Expression a : _toProject) {
          String nameOfProjection = Helpers.getNameFromExpression(a);
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
