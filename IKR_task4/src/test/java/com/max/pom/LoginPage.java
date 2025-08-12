package com.max.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;


    private final By emailField = By.cssSelector("form input[name='email']");
    private final By passwordField = By.cssSelector("form input[name='password']");
    private final By submitButton = By.cssSelector("form input[type='submit']");
    private final By emailError = By.cssSelector("form div:nth-of-type(1) ul");
    private final By passwordError = By.cssSelector("form div:nth-of-type(2) ul");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage submit() {
        driver.findElement(submitButton).click();
        return this;
    }

    public boolean isEmailErrorVisible() {
        return !driver.findElements(emailError).isEmpty();
    }

    public boolean isPasswordErrorVisible() {
        return !driver.findElements(passwordError).isEmpty();
    }
}