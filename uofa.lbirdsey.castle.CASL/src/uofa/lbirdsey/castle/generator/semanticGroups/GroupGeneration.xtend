package uofa.lbirdsey.castle.generator.semanticGroups

import java.math.BigDecimal
import java.util.ArrayList
import java.util.HashSet
import org.eclipse.emf.ecore.EObject
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.Group
import uofa.lbirdsey.castle.casl.Group_Rules
import uofa.lbirdsey.castle.casl.Concern
import uofa.lbirdsey.castle.casl.Transmission_Phase
import uofa.lbirdsey.castle.casl.Transmission_Repeat
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions

class GroupGeneration {
	Group theGroup = null;
	var grpsPkg = "";
	var systemRoot = "";
	var fileContents = "";
	var ArrayList<String> libImports = null;
	var ArrayList<EObject> newImports = null;
	var HashSet<String> importsToPrint = null;
	var groupLayout = "";
	var ArrayList<String> initialList = null;
	var ArrayList<String> triggersToPrintInit = null;
	var ArrayList<String> triggersStringsToPrint = null;
	
	new(Group g, String systemRoot, String grpsPkg){
		theGroup = g;
		this.systemRoot = systemRoot;
		this.grpsPkg = grpsPkg;
		libImports = new ArrayList<String>();
		newImports = new ArrayList<EObject>();
		initialList = new ArrayList<String>();
		importsToPrint = new HashSet<String>();
		groupLayout = "";
		triggersToPrintInit = new ArrayList<String>();
		triggersStringsToPrint = new ArrayList<String>();
	}
	
	def setup(){
		fileContents = printLocal() as String;
		//Add in the imports
		var imports = "//Automated Group Import Generation\nimport castleComponents.SemanticGroup;\n";
		imports += "import castleComponents.Environment;\nimport castleComponents.Agent;\n"
		imports += "import castleComponents.Entity;\n"
		imports += "import castleComponents.representations.LayoutParameters;\n"
		imports += "import castleComponents.objects.*;\n"
		imports += "import stdSimLib.*;\n"
		imports += "import stdSimLib.utilities.*;\n"
		imports += "import castleComponents.Interaction.InteractionType;\n"
		imports += "import repast.simphony.context.Context;\n"
		imports += "import "+systemRoot+"."+systemRoot.toFirstUpper+";\n"

		var allImports = HelperFunctions.parseImportsForGeneration(libImports, systemRoot);
		if (allImports !== null){
			importsToPrint.addAll(allImports);
		}	
		
		for (String iC : importsToPrint){
			imports += iC+"\n";
		}
		//Parse Group rules
		imports += "import castleComponents.Enums.*;\n" //TODO: This is very lazy
		imports += "import castleComponents.representations.*;\n" //TODO: This is lazy
		
		//Prepend import statements
		fileContents = imports +"\n" + fileContents;
		//Prepend package declaration
		fileContents = "package "+grpsPkg+";\n\n" + fileContents;
	}
	
	def String printLocal()'''
		«RepastSpecifics.generateAgentBuilder()»
		
		public class «theGroup.name» extends SemanticGroup {
			/*Description: «theGroup.desc»*/
			
			/*****«theGroup.name.toFirstUpper» Initialisation*****/
			«groupInitialisation(theGroup)»
			
			/*****«theGroup.name.toFirstUpper» Parameters*****/
			«generateParameters(theGroup)»
			
			/*****«theGroup.name.toFirstUpper» Functions*****/
			«generateFunctions(theGroup)»
			
			/*****«theGroup.name.toFirstUpper» Behaviors*****/
			«generateBehaviors(theGroup)»
			
			/*****«theGroup.name.toFirstUpper» Transmissions*****/
			«generateExternalInteractions(theGroup)»
			
			/*****«theGroup.name.toFirstUpper» Internals*****/
			«generateInternalInteractions(theGroup)»
			
			/*****«theGroup.name.toFirstUpper» Simulate Calls*****/
			«generateSimulateFunction(theGroup)»
			«assignActionsAndPrintPhases(theGroup)»
				
			/*****Pre-defined Schedules - setup(), action(), and cleanup()*****/
			«createInitalisePhase(theGroup)»
			«createFinalPhase(theGroup)»
			
			
			/*****Specifics*****/
			«generateRepastSpecifics(theGroup)»
				
		}
	'''
	
	def print(){
		return fileContents;
	}
	
	
	def groupInitialisation(Group grp)'''
	ArrayList<Function<«grp.name»,Void>> setupQueue;
	ArrayList<Function<«grp.name»,Void>> actionQueue;
	ArrayList<Function<«grp.name»,Void>> cleanupQueue;
	
	public «grp.name»(EntityID id){
		super("«grp.name»", id);
	}
		'''

	def generateParameters(Group grp){
		var output = "//Fields\n"
		for (field : grp.group_parameters.fields){
			if (field instanceof Field){
				if (!HelperFunctions.getFieldName(field as Field).equalsIgnoreCase("LayoutParameters")){ //Note: This could be expanded to handle a lot of special cases				
					output += "private "+Printers.printFieldDeclarations(field as Field)+";\n";
					libImports.add(HelperFunctions.getFieldType(field as Field));
				}
			} else if (field instanceof Concern){
				
			}			
		}
		output += "private LayoutParameters layoutParameters = new LayoutParameters(RepresentationTypes.REP_"+grp.layoutType+");\n"
		
//		output += "\n//Getters & Setters\n"
//		for (field : grp.group_parameters.fields){
//			if (field instanceof Field){
//				output +=HelperFunctions.generateGettersSetters(field as Field)+"\n"
//			}
//		}
		return output;
	}  
	def generateFunctions(Group grp){
		var output = "";
		for (function : grp.group_functions.functions){
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
			if (function.name.compareTo("initialise") == 0){
				for (sb : grp.group_parameters.fields){
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
	
	def generateBehaviors(Group grp){
		var output = "";
		for (behavior : grp.group_behaviors.behaviors){
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
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+grp.name.toFirstUpper+") o)."+behavior.name+"((("+grp.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, false, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.DELAYED){
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger (1, \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+grp.name.toFirstUpper+") o)."+behavior.name+"((("+grp.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, false, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				val steps = (Printers.printExpression(behavior.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggersToPrintInit.add(Printers.getNameForTrigger(behavior.name));
				triggerString = Printers.getNameForTrigger(behavior.name) +" = new Trigger ("+steps+", \""+behavior.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+grp.name.toFirstUpper+") o)."+behavior.name+"((("+grp.name.toFirstUpper+") o));\n"
				triggerString += "\t\treturn null;\n}}, true, this);\n\n"
				initialList.add("actionTriggers.add("+Printers.getNameForTrigger(behavior.name)+")");
				triggersStringsToPrint.add(triggerString);
			}
		}		
		return output;
	}
	
	def generateExternalInteractions(Group grp){
		var output = "";
		for (transmission : grp.group_external_interactions.external_interactions){
			for (transFP : transmission.functionParameters){
				if (transFP !== null){
					if (transFP instanceof FunctionParameter){
//						libImports.add(HelperFunctions.getSymbolType(internalFP as FunctionParameter))
						libImports.add(HelperFunctions.inferFunctionParameterTypeForImport(transFP as FunctionParameter));
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(transmission.body)+" " +transmission.name+ "(" + HelperFunctions.printFunctionParameters(transmission.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(transmission.body, transmission)
			libImports.addAll(HelperFunctions.populateImports(transmission.body))
			output += "\n}\n"
			
			//Create the trigger object here
			var triggerString = "";
			//Get phase
			var phase = transmission.transmissionPhase.toString().toLowerCase();
			if (transmission.transmissionRepeat == Transmission_Repeat.REPEAT){
				val steps = (Printers.printExpression(transmission.reaction_time_parm) as BigDecimal).toBigInteger.intValue;
				triggersToPrintInit.add(Printers.getNameForTrigger(transmission.name));
				triggerString = Printers.getNameForTrigger(transmission.name) +" = new Trigger ("+steps+", \""+transmission.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+grp.name.toFirstUpper+") o)."+transmission.name+"();\n"
				triggerString += "\t\treturn null;\n\t\t}}, true, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (transmission.transmissionRepeat == Transmission_Repeat.SINGLE){
				triggersToPrintInit.add(Printers.getNameForTrigger(transmission.name));
				triggerString = Printers.getNameForTrigger(transmission.name) +" = new Trigger (1, \""+transmission.name+"\", new Function<Entity,Void>(){\n"
				triggerString += "\tpublic Void apply(Entity o) {\n"
				triggerString += "\t\t(("+grp.name.toFirstUpper+") o)."+transmission.name+"();\n"
				triggerString += "\t\treturn null;\n\t\t}}, false, this);\n\n"
				triggersStringsToPrint.add(triggerString);
			} else if (transmission.transmissionRepeat == Transmission_Repeat.CALLED){
				//Do nothing yet
			}
			
		}
		return output;
	}
	
	
	def generateInternalInteractions(Group grp){
		var output = "";
//		
		for (internal : grp.group_internal_interactions.internal_interactions){
			for (internalFP : internal.functionParameters){
				if (internalFP !== null){
					if (internalFP instanceof FunctionParameter){
//						libImports.add(HelperFunctions.getSymbolType(internalFP as FunctionParameter))
						libImports.add(HelperFunctions.inferFunctionParameterTypeForImport(internalFP as FunctionParameter));
					}
				}
			}

			output += "public ";
			output += HelperFunctions.inferMethodType(internal.body)+" " +internal.name+ "(" + HelperFunctions.printFunctionParameters(internal.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(internal.body, internal)
			libImports.addAll(HelperFunctions.populateImports(internal.body))
			output += "\n}\n"
		}
		return output;
	}
	
	def String generateSimulateFunction(Group grp){
		var str = "";
			str += "@Override\npublic void run(){\n\tsimulate();\n}\n"
			str += "public void simulate() {\n";
			str += "\tif (getCurrentPhase() == Phase.SETUP) {\n"
			str += "\t\tbroadcast(MessageType.CLOCK, getCurrentStep());\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Setup();\n"
//			str += "\t\tArrayList<Entity> containedEntities = layoutParameters.getContainedEntities();\n"
			str += "\t\tArrayList<Entity> containedEntities = new ArrayList<Entity>(storedAgents);\n"
			str += "\t\tfor (Entity e : containedEntities){\n\t\t\te.phase_Setup();\n\t\t}\n"
			str += "\t} else if (getCurrentPhase() == Phase.ACTION) { \n"
			str += "\t\t broadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Action();\n"
			str += "\t\tArrayList<Entity> containedEntities = new ArrayList<Entity>(storedAgents);\n"
			str += "\t\tfor (Entity e : containedEntities){\n\t\t\te.phase_Action();\n\t\t}\n"
			str += "\t} else if (getCurrentPhase() == Phase.CLEANUP) {\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Cleanup();\n"
			str += "\t\tArrayList<Entity> containedEntities = new ArrayList<Entity>(storedAgents);\n"
			str += "\t\tfor (Entity e : containedEntities){\n\t\t\te.phase_Cleanup();\n\t\t}\n"
			str += "\t}\n"			 
			str += "}\n"
		return str;
	}
	
	def String generateRepastSpecifics(Group grp){
		var str = "Context<Entity> repastContext;\n"
		str += "public void setRepastContext(Context<Entity> rc){\n\trepastContext=rc;\n}\n"
	}
	
	def getLayoutType(Group grp){
		return grp.group_rules.layout_type;
	}

	//In this we create and initialise the groups into the environment
	def String createInitalisePhase(Group g){
			var output = "";
			output += "@Override\n";
			output += "public void initialise() {\n\tsuper.initialise();\n\t";
			output += "\tsetupQueue = new ArrayList<Function<"+g.name+",Void>>();\n
			\tactionQueue = new ArrayList<Function<"+g.name+",Void>>();\n
			\tcleanupQueue = new ArrayList<Function<"+g.name+",Void>>();\n"
			for (item : triggersStringsToPrint){
				output += "\t"+item+"\n";
			}
			for (item : initialList){
				output += "\t"+item+";\n"; 
			}
			
//			output += "\tstoredGroups.addAll(layoutParameters.getContainedGroups());\n"
			output += "\taddStoredAgents(layoutParameters.getContainedAgents());\n"
//			output += "\tstoredAgents.addAll(layoutParameters.getContainedAgents());\n"
			
			//Get layout type
			val layoutType = getLayoutType(g);
			
//			switch(layoutType){
//				case LayoutType.GRID:
//					output += initGridLayout()
//				default:
//					output += "ERROR WITH LAYOUT INIT"
//			}
			output += "}\n";
			return output;
	}
	
	def createFinalPhase(Group grp)'''
		@Override
		public void final_call(){
		}
	'''
	
	def String parseGroupRules(Group_Rules gr){
		return gr.layout_type.toString();
	}
	 
	def assignActionsAndPrintPhases(Group g){
		var triggeredActions = newArrayList
		var setupPhase = newArrayList
		var actionPhase = newArrayList
		var cleanupPhase = newArrayList
		var groupNameUpper = g.name.toFirstUpper
		
		//Get all the triggered features
		var str = "//Schedules\n"
		str += "//The NULL Triggers\n"
		for (s : triggersToPrintInit){
			str += "Trigger "+s+";\n"
		}
		str += "\n";
		
		
		for (behavior : g.group_behaviors.behaviors) {
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
//					var tObj = "Trigger "+behavior.name+"_trigger = new Trigger("+steps+","+interAsFunc+", true, "+g.name.toFirstUpper+".class);"
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
		//How do we add things to the different queues again?
		//TODO: Generate trigger objects
		for (transmission : g.group_external_interactions.external_interactions) {			
			if (transmission.transmissionRepeat == Transmission_Repeat.REPEAT){
				//Determine phase
				val phase = transmission.transmissionPhase;
				val steps = (Printers.printExpression(transmission.reaction_time_parm) as BigDecimal).toBigInteger.intValue;				
				if (steps == 1){
					if (phase == Transmission_Phase.SETUP){
						setupPhase.add(transmission.name.toFirstLower+"();")
					} else if (phase == Transmission_Phase.ACTION){
						actionPhase.add(transmission.name.toFirstLower+"();")
					} else if (phase == Transmission_Phase.CLEANUP){
						cleanupPhase.add(transmission.name.toFirstLower+"();")
					} 						
				} else {
					//TODO: These should be handled elsewhere somehow
					if (phase == Transmission_Phase.SETUP){						
					} else if (phase == Transmission_Phase.ACTION){
					
					} else if (phase == Transmission_Phase.CLEANUP){
						
					}
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
		str += "\t//Activate triggers\n"
		str += "\tpullTriggers(setupTriggers);\n"
		str +="}\n\n"
		
		//Action Phase
		str += "@Override\n"
		str += "public void phase_Action() {\n"
		
		str += "\t//Activate triggers\n"
		str += "\tpullTriggers(actionTriggers);\n"
		str +="}\n\n"
				
		//Cleanup phase
		str += "@Override\n"
		str += "public void phase_Cleanup() {\n"
		str += "\t//Activate triggers\n"
		str += "\tpullTriggers(cleanupTriggers);\n"
		str += "super.phase_Cleanup();\n"
		str +="}\n\n"

		return str;		
	}
}