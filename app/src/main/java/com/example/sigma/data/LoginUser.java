package com.example.sigma.data;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.Date;

@IgnoreExtraProperties
public class LoginUser implements Serializable {
    public CharSequence username;
    public String password;
    public String userid;
    public Date time;

    public LoginUser(){}

    public LoginUser(CharSequence username,String password,String userid){
        this.username=username;
        this.password=password;
        this.userid=userid;
    }

    @Exclude
    public void set(CharSequence username,String password,String userid){
        this.username=username;
        this.password=password;
        this.userid=userid;
    }
}
