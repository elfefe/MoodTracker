package com.moodtracker.elfefe.moodtracker.model;

import android.arch.persistence.room.Room;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.Display;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.controller.CommentAdapter;
import com.moodtracker.elfefe.moodtracker.controller.HistoryValues;
import com.moodtracker.elfefe.moodtracker.local.AppDatabase;
import com.moodtracker.elfefe.moodtracker.local.User;

import java.util.ArrayList;
import java.util.List;

import static com.moodtracker.elfefe.moodtracker.model.MainActivity.STATE_KEY;
import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    AppDatabase db;

    RecyclerView currentLayout;
    String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        currentLayout = findViewById(R.id.comment);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "user-db").allowMainThreadQueries().build();



        Log.d("screenHeight", String.valueOf(screenHeight()));

        comment = getIntent().getStringExtra(STATE_KEY);

        User user = new User(0,"moodtracker",comment);

        ArrayList<HistoryValues> listComment = new ArrayList<>();

        listComment.add(new HistoryValues("non",R.color.angry));
        listComment.add(new HistoryValues("non", R.color.happy));
        listComment.add(new HistoryValues("oui", R.color.good));
        listComment.add(new HistoryValues("non", R.color.happy));
        listComment.add(new HistoryValues("oui", R.color.average));
        listComment.add(new HistoryValues("non", R.color.sad));
        listComment.add(new HistoryValues("oui", R.color.good));

        Log.d("PAIR: ",listComment.get(0).toString());


        currentLayout.setLayoutManager(new LinearLayoutManager(this));


        currentLayout.setAdapter(new CommentAdapter(listComment, screenHeight()));



        out.println(comment);
    }

    public int screenHeight(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }
}
