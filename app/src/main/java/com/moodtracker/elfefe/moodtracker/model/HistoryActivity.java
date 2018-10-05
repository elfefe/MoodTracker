package com.moodtracker.elfefe.moodtracker.model;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.local.AppDatabase;
import com.moodtracker.elfefe.moodtracker.local.Quote;

import java.time.ZonedDateTime;

import static com.moodtracker.elfefe.moodtracker.model.MainActivity.FEEL_KEY;
import static com.moodtracker.elfefe.moodtracker.model.MainActivity.STATE_KEY;
import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    AppDatabase db;


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



        comment = getIntent().getStringExtra(STATE_KEY);
        feeling = getIntent().getIntExtra(FEEL_KEY,0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            ZonedDateTime date = ZonedDateTime.now();
            Quote state;
            if (db.quoteDao().getAll().size() != 0){
                if (db.quoteDao().getAll().get(db.quoteDao().getAll().size() - 1).getUid() != date.getDayOfMonth()) {
                    state = new Quote(date.getDayOfMonth(), comment, feeling);
                    db.quoteDao().insertAll(state);
                }
            }else{
                state = new Quote(date.getDayOfMonth(), comment, feeling);
                db.quoteDao().insertAll(state);
            }
        }



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

        onClick(mTextView1);
        onClick(mTextView2);
        onClick(mTextView3);
        onClick(mTextView4);
        onClick(mTextView5);
        onClick(mTextView6);
        onClick(mTextView7);

    }
    private void onClick(TextView textView){
        textView.setOnClickListener(v -> {
            Toast.makeText(this,"oui",Toast.LENGTH_LONG).show();
        });
    }
}
