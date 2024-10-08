package com.course.selenium.fp2.pages;

import com.course.selenium.fp2.helpers.Helpers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    final WebDriver driver;

    @FindBy(id = "_desktop_user_info")
    WebElement signInNavBarButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn(){
        signInNavBarButton.click();
    }

}
