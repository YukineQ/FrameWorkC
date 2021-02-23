package com.epam.ta.model;

public class Address {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String stateAbb;
    private String phoneNumber;
    private String zipCode;

    public Address(String firstName,String lastName,String streetAddress,String city,String stateAbb,String phoneNumber,String zipCode){
        this.firstName=firstName;
        this.lastName=lastName;
        this.streetAddress=streetAddress;
        this.city=city;
        this.stateAbb=stateAbb;
        this.phoneNumber=phoneNumber;
        this.zipCode=zipCode;
    }

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getStreetAddress(){return streetAddress;}
    public String getCity(){return city;}
    public String getStateAbb(){return stateAbb;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getZipCode(){return zipCode;}

    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setLastName(String lastName){this.lastName=lastName;}
    public void setStreetAddress(String streetAddress){this.streetAddress=streetAddress;}
    public void setCity(String city){this.city=city;}
    public void setStateAbb(String stateAbb){this.stateAbb=stateAbb;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}
    public void setZipCode(String zipCode){this.zipCode=zipCode;}
}
