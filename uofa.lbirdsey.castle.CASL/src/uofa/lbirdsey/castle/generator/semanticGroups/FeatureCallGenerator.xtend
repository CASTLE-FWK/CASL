package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.FeatureCall
import uofa.lbirdsey.castle.casl.AdaptiveProcessFeatureCall
import uofa.lbirdsey.castle.casl.AgentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.InteractionFeatureCall
import uofa.lbirdsey.castle.casl.FunctionFeatureCall
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import uofa.lbirdsey.castle.casl.BehaviorFeatureCall
import uofa.lbirdsey.castle.casl.FeatureCallExp
import uofa.lbirdsey.castle.casl.Function
import uofa.lbirdsey.castle.casl.GroupInternalInteractionsFeatureCall
import uofa.lbirdsey.castle.casl.GroupSelfInternalInteractionsFeatureCall
import uofa.lbirdsey.castle.casl.GroupExternalInteractionFeatureCall
import uofa.lbirdsey.castle.casl.ExternalInteractionFeatureCall
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Helpers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions

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
		} else if (fc instanceof GroupInternalInteractionsFeatureCall) {
			return HelperFunctions.inferMethodType((fc as GroupInternalInteractionsFeatureCall).process.body)
		} else if (fc instanceof GroupSelfInternalInteractionsFeatureCall) {
			return HelperFunctions.inferMethodType((fc as GroupSelfInternalInteractionsFeatureCall).process.body)
		} else if (fc instanceof GroupExternalInteractionFeatureCall) {
			return HelperFunctions.inferMethodType((fc as GroupExternalInteractionFeatureCall).process.body)
		} else if (fc instanceof ExternalInteractionFeatureCall) {
			return HelperFunctions.inferMethodType((fc as ExternalInteractionFeatureCall).process.body)
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
				var entityType = Helpers.determineOwner(bfc.process.eContainer.eContainer);
				var str = "cleanupTriggers.add(new Trigger("+Printers.getNameForTrigger(bfc.process.name)+",true));"
				return str;							
			} else if (bfc.process.behavior_reaction_time == BehaviorReactionTime.STEP) {
				if (bfc.process.reaction_time_parm !== null) {
					var str = "addFutureTrigger(new Trigger("+Printers.getNameForTrigger(bfc.process.name)+",true));"
					return str;
				}				
			}							
		} else if (fc instanceof GroupInternalInteractionsFeatureCall) {
			'''«(fc as GroupInternalInteractionsFeatureCall).grp.name».«(fc as GroupInternalInteractionsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupSelfInternalInteractionsFeatureCall) {
			'''«(fc as GroupSelfInternalInteractionsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupExternalInteractionFeatureCall) {
			'''«(fc as GroupExternalInteractionFeatureCall).grp.name».«(fc as GroupExternalInteractionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
		} else if (fc instanceof ExternalInteractionFeatureCall) {
			'''«(fc as ExternalInteractionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
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
				var entityType = Helpers.determineOwner(bfc.process.eContainer.eContainer);
				var str = "cleanupTriggers.add(new Trigger("+Printers.getNameForTrigger(bfc.process.name)+",true));"
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
					var str = "addFutureTrigger(new Trigger("+Printers.getNameForTrigger(bfc.process.name)+",true));"
					return str;
				}				
			}							
		} else if (fc instanceof GroupInternalInteractionsFeatureCall) {
			'''«(fc as GroupInternalInteractionsFeatureCall).grp.name».«(fc as GroupInternalInteractionsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupSelfInternalInteractionsFeatureCall) {
			'''«(fc as GroupSelfInternalInteractionsFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''
		} else if (fc instanceof GroupExternalInteractionFeatureCall) {
			'''«(fc as GroupExternalInteractionFeatureCall).grp.name».«(fc as GroupExternalInteractionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
		} else if (fc instanceof ExternalInteractionFeatureCall) {
			'''«(fc as ExternalInteractionFeatureCall).process.name»(«HelperFunctions.printFunctionArgs(fc.inputs)»)'''	
		}
		else '''ERROR WITH FEATURE CALL:«fc.toString»'''
	}
}