package com.course.selenium.fp2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutAddressesPage {
    final WebDriver driver;

    @FindBy(name = "confirm-addresses")
    WebElement continueButton;

    public CheckoutAddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectShippingAddress(String addressAlias){
        WebElement addressRadioButton = driver.findElement(By.xpath("//span[@class ='address-alias h4' and text() = '"+addressAlias+"']/../span[@class='custom-radio']"));
        addressRadioButton.click();
    }

    public String getShippingAddress(String addressAlias){
        WebElement addressElement = driver.findElement(By.xpath("//span[@class ='address-alias h4' and text() = '"+addressAlias+"']/../div[@class='address']"));
        return addressElement.getText();
    }

    public void confirmShippingAddress(){
        continueButton.click();
    }
}
