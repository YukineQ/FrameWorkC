package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.model.Item;
import com.epam.ta.page.ItemPage;
import com.epam.ta.page.OrderPage;
import com.epam.ta.service.ItemCreator;
import com.epam.ta.util.StringConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ItemTest extends CommonConditions{

    @BeforeMethod(alwaysRun = true)
    public void close(){
        DriverSingleton.deleteAllCookies();
    }

    @Test
    public void addToOrder(){
        Item item = ItemCreator.withEmptyProductCount("second");
        ItemPage itemPage = new ItemPage(driver)
                .openPage(item.getItemUrl());

        String expectedPrice = itemPage.getItemPrice();

        itemPage.addItemToCart();

        OrderPage orderPage = new OrderPage(driver)
                .openPage();

        Assert.assertEquals(expectedPrice,orderPage.getOrderPrice());
    }

    @Test
    public void addTwoDifferentItems(){
        Item firstItem=ItemCreator.withEmptyProductCount("first");
        Item secondItem=ItemCreator.withEmptyProductCount("second");

        ItemPage firstItemPage=new ItemPage(driver)
                .openPage(firstItem.getItemUrl())
                .addItemToCart();
        float firstItemPrice=StringConverter.stringPriceToFloat(firstItemPage.getItemPrice());

        ItemPage secondItemPage=new ItemPage(driver)
                .openPage(secondItem.getItemUrl())
                .addItemToCart();
        float secondItemPrice=StringConverter.stringPriceToFloat(secondItemPage.getItemPrice());

        OrderPage orderPage=new OrderPage(driver)
                .openPage();
        float orderPrice=StringConverter.stringPriceToFloat(orderPage.getOrderPrice());

        float expectedOrderPrice=firstItemPrice+secondItemPrice;

        Assert.assertEquals(orderPrice,expectedOrderPrice);
    }

   @Test
    public void addTwoSimilarItems(){
        Item item=ItemCreator.withEmptyProductCount("first");

        int expectedItemCount=2;

        int itemCount=new ItemPage(driver)
                .openPage(item.getItemUrl())
                .addItemToCart()
                .openPage(item.getItemUrl())
                .addItemToCart()
                .goToOrderPage()
                .getItemCount();

        Assert.assertEquals(expectedItemCount,itemCount);
    }

    @Test
    public void deleteAddedProduct(){
        Item item=ItemCreator.withEmptyProductCount("first");

        String  expectedPrice="$0.00";

        String orderPrice=new ItemPage(driver)
                .openPage(item.getItemUrl())
                .addItemToCart()
                .goToOrderPage()
                .removeItem()
                .getOrderPrice();

        Assert.assertEquals(orderPrice,expectedPrice);
    }

   @Test
    public void changeItemQuantity(){
        Item item=ItemCreator.withEmptyProductCount("first");

        int expectedCount=3;

        int itemCount=new ItemPage(driver)
                .openPage(item.getItemUrl())
                .addItemToCart()
                .goToOrderPage()
                .setQuantity(Integer.toString(expectedCount))
                .getItemCount();

        Assert.assertEquals(itemCount,expectedCount);
    }
}
