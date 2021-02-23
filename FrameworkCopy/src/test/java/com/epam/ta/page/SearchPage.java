package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SearchPage extends AbstractPageWithStaticUrl{

    @FindBy(xpath = "//input[@id='global-search-input']")
    private WebElement searchInputField;

    @FindBy(xpath = "//button[@id='global-search-submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='searchProductResult']/ul")
    private WebElement searchItemList;

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public SearchPage openPage(){
        driver.get("https://www.walmart.com/search");
        return this;
    }

    public SearchPage searchByTitle(String searchText){
        searchInputField.sendKeys(searchText);
        searchButton.click();
        return this;
    }

    public ItemPage goToItemPage(){
        List<WebElement> list=driver.findElements(By.xpath("//div[@id='searchProductResult']/ul/li"));
        list.get(1).click();
        return new ItemPage(driver);
    }

    public SearchPage filterByBrand(String brand){
        WebElement brandCheckBox=driver.findElement(By.xpath("//label[starts-with(@for,'"+brand+"')]/input"));
        brandCheckBox.click();
        return this;
    }

    public boolean checkBrandFilter(String brand){
        boolean result=false;
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='applied-filters-container']/div[2]/button"));
        for (WebElement element:list) {
            if((element.getText()).contains(brand)){
                result = true;
                break;
            }
        }
        return result;
    }
}
