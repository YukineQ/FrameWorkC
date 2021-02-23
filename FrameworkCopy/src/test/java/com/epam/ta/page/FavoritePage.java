package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritePage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//button[@class='ListTile-button width-full height-full']")
    private WebElement currentListButton;

    @FindBy(xpath = "//article[@class='CountSorting separator width-full']/p")
    private WebElement countOfFavoriteItems;

    public FavoritePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public FavoritePage openPage(){
        driver.get("https://www.walmart.com/lists");
        return this;
    }

    public FavoritePage getCurrentList(){
        currentListButton.click();
        return this;
    }

    public String getCountOfFavoriteItems(){
        waitUntilFieldIsChanged(countOfFavoriteItems,"0 items");
        return countOfFavoriteItems.getText();
    }
}
