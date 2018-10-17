package com.moodtracker.elfefe.moodtracker.controller;

public class Contacts {
    private String mName;
    private String mNumber;
    private String mImage;


    public Contacts(String mName, String mNumber, String mImage) {
        this.mName = mName;
        this.mNumber = mNumber;
        this.mImage = mImage;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
