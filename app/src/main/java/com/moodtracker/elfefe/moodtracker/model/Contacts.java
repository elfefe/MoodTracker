package com.moodtracker.elfefe.moodtracker.model;

public class Contacts {
    private String Name;
    private String Number;


    public Contacts(String Name, String Number) {
        this.Name = Name;
        this.Number = Number;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number = number;
    }
}
