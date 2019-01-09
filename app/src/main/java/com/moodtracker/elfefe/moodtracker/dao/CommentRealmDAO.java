package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;

import com.moodtracker.elfefe.moodtracker.model.Mood;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

import com.moodtracker.elfefe.moodtracker.utils.TimeUtils;

import java.util.List;

public class CommentRealmDAO {

    private final Realm realm;


    public CommentRealmDAO(Context context) {
        Realm.init(context);
        this.realm = Realm.getDefaultInstance();
    }

    public List<CommentRealm> getLastSevenMood() {
        RealmQuery<CommentRealm> realmQuery = realm.where(CommentRealm.class).between(CommentRealm.KEY_ID, TimeUtils.getDate(7), TimeUtils.getDate(1));
        RealmResults<CommentRealm> realmResults = realmQuery.findAll();

        return realmResults.sort(CommentRealm.KEY_ID, Sort.ASCENDING);
    }

    public CommentRealm getActualMood(){
        return realm.where(CommentRealm.class).equalTo(CommentRealm.KEY_ID,TimeUtils.getDate()).findFirst();
    }

    public void setCommentRealm(String comment,Mood feeling) {
       CommentRealm commentRealm = new CommentRealm();
        if (getActualMood() != null) {
            commentRealm.setId(TimeUtils.getDate());
            commentRealm.setComment(comment);
            commentRealm.setFeeling(feeling);
            realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(commentRealm));
            realm.close();
        }
    }
}
