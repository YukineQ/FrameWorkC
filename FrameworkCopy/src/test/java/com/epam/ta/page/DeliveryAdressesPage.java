package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DeliveryAdressesPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='addressLineOne']")
    private WebElement streetAdressField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@id='state']")
    private WebElement stateSelect;

    @FindBy(xpath = "//input[@id='postalCode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//button[@class='button spin-button button--primary']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@class='button spin-button button--primary']")
    private WebElement saveAccept;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordVerificationField;

    @FindBy(xpath = "//form[@id='sign-in-form']/button")
    private WebElement passwordVerificationButton;

    public DeliveryAdressesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public DeliveryAdressesPage openPage(){
        driver.get("https://www.walmart.com/account/deliveryaddresses");
        return this;
    }

    public DeliveryAdressesPage inputFirstName(String firstName){
        waitWebElementLocatedBy(By.xpath("//div[@class='Grid Grid--gutters edit-form-fields-v2 text-left']"));
        firstNameField.sendKeys(firstName);
        return this;
    }

    public DeliveryAdressesPage inputLastName(String lastName){
        lastNameField.sendKeys(lastName);
        return this;
    }

    public DeliveryAdressesPage inputPhoneNumber(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    public DeliveryAdressesPage inputStreetAdress(String streetAdress){
        streetAdressField.sendKeys(streetAdress);
        return this;
    }

    public DeliveryAdressesPage inputCity(String city){
        cityField.sendKeys(city);
        return this;
    }

    public DeliveryAdressesPage selectState(String stateAbb){
        Select select=new Select(stateSelect);
        select.selectByValue(stateAbb);
        return this;
    }

    public DeliveryAdressesPage inputZipCode(String zipCode){
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    public DeliveryAdressesPage saveAdress(){
        saveButton.click();
        return this;
    }

    public DeliveryAdressesPage saveAdressAccept(){
        waitWebElementLocatedBy(By.xpath("//div[@class='unmatched-address']"));
        saveAccept.click();
        return this;
    }

    public DeliveryAdressesPage passwordVerification(String password){
        waitWebElementLocatedBy(By.xpath("//div[@id='sign-in-widget']"));
        passwordVerificationField.sendKeys(password);
        passwordVerificationButton.click();
        return this;
    }

    public DeliveryAdressesPage deleteAddresses(){
        List<WebElement> deleteButtons= driver.findElements( By.xpath("//button[@class='button delete-button button--link']"));
        for (WebElement deleteButton:deleteButtons) {
            deleteButton.click();
            WebElement confirmDelete=driver.findElement(By.xpath("//button[@class='button confirm-remove-button s-margin-top button--small button--primary']"));
            confirmDelete.click();
        }
        return this;
    }
}
