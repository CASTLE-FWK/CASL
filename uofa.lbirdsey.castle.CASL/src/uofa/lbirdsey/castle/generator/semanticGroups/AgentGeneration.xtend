package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.Agent
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.State_Block
import uofa.lbirdsey.castle.casl.NumberLiteral
import uofa.lbirdsey.castle.casl.InteractionTriggerTypes
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import java.util.ArrayList
import java.util.HashSet
import java.math.BigDecimal

class AgentGeneration {
	Agent theAgent = null;
	var agentsPkg = "";
	var systemRoot = "";
	var fileContents = "";
	var ArrayList<String> libImports = null;
	var HashSet<String> importsToPrint = null;
	var ArrayList<String> initialList = null;
	
	
	new(Agent a, String systemRoot, String agentsPkg) {
		theAgent = a;
		this.systemRoot = systemRoot;
		this.agentsPkg = agentsPkg;
		libImports = new ArrayList<String>();
		importsToPrint = new HashSet<String>();
		initialList = new ArrayList<String>();
	}
	
	def setup(){
		fileContents = printLocal() as String;
		//Add in the imports
		var imports = "//Automated Agent Import Generation\nimport repastGroups.Agent;\n";
		imports += "import repastGroups.SemanticGroup;\n"
		//iC = importCandidate
		for (String iC : libImports){
			if (iC !== null){
				//imports += HelperFunctions.parseTypesAsString(iC, systemRoot);
				var str = HelperFunctions.parseTypesAsString(iC, systemRoot);
				var String[] splt = str.split(";");
				for (String s : splt){
					if (s.length() > 0){
						importsToPrint.add(s+";");						
					}	
				}				
			}
		}
		
		for (String iC : importsToPrint){
			imports += iC+"\n";
		}
		//What other dynamic stuff is needed...

		//Prepend import statements
		fileContents = imports +"\n" + fileContents;
		//Prepend package declaration
		fileContents = "package "+agentsPkg+";\n\n" + fileContents;
	}
	
	def String printLocal()'''		
		«RepastSpecifics.generateAgentBuilder()»
		
		public class «theAgent.name» extends Agent {
			/*Description: «theAgent.desc»*/
			
			/*****«theAgent.name.toFirstUpper» Initialisation*****/
			«agentInitialisation(theAgent)»
			
			/*****«theAgent.name.toFirstUpper» Parameters*****/
			«generateParameters(theAgent)»
			
			/*****«theAgent.name.toFirstUpper» Functions*****/
			«generateFunctions(theAgent)»
			
			/*****«theAgent.name.toFirstUpper» Behaviors*****/
			«generateBehaviors(theAgent)»
			
			/*****«theAgent.name.toFirstUpper» Interactions*****/
			«generateInteractions(theAgent)»
		
			/*****«theAgent.name.toFirstUpper» Adaptation*****/
			«generateAdaptations(theAgent)»
				
			/*****«theAgent.name.toFirstUpper» Subsystems*****/
			«generateSubsystems(theAgent)»
			
			/*****«theAgent.name.toFirstUpper» Simulate Calls*****/
			«generateSimulateFunction(theAgent)»
			
			/*****Pre-defined Schedules - setup(), action(), and cleanup()*****/
			«createInitalisePhase(theAgent)»
			«assignActionsToPhases(theAgent)»
		«««			«createSetupPhase(theAgent)»
«««			«createActionPhase(theAgent)»
«««			«createCleanupPhase(theAgent)»
			«createFinalPhase(theAgent)»
		}
	'''
			
	def String print(){
		return fileContents;
	}

	
	def agentInitialisation(Agent a)'''
		ArrayList<Function<«a.name»,Void>> setupQueue;
		ArrayList<Function<«a.name»,Void>> actionQueue;
		ArrayList<Function<«a.name»,Void>> cleanupQueue;
		
		public «a.name»(EntityID id) {
			super("«a.name»",id);
		}
	'''
	
	def importPass(Agent a){
		
	}
	
	def generateFunctions(Agent a){
		var output = "";
		for (function : a.agent_functions.functions){
			output += "public "
			if (function.returnType !== null){
				if (!(function.returnType instanceof FunctionParameter)){
						libImports.add(HelperFunctions.getFieldType(function.returnType as Field))
				}
				output += HelperFunctions.inferSymbolType(function.returnType)+" ";
			} else {
				output += "void ";
			}
			output += function.name+"("+HelperFunctions.printFunctionParameters(function.functionParameters)+") {\n";
			if (function.returnType !== null){
				output += "\t"+HelperFunctions.inferFunctionParameterType(function.returnType as FunctionParameter)+" "
				output += function.returnType.name+" = "+HelperFunctions.initialiseFunctionParameterReturn(function.returnType as FunctionParameter) +";\n";
			}
			if (function.name.compareTo("initialize") == 0){
				for (sb : a.agent_parameters.fields){
					if (sb instanceof State_Block){
						for (sbf : sb.stateFields){
							output += "\tregisterState(\""+sbf.ref.name+"\","+sbf.ref.name+");\n"
						}
					}
				}
			}
			for (statement : function.body){
				if (statement instanceof Field){
					libImports.add("Error: FUNCBD "+HelperFunctions.getFieldType(statement as Field))
				}
				output += "\t"+HelperFunctions.parseBodyElement(statement, function)+"\n"
			}
			if (function.returnType !== null){
				output += "\treturn "+function.returnType.name+";\n"
			}
			output += "\n}\n"
		}
		return output;
	}
	
	def generateParameters(Agent a){
		var output = "//Fields\n"
		for (field : a.agent_parameters.fields){
			if (field instanceof Field){
				output += "private "+HelperFunctions.printFieldDeclarations(field as Field)+";\n";
				libImports.add(HelperFunctions.getFieldType(field as Field));
			} else if (field instanceof State_Block){}			
		}
		
		output += "\n//Getters & Setters\n"
		for (field : a.agent_parameters.fields){
			if (field instanceof Field){
				output +=HelperFunctions.generateGettersSetters(field as Field)+"\n"
			}
		}
		return output;
	}  
	
	def generateBehaviors(Agent a){
		var output = "";
		for (behavior : a.agent_behaviors.behaviors){			
			output += "public ";
			output += HelperFunctions.inferMethodType(behavior.body)+" " +behavior.name+ "(" + HelperFunctions.printFunctionParameters(behavior.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(behavior.body, behavior)
			libImports.addAll(HelperFunctions.populateImports(behavior.body))
			output += "\n}\n"
			
			//Create the trigger object here
			var triggerString = "";
//			var phase = behavior.behavior_reaction_time.toString().toLowerCase();
			if (behavior.behavior_reaction_time == BehaviorReactionTime.STEP){
				val steps = (HelperFunctions.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggerString = HelperFunctions.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>()\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+a.name.toFirstUpper+") o)."+behavior.name+"();\n"
				triggerString += "\\ttreturn null;\n}}, false, this);\n\n"
				output += triggerString;
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.DELAYED){
				triggerString = HelperFunctions.getNameForTrigger(behavior.name) +" = new Trigger (1, \""+behavior.name+"\", new Function<Entity,Void>()\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+a.name.toFirstUpper+") o)."+behavior.name+"();\n"
				triggerString += "\t\treturn null;\n}}, false, this);\n\n"
				output += triggerString;
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				val steps = (HelperFunctions.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggerString = HelperFunctions.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>()\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+a.name.toFirstUpper+") o)."+behavior.name+"();\n"
				triggerString += "\t\treturn null;\n}}, true, this);\n\n"
				initialList.add("actionTriggers.add("+HelperFunctions.getNameForTrigger(behavior.name)+"(this))");
				output += triggerString;
			}
		}
		return output;
	}
	
	def generateInteractions(Agent a) {
		var output = "";
		for (interaction : a.agent_interactions.interactions) {
			for (interFP : interaction.functionParameters){
				if (interFP !== null){
					if (!(interFP instanceof FunctionParameter)){ 
						libImports.add(HelperFunctions.getFieldType(interFP as Field))
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(interaction.body)+" " +interaction.name+ "(" + HelperFunctions.printFunctionParameters(interaction.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(interaction.body, interaction)
			libImports.addAll(HelperFunctions.populateImports(interaction.body))
//			for (statement : interaction.body){
//				if (statement instanceof Field){
//					libImports.add(HelperFunctions.getFieldType(statement as Field))
//				}				
//				output += "\t" + HelperFunctions.parseBodyElement(statement, interaction) +"\n"
//			}
//			output += "\treturn "+HelperFunctions.printMethodReturnStatement(interaction.body)+";"
			output += "\n}\n"	
		}
		return output	
	}
	
	def generateAdaptations(Agent a) {
		var output = "";
		for (adaptation : a.agent_adaptation.adaptation) {
			for (adaptFP : adaptation.functionParameters){
				if (adaptFP !== null){
					if (!(adaptFP instanceof FunctionParameter)){
						libImports.add(HelperFunctions.getFieldType(adaptFP as Field))
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(adaptation.body)+" " +adaptation.name+ "(" + HelperFunctions.printFunctionParameters(adaptation.functionParameters) +")"
			output += " {\n"
//			for (statement : adaptation.body){
//				if (statement instanceof Field){
//					libImports.add(HelperFunctions.getFieldType(statement as Field))
//				}
//				output += "\t" + HelperFunctions.parseBodyElement(statement, adaptation) +"\n"
//			}
//			output += "\treturn "+HelperFunctions.printMethodReturnStatement(adaptation.body)+";"
			output += HelperFunctions.printMethodBody(adaptation.body, adaptation)
			libImports.addAll(HelperFunctions.populateImports(adaptation.body))
			output += "\n}\n"			
		}
		return output;
	}
	
	def generateSubsystems(Agent a){
		var output = "";
		for (subsystem : a.agent_subSystems.subSystems) {
			output += "private void "+subsystem.name+"("
			output += HelperFunctions.printFunctionParameters(subsystem.functionParameters)
			output += ") {\n"			
//			for (statement : subsystem.body) {
//				if (statement instanceof Field){
//					libImports.add(HelperFunctions.getFieldType(statement as Field))
//				}
//				output += "\t"+HelperFunctions.parseBodyElement(statement, subsystem);
//			}
			output += HelperFunctions.printMethodBody(subsystem.body, subsystem)
			libImports.addAll(HelperFunctions.populateImports(subsystem.body))
			output += "\n}\n"			
		}
		return output;
	}
	
	def String generateSimulateFunction(Agent agt){
		var str = "";
			str += "@Override\npublic void run(){\n\tsimulate();\n}\n"
			str += "public void simulate() {\n";
			str += "\tif (getCurrentPhase() == Phase.SETUP) {\n"
			str += "\t\tphase_Setup();\n"
			str += "\t} else if (getCurrentPhase() == Phase.ACTION) { \n"
			str += "\t\tphase_Action();\n"
			str += "\t} else if (getCurrentPhase() == Phase.CLEANUP) {\n"
			str += "\t\tphase_Cleanup();\n"
			str += "\t}\n"			 
			str += "}\n"
		return str;
	}
	
	
	def createFinalPhase(Agent a)'''
																		@Override
																		public void final_call(){
																		}
																	'''
	
	def String createInitalisePhase(Agent a){
		var output = "";
		output += "@Override\n";
		output += "public void initialise() {\n\tsuper.initialise();\n\t";
		
		for (item : initialList){
			output += "\t"+item+";\n"; 
		}


		output += "}\n";
		return output;
	}
	
	
	//Things that trigger each step in setup, action, cleanup should be directly called
	//in their respective phases. Things that trigger every few steps (but regularly) ...?
	//On demand actions can be placed inside a Schedule object, which contains the time until trigger
	
	//Each sub part of this should go into the HelperFunctions class since all 3 entity types need to use it 
	
	
	def assignActionsToPhases(Agent a){
		var triggeredActions = newArrayList
		var setupPhase = newArrayList
		var actionPhase = newArrayList
		var cleanupPhase = newArrayList
		var str = "//Schedules\n"
		
		//Behavior scheduling
		for (behavior : a.agent_behaviors.behaviors) {
			if (behavior.behavior_reaction_time == BehaviorReactionTime.STEP){
				//This should be called x steps late. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.INSTANT){
				//This should be called instantly somehow and not appear in the triggers. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.DELAYED){
				//This should be pushed to the cleanup phase in the same step. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				val steps = (HelperFunctions.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				if (steps == 1){
					actionPhase.add(behavior.name+"(this);")
				} else {
					var interAsFunc = "TO_DO (generation behaviour repeat > 1 step"; //TODO: This...thing
					var tObj = "Trigger "+behavior.name+"_trigger = new Trigger("+steps+","+interAsFunc+", true, "+a.name.toFirstUpper+".class);"
					triggeredActions.add(tObj)	
				}
			}
		}
		for (interaction : a.agent_interactions.interactions) {
			if (interaction.trigger_type == InteractionTriggerTypes.STEP){
				//Expecting a numeric value
				var steps = (interaction.triggerParam.expr as NumberLiteral).value.toBigInteger.intValue
				if (steps.equals(1)) {
					actionPhase.add(interaction.name+"(this);")	
				} else {
					var interAsFunc = "TO_DO";
					var tObj = "Trigger "+interaction.name+"_trigger = new Trigger("+steps+","+interAsFunc+", true, "+a.name.toFirstUpper+");"
					triggeredActions.add(tObj)	
				}
			}					
		}
		
		//Set up the triggered objects
//		str += "ArrayList<Trigger> triggers = new ArrayList<Trigger>();\n"
		for (trig : triggeredActions){
			str += trig+"\n"
		}
		
		//Print the phases
		//Setup phase
		str += "@Override\n"
		str += "public void phase_Setup() {\n"
//		str += "\tcleanupQueue.clear();\n"
		str += "\tsetupQueue.forEach(f -> f.apply(this));\n"
		for (item : setupPhase){
			str += "\t"+item+"\n"
		}
		str += "\t//Activate triggers\n"
		str += "\tfor (Trigger t : setupTriggers) {\n"
		str += "\t\tt.trigger();\n"
		str += "\t}\n"
		str +="}\n\n"
		
		//Action Phase
		str += "@Override\n"
		str += "public void phase_Action() {\n"
//		str += "\tsetupQueue.clear();\n"
		for (item : actionPhase){
			str += "\t"+item+"\n"
		}
		str += "\t//Activate triggers\n"
		str += "\tfor (Trigger t : triggers) {\n"
		str += "\t\tt.trigger();\n"
		str += "\t}\n"
		str +="}\n\n"
				
		//Cleanup phase
		str += "@Override\n"
		str += "public void phase_Cleanup() {\n"
//		str += "\tactionQueue.clear();\n"
		str += "\tcleanupQueue.forEach(f -> f.apply(this));\n"
		for (item : cleanupPhase){
			str += "\t"+item+"\n"
		}
		str += "\t//Activate triggers\n"
		str += "\tfor (Trigger t : cleanupTriggers) {\n"
		str += "\t\tt.trigger();\n"
		str += "\t}\n"
		str +="}\n\n"

		return str;		
	}
	

	def createSetupPhase(Agent a)'''
																						@Override
																						public void phase_Setup(){
																							cleanupQueue.clear();
																						}
																					'''
	
	def createActionPhase(Agent a)'''
																						@Override
																						public void phase_Action(){
																						}
																					'''
	
	
	def createCleanupPhase(Agent a)'''
																						public void phase_Cleanup(){
																							cleanupQueue.forEach(f -> f.apply(this));
																								«FOR sb : a.agent_parameters.fields»
																									«IF sb instanceof State_Block»
																										«FOR sbf : sb.stateFields»
																											updateState("«sbf.ref.name»",«sbf.ref.name»);
																										«ENDFOR»
																									«ENDIF»
																							«ENDFOR»
																						}
																					'''
}
																				