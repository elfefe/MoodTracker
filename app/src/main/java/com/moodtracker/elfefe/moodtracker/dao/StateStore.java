package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmQuery;

public class StateStore {

    private Context context;
    private Realm realm;
    private CommentRealm commentRealm;

    private String comment;

    public StateStore(Context context) {
        this.context = context;
        this.realm = RealmInst();
    }

    public void realmTransactionCopyOrUpdate(){
        if (!comment.equals(""))
            realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(commentRealm));
    }

    public RealmQuery<CommentRealm> getQuery() {
        return realm.where(CommentRealm.class);
    }

    public Integer getDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR)+calendar.get(Calendar.DAY_OF_YEAR);
    }

    public void setCommentRealm(String comment,int feeling) {
        this.comment = comment;
        commentRealm = new CommentRealm();
        commentRealm.setId(getDate());
        commentRealm.setComment(comment);
        commentRealm.setFeeling(feeling);
    }

    private Realm RealmInst() {
        Realm.init(context.getApplicationContext());
        return Realm.getDefaultInstance();
    }
}
