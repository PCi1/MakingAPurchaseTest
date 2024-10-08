package com.course.selenium.fp2.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingMethodCard {

    final WebDriver driver;

    @FindBy(id = "delivery_option_8")
    WebElement deliverySelfPickUp;


    @FindBy(xpath = "//span[@class = 'carrier-delay' and text()='Pick up in-store']")
    WebElement deliverySelfPickUp2;

    @FindBy(name= "confirmDeliveryOption")
    WebElement continueButton;

    public ShippingMethodCard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSelfPickUp(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delivery_option_8")));
        deliverySelfPickUp2.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }
}
