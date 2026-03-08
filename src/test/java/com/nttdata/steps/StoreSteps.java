package com.nttdata.steps;

import com.nttdata.page.StoreHomePage;
import com.nttdata.page.StoreLoginPage;
import com.nttdata.page.StoreRegisterPage;
import com.nttdata.page.StoreUserInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class StoreSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private String generatedEmail;

    public StoreSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navegarALaTienda(String url) {
        driver.get(url);
    }

    public void clickIniciarSesion() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(StoreHomePage.iniciarSesionLink));
        btn.click();
    }

    public void clickCrearCuenta() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(StoreLoginPage.crearCuentaLink));
        btn.click();
    }

    public void llenarFormularioRegistro(String nombre, String apellido, String correo, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(StoreRegisterPage.firstNameInput)).sendKeys(nombre);
        driver.findElement(StoreRegisterPage.lastNameInput).sendKeys(apellido);
        
        long timestamp = java.time.Instant.now().toEpochMilli();
        generatedEmail = correo.replace("@", timestamp + "@");
        driver.findElement(StoreRegisterPage.emailInput).sendKeys(generatedEmail);
        
        driver.findElement(StoreRegisterPage.passwordInput).sendKeys(password);
        
        driver.findElement(StoreRegisterPage.privacyCheckbox).click();
        driver.findElement(StoreRegisterPage.termsCheckbox).click();
    }

    public void clickGuardar() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(StoreRegisterPage.saveButton));
        saveBtn.click();
    }

    public void validarUsuarioLogeado(String nombre, String apellido) {
        WebElement userName = null;
        try {
            userName = wait.until(ExpectedConditions.visibilityOfElementLocated(StoreUserInfoPage.userNameSpan));
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("La página fallo en:\n" + driver.getPageSource());
            throw e;
        }
        Assertions.assertEquals(nombre + " " + apellido, userName.getText());
    }
}
