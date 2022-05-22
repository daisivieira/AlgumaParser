/*
 * generated by Xtext 2.27.0.M2
 */
package br.ufscar.dc.compiladores.alguma.ide;

import br.ufscar.dc.compiladores.alguma.AlgumaRuntimeModule;
import br.ufscar.dc.compiladores.alguma.AlgumaStandaloneSetup;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class AlgumaIdeSetup extends AlgumaStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new AlgumaRuntimeModule(), new AlgumaIdeModule()));
	}
	
}
