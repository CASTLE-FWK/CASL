/*
 * generated by Xtext
 */
package uofa.lbirdsey.castle.generator.semanticGroups

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.IQualifiedNameProvider
import uofa.lbirdsey.castle.casl.AbstractElement
import uofa.lbirdsey.castle.casl.Agent
import uofa.lbirdsey.castle.casl.Casl
import uofa.lbirdsey.castle.casl.Enum
import uofa.lbirdsey.castle.casl.Environment
import uofa.lbirdsey.castle.casl.Group
import uofa.lbirdsey.castle.casl.Object
import uofa.lbirdsey.castle.casl.System
import uofa.lbirdsey.castle.casl.Type
//import uofa.lbirdsey.castle.generator.HelperFunctions
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import uofa.lbirdsey.castle.casl.CAS_Semantic_Group_Switch
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Helpers

//import uofa.lbirdsey.castle.generator.castleComponents.HelperFunctions
/**
 * Generates code from your model files on save. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class RepastGenerator implements IGenerator2 {

	@Inject extension IQualifiedNameProvider
	var dirName = "";
	var mainPkg = "";
	var agentsPkg = ".agents";
	var envsPkg = ".environments";
	var grpsPkg = ".groups";
	var objsPkg = "";
	val lib = "castleComponents"
	val lib_obj = "castleComponents.objects"
	var groupsActive = false;

	override afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		throw new UnsupportedOperationException("TODO: auto-generated method stub")
//		print("post generation")
	}

	override beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		throw new UnsupportedOperationException("TODO: auto-generated method stub")
//		print("pre generation")
	}

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// Create sub-directories for each CAS Type
		Helpers.initTypesList();

		// Check to see if groups are off
		// Populate the types list (this really should be a table for V. large models but later...)
		for (ae : resource.allContents.toIterable.filter(AbstractElement)) {
			if (ae instanceof Object) {
				var pkgs = ae as Object
				Helpers.addToTypesArray(pkgs as Object);
			} else if (ae instanceof Enum) {
				var pkgs = ae as Enum
				Helpers.addToTypesArray(pkgs as Enum);
			}
		}
		for (e : resource.allContents.toIterable.filter(Agent)) {
			Helpers.addToTypesArray(e as Agent);
		}
		for (e : resource.allContents.toIterable.filter(Group)) {
			Helpers.addToTypesArray(e as Group);
		}
		for (e : resource.allContents.toIterable.filter(Environment)) {
			Helpers.addToTypesArray(e as Environment);
		}

		// Begin the creation of files.
		// Process the SYSTEM
		for (sys : resource.allContents.toIterable.filter(System)) {
			dirName = sys.name.replaceAll(" ", "");
			mainPkg = sys.name.replaceAll(" ", "").toFirstLower;
			agentsPkg = mainPkg + ".agents";
			envsPkg = mainPkg + ".environments";
			grpsPkg = mainPkg + ".groups";
			objsPkg = mainPkg + ".objects"
			groupsActive = (sys.cas_rules.semanticgroups == CAS_Semantic_Group_Switch.ENABLE);
			fsa.generateFile(dirName + "/" + sys.fullyQualifiedName.toString("/").replaceAll(" ", "") + ".java",
				sys.compileSystem.toString.replaceAll("string", "String").replaceAll("bool", "boolean").
					replaceAll("(;)+", ";"))

			fsa.generateFile(
				dirName.toFirstUpper + "/" + sys.fullyQualifiedName.toString("/").replaceAll(" ", "") +
					".rs/parameters.xml",
				sys.generateInitFile.toString.replaceAll("string", "String").replaceAll("bool", "boolean").
					replaceAll("(;)+", ";"))

		}

		// Generate the classes and get them imported!
		for (ae : resource.allContents.toIterable.filter(AbstractElement)) {
			if (ae instanceof Object) {
				var pkgs = ae as Object
				if (pkgs.custom !== null){
	//	 			HelperFunctions.addToTypesArray(pkgs as Object);
					fsa.generateFile(dirName + "/objects/" + pkgs.name + ".java",
						pkgs.createPackages.toString.replaceAll("string\\s+", "String ").replaceAll("bool\\s+", "boolean ").
							replaceAll("(;)+", ";"))
				}
			} else if (ae instanceof Enum) {
				var pkgs = ae as Enum
// 				HelperFunctions.addToTypesArray(pkgs as Enum);
				// Generate all ENUMS then place into a single file
				if (pkgs.custom !== null){
				fsa.generateFile(dirName + "/objects/" + pkgs.name + "_ENUM.java",
					pkgs.createPackages.toString.replaceAll("string\\s+", "String ").replaceAll("bool\\s+", "boolean ").
						replaceAll("(;)+", ";"))
				}
			}
		}
		// Process the AGENTs
		for (e : resource.allContents.toIterable.filter(Agent)) {
//			HelperFunctions.addToTypesArray(e as Agent);
			fsa.generateFile(dirName + "/agents/" + e.fullyQualifiedName.toString("/") + ".java",
				e.compileAgent.toString.replaceAll("string\\s+", "String ").replaceAll("bool\\s+", "boolean ").replaceAll("(;)+",
					";"))
		}

		// Process the GROUPS
		if (groupsActive) {
			for (e : resource.allContents.toIterable.filter(Group)) {
				// HelperFunctions.addToTypesArray(e as Group);
				fsa.generateFile(dirName + "/groups/" + e.fullyQualifiedName.toString("/") + ".java",
					e.compileGroup.toString.replaceAll("string\\s+", "String ").replaceAll("bool\\s+", "boolean ").
						replaceAll("(;)+", ";"))
			}
		}

		// Process the ENVIRONMENTS
		for (e : resource.allContents.toIterable.filter(Environment)) {
//			HelperFunctions.addToTypesArray(e as Environment);
			fsa.generateFile(dirName + "/environments/" + e.fullyQualifiedName.toString("/") + ".java",
				e.compileEnvironment.toString.replaceAll("string\\s+", "String ").replaceAll("bool\\s+", "boolean ").
					replaceAll("(;)+", ";"))
		}
	}

	def String compileSystem(System s) {
		var sys = new SystemGeneration(s, mainPkg);
		Helpers.setSystemName(s.name);
		sys.setup();
		return Printers.copyrightPrint(s.name) + sys.print();
	}

	def String generateInitFile(System s) {
		var sys = InitializationParametersGenerator.generateFile(s.system_parameters.fields);
		return sys;
	}

	// This should really be subclass stuff in the System class
	def compilePackage(Casl casl) '''
		«FOR pkg : casl.packageElements»
			«IF pkg instanceof Type»
			«ENDIF»
		«ENDFOR»
	'''

	// Parse an AGENTs stuff and break it down
	def String compileAgent(Agent a) {
		var ag = new AgentGeneration(a, mainPkg, agentsPkg);
		ag.setup();
		return Printers.copyrightPrint(a.name) + ag.print()
	}

	// Parse a GROUPs stuff and break it down
	def compileGroup(Group g) {
		var grp = new GroupGeneration(g, mainPkg, grpsPkg);
		grp.setup();
		return Printers.copyrightPrint(g.name) + grp.print();
	}

	// Parse an ENVIRONMENTs stuff and break it down	
	def compileEnvironment(Environment e) {
		var env = new EnvironmentGeneration(e, mainPkg, envsPkg, groupsActive);
		env.setup();
		return Printers.copyrightPrint(e.name) + env.print();
	}

	// TODO: Handle the automated importing of packages
	def String createPackages(AbstractElement e) {
		var ae = new CustomObjectGeneration(e, mainPkg, objsPkg);
		ae.setup();
		// return HelperFunctions.copyrightPrint(e.name) + ae.print(); 
		return ae.print();
	}

	// Cycle through parameters and find all GROUPS
	// Do this after the initialise step has been completed
	def String repastBuildInitialiser(Environment env) {
		var str = "";
		str = "public Context<SemanticGroup> build () {\n"
		str += "\tContext<SemanticGroup> groupContext = new DefaultContext<SemanticGroup>();\n"
		str += "\t//Build Groups"
		str += "\n\tfor (SemanticGroup grp : groups){"
		str += "\n\t\tgroupContext.add(grp);"
		str += "\n\t}"
		str += "\n\treturn groupContext;"
		str += "\t}"

	}
}
