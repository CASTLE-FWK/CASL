package uofa.lbirdsey.castle.generator.semanticGroups.helpers;

import java.util.ArrayList;
import org.eclipse.emf.ecore.EObject;
import uofa.lbirdsey.castle.casl.Field;
import uofa.lbirdsey.castle.casl.impl.AgentImpl;
import uofa.lbirdsey.castle.casl.impl.EnvironmentImpl;
import uofa.lbirdsey.castle.casl.impl.GroupImpl;
import uofa.lbirdsey.castle.casl.impl.ObjectImpl;
import uofa.lbirdsey.castle.casl.impl.SystemImpl;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions;

@SuppressWarnings("all")
public class Helpers {
  private static ArrayList<EObject> types = new ArrayList<EObject>();
  
  private static String systemName = "";
  
  public static String setSystemName(final String n) {
    return Helpers.systemName = n;
  }
  
  public static String getSystemName() {
    return Helpers.systemName;
  }
  
  public static ArrayList<EObject> getTypes() {
    return Helpers.types;
  }
  
  public static ArrayList<EObject> initTypesList() {
    ArrayList<EObject> _arrayList = new ArrayList<EObject>();
    return Helpers.types = _arrayList;
  }
  
  public static boolean addToTypesArray(final EObject type) {
    return Helpers.types.add(type);
  }
  
  public static String determineOwner(final EObject eo) {
    if ((eo instanceof AgentImpl)) {
      return ((AgentImpl) eo).getName();
    } else {
      if ((eo instanceof GroupImpl)) {
        return ((GroupImpl) eo).getName();
      } else {
        if ((eo instanceof EnvironmentImpl)) {
          return ((EnvironmentImpl) eo).getName();
        } else {
          if ((eo instanceof SystemImpl)) {
            return ((SystemImpl) eo).getName();
          } else {
            return Helpers.determineOwner(eo.eContainer());
          }
        }
      }
    }
  }
  
  public static String determineEntityType(final EObject eo) {
    if ((eo instanceof AgentImpl)) {
      return "agent";
    } else {
      if ((eo instanceof GroupImpl)) {
        return "group";
      } else {
        if ((eo instanceof EnvironmentImpl)) {
          return "environment";
        } else {
          if ((eo instanceof SystemImpl)) {
            return "system";
          } else {
            if ((eo instanceof ObjectImpl)) {
              return "object";
            } else {
              return "ERROR 3";
            }
          }
        }
      }
    }
  }
  
  public static boolean checkForSpecialCase(final Field f) {
    String fieldName = HelperFunctions.getFieldName(f);
    return false;
  }
}
