package com.epam.ta.service;

import com.epam.ta.model.Item;

public class ItemCreator {
    public static final String ITEM_URL="test.data.item.%s.url";
    public static final String ITEM_COUNT="test.data.item.%s.count";

    public static Item withAllProperty(String itemNumber){
        String itemUrl=String.format(ITEM_URL,itemNumber);
        String itemCount=String.format(ITEM_COUNT,itemNumber);
        return new Item(TestDataReader.getTestData(itemUrl),
                Integer.parseInt(TestDataReader.getTestData(itemCount)));
    }

    public static Item withEmptyProductCount(String itemNumber){
        String itemUrl=String.format(ITEM_URL,itemNumber);
        return new Item(TestDataReader.getTestData(itemUrl));
    }
}
