package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPageWithStaticUrl{
    private static final String PAGE_URL = "https://www.walmart.com/account/login";

    @FindBy(xpath = "//input[@id='email']")
    private  WebElement inputEmail;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public  LoginPage openPage(){
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public LoginPage inputUserEmail(String email){
        inputEmail.sendKeys(email);
        return this;
    }

    public LoginPage inputUserPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public AccountPage clickSubmitButton(){
        buttonSubmit.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.urlToBe("https://www.walmart.com/account/?action=SignIn&rm=true"));
        return new AccountPage(driver);
    }
}
