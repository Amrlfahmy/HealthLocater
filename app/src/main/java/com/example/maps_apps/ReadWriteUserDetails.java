package com.example.maps_apps;

public class ReadWriteUserDetails {
    public String dob, gender, mobile;

    //construction
    public ReadWriteUserDetails(){};
    public ReadWriteUserDetails( String textDoB, String textGender, String textMobile){
        this.dob=textDoB;
        this.gender=textGender;
        this.mobile=textMobile;
    }
}
