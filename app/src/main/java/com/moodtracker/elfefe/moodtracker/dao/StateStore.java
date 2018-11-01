package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmQuery;

public class StateStore {

    private Context context;
    private RealmQuery<CommentRealm> query;
    private Realm realm;
    private CommentRealm commentRealm;
    private Integer date;

    private String comment;

    public StateStore(Context context) {
        this.context = context;

        setDate();
        setRealm();
        setQuery();
    }

    public void realmTransationCopyOrUpdate(){
        if (!comment.equals(""))
            realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(commentRealm));
    }

    public RealmQuery<CommentRealm> getQuery() {
        return query;
    }

    public Integer getDate(){
        return date;
    }

    public void setCommentRealm(String comment,int feeling) {
        this.comment = comment;
        commentRealm = new CommentRealm();
        commentRealm.setId(date);
        commentRealm.setComment(comment);
        commentRealm.setFeeling(feeling);
    }

    private void setQuery() {
        query = realm.where(CommentRealm.class);
    }

    private void setRealm() {
        Realm.init(context.getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    private void setDate(){
        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.YEAR)+calendar.get(Calendar.DAY_OF_YEAR);
    }
}
