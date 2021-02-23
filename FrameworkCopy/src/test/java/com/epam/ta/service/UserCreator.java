package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {

    public static final String USER_FIRST_NAME="test.data.user.firstname";
    public static final String USER_SECOND_NAME="test.data.user.secondname";
    public static final String USER_EMAIL="test.data.user.email";
    public static final String USER_PASSWORD="test.data.user.password";
    public static final String USER_PHONE_NUMBER="test.data.user.phonenumber";

    public static User withAllProperty(){
        return new User(TestDataReader.getTestData(USER_FIRST_NAME),
                TestDataReader.getTestData(USER_SECOND_NAME),
                TestDataReader.getTestData(USER_EMAIL),
                TestDataReader.getTestData(USER_PASSWORD),
                TestDataReader.getTestData(USER_PHONE_NUMBER)
        );
    }

    public static User withEmptyPhoneNumber(){
        return new User(TestDataReader.getTestData(USER_FIRST_NAME),
                TestDataReader.getTestData(USER_SECOND_NAME),
                TestDataReader.getTestData(USER_PASSWORD),
                TestDataReader.getTestData(USER_EMAIL)
        );
    }
}
