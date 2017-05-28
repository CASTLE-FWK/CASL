package uofa.lbirdsey.castle.generator.semanticGroups

import uofa.lbirdsey.castle.casl.AdaptationDelay
import uofa.lbirdsey.castle.casl.Agent
import uofa.lbirdsey.castle.casl.BehaviorReactionTime
import uofa.lbirdsey.castle.casl.Environment
import uofa.lbirdsey.castle.casl.Group
import uofa.lbirdsey.castle.casl.InteractionTriggerTypes
import uofa.lbirdsey.castle.casl.NumberLiteral

class RepastSpecifics {
		static def String generateSystemBuilder(){
		var imports = "";
		imports = 
"import stdSimLib.utilities.Utilities;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import casFeatures.CASLib.CAS_Inspection_Level;
//import casFeatures.CASLib.CAS_Rule_Exception;
//import casFeatures.CASLib.CAS_Rule_Type;
//import casFeatures.CASRuleSet;

import repast.simphony.context.Context;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ISchedule;
import repast.simphony.engine.schedule.ScheduleParameters;
import repast.simphony.parameter.Parameters;

import castleComponents.Entity;
import castleComponents.EntityID;
import castleComponents.Logger;
import castleComponents.Message;
import castleComponents.MessageQueue;
import castleComponents.MessageType;
import castleComponents.Phase;
import castleComponents.objects.List;
import castleComponents.Trigger;"
					return imports;				
	}
	
	static def String generateAgentBuilder(){
		//imports
		val imports = 
"
import stdSimLib.utilities.Utilities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.function.Function;

import castleComponents.MessageType;
import castleComponents.Phase;
import castleComponents.Trigger;
import castleComponents.EntityID;"			
		return imports
	}
	
	static def String generateEnvironmentBuilder(){
		//imports
		val imports = 
"import repast.simphony.context.Context;
import repast.simphony.context.DefaultContext;
import stdSimLib.utilities.Utilities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.function.Function;

import castleComponents.Agent;
import castleComponents.MessageType;
import castleComponents.Phase;
import castleComponents.Trigger;
import castleComponents.EntityID;"	
		return imports
	}
	
	static def String createSchedule(Agent a){
		var sig = "";
		sig = "@Override \n public void initialiseSchedule(double startTime, double startDelay) {\n"	
		sig += "\tISchedule schedule;\n"		
		sig += "\tschedule = RunEnvironment.getInstance().getCurrentSchedule();\n"
		sig += "\t//Set up pre() schedule\n\tScheduleParameters pre_Schedule = ScheduleParameters.createRepeating(1,1,ScheduleParameters.FIRST_PRIORITY);\n"
		sig += "\t//Set up post() schedule\n\tScheduleParameters post_Schedule = ScheduleParameters.createRepeating(1,1,ScheduleParameters.LAST_PRIORITY + 1);\n"
		//Determine what methods need to be scheduled and when
		//Interactions
		var schedules = newArrayList
		sig += "\t//Interaction Schedules\n"
		for (interaction : a.agent_interactions.interactions) {
			if (interaction.trigger_type == InteractionTriggerTypes.STEP){
				//Expecting a numeric value
				var steps = (interaction.triggerParam.expr as NumberLiteral).value
				var schedule = interaction.name + "_Schedule"
				var scheduleSetup = "ScheduleParameters " + schedule + " = ScheduleParameters.createRepeating(1,"+steps+",2);"
				sig += "\t"+scheduleSetup+"\n"
				schedules.add("schedule.schedule("+schedule+",this,\""+interaction.name+"\");")								
			}					
		}
		sig += "\n\t//Adaptation Schedules\n"
		for (adaptation : a.agent_adaptation.adaptation) {
			if (adaptation.adaptationDelay == AdaptationDelay.POST){
				var schedule = adaptation.name +"_Schedule"
				//THIS HAS HARD CODING IN IT. BE WARNED
				var scheduleSetup = "ScheduleParameters " + schedule + " = ScheduleParameters.createRepeating(1,"+1+",ScheduleParameters.LAST_PRIORITY + 1);"
				sig += "\t"+scheduleSetup+"\n"
				schedules.add("schedule.schedule("+schedule+",this,\""+adaptation.name+"\");")		
			}	
		}				
		sig += "\n\t//Behavior Schedules\n"
		for (behavior : a.agent_behaviors.behaviors) {
			if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				var schedule = behavior.name +"_Schedule"
				//THIS HAS HARD CODING IN IT. BE WARNED
				var scheduleSetup = "ScheduleParameters " + schedule + " = ScheduleParameters.createRepeating(1,"+1+");"
				sig += "\t"+scheduleSetup+"\n"
				schedules.add("schedule.schedule("+schedule+",this,\""+behavior.name+"\");")		
			}	
		}	
		sig += "\n"
		sig += "\t//Send schedules to Scheduler\n"
		for (str : schedules){
			sig += "\t"+str+"\n"
		}
		sig += "\tschedule.schedule(pre_Schedule,this,\"pre\");\n"
		sig += "\tschedule.schedule(post_Schedule,this,\"post\");\n"
		sig += '}'
		return sig;			
	}
	
	static def String createSchedule(Environment env){
		var sig = "";
		sig = "@Override \n public void initialiseSchedule(double startTime, double startDelay) {\n"	
		sig += "\tISchedule schedule;\n"		
		sig += "\tschedule = RunEnvironment.getInstance().getCurrentSchedule();\n"
		sig += "\t//Set up pre() schedule\n\tScheduleParameters pre_Schedule = ScheduleParameters.createRepeating(1,1,ScheduleParameters.FIRST_PRIORITY);\n"
		sig += "\t//Set up post() schedule\n\tScheduleParameters post_Schedule = ScheduleParameters.createRepeating(1,1,ScheduleParameters.LAST_PRIORITY + 1);\n"
		sig += "\t//Set up end() schedule\n\tScheduleParameters end_Schedule = ScheduleParameters.createAtEnd(ScheduleParameters.LAST_PRIORITY);"
		//Determine what methods need to be scheduled and when
		//Interactions
		var schedules = newArrayList
		sig += "\t//Interaction Schedules\n"
		for (interaction : env.env_interactions.interactions) {
			if (interaction.trigger_type == InteractionTriggerTypes.STEP){
				//Expecting a numeric value
				var steps = (interaction.triggerParam.expr as NumberLiteral).value
				var schedule = interaction.name + "_Schedule"
				var scheduleSetup = "ScheduleParameters " + schedule + " = ScheduleParameters.createRepeating(1,"+steps+",2);"
				sig += "\t"+scheduleSetup+"\n"
				schedules.add("schedule.schedule("+schedule+",this,\""+interaction.name+"\");")								
			}					
		}
		sig += "\n\t//Adaptation Schedules\n"
		for (adaptation : env.env_adaptation.adaptation) {
			if (adaptation.adaptationDelay == AdaptationDelay.POST){
				var schedule = adaptation.name +"_Schedule"
				//THIS HAS HARD CODING IN IT. BE WARNED
				var scheduleSetup = "ScheduleParameters " + schedule + " = ScheduleParameters.createRepeating(1,"+1+",ScheduleParameters.LAST_PRIORITY + 1);"
				sig += "\t"+scheduleSetup+"\n"
				schedules.add("schedule.schedule("+schedule+",this,\""+adaptation.name+"\");")		
			}	
		}				
		for (behavior : env.env_behaviors.behaviors) {
			if (behavior.behavior_reaction_time == BehaviorReactionTime.STEP){
				var schedule = behavior.name +"_Schedule"
				//THIS HAS HARD CODING IN IT. BE WARNED
				var scheduleSetup = "ScheduleParameters " + schedule + " = ScheduleParameters.createRepeating(1,"+1+");"
				sig += "\t"+scheduleSetup+"\n"
				schedules.add("schedule.schedule("+schedule+",this,\""+behavior.name+"\");")		
			}	
		}	
		sig += "\n"
		sig += "\t//Send schedules to Scheduler\n"
		for (str : schedules){
			sig += "\t"+str+"\n"
		}
		sig += "\tschedule.schedule(pre_Schedule,this,\"pre\");\n"
		sig += "\tschedule.schedule(post_Schedule,this,\"post\");\n"
		sig += "\tschedule.schedule(end_Schedule,this,\"end\");\n"
		sig += '}'
		return sig;			
	}
	
	static def String createSchedule(Group grp){
		var sig = "";
		sig = "@Override \n public void initialiseSchedule(double startTime, double startDelay) {\n"	
		sig += "\tISchedule schedule;\n"		
		sig += "\tschedule = RunEnvironment.getInstance().getCurrentSchedule();\n"
		sig += "\t//Set up pre() schedule\n\tScheduleParameters pre_Schedule = ScheduleParameters.createRepeating(1,1,ScheduleParameters.FIRST_PRIORITY);\n"
		sig += "\t//Set up post() schedule\n\tScheduleParameters post_Schedule = ScheduleParameters.createRepeating(1,1,ScheduleParameters.LAST_PRIORITY + 1);\n"
		//Determine what methods need to be scheduled and when
		//Interactions
		var schedules = newArrayList
		sig += "\n\t//Behavior Schedules\n"
		for (behavior : grp.group_behaviors.behaviors) {
			if (behavior.behavior_reaction_time == BehaviorReactionTime.REPEAT){
				var schedule = behavior.name +"_Schedule"
				//THIS HAS HARD CODING IN IT. BE WARNED
				var scheduleSetup = "ScheduleParameters " + schedule + " = ScheduleParameters.createRepeating(1,"+1+");"
				sig += "\t"+scheduleSetup+"\n"
				schedules.add("schedule.schedule("+schedule+",this,\""+behavior.name+"\");")		
			}	
		}	
		sig += "\n"
		sig += "\t//Send schedules to Scheduler\n"
		for (str : schedules){
			sig += "\t"+str+"\n"
		}
		sig += "\tschedule.schedule(pre_Schedule,this,\"pre\");\n"
		sig += "\tschedule.schedule(post_Schedule,this,\"post\");\n"
		sig += '}'
		return sig;			
	}
}