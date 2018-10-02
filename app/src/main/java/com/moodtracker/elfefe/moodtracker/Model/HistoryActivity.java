package com.moodtracker.elfefe.moodtracker.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.moodtracker.elfefe.moodtracker.Controller.CommentAdapter;
import com.moodtracker.elfefe.moodtracker.R;

import java.util.ArrayList;
import java.util.List;

import static com.moodtracker.elfefe.moodtracker.Model.MainActivity.STATE_KEY;
import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView currentLayout;
    String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        currentLayout = findViewById(R.id.comment);


        comment = getIntent().getStringExtra(STATE_KEY);

        ArrayList<String> listComment = new ArrayList<>();
        listComment.add(comment);

        currentLayout.setLayoutManager(new LinearLayoutManager(this));
        currentLayout.setAdapter(new CommentAdapter(listComment));



        out.println(comment);
    }
}
