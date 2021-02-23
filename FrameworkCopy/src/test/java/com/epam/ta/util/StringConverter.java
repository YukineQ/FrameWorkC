package com.epam.ta.util;

public class StringConverter {

    static public float stringPriceToFloat(String price){
        String newString = price.replace("([a-z][A-Z])","");
        newString=newString.replace("$","");
        newString=newString.replace(" ","");
        return Float.parseFloat(newString);
    }
}
