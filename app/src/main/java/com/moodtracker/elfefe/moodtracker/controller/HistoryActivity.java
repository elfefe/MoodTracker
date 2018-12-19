package com.moodtracker.elfefe.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.CommentRealm;
import com.moodtracker.elfefe.moodtracker.dao.HistoryOnClickListener;
import com.moodtracker.elfefe.moodtracker.dao.StateStore;

import java.util.ArrayList;

import io.realm.RealmResults;

import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        StateStore stateStore = new StateStore(this);

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

        RealmResults<CommentRealm> findAll = stateStore.getQuery().findAll();
        if (findAll.size() != 0) {
            for (int viewCreated = 0, commentIndex = 0; viewCreated < allTextView.size(); viewCreated++) {
                CommentRealm commentRealmGet = findAll.get(commentIndex);
                if (commentIndex < findAll.size()){
                    commentRealmGet = findAll.get(commentIndex);
                }
                if (commentRealmGet != null && stateStore.getDate(viewCreated + 1) == commentRealmGet.getId()) {
                    commentIndex++;
                    new HistoryOnClickListener(this, commentRealmGet, allTextView.get(viewCreated));
                }else{
                    new HistoryOnClickListener(this, null, allTextView.get(viewCreated));
                }
            }
        }
    }
}
