package com.sophos.pruebatecnica;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
		features = "src/test/resources/features/", 
		tags     = "@ConsultarTrabajos", 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE)
public class RunnerFeatures {

}
