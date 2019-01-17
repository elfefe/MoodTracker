package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.R;
import com.moodtracker.elfefe.moodtracker.dao.CommentRealm;
import com.moodtracker.elfefe.moodtracker.model.Mood;
import com.moodtracker.elfefe.moodtracker.model.Stripe;

class HistoryStripeModifier {

    HistoryStripeModifier(Context context, @Nullable CommentRealm commentRealm, Stripe stripe) {

        if (commentRealm == null) {
            return;
        }
        Mood feeling = commentRealm.getFeeling();
        TextView textView = stripe.getTextView();
        ImageButton imageButton = stripe.getImageButton();

        textView.setBackgroundColor(context.getResources().getColor(feeling.getColor()));
        imageButton.setImageDrawable(context.getResources().getDrawable(R.drawable.ico_comment));

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
