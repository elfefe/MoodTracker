package com.moodtracker.elfefe.moodtracker.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;

import java.util.Objects;

import static com.moodtracker.elfefe.moodtracker.Model.MainActivity.STATE_KEY;
import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    Button mback;
    TextView mTextView1;
    String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        mback = findViewById(R.id.back_btn);
        mTextView1 = findViewById(R.id.comment1);


        comment = getIntent().getStringExtra(STATE_KEY);


        mTextView1.setText(comment);


        out.println(comment);


        mback.setOnClickListener(v -> finish());
    }
}
