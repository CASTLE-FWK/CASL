/*
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import uofa.lbirdsey.castle.CASL.ui.internal.CASLActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CASLExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(CASLActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		CASLActivator activator = CASLActivator.getInstance();
		return activator != null ? activator.getInjector(CASLActivator.UOFA_LBIRDSEY_CASTLE_CASL) : null;
	}

}
