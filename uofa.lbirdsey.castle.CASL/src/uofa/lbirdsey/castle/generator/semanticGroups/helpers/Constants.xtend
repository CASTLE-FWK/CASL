package uofa.lbirdsey.castle.generator.semanticGroups.helpers

class Constants {

	public static val LAYOUT_PARAMETERS_NAME = "layoutParameters";
	public static val String TAB = '\t';
	public static val String NL = '\n';
	public static val RETURN_ = "return ";
	public static val SC = ';';
	public static val AGENT = "agent"
	public static val ENVIRONMENT = "environment"
	public static val GROUP = "group"
	public static val SYSTEM = "system"
	public static val OBJECT = "object"
	public static val LINE_END = SC + NL;
	public static def String throwCASLError(String description, String location, String clazz){
//		println("ERROR: "+description+" at loc: "+location+" class: "+clazz);
		throw new Exception("CASL_ERROR: "+description+" at loc: "+location+" class: "+clazz);
//		return "[ERROR: "+description+" at loc: "+location+" class: "+clazz+"]";
	}
}