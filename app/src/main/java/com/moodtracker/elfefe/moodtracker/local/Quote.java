package com.moodtracker.elfefe.moodtracker.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "state")
public class Quote {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "quote")
    private String quote;

    @ColumnInfo(name = "feeling")
    private int feeling;

    public Quote(int uid, String quote, int feeling) {
        this.uid = uid;
        this.quote = quote;
        this.feeling = feeling;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getFeeling() {
        return feeling;
    }

    public void setFeeling(int feeling) {
        this.feeling = feeling;
    }
}