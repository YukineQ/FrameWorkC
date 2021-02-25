package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {

    private static WebDriver driver;


    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "google": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "opera": {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                }
                default: {
                    ProfilesIni profile = new ProfilesIni();
                    FirefoxProfile myprofile = profile.getProfile("testXYZ");
                    FirefoxOptions options=new FirefoxOptions();
                    options.setProfile(myprofile);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(options);
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
