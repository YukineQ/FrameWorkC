package com.epam.ta.page;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends AbstractPageWithParameterizedUrl{

    @FindBy(xpath = "//button[@class='button spin-button prod-ProductCTA--primary button--primary']")
    private WebElement addItemToCartButton;

    @FindBy(xpath = "//div[@class='tile-heart']")
    private WebElement addToWishListButton;

    @FindBy(xpath = "//span[@class='price-group']")
    private WebElement itemPrice;

    @FindBy(id = "hf-cart")
    private WebElement orderPageButton;

    @FindBy(xpath = "//div[@class='hf-Bot']/h1")
    private WebElement itemTitle;

    @FindBy(xpath = "//div[@class='hf-Bot']/a/span")
    private WebElement brandTitle;

    public ItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public ItemPage openPage(String urlPart){
        driver.get("https://www.walmart.com/"+urlPart);
        return this;
    }

    public ItemPage addItemToCart()
    {
        waitWebElementLocatedBy(By.className("button-wrapper"));
        addItemToCartButton.click();
        waitWebElementLocatedBy(By.xpath("//button[@class='button button--ghost']"));
        return this;
    }

    public ItemPage addToWishList(){
        addToWishListButton.click();
        return this;
    }

    public String getItemPrice(){
        return itemPrice.getText();
    }

    public OrderPage goToOrderPage(){
        orderPageButton.click();
        return new OrderPage(driver);
    }

    public String getItemTitle(){
        return itemTitle.getText();
    }

    public String getBrandTitle(){
        return brandTitle.getText();
    }
}
