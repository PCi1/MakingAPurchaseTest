package com.course.selenium.fp2.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PaymentMethodCard {

    private final WebDriver driver;

    @FindBy(id = "payment-option-1")
    WebElement payByCheckOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsConditionsCheckBox;

    @FindBy(xpath = "//div[@id = 'payment-confirmation']/div/button")
    WebElement placeOrderButton;

    public PaymentMethodCard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPayByCheck(){
        payByCheckOption.click();
    }

    public void acceptTermsConditions(){
        termsConditionsCheckBox.click();
    }

    public void placeOrder(){
        placeOrderButton.click();
    }

}
