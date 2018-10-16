package com.moodtracker.elfefe.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.HistoryOnClickListener;
import com.moodtracker.elfefe.moodtracker.dao.StateStore;

import java.util.ArrayList;

import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {
    TextView mTextView1,mTextView2,mTextView3,mTextView4,mTextView5,mTextView6,mTextView7;
    ImageButton mImageButton1,mImageButton2,mImageButton3,mImageButton4,mImageButton5,mImageButton6,mImageButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        StateStore stateStore = new StateStore(this);

        mTextView1 = findViewById(R.id.comment1);
        mTextView2 = findViewById(R.id.comment2);
        mTextView3 = findViewById(R.id.comment3);
        mTextView4 = findViewById(R.id.comment4);
        mTextView5 = findViewById(R.id.comment5);
        mTextView6 = findViewById(R.id.comment6);
        mTextView7 = findViewById(R.id.comment7);

        mImageButton1 = findViewById(R.id.btn1);
        mImageButton2 = findViewById(R.id.btn2);
        mImageButton3 = findViewById(R.id.btn3);
        mImageButton4 = findViewById(R.id.btn4);
        mImageButton5 = findViewById(R.id.btn5);
        mImageButton6 = findViewById(R.id.btn6);
        mImageButton7 = findViewById(R.id.btn7);

        ArrayList<TextView> allTextView = new ArrayList<>();

        allTextView.add(mTextView7);
        allTextView.add(mTextView6);
        allTextView.add(mTextView5);
        allTextView.add(mTextView4);
        allTextView.add(mTextView3);
        allTextView.add(mTextView2);
        allTextView.add(mTextView1);


        if (stateStore.getQuery().findAll().size() != 0) {
            int x = 0;
            if (stateStore.getQuery().findAll().size() >= allTextView.size())
                x = stateStore.getQuery().findAll().size() - allTextView.size();
            while(x < stateStore.getQuery().findAll().size()) {
                 new HistoryOnClickListener(this,stateStore,allTextView.get(x), x);
                x++;
            }
        }
    }
}
