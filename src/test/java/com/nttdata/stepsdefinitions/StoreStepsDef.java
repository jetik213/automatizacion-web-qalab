package com.nttdata.stepsdefinitions;

import com.nttdata.core.DriverManager;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepsDef {

    private WebDriver driver;
    private StoreSteps storeSteps;

    @Given("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        driver = DriverManager.getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.navegarALaTienda("https://qalab.bensg.com/store/es/");
    }

    @When("doy click en la opción iniciar sesión")
    public void doy_click_en_la_opcion_iniciar_sesion() {
        storeSteps.clickIniciarSesion();
    }

    @When("doy click en el link text cree una cuenta aquí")
    public void doy_click_en_el_link_text_cree_una_cuenta_aqui() {
        storeSteps.clickCrearCuenta();
    }

    @When("lleno los campos del formulario para el registro con {string} {string} {string} {string}")
    public void lleno_los_campos_del_formulario_para_el_registro_con(String nombre, String apellido, String correo, String password) {
        storeSteps.llenarFormularioRegistro(nombre, apellido, correo, password);
    }

    @When("doy click en el botón guardar")
    public void doy_click_en_el_boton_guardar() {
        storeSteps.clickGuardar();
    }

    @Then("debería visualizar al usuario {string} {string} logeado en la pantalla")
    public void deberia_visualizar_al_usuario_logeado_en_la_pantalla(String nombre, String apellido) {
        storeSteps.validarUsuarioLogeado(nombre, apellido);
    }

}
