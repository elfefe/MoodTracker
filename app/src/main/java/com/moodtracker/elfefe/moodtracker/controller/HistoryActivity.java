package com.moodtracker.elfefe.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.CommentRealm;
import com.moodtracker.elfefe.moodtracker.dao.CommentRealmDAO;

import java.util.ArrayList;

import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        CommentRealmDAO commentRealmDAO = new CommentRealmDAO(this);

        TextView TextView1 = findViewById(R.id.comment1);
        TextView TextView2 = findViewById(R.id.comment2);
        TextView TextView3 = findViewById(R.id.comment3);
        TextView TextView4 = findViewById(R.id.comment4);
        TextView TextView5 = findViewById(R.id.comment5);
        TextView TextView6 = findViewById(R.id.comment6);
        TextView TextView7 = findViewById(R.id.comment7);

        ArrayList<TextView> allTextView = new ArrayList<>();

        allTextView.add(TextView1);
        allTextView.add(TextView2);
        allTextView.add(TextView3);
        allTextView.add(TextView4);
        allTextView.add(TextView5);
        allTextView.add(TextView6);
        allTextView.add(TextView7);

        RealmQuery<CommentRealm> commentRealmDAOQuery = commentRealmDAO.getQuery();
        RealmResults<CommentRealm> realmResults = commentRealmDAOQuery.findAll().sort(CommentRealm.KEY_ID, Sort.DESCENDING);
        if (commentRealmDAOQuery.count() != 0){
            for (int commentIndex = 0;commentIndex < allTextView.size();commentIndex++){
                if (realmResults.get(commentIndex)!=null){
                    new HistoryOnClickListener(this, realmResults.get(commentIndex),allTextView.get(commentIndex));
                }else{
                    new HistoryOnClickListener(this, null, allTextView.get(commentIndex));
                }
            }
        }
    }
}
