package com.course.selenium.fp2.fragments;

import com.course.selenium.fp2.helpers.Helpers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {

    final WebDriver driver;

    @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
    WebElement searchBar;

    public SearchBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void useSearchBar(String text){
        Helpers.fieldFiller(driver, searchBar, text);
        searchBar.sendKeys(Keys.ENTER);
    }


}
