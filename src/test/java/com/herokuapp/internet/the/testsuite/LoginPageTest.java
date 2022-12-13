package com.herokuapp.internet.the.testsuite;

import com.herokuapp.internet.the.customlisteners.CustomListeners;
import com.herokuapp.internet.the.pages.LoginPage;
import com.herokuapp.internet.the.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Secure Area";
        Assert.assertEquals(loginPage.getTextMessage(), expectedMessage, "No Secure Area text found");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Your username is invalid!\n" + "×";
        Assert.assertEquals(loginPage.getUserNameErrorMessage(), expectedMessage, "Your username is invalid!");
    }

    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Your password is invalid!\n" + "×";
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), expectedMessage, "Your password is invalid!");
    }
}
