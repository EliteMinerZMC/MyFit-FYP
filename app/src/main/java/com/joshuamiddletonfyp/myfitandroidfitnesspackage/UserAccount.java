package com.joshuamiddletonfyp.myfitandroidfitnesspackage;

import android.media.Image;

/**
 * Created by joshu on 01/04/2016.
 * UserAccount Definationn
 */
public class UserAccount {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String userName;
    private String password;
    private Image i;


    public UserAccount() {
    }

    public UserAccount(String firstName, String lastName, int age, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.password = password;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
