/*
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import uofa.lbirdsey.castle.parser.antlr.internal.InternalCASLParser;
import uofa.lbirdsey.castle.services.CASLGrammarAccess;

public class CASLParser extends AbstractAntlrParser {

	@Inject
	private CASLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalCASLParser createParser(XtextTokenStream stream) {
		return new InternalCASLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Casl";
	}

	public CASLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CASLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
