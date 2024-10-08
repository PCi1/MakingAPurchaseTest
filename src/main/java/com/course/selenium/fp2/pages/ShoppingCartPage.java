package com.course.selenium.fp2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    final WebDriver driver;

    @FindBy(xpath = "//a[@class='btn btn-primary' and text()='Proceed to checkout']")
    WebElement proceedToCheckoutButton;


    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}
