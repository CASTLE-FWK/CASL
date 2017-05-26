package uofa.lbirdsey.castle.validation

import org.eclipse.xtext.validation.Check
import uofa.lbirdsey.castle.casl.CaslPackage
import uofa.lbirdsey.castle.casl.System
import uofa.lbirdsey.castle.casl.Agent

class AgentValidator extends AbstractCASLValidator {
	/*****Agent Checking *****/
	@Check
	def checkAgentHasBeenDefined(Agent agent, System system){
		var agent_types = system.getAgent_types().agent_types.toArray()
		for (a : agent_types) {
			if ((a as String).compareTo(agent.getName()) != 0) {
				warning('Agent has not been described in the SYSTEM structure.',
				CaslPackage::eINSTANCE.entity_Name,
				"blorp")
			}
		}	
	}
	
	@Check
	def validateAgent(Agent agt){
//		checkAgentBehavior(agt.agent_behaviors);
	}
	

	
	
	//	@Check
	def checkAgentInteractions(Agent age){
		
	}
}