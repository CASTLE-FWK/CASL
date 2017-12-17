package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.Environment
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.Concern
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import java.util.HashSet
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import java.math.BigDecimal
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions

class EnvironmentGeneration {
	
	Environment theEnvironment = null;
	var envPkg = "";
	var systemRoot = "";
	var fileContents = "";
	var ArrayList<String> libImports = null;
	var ArrayList<EObject> newImports = null;
	var HashSet<String> importsToPrint = null;
	var ArrayList<String> triggersToPrintInit = null;
	var ArrayList<String> triggersStringsToPrint = null;
	var ArrayList<String> initialList = null;
	var groupsActive = false;
	
	def EnvironmentInitialisation(Environment env)'''
	ArrayList<Function<«env.name»,Void>> setupQueue;
	ArrayList<Function<«env.name»,Void>> actionQueue;
	ArrayList<Function<«env.name»,Void>> cleanupQueue;
	ArrayList<SemanticGroup> groups;
	
	public «env.name»(EntityID id) {
		super("«env.name»", id);
	}'''
	
	new(Environment e, String systemRoot, String envPkg, boolean groupsActive){
		this.theEnvironment = e;
		this.systemRoot = systemRoot;
		this.envPkg = envPkg;
		libImports = new ArrayList<String>();
		newImports = new ArrayList<EObject>();
		importsToPrint = new HashSet<String>();
		triggersToPrintInit = new ArrayList<String>();
		initialList = new ArrayList<String>();
		triggersStringsToPrint = new ArrayList<String>();
		this.groupsActive = groupsActive;
	}
	
	def setup(){
		fileContents = printLocal() as String;
		//Add in the imports
		var imports = "//Automated Environment Import Generation\n import castleComponents.Environment;\n";
		imports += "import castleComponents.SemanticGroup;\n"
		imports += "import castleComponents.representations.LayoutParameters;\n"
		imports += "import castleComponents.objects.*;\n"
		imports += "import stdSimLib.*;\n"
		imports += "import stdSimLib.utilities.*;\n"
		imports += "import castleComponents.Interaction.InteractionType;\n"
		imports += "import castleComponents.Entity;\n import castleComponents.objects.Vector2;\n"
		imports += "import "+systemRoot+"."+systemRoot.toFirstUpper+";\n"
		imports += "import java.util.concurrent.Executors;\n import java.util.Collections;\n"
		
		var allImports = HelperFunctions.parseImportsForGeneration(libImports, systemRoot);
		if (allImports !== null){
			importsToPrint.addAll(allImports);
		}
		
		for (String iC : importsToPrint){
			imports += iC+"\n";
		}
		//What other dynamic stuff is needed...
		//Parse Env rules
		imports += "import castleComponents.Enums.*;\n" //TODO: This is very lazy
		imports += "import castleComponents.representations.*;\n" //TODO: This is lazy
//		imports += "import castleComponents.representations."+(parseGroupRules(theGroup.group_rules).toLowerCase.toFirstUpper)+";\n"

		//Prepend import statements
		fileContents = imports +"\n" + fileContents;
		//Prepend package declaration
		fileContents = "package "+envPkg+";\n\n" + fileContents;
	}
	def String printLocal(){'''
		«RepastSpecifics.generateEnvironmentBuilder()»
		
		public class «theEnvironment.name» extends Environment {
			/*Description: «theEnvironment.desc»*/
			
			/*****«theEnvironment.name.toFirstUpper» Initialisation*****/
			«EnvironmentInitialisation(theEnvironment)»
			
			/*****«theEnvironment.name.toFirstUpper» Parameters*****/
			«generateParameters(theEnvironment)»
			
			/*****«theEnvironment.name.toFirstUpper» Functions*****/
			«generateFunctions(theEnvironment)»			
			
			/*****«theEnvironment.name.toFirstUpper» Behaviors*****/
			«generateBehaviors(theEnvironment)»
			
			/*****«theEnvironment.name.toFirstUpper» Interactions*****/
			«generateInteractions(theEnvironment)»
			
			/*****«theEnvironment.name.toFirstUpper» Adaptation*****/
			«generateAdaptations(theEnvironment)»
				
			/*****«theEnvironment.name.toFirstUpper» Subsystems*****/
			«generateSubsystems(theEnvironment)»
			
			/*****«theEnvironment.name.toFirstUpper» Group Interactions*****/			
			«generateGroupInteractions(theEnvironment)»
			
			/*****«theEnvironment.name.toFirstUpper» Simulate Calls*****/
			«generateSimulateFunction(theEnvironment)»
			
			/*****Trigger Scheduling*****/
			«createInitialiseFunction(theEnvironment)»
			«assignActionsAndPrintPhases(theEnvironment)»
			
			/*****Platform Specifics*****/
			«generateRepastSpecifics(theEnvironment)»
		}
		'''
	}
	def print(){
		return fileContents;
	}
	
	def generateParameters(Environment env){
		var output = "//Fields\n"
		for (field : env.env_parameters.fields){
			if (field instanceof Field){
				if (!HelperFunctions.getFieldName(field as Field).equalsIgnoreCase("LayoutParameters")){ //Note: This could be expanded to handle a lot of special cases				
					output += "private "+Printers.printFieldDeclarations(field as Field)+";\n";
					libImports.add(HelperFunctions.getFieldType(field as Field));
					newImports.add(field as Field);
				}				
			} else if (field instanceof Concern){}			
		}
		
		//Layout Parameter stuff
		output += "private LayoutParameters layoutParameters = new LayoutParameters(RepresentationTypes.REP_"+env.layoutType+");\n"
		
//		output += "\n//Getters & Setters\n"
//		for (field : env.env_parameters.fields){
//			if (field instanceof Field){
//				output +=HelperFunctions.generateGettersSetters(field as Field)+"\n"
//			}
//		}
		return output;
	}  
	
	def generateFunctions(Environment env){
		var output = "";
		for (function : env.env_functions.functions){
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
			
			//This needs to go or be fixed
			if (function.name.compareTo("initialise") == 0){
				for (sb : env.env_parameters.fields){
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
	
	def generateBehaviors(Environment env){
		var output = "";
		for (behavior : env.env_behaviors.behaviors){
			for (behaviorFP : behavior.functionParameters){
				if (behaviorFP !== null){
					if (behaviorFP instanceof FunctionParameter){
//						libImports.add(HelperFunctions.getSymbolType(internalFP as FunctionParameter))
						libImports.add(HelperFunctions.inferFunctionParameterTypeForImport(behaviorFP as FunctionParameter));
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(behavior.body)+" " +behavior.name+ "(" + HelperFunctions.printFunctionParameters(behavior.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(behavior.body, behavior)
			libImports.addAll(HelperFunctions.populateImports(behavior.body))
			output += "\n}\n"
						//Create the trigger object here
			var triggerString = "";
			if (behavior.behavior_reaction_time == BehaviorReactionTime.STEP){
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue; //TODO: Why is it like this?
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+env.name.toFirstUpper+") o)."+behavior.name+"((("+env.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, false, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.DELAYED){
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger (1, \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+env.name.toFirstUpper+") o)."+behavior.name+"((("+env.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, false, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+env.name.toFirstUpper+") o)."+behavior.name+"((("+env.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, true, this);\n\n"
//				initialList.add("actionTriggers.add("+Printers.getNameForTrigger(behavior.name)+"(this))");
				initialList.add("actionTriggers.add("+Printers.getNameForTrigger(behavior.name)+")");
				triggersStringsToPrint.add(triggerString);
			}
		}
		return output;
	}
	
	def generateInteractions(Environment env){
		var output = "";
		for (interaction : env.env_interactions.interactions) {
			for (interFP : interaction.functionParameters){
				if (interFP !== null){
					if (interFP instanceof FunctionParameter){
//						libImports.add(HelperFunctions.getSymbolType(internalFP as FunctionParameter))
						libImports.add(HelperFunctions.inferFunctionParameterTypeForImport(interFP as FunctionParameter));
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(interaction.body)+" " +interaction.name+ "(" + HelperFunctions.printFunctionParameters(interaction.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(interaction.body, interaction)
			libImports.addAll(HelperFunctions.populateImports(interaction.body))
			output += "\n}\n"
		}
		return output	
	}
	
	def generateAdaptations(Environment env) {
		var output = "";
		for (adaptation : env.env_adaptation.adaptation) {
			for (adaptFP : adaptation.functionParameters){
				if (adaptFP !== null){
					if (adaptFP instanceof FunctionParameter){
//						libImports.add(HelperFunctions.getSymbolType(internalFP as FunctionParameter))
						libImports.add(HelperFunctions.inferFunctionParameterTypeForImport(adaptFP as FunctionParameter));
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
	
	def generateSubsystems(Environment env){
		var output = "";
		for (subsystem : env.env_subSystems.subSystems) {
			for (subsFP : subsystem.functionParameters){
				if (subsFP !== null){
					if (subsFP instanceof FunctionParameter){
//						libImports.add(HelperFunctions.getSymbolType(internalFP as FunctionParameter))
						libImports.add(HelperFunctions.inferFunctionParameterTypeForImport(subsFP as FunctionParameter));
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(subsystem.body)+" " +subsystem.name+ "(" + HelperFunctions.printFunctionParameters(subsystem.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(subsystem.body, subsystem)
			libImports.addAll(HelperFunctions.populateImports(subsystem.body))
			output += "\n}\n"			
		}
		return output;
	}
	
	def generateGroupInteractions(Environment env){
		var output = "";
		for (interaction : env.env_groupinteractions.interactions) {
			for (interFP : interaction.functionParameters){
				if (interFP !== null){
					if (interFP instanceof FunctionParameter){
//						libImports.add(HelperFunctions.getSymbolType(internalFP as FunctionParameter))
						libImports.add(HelperFunctions.inferFunctionParameterTypeForImport(interFP as FunctionParameter));
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(interaction.body)+" " +interaction.name+ "(" + HelperFunctions.printFunctionParameters(interaction.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(interaction.body, interaction)
			libImports.addAll(HelperFunctions.populateImports(interaction.body))
			output += "\n}\n"
		}
		return output	
	}
	

	
	def getLayoutType(Environment env){
		return env.env_attributes.layout_type;
	}
	//In this we create and initialise the groups into the environment
	def createInitialiseFunction(Environment env){
		var output = "";
		output += "@Override\n";
		output += "public void initialise() {\n\tsuper.initialise();\n\t";
		output += "\tsetupQueue = new ArrayList<Function<"+env.name+",Void>>();\n
			\tactionQueue = new ArrayList<Function<"+env.name+",Void>>();\n
			\tcleanupQueue = new ArrayList<Function<"+env.name+",Void>>();\n"
		for (item : triggersStringsToPrint){
			output += "\t"+item+"\n";
		}
		for (item : initialList){
			output += "\t"+item+";\n"; 
		}


		output += "}\n";
		return output;
	}
	
	
	def String generateSimulateFunction(Environment env){
		if (groupsActive){
			return generateSimulateFunction_SG(env);
		} else {
			return generateSimulateFunction_Normal(env);
		}
	}
	
	def String generateSimulateFunction_SG(Environment environment){
		var str = "";
			str += "@Override\npublic void run(){\n\tsimulate();\n}\n"
			str += "public void simulate() {\n";
			str += "\tif (getCurrentPhase() == Phase.SETUP) {\n"
			str += "\t\tbroadcast(MessageType.CLOCK, getCurrentStep());\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Setup();\n"
//			str += "\t\tArrayList<Entity> containedEntities = layoutParameters.getContainedEntities();\n"
			str += "\t\tArrayList<Entity> containedEntities = new ArrayList<Entity>(storedGroups);\n"
			str += "\t\tif (containedEntities.size() > 0) {\n"
				str += "\t\t\tgroupExecutor = Executors.newFixedThreadPool(containedEntities.size());\n"
				str += "\t\t\tfor (Entity e : containedEntities){\n\t\t\t\tgroupExecutor.execute(e);\n\t\t}\n"
				str += "\t\t\t groupExecutor.shutdown();\n\t\twhile (!groupExecutor.isTerminated()){};\n"
			str += "\t\t}\n"
			str += "\t} else if (getCurrentPhase() == Phase.ACTION) { \n"
			str += "\t\t broadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Action();\n"
			str += "\t\tArrayList<Entity> containedEntities = new ArrayList<Entity>(storedGroups);\n"
			str += "\t\tif (containedEntities.size() > 0) {\n"
				str += "\t\t\tgroupExecutor = Executors.newFixedThreadPool(containedEntities.size());\n"
				str += "\t\t\tfor (Entity e : containedEntities){\n\t\t\t\tgroupExecutor.execute(e);\n\t\t}\n"
				str += "\t\t\t groupExecutor.shutdown();\n\t\twhile (!groupExecutor.isTerminated()){};\n"
			str += "\t\t}\n"
			str += "\t} else if (getCurrentPhase() == Phase.CLEANUP) {\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Cleanup();\n"
			str += "\t\tArrayList<Entity> containedEntities = new ArrayList<Entity>(storedGroups);\n"
			str += "\t\tif (containedEntities.size() > 0) {\n"
				str += "\t\t\tgroupExecutor = Executors.newFixedThreadPool(containedEntities.size());\n"
				str += "\t\t\tfor (Entity e : containedEntities){\n\t\t\t\tgroupExecutor.execute(e);\n\t\t}\n"
				str += "\t\t\t groupExecutor.shutdown();\n\t\twhile (!groupExecutor.isTerminated()){};\n"
			str += "\t\t}\n"
			str += "\t}\n"			 
			str += "}\n"
		return str;
	}
	
	def String generateSimulateFunction_Normal(Environment environment){
			var str = "";
			str += "@Override\npublic void run(){\n\tsimulate();\n}\n"
			str += "public void simulate() {\n";
			str += "\tif (getCurrentPhase() == Phase.SETUP) {\n"
			str += "\t\tbroadcast(MessageType.CLOCK, getCurrentStep());\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Setup();\n"
			str += "\t\tArrayList<Agent> containedEntities = storedAgents;\n"
			//Shuffle
			str += "\t\tCollections.shuffle(containedEntities);\n"
			str += "\t\tfor (Entity e : containedEntities){e.phase_Setup();}\n"
			str += "\t} else if (getCurrentPhase() == Phase.ACTION) { \n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			
			str += "\t\tphase_Action();\n"
			str += "\t\tArrayList<Agent> containedEntities = storedAgents;\n"
			//Shuffle
			str += "\t\tCollections.shuffle(containedEntities);\n"
			
			str += "\t\tfor (Entity e : containedEntities){e.phase_Action();}\n"
			
			str += "\t} else if (getCurrentPhase() == Phase.CLEANUP) {\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			
			str += "\t\tphase_Cleanup();\n"
			str += "\t\tArrayList<Agent> containedEntities = storedAgents;\n"
			//Shuffle
			str += "\t\tCollections.shuffle(containedEntities);\n"
			str += "\t\tfor (Entity e : containedEntities){e.phase_Cleanup();}\n"
			
			str += "\t}\n"			 
			str += "}\n"
		return str;
	}
	
	def String generateRepastSpecifics(Environment env){
		var str = "Context<Entity> repastContext;\n"
		str += "public void setRepastContext(Context<Entity> rc){\n\trepastContext=rc;\n}\n"
	}
	
	def assignActionsAndPrintPhases(Environment env){
		var triggeredActions = newArrayList
		var setupPhase = newArrayList
		var actionPhase = newArrayList
		var cleanupPhase = newArrayList
		var groupNameUpper = env.name.toFirstUpper
		
		//Get all the triggered features
		var str = "//Schedules\n"
		str += "//The NULL Triggers\n"
		for (s : triggersToPrintInit){
			str += "Trigger "+s+";\n"
		}
		str += "\n";
		
		for (behavior : env.env_behaviors.behaviors) {
			if (behavior.behavior_reaction_time == BehaviorReactionTime.STEP){
				//This should be called x steps late. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.INSTANT){
				//This should be called instantly somehow and not appear in the triggers. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.DELAYED){
				//This should be pushed to the cleanup phase in the same step. Is already handled
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
//				if (steps == 1){
//					actionPhase.add(behavior.name+"(this);")
//				} else {
//					var interAsFunc = "TO_DO (generation behaviour repeat > 1 step"; //TODO: This...thing
//					var tObj = "Trigger "+behavior.name+"_trigger = new Trigger("+steps+","+interAsFunc+", true, "+env.name.toFirstUpper+".class);"
//					triggeredActions.add(tObj)	
//				}
			}
		}
		/*
		//There are two types of group interactions: Internal, external
		for (interaction : g.group_internals.internals) {
			if (interaction.trigger_type == InteractionTriggerTypes.STEP){
				//Expecting a numeric value
				var steps = (interaction.triggerParam.expr as NumberLiteral).value.toBigInteger.intValue
				if (steps.equals(1)) {
					actionPhase.add(interaction.name+"(this);")	
				} else {
					var interAsFunc = "TO_DO";
					var tObj = "Trigger "+interaction.name+"_trigger = new Trigger("+steps+","+interAsFunc+", true, "+groupNameUpper+");"
					triggeredActions.add(tObj)	
				}
				//TODO: Trigger objects

			}					
		}
		*/
//		//How do we add things to the different queues again?
//		for (transmission : g.group_transmissions.transmissions) {			
//			if (transmission.transmissionRepeat == Transmission_Repeat.REPEAT){
//				//Determine phase
//				val phase = transmission.transmissionPhase;
//				if (phase == Transmission_Phase.SETUP){
//					setupPhase.add(transmission.name.toFirstLower+"();")
//				} else if (phase == Transmission_Phase.ACTION){
//					actionPhase.add(transmission.name.toFirstLower+"();")
//				} else if (phase == Transmission_Phase.CLEANUP){
//					cleanupPhase.add(transmission.name.toFirstLower+"();")
//				} 	
//			} 			
//		}
		
		//Set up the triggered objects
//		str += "ArrayList<Trigger> triggers = new ArrayList<Trigger>();\n"
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