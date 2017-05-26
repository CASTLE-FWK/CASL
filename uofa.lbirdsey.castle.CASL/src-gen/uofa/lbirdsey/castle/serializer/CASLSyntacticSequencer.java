/*
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import uofa.lbirdsey.castle.services.CASLGrammarAccess;

@SuppressWarnings("all")
public class CASLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CASLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Feature_CommaKeyword_3_1_or_SemicolonKeyword_3_0;
	protected AbstractElementAlias match_Prefixed_LeftParenthesisKeyword_2_0_a;
	protected AbstractElementAlias match_Prefixed_LeftParenthesisKeyword_2_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CASLGrammarAccess) access;
		match_Feature_CommaKeyword_3_1_or_SemicolonKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getFeatureAccess().getCommaKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getFeatureAccess().getSemicolonKeyword_3_0()));
		match_Prefixed_LeftParenthesisKeyword_2_0_a = new TokenAlias(true, true, grammarAccess.getPrefixedAccess().getLeftParenthesisKeyword_2_0());
		match_Prefixed_LeftParenthesisKeyword_2_0_p = new TokenAlias(true, false, grammarAccess.getPrefixedAccess().getLeftParenthesisKeyword_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Feature_CommaKeyword_3_1_or_SemicolonKeyword_3_0.equals(syntax))
				emit_Feature_CommaKeyword_3_1_or_SemicolonKeyword_3_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Prefixed_LeftParenthesisKeyword_2_0_a.equals(syntax))
				emit_Prefixed_LeftParenthesisKeyword_2_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Prefixed_LeftParenthesisKeyword_2_0_p.equals(syntax))
				emit_Prefixed_LeftParenthesisKeyword_2_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ';' | ','
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 *     type=[Type|QualifiedName] (ambiguity) (rule end)
	 *     val=AbstractElement (ambiguity) (rule end)
	 */
	protected void emit_Feature_CommaKeyword_3_1_or_SemicolonKeyword_3_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' expression=Prefixed
	 *     (rule start) (ambiguity) '-' expression=Prefixed
	 *     (rule start) (ambiguity) 'for' '(' init=Expression
	 *     (rule start) (ambiguity) 'for' '(' init=Field
	 *     (rule start) (ambiguity) 'for' '(' init=Formula
	 *     (rule start) (ambiguity) 'for' '(' init=SelfAssignedFormula
	 *     (rule start) (ambiguity) 'foreach' '(' ty=QualifiedName
	 *     (rule start) (ambiguity) 'if' '(' condition=Expression
	 *     (rule start) (ambiguity) agentCall=Agent_Call
	 *     (rule start) (ambiguity) bool=BooleanValue
	 *     (rule start) (ambiguity) enumCall=EnumCall
	 *     (rule start) (ambiguity) environmentCall=Environment_Call
	 *     (rule start) (ambiguity) func=FeatureCall
	 *     (rule start) (ambiguity) funcCall=FunctionCall
	 *     (rule start) (ambiguity) groupCall=Group_Call
	 *     (rule start) (ambiguity) macroCall=CASL_Macro_Call
	 *     (rule start) (ambiguity) nulltype=NullType
	 *     (rule start) (ambiguity) selfCall=SelfCall
	 *     (rule start) (ambiguity) sysCall=SystemCall
	 *     (rule start) (ambiguity) type=[Symbol|ID]
	 *     (rule start) (ambiguity) value=NUMBER
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {Addition.left=}
	 *     (rule start) (ambiguity) {BooleanExpression.left=}
	 *     (rule start) (ambiguity) {Comparison.left=}
	 *     (rule start) (ambiguity) {Div.left=}
	 *     (rule start) (ambiguity) {Equals.left=}
	 *     (rule start) (ambiguity) {Multiplication.left=}
	 *     (rule start) (ambiguity) {Subtraction.left=}
	 */
	protected void emit_Prefixed_LeftParenthesisKeyword_2_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'for' '(' init=Expression
	 *     (rule start) (ambiguity) 'for' '(' init=Field
	 *     (rule start) (ambiguity) 'for' '(' init=Formula
	 *     (rule start) (ambiguity) 'for' '(' init=SelfAssignedFormula
	 *     (rule start) (ambiguity) 'foreach' '(' ty=QualifiedName
	 *     (rule start) (ambiguity) 'if' '(' condition=Expression
	 *     (rule start) (ambiguity) {Addition.left=}
	 *     (rule start) (ambiguity) {BooleanExpression.left=}
	 *     (rule start) (ambiguity) {Comparison.left=}
	 *     (rule start) (ambiguity) {Div.left=}
	 *     (rule start) (ambiguity) {Equals.left=}
	 *     (rule start) (ambiguity) {Multiplication.left=}
	 *     (rule start) (ambiguity) {Subtraction.left=}
	 */
	protected void emit_Prefixed_LeftParenthesisKeyword_2_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
