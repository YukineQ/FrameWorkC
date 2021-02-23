package com.epam.ta.test;

import com.epam.ta.model.Address;
import com.epam.ta.model.Item;
import com.epam.ta.model.User;
import com.epam.ta.page.AccountPage;
import com.epam.ta.page.DeliveryAdressesPage;
import com.epam.ta.page.FavoritePage;
import com.epam.ta.page.ItemPage;
import com.epam.ta.service.AddressCreator;
import com.epam.ta.service.ItemCreator;
import com.epam.ta.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTest extends CommonConditions{

    @Test
    public void removeAddressTest(){
        DeliveryAdressesPage deliveryAdressesPage=new DeliveryAdressesPage(driver)
                .openPage()
                .deleteAddresses();
    }

    @Test
    public void addressAddTest(){
        Address newAddress= AddressCreator.withAllProperty();
        User testUser=UserCreator.withEmptyPhoneNumber();

        AccountPage accountPage=new AccountPage(driver)
                .openPage();

        DeliveryAdressesPage deliveryAdressesPage=accountPage.openDeliveryAdressesPage()
                .inputFirstName(newAddress.getFirstName())
                .inputLastName(newAddress.getLastName())
                .inputStreetAdress(newAddress.getStreetAddress())
                .inputCity(newAddress.getCity())
                .selectState(newAddress.getStateAbb())
                .inputPhoneNumber(newAddress.getPhoneNumber())
                .inputZipCode(newAddress.getZipCode())
                .saveAdress()
                .saveAdressAccept()
                .passwordVerification(testUser.getPassword());
    }



    @Test
    public void checkCorrectAddToFavorite(){
        Item item = ItemCreator.withEmptyProductCount("first");
        String expectedCount = "1 item";
        ItemPage itemPage = new ItemPage(driver)
                .openPage(item.getItemUrl())
                .addToWishList();

        FavoritePage favoritePage = new FavoritePage(driver)
                .openPage()
                .getCurrentList();

        Assert.assertEquals(favoritePage.getCountOfFavoriteItems(),expectedCount);
    }
}
