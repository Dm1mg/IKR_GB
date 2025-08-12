package com.max.tests;

import com.max.pom.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends AbstractTest{
    @Test
    void testGBNotEmailLogin() {
        LoginPage loginPage = new LoginPage(driver)
                .enterEmail("login")
                .enterPassword("password")
                .submit();

        Assertions.assertTrue(loginPage.isEmailErrorVisible(), "Ошибка email не отображается");
    }

    @Test
    void testGBWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver)
                .enterEmail("login@login.ru")
                .submit();

        Assertions.assertTrue(loginPage.isPasswordErrorVisible(), "Ошибка пароля не отображается");
    }
}
