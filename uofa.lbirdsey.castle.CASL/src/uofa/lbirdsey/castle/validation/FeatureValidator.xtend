package uofa.lbirdsey.castle.validation

import org.eclipse.xtext.validation.Check
import uofa.lbirdsey.castle.casl.Behavior
import uofa.lbirdsey.castle.casl.BehaviorType
import uofa.lbirdsey.castle.casl.CaslPackage
import uofa.lbirdsey.castle.casl.Interaction
import uofa.lbirdsey.castle.casl.InteractionFeatureCall
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.FeatureCallExp

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
					error(fn.name+" contains an Interaction but Behavior Type is set to SELF. Change to AFFECT or remove the INTERACTION", CaslPackage::eINSTANCE.behavior_Name)			
				} else if (!(beh instanceof InteractionFeatureCall) && !(fn.behavior_type == BehaviorType.SELF)){
					//If does not contains an interaction trigger and is set to self, warn/error
					error(fn.name+" is set to AFFECT but has no INTERACTION.", CaslPackage::eINSTANCE.behavior_Name)			
				}			
			} 
		}
	}

	//Interaction checks
	@Check
	def checkInteractions(Interaction inter){
		//Check that the Interaction actually COMMUNICATEs or QUERYs		
		
		val interBody = inter.body;
		for (ib : interBody){
			
		}
	}
	
}