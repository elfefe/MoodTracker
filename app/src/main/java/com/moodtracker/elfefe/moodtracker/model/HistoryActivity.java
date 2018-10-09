package com.moodtracker.elfefe.moodtracker.model;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.local.CommentRealm;

import java.util.ArrayList;
import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmQuery;

import static com.moodtracker.elfefe.moodtracker.model.MainActivity.FEEL_KEY;
import static com.moodtracker.elfefe.moodtracker.model.MainActivity.STATE_KEY;
import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    RealmQuery<CommentRealm> query;

    String comment;
    int feeling;

    TextView mTextView1,mTextView2,mTextView3,mTextView4,mTextView5,mTextView6,mTextView7;
    ImageButton mImageButton1,mImageButton2,mImageButton3,mImageButton4,mImageButton5,mImageButton6,mImageButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        out.println("HistoryActivity::onCreate()");

        comment = getIntent().getStringExtra(STATE_KEY);
        feeling = getIntent().getIntExtra(FEEL_KEY,0);

        Calendar cal = Calendar.getInstance();
        Integer date = cal.get(Calendar.DAY_OF_MONTH);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        query = realm.where(CommentRealm.class);

        CommentRealm commentRealm = new CommentRealm();

        commentRealm.setDate(date);
        commentRealm.setComment(comment);
        commentRealm.setFeeling(feeling);

        if (comment != null)
            realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(commentRealm));

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

        if (query.findAll().size() != 0) {
            int x = 0;
            if (query.findAll().size() > 7)
                x = query.findAll().size() - 7;
            while(x < query.findAll().size()) {
                onClick(allTextView.get(x), x);
                x++;
            }
        }
    }
    private void onClick(TextView textView,int position){

        CommentRealm dbGet = query.findAll().get(position);

        assert dbGet != null;
        textView.setBackgroundColor(getResources().getColor(dbGet.getFeeling()));

        textView.setOnClickListener(v -> Toast.makeText(
                                            this,
                                                    dbGet.getComment(),
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
