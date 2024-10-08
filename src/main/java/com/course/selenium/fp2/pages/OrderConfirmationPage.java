package com.course.selenium.fp2.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;

public class OrderConfirmationPage {

    public WebDriver driver;

    @FindBy(xpath="//h3[@class = 'h1 card-title']")
    WebElement orderConfirmedBanner;

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBannerText(){
        return orderConfirmedBanner.getText();
    }

    public void screenshotConfirmation(){
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:/Users/PCi/Desktop/Java Tester/test.png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void screenshotOrder() throws IOException {
            File File = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(File, new File("C:/Users/PCi/Desktop/Java Tester" + "test" + ".png"));
        }
}
