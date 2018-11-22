package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.model.Mood;

public class HistoryOnClickListener {

    public HistoryOnClickListener(Context context, StateStore stateStore, TextView textView, int position) {

        CommentRealm dbGet = stateStore.getQuery().findAll().get(position);

        if (dbGet == null) {
            return;
        }
        Mood feeling = dbGet.getFeeling();

        textView.setBackgroundColor(context.getResources().getColor(feeling.getColor()));

        textView.setOnClickListener(v -> Toast.makeText(
                context,
                dbGet.getComment(),
                Toast.LENGTH_LONG)
                .show()
        );

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        textView.setLayoutParams(layoutParams);

        layoutParams.matchConstraintPercentWidth = feeling.getPercecnt();
    }
}
