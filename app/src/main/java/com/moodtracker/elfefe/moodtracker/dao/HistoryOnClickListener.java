package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.model.Mood;

public class HistoryOnClickListener {

    private static  final float WIDTH_100_PERCENT = 1f;
    private static  final float WIDTH_80_PERCENT = 0.8f;
    private static  final float WIDTH_60_PERCENT = 0.6f;
    private static  final float WIDTH_40_PERCENT = 0.4f;
    private static  final float WIDTH_20_PERCENT = 0.2f;
    
    private int feeling;

    public HistoryOnClickListener(Context context, StateStore stateStore,TextView textView, int position) {

        CommentRealm dbGet = stateStore.getQuery().findAll().get(position);

        assert dbGet != null;
        feeling = dbGet.getFeeling();
        

        if (dbGet.getId() != stateStore.getDate()) {
            textView.setBackgroundColor(context.getResources().getColor(feeling));

            textView.setOnClickListener(v -> Toast.makeText(
                    context,
                    dbGet.getComment(),
                    Toast.LENGTH_LONG)
                    .show()
            );

            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
            textView.setLayoutParams(layoutParams);

            layoutParams.matchConstraintPercentWidth = getFeelingPercent();
        }
    }
    
    private float getFeelingPercent(){
        if (feeling == Mood.HAPPY.getColor())
            return WIDTH_100_PERCENT;
        else if (feeling == Mood.GOOD.getColor())
            return WIDTH_80_PERCENT;
        else if (feeling == Mood.AVERAGE.getColor())
            return WIDTH_60_PERCENT;
        else if (feeling == Mood.SAD.getColor())
            return WIDTH_40_PERCENT;
        else if (feeling == Mood.ANGRY.getColor())
            return WIDTH_20_PERCENT;
        else
            return 0;
    }
}
