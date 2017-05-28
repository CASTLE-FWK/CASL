package uofa.lbirdsey.castle.validation

import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider
import org.eclipse.xtext.validation.Check
import uofa.lbirdsey.castle.casl.Agent
import uofa.lbirdsey.castle.casl.CAS_Inspection_Level
import uofa.lbirdsey.castle.casl.CAS_Rule_Exception
import uofa.lbirdsey.castle.casl.CAS_Rule_Types
import uofa.lbirdsey.castle.casl.CaslPackage
import uofa.lbirdsey.castle.casl.System
import uofa.lbirdsey.castle.casl.CAS_Semantic_Group_Switch
import uofa.lbirdsey.castle.casl.End_Condition
import uofa.lbirdsey.castle.casl.Field
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.Concern
import java.util.ArrayList
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions

class SystemValidator extends AbstractCASLValidator {
	
	/*****Fields? *****/
	CAS_Rule_Types ruletype = null; 
	CAS_Inspection_Level inspection_level = null;
	EList<CAS_Rule_Exception> exceptions = null;
	var numberOfAgents = 0;
	

	/*****System Checking *****/
	@Check
	def determineCasFeatures(System system){
		//Provide errors with STRONG and WEAK, warnings with NONE
		ruletype = system.cas_rules.cas_rule
		inspection_level = system.cas_rules.cas_check
		exceptions = system.cas_rules.exceptions
		if (exceptions.length > 3){
			error('Too many exceptions included. Maximum amount of 3 (for now)',CaslPackage::eINSTANCE.system_Cas_rules);
		}	
		//If type is STRICT and exceptions are added that aren't NONE, ERROR 
		if (ruletype == CAS_Rule_Types.STRICT){
			if (exceptions.length == 0 || !exceptions.contains(CAS_Rule_Exception.NONE)){
				error('CAS Ruletype is STRICT but exceptions are provided. Either change to LENIENT or change exceptions to NONE',CaslPackage::eINSTANCE.system_Cas_rules);
			}			
		}
		//This is a lazy hack
		numberOfAgents = system.agent_types.agent_types.length;
		
	}
	
	/**
	 * Checks to see if the end_conditions have been defined in the system parameters
	 */
	@Check
	def checkEndConditionIsDefined(System system){
		var EList<End_Condition> endConditions = system.end_conditions.end_conditions;
		var EList<EObject> parameters = system.system_parameters.fields;
		var ArrayList<String> paramNames = newArrayList();
		var ArrayList<String> undefinedVars = newArrayList();
		for (EObject p : parameters){
			var paramName = "";
			if (p instanceof Field){
				paramName = HelperFunctions.getFieldName(p as Field)
			} else if (p instanceof Concern){
				paramName = (p as Concern).name
			}			
			paramNames.add(paramName);
		}

		var found = false;
		for (End_Condition ec : endConditions){
			for (String p : paramNames){
				if (ec.name.equalsIgnoreCase(p)){
					found = true;
				}
			}
			if (!found){
				undefinedVars.add(ec.name);
			}
			found = false;
		}
		
		if (undefinedVars.size() > 0){
			//Build the nice string
			var missing = "";
			for (String s : undefinedVars){
				missing += s+" ";
			}
			//Throw an error
			error("The following END_CONDITIONS have not been defined in the system PARAMETERS: "+missing,CaslPackage::eINSTANCE.system_End_conditions);
		}
	}
	
	@Check
	def semanticGroupActive(System sys){
		var sgActive = (sys.cas_rules.semanticgroups == CAS_Semantic_Group_Switch.ENABLE);
		var numGroups = sys.group_types.group_types.size
		if (sgActive){
			if (numGroups < 1){
				warning("Semantic Groups is on. Please define a group in the list and a full definition below.",CaslPackage::eINSTANCE.system_Group_types)	
			}
		} else {
			if (numGroups > 0){
				warning("Semantic Groups is disabled. Implemented groups won't be generated",CaslPackage::eINSTANCE.system_Cas_rules)
			}
		}
		
	}
	
	//This uses the dodgy System types thing
	@Check
	def determineNumberOfAgents(){
		var dgsp = new DefaultGlobalScopeProvider;
		if (ruletype == CAS_Rule_Types.STRICT || (ruletype == CAS_Rule_Types.LENIENT && !exceptions.contains(CAS_Rule_Exception.DIVERSITY))){
			if (numberOfAgents == 1){
				error('Only a single agent has been specified. Either define some more of change rule type to LENIENT and add the DIVERSITY exception.',CaslPackage::eINSTANCE.system_Cas_rules)
			}
		}
	}
	
		//CAS CHECKS
	@Check
	def checkCasFeatures(Agent agent){
		//Provide errors with STRONG and WEAK, warnings with NONE
		//Do the feature checking
		if (inspection_level == CAS_Inspection_Level.STRONG || inspection_level == CAS_Inspection_Level.WEAK){
			//All rules
			if (ruletype == CAS_Rule_Types.STRICT){
				if (agent.agent_adaptation.adaptation.length == 0) {
					error(agent.getName()+" does not have any adaptive processes specified. Either create one or change CAS Type to \'lenient\' with \'adaptation\' exception",CaslPackage::eINSTANCE.agent_Agent_adaptation)
				}
				if (agent.agent_subSystems.subSystems == 0 && agent.agent_subSystems.subAgents == 0 && agent.agent_subSystems.subEnvs == 0) {
					error(agent.getName()+" does not have any subsystems specified. Either create one or change CAS Type to \'lenient\' with \'modularity\' exception",CaslPackage::eINSTANCE.agent_Agent_subSystems)
				}
				
			//All rules minus the exceptions
			} else {
				if (!exceptions.contains(CAS_Rule_Exception.ADAPTATION)) {
					if (agent.agent_adaptation.adaptation.length == 0) {
						error(agent.getName()+" does not have any adaptive processes specified. Either create one or change CAS Type to \'lenient\' with \'adaptation\' exception",CaslPackage::eINSTANCE.agent_Agent_adaptation)
					}				
				}
				
				if (!exceptions.contains(CAS_Rule_Exception.MODULARITY)) {
					if (agent.agent_subSystems.subSystems == 0 && agent.agent_subSystems.subAgents == 0 && agent.agent_subSystems.subEnvs == 0) {
						error(agent.getName()+" does not have any subsystems specified. Either create one or change CAS Type to \'lenient\' with \'modularity\' exception",CaslPackage::eINSTANCE.agent_Agent_subSystems)
					}				
				}
			}
		}		
	}
	
}