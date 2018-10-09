package com.moodtracker.elfefe.moodtracker.local;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CommentRealm extends RealmObject {
    @PrimaryKey
    private int date;

    private String comment;
    private int feeling;


    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getFeeling() {
        return feeling;
    }

    public void setFeeling(int feeling) {
        this.feeling = feeling;
    }
}
