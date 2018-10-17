package com.moodtracker.elfefe.moodtracker.controller;

public class Contacts {
    private String mName;
    private String mNumber;


    Contacts(String mName, String mNumber) {
        this.mName = mName;
        this.mNumber = mNumber;
    }


    String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }
}
