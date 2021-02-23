package com.epam.ta.test;

import com.epam.ta.page.AccountPage;
import com.epam.ta.page.LoginPage;
import com.epam.ta.model.User;
import com.epam.ta.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends CommonConditions{
    @Test
    public void loginTest(){
        User testUser=UserCreator.withEmptyPhoneNumber();
        LoginPage loginPage=new LoginPage(driver)
                .openPage()
                .inputUserEmail(testUser.getEmail())
                .inputUserPassword(testUser.getPassword());

        AccountPage accountPage=loginPage.clickSubmitButton();

        String currentUrl=accountPage.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://www.walmart.com/account/?action=SignIn&rm=true");
    }

    @Test
    public void logoutTest(){
        User testUser=UserCreator.withEmptyPhoneNumber();
        LoginPage loginPage=new LoginPage(driver)
                .openPage()
                .inputUserEmail(testUser.getEmail())
                .inputUserPassword(testUser.getPassword());

        boolean isLoggined=loginPage.clickSubmitButton()
                .signOut()
                .isLoggined();

        Assert.assertTrue(isLoggined);
    }
}
