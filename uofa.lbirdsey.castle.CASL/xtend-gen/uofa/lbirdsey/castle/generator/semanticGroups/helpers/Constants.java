package uofa.lbirdsey.castle.generator.semanticGroups.helpers;

import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Constants {
  public final static String LAYOUT_PARAMETERS_NAME = "layoutParameters";
  
  public final static String TAB = "\t";
  
  public final static String NL = "\n";
  
  public final static String RETURN_ = "return ";
  
  public final static String SC = ";";
  
  public final static String AGENT = "agent";
  
  public final static String ENVIRONMENT = "environment";
  
  public final static String GROUP = "group";
  
  public final static String SYSTEM = "system";
  
  public final static String OBJECT = "object";
  
  public final static String LINE_END = (Constants.SC + Constants.NL);
  
  public static String printCASLError(final String description, final String location, final String clazz) {
    InputOutput.<String>println(((((("ERROR: " + description) + " at loc: ") + location) + " class: ") + clazz));
    return (((((("[ERROR: " + description) + " at loc: ") + location) + " class: ") + clazz) + "]");
  }
}
