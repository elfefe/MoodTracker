package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;

import com.moodtracker.elfefe.moodtracker.model.Mood;

import org.threeten.bp.LocalDate;

import io.realm.Realm;
import io.realm.RealmQuery;

public class StateStore {

    private final Context context;
    private final Realm realm;
    private CommentRealm commentRealm;

    private String comment;

    public StateStore(Context context) {
        this.context = context;
        this.realm = RealmInst();
    }


    public void realmTransactionCopyOrUpdate() {
        if (!comment.equals(""))
            realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(commentRealm));
    }

    public RealmQuery<CommentRealm> getQuery() {
        return realm.where(CommentRealm.class).between(CommentRealm.KEY_ID, getDate(7), getDate(1));
    }

    public Integer getDate() {
        LocalDate now = LocalDate.now();
        return now.getYear() * 1_000 + now.getDayOfYear();
    }

    public Integer getDate(int minusDays) {
        LocalDate now = LocalDate.now();
        int someDaysAgo;

        if (now.getDayOfYear() - minusDays < 0) {
            int dayInYear = 365;
            if (now.isLeapYear()) {
                dayInYear = 366;
            }
            someDaysAgo = (now.getYear() - 1) * 1_000 + (dayInYear - minusDays + now.getDayOfYear());
        } else {
            someDaysAgo = getDate() - minusDays;
        }

        return someDaysAgo;
    }

    public void setCommentRealm(String comment, Mood feeling) {
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
