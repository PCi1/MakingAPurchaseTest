package com.course.selenium.fp2.pages;

import com.course.selenium.fp2.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {

    final WebDriver driver;

    @FindBy(id = "field-email")
    WebElement emailField;

    @FindBy(id = "field-password")
    WebElement passwordField;

    @FindBy(id = "submit-login")
    WebElement signInSubmitButton;

    public AuthPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeEmailIntoLogIn(String email){
        Helpers.fieldFiller(driver, emailField, email);
    }

    public void typePasswordIntoLogIn(String password){
        Helpers.fieldFiller(driver, passwordField, password);
    }

    public void clickSignInButton(){
        signInSubmitButton.click();
    }

}
