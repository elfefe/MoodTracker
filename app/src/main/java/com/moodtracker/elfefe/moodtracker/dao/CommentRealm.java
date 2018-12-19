package com.moodtracker.elfefe.moodtracker.dao;

import com.moodtracker.elfefe.moodtracker.model.Mood;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CommentRealm extends RealmObject {

    static final String KEY_ID = "id";

    @PrimaryKey
    private int id;

    private String comment, feeling;


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

    public Mood getFeeling() {
        return Mood.valueOf(feeling);
    }

    void setFeeling(Mood feeling) {
        this.feeling = feeling.name();
    }
}
