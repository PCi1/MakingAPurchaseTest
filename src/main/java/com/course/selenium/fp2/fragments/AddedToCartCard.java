package com.course.selenium.fp2.fragments;

import com.course.selenium.fp2.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddedToCartCard {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='btn btn-primary' and text()='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public AddedToCartCard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickProceedToCheckout(){

        WebElement element = Helpers.waitForElement(driver,By.xpath("//a[@class='btn btn-primary' and text()='Proceed to checkout']" ));
        element.click();
    }

}

