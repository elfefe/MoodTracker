package com.moodtracker.elfefe.moodtracker.dao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CommentRealm extends RealmObject {
    @PrimaryKey
    private int id;

    private String comment;
    private int feeling;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    void setFeeling(int feeling) {
        this.feeling = feeling;
    }
}
