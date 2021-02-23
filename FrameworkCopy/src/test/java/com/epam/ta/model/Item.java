package com.epam.ta.model;

import com.epam.ta.page.OrderPage;

public class Item {
    private String itemUrl;
    private int count;

    public Item(String itemUrl,int count){
        this.itemUrl=itemUrl;
        this.count=count;
    }

    public Item(String itemUrl){
        this.itemUrl=itemUrl;
    }

    public String getItemUrl(){
        return itemUrl;
    }

    public void setItemUrl(String itemUrl){
        this.itemUrl=itemUrl;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count=count;
    }
}
