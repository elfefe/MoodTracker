package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;

import com.moodtracker.elfefe.moodtracker.model.Mood;
import com.moodtracker.elfefe.moodtracker.utils.TimeUtils;
import io.realm.Realm;
import io.realm.RealmQuery;

public class CommentRealmDAO {

    private final Context context;
    private final Realm realm;
    private CommentRealm commentRealm;

    private String comment;

    public CommentRealmDAO(Context context) {
        this.context = context;
        this.realm = RealmInst();
    }


    public void realmTransactionCopyOrUpdate() {
        if (!comment.equals(""))
            realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(commentRealm));
    }

    public RealmQuery<CommentRealm> getQuery() {
        return realm.where(CommentRealm.class).between(CommentRealm.KEY_ID, TimeUtils.getDate(7), TimeUtils.getDate(1));
    }


    public void setCommentRealm(String comment, Mood feeling) {
        this.comment = comment;
        commentRealm = new CommentRealm();
        commentRealm.setId(TimeUtils.getDate());
        commentRealm.setComment(comment);
        commentRealm.setFeeling(feeling);
    }

    private Realm RealmInst() {
        Realm.init(context.getApplicationContext());
        return Realm.getDefaultInstance();
    }
}
