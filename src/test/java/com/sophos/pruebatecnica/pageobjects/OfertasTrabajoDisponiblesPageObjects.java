package com.sophos.pruebatecnica.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

@DefaultUrl ("https://www.sophossolutions.com/")

public class OfertasTrabajoDisponiblesPageObjects extends PageObject {

	String popup              = "//*[@class='sg-popup-builder-content']";
	String btnTrabajaNosotros = "(//a[contains(@class, 'mega-menu-link') and contains(text(), 'Trabaja Con Nosotros')])[1]";
	String strSinRegistros    = "//*[@class='premium-error-notice']";
	String txtBuscar          = "//input[@type='text' and @id='s']";
	String btnSiguiente       = "//a[@class='next page-numbers']";
	String btnAnterior        = "//a[@class='prev page-numbers']";
	String lstEmpleos         = "//div[contains(@class, 'premium-blog-wrap')]";
	String txtPaginaActual    = "//span[contains(@class, 'page-numbers current')]";
	String lstTrabajos        = "//div[contains(@class, 'premium-blog-wrap')]/div";
	
	//Para dar click por fuera del popup para cerrarlo
	public void saltarPopUp() {
		if (find(By.xpath(popup)).isVisible())
		{
			find(By.xpath(popup)).waitUntilClickable();
			WebDriver driver = getDriver();
		    Actions actions = new Actions(driver);
			actions.moveByOffset(1, 1).click().perform();
		}
	}

	//Dar click en "Trabaja con nosotros"
	public void ingresarTrabajaConNosotros() {
		find(By.xpath(btnTrabajaNosotros)).waitUntilClickable().click();
	}
	
	//Devuelve verdadero cuando no se visualizan trabajos en la página, es decir, cuando sale el mensaje 
	//"The current query has no posts. Please make sure you have published items matching your query."
	public boolean validarRegistros() {
		if(find(By.xpath(strSinRegistros)).isVisible()){
			return true;
		}
		else {
			return false;
		}
	}
	
	//Devuelve verdadero si se visualiza el botón siguiente de la paginación
	public boolean validarSiguiente() {
		if(find(By.xpath(btnSiguiente)).isVisible()){
			return true;
		}
		else {
			return false;
		}
	}
	
	//Devuelve verdadero si se visualiza el botón siguiente de la paginación
	public void avanzarSiguiente() {
		find(By.xpath(btnSiguiente)).waitUntilClickable().click();
	}
	
	//Ingresa el texto "java" y se oprime Enter para buscar trabajos por dicho filtro
	public void buscarTrabajo() {
		find(By.xpath(txtBuscar)).sendKeys("java", Keys.ENTER);
	}
	
	//Baja la pantalla hasta el lugar donde se encuentra la paginación
	public void bajarPantalla() {
		WebDriver driver = getDriver();
	    Actions actions = new Actions(driver);
		actions.moveToElement(find(By.xpath(txtPaginaActual))).perform();
	}
	
	//Para imprimir los trabajos por consola
	public void imprimirTrabajos() {
		int cont = 1;
		int pagina = Integer.parseInt(find(By.xpath(txtPaginaActual)).getText()); 
		int contIni = (pagina-1) * 9;
		
		cont = contIni + cont;
		
		List<String> lista = findAll(lstTrabajos)
								.stream()
								.map(WebElementFacade::getText)
								.collect(Collectors.toList());
		
		for (String lis:lista) {						
			String[] divLista = lis.split("\\r?\\n");
			System.out.println("Oferta " + cont + ":");
			System.out.println("Nombre de la oferta: " + divLista[0]);
			System.out.println("Fecha de publicación: " + divLista[1]);
			System.out.println("Descripción: " + divLista[2]);
			System.out.println("--------------------------------------------------------------");
			cont += 1;
		}
	}
	
	
}
