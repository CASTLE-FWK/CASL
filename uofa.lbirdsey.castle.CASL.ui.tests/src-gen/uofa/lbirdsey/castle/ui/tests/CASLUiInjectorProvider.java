/*
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;
import uofa.lbirdsey.castle.CASL.ui.internal.CASLActivator;

public class CASLUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return CASLActivator.getInstance().getInjector("uofa.lbirdsey.castle.CASL");
	}

}
