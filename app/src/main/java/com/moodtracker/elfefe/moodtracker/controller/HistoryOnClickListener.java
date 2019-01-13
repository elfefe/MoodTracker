package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.dao.CommentRealm;
import com.moodtracker.elfefe.moodtracker.model.Mood;

class HistoryOnClickListener {

    HistoryOnClickListener(Context context, @Nullable CommentRealm commentRealm, TextView textView) {

        if (commentRealm == null) {
            return;
        }
        Mood feeling = commentRealm.getFeeling();

        textView.setBackgroundColor(context.getResources().getColor(feeling.getColor()));

        textView.setOnClickListener(v -> Toast.makeText(
                context,
                commentRealm.getComment(),
                Toast.LENGTH_LONG)
                .show()
        );

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();

        layoutParams.matchConstraintPercentWidth = feeling.getPercent();

        textView.setLayoutParams(layoutParams);
    }
}
