package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreRegisterPage {
    public static By firstNameInput = By.name("firstname");
    public static By lastNameInput = By.name("lastname");
    public static By emailInput = By.name("email");
    public static By passwordInput = By.name("password");
    public static By privacyCheckbox = By.name("customer_privacy");
    public static By termsCheckbox = By.name("psgdpr");
    public static By saveButton = By.xpath("//button[@data-link-action='save-customer'] | //button[contains(text(), 'Guardar')]");
}
