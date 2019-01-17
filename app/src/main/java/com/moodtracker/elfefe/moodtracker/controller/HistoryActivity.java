package com.moodtracker.elfefe.moodtracker.controller;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.CommentRealm;
import com.moodtracker.elfefe.moodtracker.dao.CommentRealmDAO;
import com.moodtracker.elfefe.moodtracker.model.Stripe;
import com.moodtracker.elfefe.moodtracker.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class HistoryActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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

        ImageButton imageButton1 = findViewById(R.id.btn1);
        ImageButton imageButton2 = findViewById(R.id.btn2);
        ImageButton imageButton3 = findViewById(R.id.btn3);
        ImageButton imageButton4 = findViewById(R.id.btn4);
        ImageButton imageButton5 = findViewById(R.id.btn5);
        ImageButton imageButton6 = findViewById(R.id.btn6);
        ImageButton imageButton7 = findViewById(R.id.btn7);

        ArrayList<Stripe> sevenStripe = new ArrayList<>();

        sevenStripe.add(new Stripe(TextView7,imageButton7));
        sevenStripe.add(new Stripe(TextView6,imageButton6));
        sevenStripe.add(new Stripe(TextView5,imageButton5));
        sevenStripe.add(new Stripe(TextView4,imageButton4));
        sevenStripe.add(new Stripe(TextView3,imageButton3));
        sevenStripe.add(new Stripe(TextView2,imageButton2));
        sevenStripe.add(new Stripe(TextView1,imageButton1));

        List<CommentRealm> lastSevenMoodList = commentRealmDAO.getLastSevenMood();
        if (!lastSevenMoodList.isEmpty()) {
            for (int viewCreated = 0, deltaDay = 0; viewCreated < sevenStripe.size(); viewCreated++) {
                if (lastSevenMoodList.get(deltaDay).getId() == TimeUtils.getDate(viewCreated + 1)) {
                    new HistoryStripeModifier(this, lastSevenMoodList.get(deltaDay), sevenStripe.get(viewCreated));
                    if (deltaDay < lastSevenMoodList.size() - 1)
                        deltaDay++;
                } else {
                    new HistoryStripeModifier(this, null, null);
                }
            }
        }
    }
}
