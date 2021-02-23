package com.epam.ta.service;

import com.epam.ta.model.Address;

public class AddressCreator {
    public static final String ADDRESS_FIRST_NAME="test.data.address.firstname";
    public static final String ADDRESS_LAST_NAME="test.data.address.lastname";
    public static final String ADDRESS_STREET_ADDRESS="test.data.address.streetaddress";
    public static final String ADDRESS_CITY="test.data.address.city";
    public static final String ADDRESS_STATE_ABB="test.data.address.stateabb";
    public static final String ADDRESS_PHONE_NUMBER="test.data.address.phonenumber";
    public static final String ADDRESS_ZIP_CODE="test.data.address.zipcode";

    public  static Address withAllProperty(){
        return new Address(TestDataReader.getTestData(ADDRESS_FIRST_NAME),
                TestDataReader.getTestData(ADDRESS_LAST_NAME),
                TestDataReader.getTestData(ADDRESS_STREET_ADDRESS),
                TestDataReader.getTestData(ADDRESS_CITY),
                TestDataReader.getTestData(ADDRESS_STATE_ABB),
                TestDataReader.getTestData(ADDRESS_PHONE_NUMBER),
                TestDataReader.getTestData(ADDRESS_ZIP_CODE)
                );
    }
}
