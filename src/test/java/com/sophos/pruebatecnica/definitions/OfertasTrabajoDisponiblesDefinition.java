package com.sophos.pruebatecnica.definitions;

import com.sophos.pruebatecnica.steps.OfertasTrabajoDisponiblesSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OfertasTrabajoDisponiblesDefinition {
	
	@Steps
	OfertasTrabajoDisponiblesSteps ofertasTrabajoDisponiblesSteps;
	
	@Given("Que ingreso a la web de Sophos")
	public void queIngresoALaWebDeSophos() {
		ofertasTrabajoDisponiblesSteps.abrirUrlSophos();
	    
	}

	@When("Ingreso a trabaja con nosotros")
	public void ingresoATrabajaConNosotros() {
		ofertasTrabajoDisponiblesSteps.ingresarTrabajaConNosotros();
	    
	}

	@Then("Genera lista con ofertas laborales disponibles")
	public void generaListaConOfertasLaboralesDisponibles() {
		ofertasTrabajoDisponiblesSteps.generarLista();
	    
	}
	
}
