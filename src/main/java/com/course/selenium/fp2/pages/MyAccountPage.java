package com.course.selenium.fp2.pages;

import com.course.selenium.fp2.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    final WebDriver driver;

    @FindBy(id = "addresses-link")
    WebElement addressesLink;

    @FindBy(id = "_desktop_logo")
    WebElement desktopLogo;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAddresses(){
        addressesLink.click();
    }

    public void goToHomePage(){
        desktopLogo.click();
    }

}
