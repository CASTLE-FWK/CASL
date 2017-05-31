package uofa.lbirdsey.castle.generator.semanticGroups.helpers

import uofa.lbirdsey.castle.casl.impl.AgentImpl
import uofa.lbirdsey.castle.casl.impl.GroupImpl
import uofa.lbirdsey.castle.casl.impl.EnvironmentImpl
import uofa.lbirdsey.castle.casl.impl.SystemImpl
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.impl.ObjectImpl
import java.util.ArrayList
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.Entity_Call
import uofa.lbirdsey.castle.casl.Agent_Call
import uofa.lbirdsey.castle.casl.Environment_Call
import uofa.lbirdsey.castle.casl.Group_Call

class Helpers {
	
	static var ArrayList<EObject> types = new ArrayList<EObject>();
	static var systemName = "";

	static def setSystemName(String n) {
		systemName = n;
	}

	static def getSystemName() {
		return systemName;
	}
	
	static def ArrayList<EObject> getTypes(){
		return types;
	}
	
	static def initTypesList() {
		types = new ArrayList<EObject>();
	}

	static def addToTypesArray(EObject type) {
		types.add(type);
	}
	
	//Walk up
	static def String determineOwner(EObject eo){
		if (eo instanceof AgentImpl){
			return (eo as AgentImpl).name
		} else if (eo instanceof GroupImpl){
			return (eo as GroupImpl).name
		} else if (eo instanceof EnvironmentImpl){
			return (eo as EnvironmentImpl).name
		} else if (eo instanceof SystemImpl) {
			return (eo as SystemImpl).name
		} else {
			return determineOwner(eo.eContainer);
		}
	}
	
	//Find out what type the EObject is
	static def String determineEntityType(EObject eo){
		if (eo instanceof AgentImpl){
			return "agent";
		} else if (eo instanceof GroupImpl){
			return "group";
		} else if (eo instanceof EnvironmentImpl){
			return "environment";
		} else if (eo instanceof SystemImpl) {
			return "system";
		} else if (eo instanceof ObjectImpl){
			return "object"
		} else {
			return "ERROR 3"
		}
	}	
	
	static def String getEntityNameFromCall(Entity_Call ec){
		if (ec instanceof Agent_Call){
			return (ec as Agent_Call).agent.name;
		} else if (ec instanceof Environment_Call){
			return (ec as Environment_Call).env.name;
		} else if (ec instanceof Group_Call){
			return (ec as Group_Call).grp.name;
		} else {
			return "ERROR: getEntityNameFromCall: "+ec.class
		}
	}
	
	//TODO: Fill this in
	static def boolean checkForSpecialCase(Field f){
		//There are many special cases to handle for parameters and imports
		//This will mainly fix the import issue  but there is also the layoutParameters issue
		var fieldName = HelperFunctions.getFieldName(f);
		
		return false;
	}
	
	//TODO: FIll this in
	static def boolean containsAnInteraction(EObject eo){
		return false;
		
	}
	
	static def boolean isAPrimitive(String str){
		if (str.equalsIgnoreCase("void") ||
				str.equalsIgnoreCase("boolean") ||
				str.equalsIgnoreCase("int")|| 
				str.equalsIgnoreCase("String") ||
				str.equalsIgnoreCase("float") ||
				str.equalsIgnoreCase("double") ) {
				return true;
		}
		return false;
	}
	
	static def boolean isANumber(String str){
		if (
				str.equalsIgnoreCase("int")|| 
				str.equalsIgnoreCase("float") ||
				str.equalsIgnoreCase("double") ) {
				return true;
		}
		return false;	
	}
	
	
	
}