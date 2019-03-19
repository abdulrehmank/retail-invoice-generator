package com.retail.simulator.models;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private String email;
    private String phone;

    public enum UserType{
        EMPLOYEE,
        AFFILIATE,
        CUSTOMER
    };

    private UserType userType;
    private long registrationDate;

    public User(int id, String name, String email, String phone, UserType userType, long registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.userType = userType;
        this.registrationDate = registrationDate;
    }

    public long getRegistrationDate() {
        return registrationDate;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
