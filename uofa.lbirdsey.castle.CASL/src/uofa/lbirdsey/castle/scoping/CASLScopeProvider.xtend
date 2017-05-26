/*
 * generated by Xtext
 */
package uofa.lbirdsey.castle.scoping

import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import uofa.lbirdsey.castle.casl.AgentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.DataTypeDeclaration
import uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall
import uofa.lbirdsey.castle.casl.Field
import uofa.lbirdsey.castle.casl.Formula
import uofa.lbirdsey.castle.casl.FunctionParameter
import uofa.lbirdsey.castle.casl.SelfAssignedFormula
import uofa.lbirdsey.castle.casl.SelfCallExpr
import uofa.lbirdsey.castle.casl.Function
import uofa.lbirdsey.castle.casl.FunctionCall
import uofa.lbirdsey.castle.casl.TypeRef
import uofa.lbirdsey.castle.casl.SelfCall
import uofa.lbirdsey.castle.casl.NonPrimitiveType
import org.eclipse.emf.common.util.EList
import java.util.ArrayList
import uofa.lbirdsey.castle.casl.Symbol
import uofa.lbirdsey.castle.casl.Parameters
import uofa.lbirdsey.castle.casl.EnvironmentFieldReference
import uofa.lbirdsey.castle.casl.AgentFieldReference
import uofa.lbirdsey.castle.casl.EnumCall
import uofa.lbirdsey.castle.casl.GroupFieldReference
import uofa.lbirdsey.castle.casl.GroupInternalInteractionsFeatureCall

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 *
 */
class CASLScopeProvider extends AbstractDeclarativeScopeProvider {

	//What is this and how can I use it to fix my stupid issues
	
	//What should happen now is that when an EnrvironmentInteraction
	//or AgentInteraction appear, they should be exposed to the entire scope
	//of CASL interactions (which is still not correct but will fix issues for the 
	//moment). However, this does not work yet. :(

	def scope_AgentInteractionFeatureCall_process(AgentInteractionFeatureCall context, EReference ref) {
		if (context.agt instanceof FunctionParameter){
			return Scopes.scopeFor((context.agt as FunctionParameter).agent.agent_interactions.interactions);
		} else if (context.agt instanceof AgentFieldReference) {	
			return Scopes.scopeFor((context.agt as AgentFieldReference).agent.agent_interactions.interactions); 			
		} 
	}
	
	def scope_EnvironmentInteractionFeatureCall_process(EnvironmentInteractionFeatureCall context, EReference ref) {
		if (context.env instanceof FunctionParameter){
			return Scopes.scopeFor((context.env as FunctionParameter).env.env_interactions.interactions);
		} else if (context.env instanceof EnvironmentFieldReference) {	
			return Scopes.scopeFor((context.env as EnvironmentFieldReference).env.env_interactions.interactions); 			
		} 
	}
	
	def scope_GroupInternalInteractionsFeatureCall_process(GroupInternalInteractionsFeatureCall context, EReference ref) {
		if (context.grp instanceof FunctionParameter){
			return Scopes.scopeFor((context.grp as FunctionParameter).grp.group_internal_interactions.internal_interactions);
		} else if (context.grp instanceof GroupFieldReference) {	
			return Scopes.scopeFor((context.grp as GroupFieldReference).grp.group_internal_interactions.internal_interactions); 			
		} 
	}
	
//	def scope_GroupSelfInternalsFeatureCall_process(GroupSelfInternalsFeatureCall context, EReference ref) {
//		if (context.env instanceof FunctionParameter){
//			return Scopes.scopeFor((context.env as FunctionParameter).env.env_interactions.interactions);
//		} else if (context.env instanceof EnvironmentFieldReference) {	
//			return Scopes.scopeFor((context.env as EnvironmentFieldReference).env.env_interactions.interactions); 			
//		} 
//	}
	
	def scope_SelfAssignedFormula_objField(SelfAssignedFormula context, EReference ref){
		if (context.ref instanceof DataTypeDeclaration){
			if ((context.ref as DataTypeDeclaration).obj != null) {
				var bigList = newArrayList();
				bigList = addToSymbolsList((context.ref as DataTypeDeclaration).obj, bigList);

				return Scopes.scopeFor(bigList)
			}
		}
	}
	
	def addToSymbolsList(NonPrimitiveType npt, ArrayList<Symbol> listToAddTo){
		if (npt instanceof uofa.lbirdsey.castle.casl.Object){
			val obj = npt as uofa.lbirdsey.castle.casl.Object;
			for (f : obj.fields) {
				if (f instanceof Field) {
					val fdt = f as Field
					if (fdt.declaration != null){
						listToAddTo.add(fdt.declaration)
					} else if (fdt.agentFieldRef != null){
						listToAddTo.add(fdt.agentFieldRef)
					} else if (fdt.envFieldRef != null){
						listToAddTo.add(fdt.envFieldRef)
					}
				}
			}
		} if (npt instanceof uofa.lbirdsey.castle.casl.Enum) {
			val enu = npt as uofa.lbirdsey.castle.casl.Enum
			for (f : enu.enum_fields) {
				listToAddTo.add(f);
			}
		}
		
		return listToAddTo;		
	}
	
	def addToFunctionsList(NonPrimitiveType npt, ArrayList<Function> listToAddTo){
		if (npt instanceof uofa.lbirdsey.castle.casl.Object){
			val obj = npt as uofa.lbirdsey.castle.casl.Object;
			for (f : obj.fields) {
				if (f instanceof Function){
						listToAddTo.add(f as Function)
				}
			}
		}
		
		return listToAddTo;
		
	}
	
	def scope_Formula_objField(Formula context, EReference ref){
		if (context.sym instanceof DataTypeDeclaration){
			if ((context.sym as DataTypeDeclaration).obj != null) {
				var bigList = newArrayList();
				bigList = addToSymbolsList((context.sym as DataTypeDeclaration).obj,bigList);

				return Scopes.scopeFor(bigList)
			}
		} else if (context.sym instanceof FunctionParameter) {
			if ((context.sym as FunctionParameter).obj != null) {
				var bigList = newArrayList();
				bigList = addToSymbolsList((context.sym as FunctionParameter).obj,bigList);

				return Scopes.scopeFor(bigList)
			}
		}
	}


//TODO: Move this over to FunctionCall	
//	def scope_SelfCall_call(SelfCall context, EReference ref){
//		if (context.ref != null) {
//			if (context.ref instanceof DataTypeDeclaration){
//				if ((context.ref as DataTypeDeclaration).obj != null) {
//					var bigList = newArrayList();
//					bigList = addToSymbolsList(context.ref.obj,bigList);
//
//					return Scopes.scopeFor(bigList)
//				}				
//			}
//		}
//	}
	//TODO:Fix all the scoping on FunctionCall
	def scope_FunctionCall_func(FunctionCall fc, EReference ref) {
		var sym = fc.obj
		if (sym instanceof DataTypeDeclaration){
			var dtd = (sym as DataTypeDeclaration)
			if (dtd.obj != null){
				var bigList = newArrayList();
				bigList = addToFunctionsList(dtd.obj, bigList);

				return Scopes.scopeFor(bigList)
			}
		} //if or else if?
		if (sym instanceof FunctionParameter){
			var fp = sym as FunctionParameter
			if (fp.obj != null){
				var bigList = newArrayList();
				bigList = addToFunctionsList(fp.obj, bigList);

				return Scopes.scopeFor(bigList)
			}
		}
	}
	
	def scope_FunctionCall_fields(FunctionCall fc, EReference ref){
		if (fc.obj != null){
			var sym = fc.obj
			if (sym instanceof DataTypeDeclaration){
				var dtd = (sym as DataTypeDeclaration)
				if (dtd.obj != null){
					var bigList = newArrayList();
					bigList = addToSymbolsList(dtd.obj,bigList);
					return Scopes.scopeFor(bigList)
				}
			} else if (sym instanceof FunctionParameter){
				var fp = sym as FunctionParameter
				if (fp.obj != null){
					var bigList = newArrayList();
					bigList = addToSymbolsList(fp.obj,bigList);
					return Scopes.scopeFor(bigList)
				}
			}
		}
	}
	
	def scope_EnumCall_entype(EnumCall ec, EReference ref){
		var list = newArrayList();
		list = addToSymbolsList(ec.en,list);
		return Scopes.scopeFor(list)
	}


//	def scope_TypeRef_call(TypeRef context, EReference ref){
//		if (context.type != null){
//			var sym = context.type
//			if (sym instanceof DataTypeDeclaration){
//				var dtd = (sym as DataTypeDeclaration)
//				if (dtd.obj != null){
//					var bigList = newArrayList();
//					bigList = addToSymbolsList(dtd.obj,bigList);
//					return Scopes.scopeFor(bigList)
//				}
//			} else if (sym instanceof FunctionParameter){
//				var fp = sym as FunctionParameter
//				if (fp.obj != null){
//					var bigList = newArrayList();
//					bigList = addToSymbolsList(fp.obj,bigList);
//					return Scopes.scopeFor(bigList)
//				}
//			}
//		}
//	}
}
