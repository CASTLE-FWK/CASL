package uofa.lbirdsey.castle.validation

import org.eclipse.xtext.validation.Check
import uofa.lbirdsey.castle.casl.Behavior
import uofa.lbirdsey.castle.casl.BehaviorType
import uofa.lbirdsey.castle.casl.CaslPackage
import uofa.lbirdsey.castle.casl.Interaction
import uofa.lbirdsey.castle.casl.InteractionFeatureCall
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.FeatureCallExp
import uofa.lbirdsey.castle.casl.GroupExternalInteractionFeatureCall
import uofa.lbirdsey.castle.casl.AgentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.ExternalInteractionFeatureCall
import uofa.lbirdsey.castle.casl.GroupInternalInteractionsFeatureCall
import uofa.lbirdsey.castle.casl.GroupSelfInternalInteractionsFeatureCall

/**
 * This class handles the validation of the features
 */
class FeatureValidator extends AbstractCASLValidator{
	
	@Check
	def checkBehavior(Behavior behavior) {			
		var fn = behavior
		var behaviorBody = fn.body;
		for (EObject bb : behaviorBody){
			//Do the infection type test
			if (bb instanceof FeatureCallExp){
				var beh = (bb as FeatureCallExp).func.fc;
				if (beh instanceof InteractionFeatureCall && fn.behavior_type == BehaviorType.SELF){
					//If contains an interaction trigger and is set to self, warn/error					
					error(fn.name+" contains an Interaction but Behavior Type is set to SELF. Change to AFFECT or remove the INTERACTION", 
						CaslPackage::eINSTANCE.behavior_Name
					)			
				} else if (!(beh instanceof InteractionFeatureCall) && !(fn.behavior_type == BehaviorType.SELF)){
					//If does not contains an interaction trigger and is set to self, warn/error
					error(fn.name+" is set to AFFECT but has no INTERACTION.", CaslPackage::eINSTANCE.behavior_Name)			
				}			
			} 
		}
	}

	/**
	 * Interactions have 3 types: QUERY, INDIRECT, COMMUNICATION
	 * What this validator does is check to see if:
	 *  0: Make sure an actual interaction is happening
	 * 	1: A QUERY interaction is a request
	 *  2: A COMMUNICATE interaction is an acknowledged 2 way request
	 *  3: An INDIRECT interaction can't be validated
	 */
	@Check
	def checkInteractions(Interaction inter){
		val interType = inter.interaction_type;	
		val interBody = inter.body;
		var isAnInteraction = false;
		for (EObject ib : interBody){
			//Find references to other entities
				//Do task 0
				//if (containsAnInteraction(ib)) { //Do Something; }
				
//			if (ib instanceof FeatureCallExp){
//				var beh = (ib as FeatureCallExp).func.fc;
//				if (beh instanceof GroupExternalInteractionFeatureCall){
//					isAnInteraction = true;
//				} else if (beh instanceof AgentInteractionFeatureCall){ 
//					isAnInteraction = true;
//				} else if (beh instanceof EnvironmentInteractionFeatureCall){
//					isAnInteraction = true;
//				} else if (beh instanceof ExternalInteractionFeatureCall){
//					isAnInteraction = true;
//				} else if (beh instanceof GroupInternalInteractionsFeatureCall){
//					isAnInteraction = true;
//				} else if (beh instanceof GroupSelfInternalInteractionsFeatureCall){
//					isAnInteraction = true;
//				}
//			}

			//Explore the references and check to see if
				//Task 1 || Task 2	 
		}
		
//		if (!isAnInteraction){
//			error(inter.name+" is not actually an interaction. Please add some interaction.", CaslPackage::eINSTANCE.interaction_Body)			
//		}
	}
	
}