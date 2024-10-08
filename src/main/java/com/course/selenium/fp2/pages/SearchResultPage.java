package com.course.selenium.fp2.pages;

import com.course.selenium.fp2.helpers.BrowserFactory;
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

public class SearchResultPage {

    final WebDriver driver;

//    @FindBy(xpath = "//a[text()='"+ BrowserFactory.getProductToBuy() +"']")
//    WebElement product;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToProductPage(String productToBuy){
        WebElement element = Helpers.waitForElement(driver, By.xpath("//a[text()='"+ productToBuy+"']"));
        element.click();
    }


}
