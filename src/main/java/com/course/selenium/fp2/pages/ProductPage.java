package com.course.selenium.fp2.pages;

import com.course.selenium.fp2.helpers.Helpers;
import io.cucumber.datatable.internal.difflib.StringUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ProductPage {

    final WebDriver driver;

    @FindBy(xpath ="//div[@class='row product-container js-product-container']//span[@class='regular-price']")
    WebElement regularPrice;

    @FindBy(xpath = "//span[@class = 'current-price-value']")
    WebElement discountedPrice;

    @FindBy(id = "group_1")
    WebElement sizeDropDown;

    @FindBy(id = "quantity_wanted")
    WebElement quantityWanted;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    WebElement addToCartButton;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public long getDiscountedPrice(){
        String discountedPriceStr = discountedPrice.getText().substring(1);
        long discountedPriceValue = Long.parseLong(discountedPriceStr);
        return discountedPriceValue;
    }

    public long getRegularPrice(){
        String regularPriceStr = regularPrice.getText().substring(1);
        long regularPriceValue = Long.parseLong(regularPriceStr);
        return regularPriceValue;
    }

    public void selectSize(String size){
        WebElement element = driver.findElement(By.xpath("//select/option[@title='"+size.toUpperCase()+"']"));
        element.click();
    }

    public void selectQuantity(String quantity){
//        Helpers.fieldFiller(driver, quantityWanted, quantity);

        quantityWanted.click();
        quantityWanted.sendKeys(Keys.BACK_SPACE);
        quantityWanted.sendKeys(quantity);
    }

    public void addProductToCart(){
        addToCartButton.click();
    }
}
