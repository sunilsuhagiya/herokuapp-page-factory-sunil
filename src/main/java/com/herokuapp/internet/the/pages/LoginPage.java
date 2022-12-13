package com.herokuapp.internet.the.pages;
import com.aventstack.extentreports.Status;
import com.herokuapp.internet.the.customlisteners.CustomListeners;
import com.herokuapp.internet.the.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
   @CacheLookup
    @FindBy(id ="username")
    WebElement userNameField;
    @CacheLookup
    @FindBy(name ="password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath ="//i[@class='fa fa-2x fa-sign-in']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath ="//h2[text()=' Secure Area']")
    WebElement textMessage;
    @CacheLookup
    @FindBy(xpath ="//div[@id='flash']")
    WebElement userNameErrorMessage;
    @CacheLookup
    @FindBy(xpath ="//div[@id='flash']")
    WebElement passwordErrorMessage;



    public void enterUserName(String userName) {
        Reporter.log("Enter user name" + userNameField.toString());
        sendTextToElement(userNameField, userName);
        CustomListeners.test.log(Status.PASS,"Enter user name " + userName);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password" + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on login ");
    }

    public String getTextMessage() {
        Reporter.log("Get Text Message" + textMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get Tex tMessage ");
        return getTextFromElement(textMessage);
    }

    public String getUserNameErrorMessage() {
        Reporter.log("Get User Name Error Message" + userNameErrorMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get User Name Error Message");
        return getTextFromElement(userNameErrorMessage);
    }

    public String getPasswordErrorMessage() {
        Reporter.log("Get Password Error Message" + passwordErrorMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get Password Error Message");
        return getTextFromElement(passwordErrorMessage);
    }


}
