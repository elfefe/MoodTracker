package com.moodtracker.elfefe.moodtracker.model;

import android.widget.ImageButton;
import android.widget.TextView;

public class Stripe {
    final private TextView textView;
    final private ImageButton imageButton;

    public Stripe(TextView textView, ImageButton imageButton) {
        this.textView = textView;
        this.imageButton = imageButton;
    }


    public TextView getTextView() {
        return textView;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }


}
