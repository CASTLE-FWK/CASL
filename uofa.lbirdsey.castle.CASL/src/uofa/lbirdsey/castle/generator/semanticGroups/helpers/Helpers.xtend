package uofa.lbirdsey.castle.generator.semanticGroups.helpers

import uofa.lbirdsey.castle.casl.impl.AgentImpl
import uofa.lbirdsey.castle.casl.impl.GroupImpl
import uofa.lbirdsey.castle.casl.impl.EnvironmentImpl
import uofa.lbirdsey.castle.casl.impl.SystemImpl
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.impl.ObjectImpl
import java.util.ArrayList

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
	
	
	
}