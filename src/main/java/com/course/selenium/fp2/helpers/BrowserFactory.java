package com.course.selenium.fp2.helpers;

import io.cucumber.java.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final String URL = "https://mystore-testlab.coderslab.pl";

    private static final String userLogin = "random@random.com";

    private static final String userPassword ="RandomPass,.";


    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public static String getUserLogin(){
        return userLogin;
    }
    public static String getUserPassword(){
        return userPassword;
    }


    @Before
    public void setUp(){
        driverThreadLocal.set(new FirefoxDriver());
//        driverThreadLocal.set(new ChromeDriver());
        WebDriver driver = driverThreadLocal.get();
        driver.get(URL);
    }

//    @After
//    public void tearDown(){
//        if(driverThreadLocal.get() != null){
//            driverThreadLocal.get().quit();
//        }
//    }
}