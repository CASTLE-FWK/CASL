package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.Agent
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.Concern
import uofa.lbirdsey.castle.casl.NumberLiteral
import uofa.lbirdsey.castle.casl.InteractionTriggerTypes
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import java.util.ArrayList
import java.util.HashSet
import java.math.BigDecimal
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions

class AgentGeneration {
	Agent theAgent = null;
	var agentsPkg = "";
	var systemRoot = "";
	var fileContents = "";
	var ArrayList<String> libImports = null;
	var HashSet<String> importsToPrint = null;
	var ArrayList<String> initialList = null;
	var ArrayList<String> triggersToPrintInit = null;
	var ArrayList<String> triggersStringsToPrint = null;
	
	
	new(Agent a, String systemRoot, String agentsPkg) {
		theAgent = a;
		this.systemRoot = systemRoot;
		this.agentsPkg = agentsPkg;
		libImports = new ArrayList<String>();
		importsToPrint = new HashSet<String>();
		initialList = new ArrayList<String>();
		triggersToPrintInit = new ArrayList<String>();
		triggersStringsToPrint = new ArrayList<String>();
	}
	
	def setup(){
		fileContents = printLocal() as String;
		//Add in the imports
		var imports = "//Automated Agent Import Generation\nimport castleComponents.Agent;\n";
		imports += "import castleComponents.SemanticGroup;\n"
		imports += "import castleComponents.Entity;\n"
		imports += "import castleComponents.representations.LayoutParameters;\n"
		imports += "import stdSimLib.*;\n"
		imports += "import stdSimLib.utilities.*;\n"
		imports += "import castleComponents.Interaction.InteractionType;\n"
		imports += "import "+systemRoot.toFirstLower+"."+systemRoot.toFirstUpper+";\n"

		var allImports = HelperFunctions.parseImportsForGeneration(libImports, systemRoot);
		if (allImports !== null){
			importsToPrint.addAll(allImports);
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
					if (sb instanceof Concern){
						for (sbf : sb.stateFields){
							output += "\tregisterState(\""+sbf.ref.name+"\","+sbf.ref.name+");\n"
						}
					}
				}
			}
			libImports.addAll(HelperFunctions.populateImports(function.body))
				
			for (statement : function.body){
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
				output += "private "+Printers.printFieldDeclarations(field as Field)+";\n";
				libImports.add(HelperFunctions.getFieldType(field as Field));
			} else if (field instanceof Concern){}			
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
			if (behavior.functionParameters.size > 0){
				output += HelperFunctions.inferMethodType(behavior.body)+" " +behavior.name+ "(" +a.name.toFirstUpper+ " "+a.name.toLowerCase+", " + HelperFunctions.printFunctionParameters(behavior.functionParameters) +")"
			} else {
				output += HelperFunctions.inferMethodType(behavior.body)+" " +behavior.name+ "(" +a.name.toFirstUpper+ " "+a.name.toLowerCase+")"
			}
			output += " {\n"
			output += HelperFunctions.printMethodBody(behavior.body, behavior)
			libImports.addAll(HelperFunctions.populateImports(behavior.body))
			output += "\n}\n"

			//Create the trigger object here
			var triggerString = "";
			if (behavior.behavior_reaction_time == BehaviorReactionTime.STEP){
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+a.name.toFirstUpper+") o)."+behavior.name+"((("+a.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, false, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.DELAYED){
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger (1, \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+a.name.toFirstUpper+") o)."+behavior.name+"((("+a.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, false, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+a.name.toFirstUpper+") o)."+behavior.name+"((("+a.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, true, this);\n\n"
//				initialList.add("actionTriggers.add("+Printers.getNameForTrigger(behavior.name)+"(this))");
				initialList.add("actionTriggers.add("+Printers.getNameForTrigger(behavior.name)+")");
				triggersStringsToPrint.add(triggerString);
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
			output += HelperFunctions.printMethodBody(interaction.body, interaction);
			libImports.addAll(HelperFunctions.populateImports(interaction.body))
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
		output += "\tsetupQueue = new ArrayList<Function<"+a.name+",Void>>();\n
			\tactionQueue = new ArrayList<Function<"+a.name+",Void>>();\n
			\tcleanupQueue = new ArrayList<Function<"+a.name+",Void>>();\n"
		for (item : triggersStringsToPrint){
			output += "\t"+item+"\n";
		}
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
		str += "//The uninitialized Triggers\n"
		for (s : triggersToPrintInit){
			str += "Trigger "+s+";\n"
		}
		str += "\n";
		
		//Behavior scheduling
		for (behavior : a.agent_behaviors.behaviors) {
			if (behavior.behavior_reaction_time == BehaviorReactionTime.STEP){
				//This should be called x steps late. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.INSTANT){
				//This should be called instantly somehow and not appear in the triggers. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.DELAYED){
				//This should be pushed to the cleanup phase in the same step. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				if (steps == 1){
//					actionPhase.add(behavior.name+"(this);")
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
//					actionPhase.add(interaction.name+"(this);")	
				} else {
					var interAsFunc = "TO_DO";
					var tObj = "Trigger "+interaction.name+"_trigger = new Trigger("+steps+","+interAsFunc+", true, "+a.name.toFirstUpper+");"
					triggeredActions.add(tObj)	
				}
			}					
		}
		
		//Set up the triggered objects
		for (trig : triggeredActions){
			str += trig+"\n"
		}
		
		//Print the phases
		//Setup phase
		str += "@Override\n"
		str += "public void phase_Setup() {\n"
		
		for (item : setupPhase){
			str += "\t"+item+"\n"
		}
		str += "\t//Activate triggers\n"
		str += "\tpullTriggers(setupTriggers);\n"
		str +="}\n\n"
		
		//Action Phase
		str += "@Override\n"
		str += "public void phase_Action() {\n"
		for (item : actionPhase){
			str += "\t"+item+"\n"
		}
		str += "\t//Activate triggers\n"
		str += "\tpullTriggers(actionTriggers);\n"
		str +="}\n\n"
				
		//Cleanup phase
		str += "@Override\n"
		str += "public void phase_Cleanup() {\n"
		for (item : cleanupPhase){
			str += "\t"+item+"\n"
		}
		str += "\t//Activate triggers\n"
		str += "\tpullTriggers(cleanupTriggers);\n"
		str += "super.phase_Cleanup();\n"
		str +="}\n\n"

		return str;		
	}
}