package com.sophos.pruebatecnica.steps;

import com.sophos.pruebatecnica.pageobjects.OfertasTrabajoDisponiblesPageObjects;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;

public class OfertasTrabajoDisponiblesSteps {

	OfertasTrabajoDisponiblesPageObjects ofertasTrabajoDisponiblesPageObjects;
	
	@Step
	public void abrirUrlSophos() {
		ofertasTrabajoDisponiblesPageObjects.open();
	}

	@Step
	public void ingresarTrabajaConNosotros() {
		ofertasTrabajoDisponiblesPageObjects.saltarPopUp();
		Serenity.takeScreenshot();
		ofertasTrabajoDisponiblesPageObjects.ingresarTrabajaConNosotros();
		Serenity.takeScreenshot();
	}

	@Step
	public void generarLista() {
		if(ofertasTrabajoDisponiblesPageObjects.validarRegistros()) {
			ofertasTrabajoDisponiblesPageObjects.buscarTrabajo();
			Serenity.takeScreenshot();
		}
		
		while(ofertasTrabajoDisponiblesPageObjects.validarSiguiente() && !ofertasTrabajoDisponiblesPageObjects.validarRegistros()) {
			ofertasTrabajoDisponiblesPageObjects.bajarPantalla();
			Serenity.takeScreenshot();
			ofertasTrabajoDisponiblesPageObjects.imprimirTrabajos();
			ofertasTrabajoDisponiblesPageObjects.avanzarSiguiente();
		}
		
		MatcherAssert.assertThat("Ya no existen más trabajos por lo que se detiene la prueba. PRUEBA EXITOSA", 
								  !ofertasTrabajoDisponiblesPageObjects.validarSiguiente() && 
								  ofertasTrabajoDisponiblesPageObjects.validarRegistros());
		
		Serenity.takeScreenshot();
	}
}
