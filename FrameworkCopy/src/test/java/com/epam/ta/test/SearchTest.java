package com.epam.ta.test;

import com.epam.ta.page.SearchPage;
import com.epam.ta.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class SearchTest extends CommonConditions{

    @Test
    public void searchByTitleTest(){
        String searchTitle=TestDataReader.getTestData("test.data.search.title");

        String searchResult=new SearchPage(driver)
                .openPage()
                .searchByTitle(searchTitle)
                .goToItemPage()
                .getItemTitle();

        assertThat(searchResult,containsString(searchTitle));
    }

    @Test
    public void filterByBrandTest(){

        String brandName=TestDataReader.getTestData("test.data.search.brandtitle");

        boolean isBrandFilterApplied=new SearchPage(driver)
                .openPage()
                .filterByBrand(brandName)
                .checkBrandFilter(brandName);

        Assert.assertTrue(isBrandFilterApplied);
    }
}
