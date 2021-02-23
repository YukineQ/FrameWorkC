package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class OrderPage extends AbstractPageWithStaticUrl{

    @FindBy(xpath = "//button[@class='button ios-primary-btn-touch-fix hide-content-m button--primary']")
    private WebElement checkOutPageButton;

    @FindBy(xpath = "//h1[@id='cart-active-cart-heading']/span/span[2]/b")
    private WebElement itemCount;

    @FindBy(xpath = "//div[@class='order-summary-grand-total order-summary-line']/span[2]")
    private WebElement orderPrice;

    @FindBy(xpath = "//button[@analyticsid='cart-item-remove']")
    private WebElement deleteItemButton;

    @FindBy(xpath = "//div[@class='pos-relative cart-quantity-s text-center']/div/div/span/div/div/div/select")
    private WebElement quantitySelect;

    public OrderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public OrderPage openPage(){
        driver.get("https://www.walmart.com/cart");
        return this;
    }

    public CheckOutPage checkOut(){
        checkOutPageButton.click();
        return new CheckOutPage(driver);
    }

    public String getOrderPrice(){
        return orderPrice.getText();
    }

    public int getItemCount(){
        return Integer.parseInt(itemCount.getText());
    }

    public OrderPage removeItem(){
        String startValue=orderPrice.getText();
        deleteItemButton.click();
        waitUntilFieldIsChanged(orderPrice,startValue);
        return this;
    }

    public OrderPage setQuantity(String value){
        waitWebElementLocatedBy(By.xpath("//div[@class='pos-relative cart-quantity-s text-center']/div"));

        Select quantity=new Select(quantitySelect);
        String startValue=itemCount.getText();
        quantity.selectByValue(value);

        waitUntilFieldIsChanged(itemCount,startValue);
        return this;
    }
}
