package com.example.sigma;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class SigmaObject {
    public CharSequence message;
    public CharSequence username;
    public String password;
    public SigmaObject(){
    }
    @Exclude
    public void set(CharSequence message,CharSequence username,String password){
        this.username=username;
        this.password=password;
        this.message=message;
    }
}
