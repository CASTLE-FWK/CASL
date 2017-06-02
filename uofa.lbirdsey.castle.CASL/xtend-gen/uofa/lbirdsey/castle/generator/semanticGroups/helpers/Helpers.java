package uofa.lbirdsey.castle.generator.semanticGroups.helpers;

import java.util.ArrayList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import uofa.lbirdsey.castle.casl.Agent_Call;
import uofa.lbirdsey.castle.casl.Entity_Call;
import uofa.lbirdsey.castle.casl.Environment_Call;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.Field;
import uofa.lbirdsey.castle.casl.Group_Call;
import uofa.lbirdsey.castle.casl.Symbol;
import uofa.lbirdsey.castle.casl.TypeRef;
import uofa.lbirdsey.castle.casl.impl.AgentImpl;
import uofa.lbirdsey.castle.casl.impl.EnvironmentImpl;
import uofa.lbirdsey.castle.casl.impl.GroupImpl;
import uofa.lbirdsey.castle.casl.impl.ObjectImpl;
import uofa.lbirdsey.castle.casl.impl.SystemImpl;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Constants;
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
      return Constants.AGENT;
    } else {
      if ((eo instanceof GroupImpl)) {
        return Constants.GROUP;
      } else {
        if ((eo instanceof EnvironmentImpl)) {
          return Constants.ENVIRONMENT;
        } else {
          if ((eo instanceof SystemImpl)) {
            return Constants.SYSTEM;
          } else {
            if ((eo instanceof ObjectImpl)) {
              return Constants.OBJECT;
            } else {
              return Constants.printCASLError("Cannot determine entity type", "determineEntityType", "Helpers");
            }
          }
        }
      }
    }
  }
  
  public static String getEntityNameFromCall(final Entity_Call ec) {
    if ((ec instanceof Agent_Call)) {
      return ((Agent_Call) ec).getAgent().getName();
    } else {
      if ((ec instanceof Environment_Call)) {
        return ((Environment_Call) ec).getEnv().getName();
      } else {
        if ((ec instanceof Group_Call)) {
          return ((Group_Call) ec).getGrp().getName();
        } else {
          return Constants.printCASLError("Cannot infer name", "getEntityNameFromCall", "Helpers");
        }
      }
    }
  }
  
  public static String getNameFromExpression(final Expression e) {
    InputOutput.<Class<? extends Expression>>println(e.getClass());
    if ((e instanceof Field)) {
      return HelperFunctions.getFieldName(((Field) e));
    } else {
      if ((e instanceof TypeRef)) {
        return Helpers.getSymbolName(((TypeRef) e).getType());
      } else {
        return Constants.printCASLError("Cannot infer name", "getNameFromExpression", "Helpers");
      }
    }
  }
  
  public static String getEntityTypeFromCall(final Entity_Call ec) {
    if ((ec instanceof Agent_Call)) {
      return Constants.AGENT;
    } else {
      if ((ec instanceof Environment_Call)) {
        return Constants.ENVIRONMENT;
      } else {
        if ((ec instanceof Group_Call)) {
          return Constants.GROUP;
        } else {
          return Constants.printCASLError("Cannot infer entity type", "getEntityTypeFromCall", "Helpers");
        }
      }
    }
  }
  
  public static boolean checkForSpecialCase(final Field f) {
    String fieldName = HelperFunctions.getFieldName(f);
    return false;
  }
  
  public static boolean containsAnInteraction(final EObject eo) {
    return false;
  }
  
  public static boolean isAPrimitive(final String str) {
    if ((((((str.equalsIgnoreCase("void") || 
      str.equalsIgnoreCase("boolean")) || 
      str.equalsIgnoreCase("int")) || 
      str.equalsIgnoreCase("String")) || 
      str.equalsIgnoreCase("float")) || 
      str.equalsIgnoreCase("double"))) {
      return true;
    }
    return false;
  }
  
  public static boolean isANumber(final String str) {
    if (((str.equalsIgnoreCase("int") || 
      str.equalsIgnoreCase("float")) || 
      str.equalsIgnoreCase("double"))) {
      return true;
    }
    return false;
  }
  
  public static String getSymbolName(final Symbol s) {
    return s.getName();
  }
}
