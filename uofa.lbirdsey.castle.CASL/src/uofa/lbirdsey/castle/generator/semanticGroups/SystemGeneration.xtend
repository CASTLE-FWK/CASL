package uofa.lbirdsey.castle.generator.semanticGroups

import java.util.ArrayList
import java.util.HashSet
import uofa.lbirdsey.castle.casl.DataTypeDeclaration
import uofa.lbirdsey.castle.casl.EndConditionTypes
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.Concern
import uofa.lbirdsey.castle.casl.System
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers

class SystemGeneration {
	System theSystem;
	String systemRoot = "";
	var fileContents = "";
	var ArrayList<String> libImports = null;

	var HashSet<String> importsToPrint

	new(System s, String systemRoot) {
		this.theSystem = s;
		this.systemRoot = systemRoot;
		fileContents = "";
		libImports = new ArrayList<String>();
		importsToPrint = new HashSet<String>();
	}

	def setup() {
		fileContents = printLocal() as String;
		// Add in the imports
		var imports = "//Automated System Import Generation\nimport castleComponents.Environment;\n";
		imports += "import castleComponents.SemanticGroup;\n"
		imports += "import stdSimLib.*;\n"
		imports += "import castleComponents.objects.*;\n"
		imports += "import stdSimLib.utilities.*;\n"
		imports += "import castleComponents.representations.LayoutParameters;\n"
		imports += "import castleComponents.CASSystem;\n"
		imports += "import castleComponents.Output;\n"
		imports += "import castleComponents.SimulationInfo;\n"
		imports += "import castleComponents.visualisation.EntityDisplay;\n"
		imports += "import dataGenerator.OutputToJSON_Mongo;\n"

		var allImports = HelperFunctions.parseImportsForGeneration(libImports, systemRoot);
		if (allImports !== null) {
			importsToPrint.addAll(allImports);
		}

		// What other dynamic stuff is needed...
		for (String iC : importsToPrint) {
			imports += iC + "\n";
		}

		imports += "import castleComponents.Enums.*;\n" // TODO: This is very lazy
		imports += "import castleComponents.representations.*;\n" // TODO: This is lazy
		imports += "import visualisation.LiveSimulator;\n" // TODO: This is lazy
		imports += "import observationTool.VEntity;\n" // TODO: This is lazy
		// Prepend import statements
		fileContents = imports + "\n" + fileContents;
		// Prepend package declaration
		fileContents = "package " + systemRoot + ";\n\n" + fileContents;
	}

	def String printLocal() '''
«RepastSpecifics.generateSystemBuilder()»

public class «theSystem.name.replaceAll(" ","")» extends CASSystem implements ContextBuilder<Entity> {
	String name = "«theSystem.name»";
	String description = "«theSystem.desc.replaceAll("\n","\"\n\t + \"")»";
«««			/*****Ruleset*****/
«««			
«««			//Type
«««			CAS_Rule_Type ruleType = CAS_Rule_Type.«theSystem.cas_rules.cas_rule.toString.toUpperCase»;
«««			
«««			//Checking
«««			CAS_Inspection_Level ruleCheckType = CAS_Inspection_Level.«theSystem.cas_rules.cas_check.toString.toUpperCase»;
«««			
«««			//Exceptions
«««			CAS_Rule_Exception ruleExceptions[] = new CAS_Rule_Exception[]{«HelperFunctions.printRuleExceptionArgs(theSystem.cas_rules.exceptions)»};
«««			 
«««			CASRuleSet ruleSet = new CASRuleSet(ruleCheckType, ruleType, ruleExceptions);
	
	/*****Agent Types*****/ //is there much point in printing this?
	«FOR a : theSystem.agent_types.agent_types»
	//Why: «libImports.add("agents."+a.agent_type_name)»
	«a.agent_type_name» a«a.agent_type_name»;
	ArrayList<«a.agent_type_name»> «a.agent_type_name»List;
	«ENDFOR»
	
	/*****Group Types*****/
	«FOR grp : theSystem.group_types.group_types»
	//Why: «libImports.add("groups."+grp.group_type_name)»
	«grp.group_type_name» a«grp.group_type_name»;
	ArrayList<«grp.group_type_name»> «grp.group_type_name»List;
	«ENDFOR»
	
	/*****Environment Types Present*****/
	«FOR env : theSystem.environment_types.environment_types»
	//Why: «libImports.add("environments."+env.environment_type_name)»
	«env.environment_type_name» a«env.environment_type_name»;
	ArrayList<«env.environment_type_name»> «env.environment_type_name»List;
	«ENDFOR»
	
	/*****System Parameters*****/
	«generateParameters(theSystem)»
		
	/*****System Functions*****/
	«generateFunctions(theSystem)»
			
«««			/*****CAS Checking*****/
«««			«generateCASChecker(theSystem)»
	
	/*****Simulation Stuff*****/
				
	«generateBroadcastFunction(theSystem)»
	
	«generateSimulateFunction(theSystem)»
	
	«generateDebugFunctions(theSystem)»
		
	/*****Repast Stuff*****/
	«repastBuildInitialiser(theSystem)»
	}'''

	def print() {
		return fileContents;
	}

	def generateParameters(System sys) {
		var output = "//Fields\n"
		output += "ArrayList<Parameter<?>> simulationParameters = new ArrayList<Parameter<?>>();\n"
//		output += "SimulationInfo simulationInfo;\n"
//		output += "Logger logger;\n"
//		output += "Output output;\n"
//		output += "OutputToJSON_Mongo dbOut = null;\n"
		output += "int stepsUntilTermination;\n"
		for (field : sys.system_parameters.fields) {
			if (field instanceof Field) {
				output += "public static " + Printers.printFieldDeclarations(field as Field) + ";\n";
				libImports.add(HelperFunctions.getFieldType(field as Field));
			} else if (field instanceof Concern) {
			}
		}

		output += "//For all Systems\nstatic int clock = 0;\nint numberOfSteps;\nEntityID sysID;\n";
		output += "//Tier Below\nArrayList<Environment> storedEnvironments;\nArrayList<SemanticGroup> storedGroups;\n"
		output += "MessageQueue messageQueue;\nPhase currentPhase;\nint tier1Entities = 0;\n"
		output += "//Repast Specific\nContext<Entity> repastContext;\n"
		output += "static bool visualizing = false;\n"

		output += "\n//Getters & Setters\n"
		for (field : sys.system_parameters.fields) {
			if (field instanceof Field) {
				output += HelperFunctions.generateGettersSetters(field as Field, true) + "\n"
			}
		}
		return output;
	}

	// This just creates an init method to put various things in 
	def String initialiseSystem(System sys) {
		var str = "";
		for (a : sys.agent_types.agent_types) {
			str += "\t" + a.agent_type_name + "List = new ArrayList<" + a.agent_type_name + ">();\n"
		}

		for (env : sys.environment_types.environment_types) {
			str += "\t" + env.environment_type_name + "List = new ArrayList<" + env.environment_type_name + ">();\n"
		}

		str += "\tstoredEnvironments = new ArrayList<Environment>();\n"
		str += "\tstoredGroups = new ArrayList<SemanticGroup>();\n"

		return str
	}

	// TODO: (For all functions) make sure init is special and gets dumped into the intialise function
	def generateFunctions(System sys) {
		var output = "";
		for (function : sys.system_functions.functions) {
			output += "public "
			if (function.returnType !== null) {
				if (!(function.returnType instanceof FunctionParameter)) {
					libImports.add(HelperFunctions.getFieldType(function.returnType as Field))
				}
//				libImports.add(HelperFunctions.inferSymbolType((function.returnType as Symbol)));
				output += HelperFunctions.inferSymbolType(function.returnType) + " ";
			} else {
				output += "void ";
			}
			output +=
				function.name + "(" + HelperFunctions.printFunctionParameters(function.functionParameters) + ") {\n";
			if (function.returnType !== null) {
				output +=
					"\t" + HelperFunctions.inferFunctionParameterType(function.returnType as FunctionParameter) + " "
				output +=
					function.returnType.name + " = " +
						HelperFunctions.initialiseFunctionParameterReturn(function.returnType as FunctionParameter) +
						";\n";
			}
			if (function.name.compareTo("initialise") == 0) {
				for (sb : sys.system_parameters.fields) {
					if (sb instanceof Concern) {
						for (sbf : sb.stateFields) {
							output += "\tregisterState(\"" + sbf.ref.name + "\"," + sbf.ref.name + ");\n"
						}
					}
				}
			}
			for (statement : function.body) {
				if (statement instanceof Field) {
					libImports.add(HelperFunctions.getFieldType(statement as Field))
				}
				output += "\t" + HelperFunctions.parseBodyElement(statement, function) + "\n"
			}
			if (function.returnType !== null) {
				output += "\treturn " + function.returnType.name + ";\n"
			}
			output += "\n}\n"
		}
		return output;
	}

	/******SYSTEM LEVEL GENERATION STUFF **********/
	/**********lots of this will be needed across agents and environments */
	def String generateCASChecker(System sys) {
		var str = "";
		// Init the CASFeatures system
		str += "private CASFeatures casFeatures = new CASFeatures(\"" + sys.name + "\",ruleSet);\n"
		str += "public void registerAgentState_Init(Agent agent) {\n\tcasFeatures.registerAgentState_Init(agent); \n}\n"
		str +=
			"public void registerEnvironmentState_Init(Environment env) {\n\tcasFeatures.registerEnvironmentState_Init(env); \n}"
		str +=
			"public void runCASFeatureChecks(){\n\tcasFeatures.newCheck();\n/*MANUALcasFeatures.addAgentListForNewCheck(\"Cell\", CellList);*/\n\tcasFeatures.runChecks();\n}\n"
		str += "public void finalCASFeatureCall(){\n\tcasFeatures.finalCall();\n}\n"
		return str;
	}

	def String generateSimulateFunction(System sys) {
		var str = "";
		str += "public void simulate() {\n";
		str += "\tclock = (int)getCurrentTickCount();\n"
		str += "\t//Broadcast clock to tier1 entities\n\tbroadcast(MessageType.CLOCK,clock);\n";
		str += output_newStep(sys);
		str += "\t//Wait for Tier1 ACKS\n\n//Begin the fun\n"
		str += "\t/**********SETUP PHASE**********/ \n\n"
		str += "\tcurrentPhase = Phase.SETUP; \n"
		str += "\t//Broadcast clock to tier1 entities\n\tbroadcast(MessageType.CLOCK,clock);\n";
		str += "\t//Broadcast Phase.SETUP to tier1 entities\n\tbroadcast(MessageType.PHASE, currentPhase);\n\n"
		str += "\t//Make things go\n"
		str += "\tExecutorService envExecutor = Executors.newFixedThreadPool(tier1Entities);\n"
		str += "\tfor (Environment env : storedEnvironments){\n"
		str += "\t\tenvExecutor.execute(env);\n\t}\n"
		str += "\tenvExecutor.shutdown();\n"
		str += "\twhile(!envExecutor.isTerminated()){\n" // EWWWW
		str += "\t\t \n\t}\n"
		str += "\t/**********ACTION PHASE**********/ \n\n"
		str += "\tcurrentPhase = Phase.ACTION; \n"
		str += "\t//Broadcast Phase.SETUP to tier1 entities\n\tbroadcast(MessageType.PHASE, currentPhase);\n\n"
		str += "\t//Make things go\n"
		str += "\tenvExecutor = Executors.newFixedThreadPool(tier1Entities);\n"
		str += "\tfor (Environment env : storedEnvironments){\n"
		str += "\t\tenvExecutor.execute(env);\n\t}\n"
		str += "\tenvExecutor.shutdown();\n"
		str += "\twhile(!envExecutor.isTerminated()){\n" // EWWWW
		str += "\t\t \n\t}\n"
		str += "\t/**********CLEANUP PHASE**********/ \n\n"
		str += "\tclock = (int)getCurrentTickCount();\n"
		str += "\tcurrentPhase = Phase.CLEANUP; \n"
		str += "\t//Broadcast clock to tier1 entities\n\tbroadcast(MessageType.CLOCK,clock);\n";
		str += "\t//Broadcast Phase.SETUP to tier1 entities\n\tbroadcast(MessageType.PHASE, currentPhase);\n\n"
		str += "\t//Make things go\n"
		str += "\tenvExecutor = Executors.newFixedThreadPool(tier1Entities);\n"
		str += "\tfor (Environment env : storedEnvironments){\n"
		str += "\t\tenvExecutor.execute(env);\n\t}\n"
		str += "\tenvExecutor.shutdown();\n"
		str += "\twhile(!envExecutor.isTerminated()){\n" // EWWWW
		str += "\t\t \n\t}\n"
		str += output_endOfStep(sys);
		str += "}\n"
		return str;
	}

	def String output_newStep(System sys) {
		var str = "\t//New step logging and model data sending\n"
		str += "\toutput.newStep(clock);\n"

	}

	def String output_endOfStep(System sys) {
		var str = "\t//New step logging and model data sending\n"
		str += "\toutput.endOfStep(clock);\n"
	}

	def String output_endOfSim(System sys) {
		var str = "\t//Simulation has finished. Perform cleanup and sending of final data\n"
		str += "\toutput.endOfSimulation(clock, time, getTerminationStep());"
	}

	def String generateBroadcastFunction(System sys) '''
	/**
	 * Sends a message to all tier 1 entities
	 * @param  messageType [description]
	 * @param  contents    [description]
	 * @return             [description]
	 */
	<T> void broadcast(MessageType messageType, T contents){
		Message<T> message = new Message<T>(messageType, contents, clock);
	
		//Really you want generate a bunch of messages and put them in the queue
	
		for (Environment env : storedEnvironments){
			env.receiveMessage(new Message<T>(messageType, contents, clock, env));
		}
	
		for (SemanticGroup grp : storedGroups){
			grp.receiveMessage(new Message<T>(messageType, contents, clock, grp));
		}
	
		// notifyAll(); //??
	}'''

	def String generateDebugFunctions(System sys) {
		var str = "";
		str += "/*****Debugging Methods*****/\n"
		str += "public long time = 0;\n"
		str += "public long lastCall = 0;\n"
		str += "//Every time this is called it adds\n"
		str += "public void initTimer(){\n"
		str += "\ttime = 0;\n"
		str += "\tlastCall = System.currentTimeMillis();\n"
		str += "}\n"
		str += "public void timer(){\n"
		str += "\tlong tmpCall = System.currentTimeMillis();\n"
		str += "\ttime += (tmpCall - lastCall);\n"
		str += "\tlastCall = tmpCall;\n"
		str += "\t//		System.out.println(\"time: \" + time);\n"
		str += "}\n"
		str += '''
		public void printTimer() {
				System.out.print("runtime="+time + ",name="+name+",");
			}'''
		str += "\n"
//		str += "public void printTimer(){\n"
//		str += "\tSystem.out.print(time+\",\");\n"
//		str += "}\n"

		str += "/****Results Exporting*****/\n"

		str += "public void finalCall(){\n"
		str += output_endOfSim(sys);
		str += "}\n"

		return str
	}

	def String repastBuildInitialiser(System sys) {
		var str = "";
		str = "public Context<Entity> build (Context<Entity> context) {\n\tcontext.setId(\"" + sys.name + "\");\n"
		str += "\trepastContext = context;\n";

		str += "\t//Initialise lists to contain Agents and Environments\n"
		str += initialiseSystem(sys)
		str += "\n\t//Get parameters from Repast\n\tParameters params = RunEnvironment.getInstance().getParameters();\n"

		var paramGetters = "";
		for (field : sys.system_parameters.fields) {
			var ff = (field as Field)
			if (ff.declaration != null) {
				var fdt = ff.declaration as DataTypeDeclaration
				if (fdt.initInclude !== null) {
					paramGetters +=
						"\tset" + fdt.name.toFirstUpper + "_((" + HelperFunctions.getFieldType(ff) +
							")params.getValue(\"" + fdt.name + "\"));\n"
					paramGetters +=
						"\tsimulationParameters.add(new Parameter<" +
							HelperFunctions.javafy(HelperFunctions.getFieldType(ff)) + ">(" + fdt.name + ", \"" +
							fdt.name + "\"));\n"
				}
			}
		}

		// Stuff for termination
		var finalSteps = "";
		for (endCond : sys.end_conditions.end_conditions) {
			if (endCond.endType == EndConditionTypes.STEPS) {
				paramGetters +=
					"\tset" + endCond.name.toFirstUpper + "((int)params.getValue(\"" + endCond.name + "\"));\n"
				finalSteps = "\tRunEnvironment.getInstance().endAt(get" + endCond.name.toFirstUpper + "_());"
				str += "\tstepsUntilTermination = get" + endCond.name.toFirstUpper + "();\n"
			}
		}
		str += paramGetters + "\n"
		str += finalSteps + "\n"

		var scheduleSetup = "\n";
		scheduleSetup += "\t//Set Schedule for CASFeatures ()\n"
		scheduleSetup += "\tISchedule schedule;\n"
		scheduleSetup += "\tschedule = RunEnvironment.getInstance().getCurrentSchedule();\n"
		scheduleSetup +=
			"//\tScheduleParameters casFeatureRunner = ScheduleParameters.createRepeating(0,1,ScheduleParameters.LAST_PRIORITY + 1);\n"
		scheduleSetup += "//\tschedule.schedule(casFeatureRunner,this,\"runCASFeatureChecks\");\n"

		scheduleSetup += "\n\t//Timing\n"
		scheduleSetup +=
			"\tScheduleParameters stepper = ScheduleParameters.createRepeating(0,1,ScheduleParameters.FIRST_PRIORITY);\n"
		scheduleSetup += "\tschedule.schedule(stepper,this,\"simulate\");\n"
		scheduleSetup += "//\tschedule.schedule(stepper,this,\"prefixStepNumber\");\n"
		scheduleSetup +=
			"\tScheduleParameters timerSchedule = ScheduleParameters.createRepeating(0,1,ScheduleParameters.LAST_PRIORITY + 100);\n"
		scheduleSetup += "\tschedule.schedule(timerSchedule,this,\"timer\");\n"
		scheduleSetup +=
			"\tScheduleParameters initTimerSchedule = ScheduleParameters.createOneTime(0,ScheduleParameters.FIRST_PRIORITY);\n"
		scheduleSetup += "\tschedule.schedule(initTimerSchedule,this,\"initTimer\");\n"
		scheduleSetup +=
			"\tScheduleParameters printFinalTime = ScheduleParameters.createAtEnd(ScheduleParameters.LAST_PRIORITY);\n"
		scheduleSetup += "\tschedule.schedule(printFinalTime,this,\"printTimer\");\n"
		scheduleSetup += "\tschedule.schedule(printFinalTime,this,\"finalCall\");\n"
		str += scheduleSetup;

		// Initialise Agents/Environments
		// Initialize() & layouts are responsible for creating entities
		str += "\t//Fill the simulationInfo\n"
		str +=
			"\tsimulationInfo = new SimulationInfo(name, description, name + \"-\" + Utilities.generateTimeStamp());\n"
		str += "\t//Set up the outputter and logger\n"
		str += "\toutput = new Output(simulationInfo);\n"
		str += "\tlogger = new Logger(output, simulationInfo);\n"
		str += "\toutput.setLogger(logger);\n"
		str += "\t//Export information to Logger and/or Database\n"
		str += "\toutput.forceToConsole(systemSpecsToString(name, description, simulationParameters));\n"

		// Set up the main System init stuff
		str += "\n\tinitialize();\n"
		str += "\tif (visualizing) {\n\t\tvis = new LiveSimulator(dims);\n}\n"

		str += "\t//Are we writing to a database? If so, initialise the DB stuff\n"
		str += "\tdbOut = new OutputToJSON_Mongo(output, simulationInfo);\n"
		str += "\toutput.setDatabaseOutput(dbOut);\n"
		str += "\toutput.setupDB(simulationInfo.getSystemName(), simulationInfo.getExecutionID(), \"simulations\");\n"

		// What we want to have here is context adding of environments and subcontext adding of groups (if an SG model)
//		str += "\tstoredEnvironments.addAll(layoutParameters.getContainedEnvironments());\n"	
		str += "\ttier1Entities = storedEnvironments.size();";
		str += "\n\treturn context;"
		str += "\n}\n"

		// TODO: Move this later
		str +=
			"public double getCurrentTickCount(){\n\treturn RunEnvironment.getInstance().getCurrentSchedule().getTickCount();\n}";

		str += '''//Visualisation stuff
			static LiveSimulator vis;
			
			public static void drawEntities(ArrayList<castleComponents.Agent> ents) {
				if (visualizing){
					//get the clock
					int time = clock; //TODO
					ArrayList<VEntity> ves = new ArrayList<VEntity>();
					//We must convert the agents to VEntity at runtime :/
					for (castleComponents.Agent a : ents) {
						if (a.isVisualising()){
							ves.add(new VEntity(a));
						}
					}
					
					vis.newStep(time, ves);
				}
			}'''

		return str
	}
}
