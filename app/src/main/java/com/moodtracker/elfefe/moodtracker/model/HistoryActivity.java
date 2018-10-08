package com.moodtracker.elfefe.moodtracker.model;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.local.AppDatabase;
import com.moodtracker.elfefe.moodtracker.local.Quote;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.moodtracker.elfefe.moodtracker.model.MainActivity.FEEL_KEY;
import static com.moodtracker.elfefe.moodtracker.model.MainActivity.STATE_KEY;
import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    AppDatabase db;

    Quote state;

    String comment;
    int feeling;

    TextView mTextView1,mTextView2,mTextView3,mTextView4,mTextView5,mTextView6,mTextView7;
    ImageButton mImageButton1,mImageButton2,mImageButton3,mImageButton4,mImageButton5,mImageButton6,mImageButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "state_db").allowMainThreadQueries().build();

        List<Quote> dbData = db.quoteDao().getAll();

        comment = getIntent().getStringExtra(STATE_KEY);
        feeling = getIntent().getIntExtra(FEEL_KEY,0);
        
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O && comment != null) {
            ZonedDateTime date = ZonedDateTime.now();

            if (dbData.size() == 0) {
                state = new Quote(date.getDayOfMonth(), comment, feeling);
                db.quoteDao().insertAll(state);
            }else if(dbData.get(dbData.size() -1).getUid() != date.getDayOfMonth()){
                state = new Quote(date.getDayOfMonth(), comment, feeling);
                db.quoteDao().insertAll(state);
            }else
                db.quoteDao().replaceField(date.getDayOfMonth(), comment, feeling);
        }else if(android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.O)
            Toast.makeText(this,
                            "This application don't take in charge your SDK version.",
                                Toast.LENGTH_LONG)
                    .show();

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

        allTextView.add(mTextView1);
        allTextView.add(mTextView2);
        allTextView.add(mTextView3);
        allTextView.add(mTextView4);
        allTextView.add(mTextView5);
        allTextView.add(mTextView6);
        allTextView.add(mTextView7);


        if (dbData.size() != 0) {
            int x = 0;
            if (dbData.size() > 7)
                x = dbData.size() - 7;
            while(x < dbData.size()) {
                onClick(allTextView.get(x), x);
                x++;
            }
        }

    }
    private void onClick(TextView textView,int position){

        Quote dbGet = db.quoteDao().getAll().get(position);

        textView.setBackgroundColor(getResources().getColor(dbGet.getFeeling()));

        textView.setOnClickListener(v -> Toast.makeText(
                                            this,
                                                    dbGet.getQuote(),
                                                    Toast.LENGTH_LONG)
                                                .show()
                                    );

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        textView.setLayoutParams(layoutParams);

        if (dbGet.getFeeling() ==  Mood.HAPPY.getColor())
            layoutParams.matchConstraintPercentWidth =  1;
        else if (dbGet.getFeeling() ==  Mood.GOOD.getColor())
            layoutParams.matchConstraintPercentWidth =  0.8f;
        else if (dbGet.getFeeling() ==  Mood.AVERAGE.getColor())
            layoutParams.matchConstraintPercentWidth =  0.6f;
        else if (dbGet.getFeeling() ==  Mood.SAD.getColor())
            layoutParams.matchConstraintPercentWidth =  0.4f;
        else if (dbGet.getFeeling() ==  Mood.ANGRY.getColor())
            layoutParams.matchConstraintPercentWidth =  0.2f;
    }
}
