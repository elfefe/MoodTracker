package com.moodtracker.elfefe.moodtracker.controller;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;

import com.moodtracker.elfefe.moodtracker.R;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class LoaderMainViewTest {

    private MainActivity mainActivity = spy(MainActivity.class);

    @Test
    public void setFeeling_background_can_be_set() {
        ConstraintLayout constraintLayout = new ConstraintLayout(mainActivity);
        int drawableRes = R.drawable.happy;

        Drawable drawable = mainActivity.getDrawable(drawableRes);

        constraintLayout.setBackgroundResource(drawableRes);

        Assert.assertEquals(drawable,constraintLayout.getBackground());
    }
}