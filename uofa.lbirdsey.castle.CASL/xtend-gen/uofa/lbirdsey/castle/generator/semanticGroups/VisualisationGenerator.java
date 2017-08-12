package uofa.lbirdsey.castle.generator.semanticGroups;

import org.eclipse.xtext.xbase.lib.InputOutput;
import uofa.lbirdsey.castle.casl.CASL_Macro_Display;
import uofa.lbirdsey.castle.casl.CASL_Macro_Visualize;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Constants;

@SuppressWarnings("all")
public class VisualisationGenerator {
  public static String generateVisualiser(final CASL_Macro_Visualize v) {
    return "";
  }
  
  public static String generateDisplayer(final CASL_Macro_Display d) {
    String _xblockexpression = null;
    {
      final String rep = d.getRepresentationType().toString();
      InputOutput.<String>print((("The Rep: " + rep) + "\n"));
      String _switchResult = null;
      if (rep != null) {
        switch (rep) {
          case "GRID":
            return "//SOME GRID CODE GENERATION";
          default:
            _switchResult = Constants.throwCASLError("Unknown representation type", "generateDisplayer", "VisualisationGenerator");
            break;
        }
      } else {
        _switchResult = Constants.throwCASLError("Unknown representation type", "generateDisplayer", "VisualisationGenerator");
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
