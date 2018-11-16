package com.moodtracker.elfefe.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.HistoryOnClickListener;
import com.moodtracker.elfefe.moodtracker.dao.StateStore;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {
    final private static int TODAY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
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

        int dbSize = stateStore.getQuery().findAll().size() - TODAY;
        if (dbSize + TODAY != 0) {
            int allTVPosition = dbSize - allTextView.size();
            int dbIdPosition = stateStore.getDate() - allTextView.size();
            int x = 0;

            while(dbIdPosition <= stateStore.getDate() - TODAY) {
                if(allTVPosition >= 0){
                    if(dbIdPosition == Objects.requireNonNull(stateStore.getQuery().findAll().get(allTVPosition)).getId()) {
                        new HistoryOnClickListener(this, stateStore, allTextView.get(allTVPosition + x), allTVPosition);
                    }
                }else
                    x++;

                allTVPosition++;
                dbIdPosition++;
            }
        }
    }
}
