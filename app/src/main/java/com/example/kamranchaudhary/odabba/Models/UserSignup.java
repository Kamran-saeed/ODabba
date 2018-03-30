package com.example.kamranchaudhary.odabba.Models;

public class UserSignup {
    private int id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String phone;
    private String birthday;

    public UserSignup(String firstname, String lastname, String password, String email, String phone, String birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }
}
