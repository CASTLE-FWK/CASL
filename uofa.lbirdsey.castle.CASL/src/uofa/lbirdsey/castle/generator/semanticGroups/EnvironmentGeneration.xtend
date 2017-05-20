package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.Environment
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.Concern
import uofa.lbirdsey.castle.casl.LayoutType
import java.util.ArrayList
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import uofa.lbirdsey.castle.casl.Symbol
import org.eclipse.emf.ecore.EObject
import java.util.HashSet
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import java.math.BigDecimal

class EnvironmentGeneration {
	
	Environment theEnvironment = null;
	var envPkg = "";
	var systemRoot = "";
	var fileContents = "";
	var ArrayList<String> libImports = null;
	var ArrayList<EObject> newImports = null;
	var HashSet<String> importsToPrint = null;
	
	def EnvironmentInitialisation(Environment env)'''
	ArrayList<Function<«env.name»,Void>> setupQueue;
	ArrayList<Function<«env.name»,Void>> actionQueue;
	ArrayList<Function<«env.name»,Void>> cleanupQueue;
	ArrayList<SemanticGroup> groups;
	
	public «env.name»(EntityID id) {
		super("«env.name»", id);
	}'''
	
	new(Environment e, String systemRoot, String envPkg){
		this.theEnvironment = e;
		this.systemRoot = systemRoot;
		this.envPkg = envPkg;
		libImports = new ArrayList<String>();
		newImports = new ArrayList<EObject>();
		importsToPrint = new HashSet<String>();
	}
	
	def setup(){
		fileContents = printLocal() as String;
		//Add in the imports
		var imports = "//Automated Environment Import Generation\nimport castleComponents.Environment;\n";
		imports += "import castleComponents.SemanticGroup;\n"
		imports += "import castleComponents.representations.LayoutParameters;\n"
		imports += "import castleComponents.Entity;\n"
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
		//Parse Env rules
//		imports += "import castleComponents.Enums.RepresentationTypes;\n"
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
«««			«print(createInitialiseFunction(theEnvironment))»
			
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
«««			«createSetupPhase(theEnvironment)»
«««			«createActionPhase(theEnvironment)»
«««			«createCleanupPhase(theEnvironment)»
			«createInitialiseFunction(theEnvironment)»
			«assignActionsAndPrintPhases(theEnvironment)»
			
			/*****Build Groups*****/
«««			«repastBuildInitialiser(theEnvironment)»
			
			/*****Repast Functions*****/
«««			«miscRepast(theEnvironment)»
			
«««			/*****Schedule Initialisation*****/
«««			«print(theEnvironment.createSchedule)»
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
				output += "private "+HelperFunctions.printFieldDeclarations(field as Field)+";\n";
				libImports.add(HelperFunctions.getFieldType(field as Field));
				newImports.add(field as Field);
			} else if (field instanceof Concern){}			
		}
		
		//Layout Parameter stuff
		output += "private LayoutParameters layoutParameters = new LayoutParameters(RepresentationTypes."+env.layoutType+");\n"
		
		output += "\n//Getters & Setters\n"
		for (field : env.env_parameters.fields){
			if (field instanceof Field){
				output +=HelperFunctions.generateGettersSetters(field as Field)+"\n"
			}
		}
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
//				libImports.add(HelperFunctions.inferSymbolType((function.returnType as Symbol)));
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
				for (sb : env.env_parameters.fields){
					if (sb instanceof Concern){
						for (sbf : sb.stateFields){
							output += "\tregisterState(\""+sbf.ref.name+"\","+sbf.ref.name+");\n"
						}
					}
				}
			}
			for (statement : function.body){
				if (statement instanceof Field){
					libImports.add(HelperFunctions.getFieldType(statement as Field))
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
	
	def generateBehaviors(Environment env){
		var output = "";
		for (behavior : env.env_behaviors.behaviors){
			for (behaviorFP : behavior.functionParameters){
				if (behaviorFP !== null){
					if (!(behaviorFP instanceof FunctionParameter)){
//						libImports.add("INTHD"+HelperFunctions.inferSymbolType(interFP as Symbol));
						libImports.add(HelperFunctions.getFieldType(behaviorFP as Field))
					}
				}
			}
			output += "public ";
			output += HelperFunctions.inferMethodType(behavior.body)+" " +behavior.name+ "(" + HelperFunctions.printFunctionParameters(behavior.functionParameters) +")"
			output += " {\n"
			output += HelperFunctions.printMethodBody(behavior.body, behavior)
			libImports.addAll(HelperFunctions.populateImports(behavior.body))
			output += "\n}\n"
		}
		return output;
	}
	
	def generateInteractions(Environment env){
		var output = "";
		for (interaction : env.env_interactions.interactions) {
			for (interFP : interaction.functionParameters){
				if (interFP !== null){
					if (!(interFP instanceof FunctionParameter)){
//						libImports.add("INTHD"+HelperFunctions.inferSymbolType(interFP as Symbol));
						libImports.add(HelperFunctions.getFieldType(interFP as Field))
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
					if (!(adaptFP instanceof FunctionParameter)){
//						libImports.add("INTHD"+HelperFunctions.inferSymbolType(interFP as Symbol));
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
	
	def generateSubsystems(Environment env){
		var output = "";
		for (subsystem : env.env_subSystems.subSystems) {
			for (subsFP : subsystem.functionParameters){
				if (subsFP !== null){
					if (!(subsFP instanceof FunctionParameter)){
//						libImports.add("INTHD"+HelperFunctions.inferSymbolType(interFP as Symbol));
						libImports.add(HelperFunctions.getFieldType(subsFP as Field))
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
					if (!(interFP instanceof FunctionParameter)){
//						libImports.add("INTHD"+HelperFunctions.inferSymbolType(interFP as Symbol));
						libImports.add(HelperFunctions.getFieldType(interFP as Field))
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
	
		def miscRepast(Environment env)'''
		public void assignSpace(Grid<Agent> grid, ContinuousSpace<Agent> space) {
			setGrid(grid);
			setSpace(space);
		}
		@Override
		public void setPosition(Vector2 vector){
			super.setPosition(vector);
					
			space.moveTo(this, position.getX(), position.getY());
			grid.moveTo(this, (int)position.getX(), (int)position.getY());
		}
		public double getCurrentTickCount() {
				return RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
		}
	'''
	
	def getLayoutType(Environment env){
		return env.env_attributes.layout_type;
	}
	//In this we create and initialise the groups into the environment
	def createInitialiseFunction(Environment env){
		var str = "void initialise() {\n\tsuper.initialise();\n\t";
		//Get layout type
		val layoutType = getLayoutType(env);
		
		switch(layoutType){
			case LayoutType.GRID:
				str += initGridLayout()
			default:
				str += "ERROR WITH LAYOUT INIT"
		}
		return str;
	}
	
	def initGridLayout(){
		var str = "";
		str += "\tfor (int i = 0; i < layoutParameters.gridX(); i++){\n"
		str += "\t\tfor (int j = 0; j < layoutParameters.gridY(); j++){\n"
		str += "\t\t\t SemanticGroup tmpGrp = new SemanticGroup(getEntityID().toString()+\"_Group\", i, layoutParameters, this, i , j);\n" //TODO
		str += "\t\t\tstoredGroups.add(tmpGrp);\n"
		str += "\t\t\t//....\n" //TODO
		str += "\t\t}\n\t}\n"
		str += "\tfor (SemanticGroup grp : storedGroups) {\n"
		str += "\t\tgrp.initialise();\n"
		str += "\t}\n"
		str += "}"
		return str;
	}
	
	def String generateSimulateFunction(Environment environment){
		var str = "";
			str += "@Override\npublic void run(){\n\tsimulate();\n}\n"
			str += "public void simulate() {\n";
			str += "\tif (getCurrentPhase() == Phase.SETUP) {\n"
			str += "\t\tbroadcast(MessageType.CLOCK, getCurrentStep());\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Setup();\n"
			str += "\t\tArrayList<Entity> containedEntities = layoutParameters.getContainedEntities();\n"
			str += "\t\tcapExecutor = Executors.newFixedThreadPool(containedEntities.size());\n"
			str += "\t\tfor (SemanticGroup e : containedEntities){\n\t\t\ttcapExecutor.execute(e);\n\t\t}\n"
			str += "\t\tcapExecutor.shutdown();\n\t\twhile (!capExecutor.isTerminated()){};\n"
			str += "\t} else if (getCurrentPhase() == Phase.ACTION) { \n"
			str += "\t\t broadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Action();\n"
			str += "\t\tArrayList<Entity> containedEntities = layoutParameters.getContainedEntities();\n"
			str += "\t\tcapExecutor = Executors.newFixedThreadPool(containedEntities.size());\n"
			str += "\t\tfor (SemanticGroup e : containedEntities){\n\t\t\ttcapExecutor.execute(e);\n\t\t}\n"
			str += "\t\tcapExecutor.shutdown();\n\t\twhile (!capExecutor.isTerminated()){};\n"
			str += "\t} else if (getCurrentPhase() == Phase.CLEANUP) {\n"
			str += "\t\tbroadcast(MessageType.PHASE, getCurrentPhase());\n"
			str += "\t\tphase_Cleanup();\n"
			str += "\t\tArrayList<Entity> containedEntities = layoutParameters.getContainedEntities();\n"
			str += "\t\tcapExecutor = Executors.newFixedThreadPool(containedEntities.size());\n"
			str += "\t\tfor (SemanticGroup e : containedEntities){\n\t\t\ttcapExecutor.execute(e);\n\t\t}\n"
			str += "\t\tcapExecutor.shutdown();\n\t\twhile (!capExecutor.isTerminated()){};\n"
			str += "\t}\n"			 
			str += "}\n"
		return str;
	}
	
	def assignActionsAndPrintPhases(Environment env){
		var triggeredActions = newArrayList
		var setupPhase = newArrayList
		var actionPhase = newArrayList
		var cleanupPhase = newArrayList
		var groupNameUpper = env.name.toFirstUpper
		
		//Get all the triggered features
		var str = "//Schedules\n"
		for (behavior : env.env_behaviors.behaviors) {
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
					var tObj = "Trigger "+behavior.name+"_trigger = new Trigger("+steps+","+interAsFunc+", true, "+env.name.toFirstUpper+".class);"
					triggeredActions.add(tObj)	
				}
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
	
	
	
	
		def createInitalisePhase(Environment env)'''
		@Override
		public void initialise(){
			setupQueue = new ArrayList<Function<«env.name»,Void>>();
			actionQueue = new ArrayList<Function<«env.name»,Void>>();
			cleanupQueue = new ArrayList<Function<«env.name»,Void>>();
		}
	'''
	
	def createSetupPhase(Environment env)'''
		@Override
		public void phase_Setup(){
			cleanupQueue.clear();
		}
	'''
	
	def createActionPhase(Environment env)'''
		@Override
		public void phase_Action(){
		}
	'''
	
	def createCleanupPhase(Environment env)'''
		@Override
		public void phase_Cleanup(){
			cleanupQueue.forEach(f -> f.apply(this));
				«FOR sb : env.env_parameters.fields»
				«IF sb instanceof Concern»
					«FOR sbf : sb.stateFields»
					updateState("«sbf.ref.name»",«sbf.ref.name»);
					«ENDFOR»
				«ENDIF»
			«ENDFOR»
		}
	'''
}