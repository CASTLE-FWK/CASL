package uofa.lbirdsey.castle.generator.semanticGroups.helpers;

import org.eclipse.xtext.xbase.lib.Exceptions;

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
  
  public static String throwCASLError(final String description, final String location, final String clazz) {
    try {
      throw new Exception(((((("ERROR: " + description) + " at loc: ") + location) + " class: ") + clazz));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
