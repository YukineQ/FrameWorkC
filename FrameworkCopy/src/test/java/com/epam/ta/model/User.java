package com.epam.ta.model;

import java.util.Objects;

public class User {
    private String firstName;
    private String secondName;
    private String password;
    private String email;
    private String phoneNumber;


    public User(String firstName,String secondName, String password, String email, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String firstName,String secondName,String password,String email){
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
    }

    public User(String email,String password){
        this.email=email;
        this.password=password;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getSecondName(){
        return secondName;
    }

    public  void setSecondName(String secondName){
        this.secondName=secondName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    @Override
    public String toString() {
        return "User(" +
                "email= '" + email + "'" +
                ", password= '" + password + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof User)) return false;
        User user=(User) o;
        return Objects.equals(getEmail(),user.getEmail()) &&
                Objects.equals(getPassword(),user.getPassword());
    }
}