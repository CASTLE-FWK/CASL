package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.FeatureCall
import uofa.lbirdsey.castle.casl.AdaptiveProcessFeatureCall
import uofa.lbirdsey.castle.casl.AgentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.InteractionFeatureCall
import uofa.lbirdsey.castle.casl.FunctionFeatureCall
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import uofa.lbirdsey.castle.casl.GroupInternalsFeatureCall
import uofa.lbirdsey.castle.casl.GroupSelfInternalsFeatureCall
import uofa.lbirdsey.castle.casl.GroupTransmissionFeatureCall
import uofa.lbirdsey.castle.casl.TransmissionFeatureCall
import uofa.lbirdsey.castle.casl.BehaviorFeatureCall
import uofa.lbirdsey.castle.casl.FeatureCallExp
import uofa.lbirdsey.castle.casl.Function

class FeatureCallGenerator {
	
	//Determine the return type of the feature call
	static def String inferFeatureCallType(FeatureCallExp featcall){
		var fc = featcall.func.fc;
		if (fc instanceof AdaptiveProcessFeatureCall)
			return HelperFunctions.inferMethodType((fc as AdaptiveProcessFeatureCall).process.body)
		else if (fc instanceof AgentInteractionFeatureCall)
			return HelperFunctions.inferMethodType((fc as AgentInteractionFeatureCall).process.body)
		else if (fc instanceof EnvironmentInteractionFeatureCall)
			return HelperFunctions.inferMethodType((fc as EnvironmentInteractionFeatureCall).process.body)
		else if (fc instanceof InteractionFeatureCall){
			var ifc = (fc as InteractionFeatureCall).process;
			return HelperFunctions.inferMethodType(ifc.body);  							
		} else if (fc instanceof FunctionFeatureCall){
			var ifc = (fc as FunctionFeatureCall).process;
			if ((ifc as Function).returnType !== null){
				return HelperFunctions.inferSymbolType((ifc as Function).returnType)
			} else {
				return "void"
			} 
			
		}else if (fc instanceof BehaviorFeatureCall) {
			var bfc = (fc as BehaviorFeatureCall).process;
			if (bfc.behavior_reaction_time == BehaviorReactionTime.INSTANT){
				return HelperFunctions.inferMethodType(bfc.body);
			} else {
				return "void";
			}
		} else if (fc instanceof GroupInternalsFeatureCall) {
			return HelperFunctions.inferMethodType((fc as GroupInternalsFeatureCall).process.body)
		} else if (fc instanceof GroupSelfInternalsFeatureCall) {
			return HelperFunctions.inferMethodType((fc as GroupSelfInternalsFeatureCall).process.body)
		} else if (fc instanceof GroupTransmissionFeatureCall) {
			return HelperFunctions.inferMethodType((fc as GroupTransmissionFeatureCall).process.body)
		} else if (fc instanceof TransmissionFeatureCall) {
			return HelperFunctions.inferMethodType((fc as TransmissionFeatureCall).process.body)
		}
		else "Error with inferring featurecall"
		
		
	}
	
	static def printFeatureCall(FeatureCall featcall) {
		val fc = featcall.fc
		if (fc instanceof AdaptiveProcessFeatureCall)
		'''«(fc as AdaptiveProcessFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		else if (fc instanceof AgentInteractionFeatureCall)
		'''«(fc as AgentInteractionFeatureCall).agt.name».«(fc as AgentInteractionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		else if (fc instanceof EnvironmentInteractionFeatureCall)
		'''«(fc as EnvironmentInteractionFeatureCall).env.name».«(fc as EnvironmentInteractionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		else if (fc instanceof InteractionFeatureCall)
		'''«(fc as InteractionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		else if (fc instanceof FunctionFeatureCall)
		'''«(fc as FunctionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		else if (fc instanceof BehaviorFeatureCall) {
			 var bfc = (fc as BehaviorFeatureCall);
			 if (bfc.process.behavior_reaction_time == BehaviorReactionTime.INSTANT) {
				return bfc.process.name+"("+HelperFunctions.printFunctionArgs(fc.inputs)+")"
			} else if (bfc.process.behavior_reaction_time == BehaviorReactionTime.DELAYED) {
				//Get entity type
				var entityType = HelperFunctions.determineOwner(bfc.process.eContainer.eContainer);
				var str = "cleanupTriggers.add(new Trigger("+HelperFunctions.getNameForTrigger(bfc.process.name)+",true));"
				return str;							
			} else if (bfc.process.behavior_reaction_time == BehaviorReactionTime.STEP) {
				if (bfc.process.reaction_time_parm !== null) {
					var str = "addFutureTrigger(new Trigger("+HelperFunctions.getNameForTrigger(bfc.process.name)+",true));"
					return str;
				}				
			}							
		} else if (fc instanceof GroupInternalsFeatureCall) {
			'''«(fc as GroupInternalsFeatureCall).grp.name».«(fc as GroupInternalsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupSelfInternalsFeatureCall) {
			'''«(fc as GroupSelfInternalsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupTransmissionFeatureCall) {
			'''«(fc as GroupTransmissionFeatureCall).grp.name».«(fc as GroupTransmissionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
		} else if (fc instanceof TransmissionFeatureCall) {
			'''«(fc as TransmissionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
		}
		else '''ERROR WITH FEATURE CALL:«fc.toString»'''	
	}
	
	
	
	
	static def String getFeatureCallName(FeatureCall fc){
		if (fc instanceof AdaptiveProcessFeatureCall)
		'''«(fc as AdaptiveProcessFeatureCall).process.name»'''
		else if (fc instanceof AgentInteractionFeatureCall)
		'''«(fc as AgentInteractionFeatureCall).agt.name»'''
		else if (fc instanceof EnvironmentInteractionFeatureCall)
		'''«(fc as EnvironmentInteractionFeatureCall).env.name»'''
		else if (fc instanceof InteractionFeatureCall)
		'''«(fc as InteractionFeatureCall).process.name»'''
		else if (fc instanceof FunctionFeatureCall)
		'''«(fc as FunctionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		else if (fc instanceof BehaviorFeatureCall) {
			 var bfc = (fc as BehaviorFeatureCall);
			 if (bfc.process.behavior_reaction_time == BehaviorReactionTime.INSTANT) {
				return bfc.process.name+"("+HelperFunctions.printFunctionArgs(fc.inputs)+")"
			} else if (bfc.process.behavior_reaction_time == BehaviorReactionTime.DELAYED) {
				//Get entity type
				var entityType = HelperFunctions.determineOwner(bfc.process.eContainer.eContainer);
				var str = "cleanupTriggers.add(new Trigger("+HelperFunctions.getNameForTrigger(bfc.process.name)+",true));"
//				str += "Function<"+entityType+",Void> fn = new Function<"+entityType+",Void>() {"
//				+"\n\t\tpublic Void apply("+entityType+" o) {"
//				+"\n\t\t\to."+bfc.process.name+"("+printFunctionArgs(fc.inputs)+");"
//				+"\n\t\t\treturn null;"
//				+"\n\t\t}"
//				+"\n\t};"
//				+"\n\tcleanupQueue.add(fn);"
				return str;							
			} else if (bfc.process.behavior_reaction_time == BehaviorReactionTime.STEP) {
				if (bfc.process.reaction_time_parm !== null) {
					var str = "addFutureTrigger(new Trigger("+HelperFunctions.getNameForTrigger(bfc.process.name)+",true));"
					return str;
				}				
			}							
		} else if (fc instanceof GroupInternalsFeatureCall) {
			'''«(fc as GroupInternalsFeatureCall).grp.name».«(fc as GroupInternalsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupSelfInternalsFeatureCall) {
			'''«(fc as GroupSelfInternalsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupTransmissionFeatureCall) {
			'''«(fc as GroupTransmissionFeatureCall).grp.name».«(fc as GroupTransmissionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
		} else if (fc instanceof TransmissionFeatureCall) {
			'''«(fc as TransmissionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
		}
		else '''ERROR WITH FEATURE CALL:«fc.toString»'''
	}
}