package com.moodtracker.elfefe.moodtracker.controller;

import com.moodtracker.elfefe.moodtracker.model.Mood;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GestureListenerTest {

    @Test
    public void onFling_valueX_never_greaterthan4() {
        int valueX = -1;
        for (int velocityY = -10; velocityY < 1; velocityY++) {
            if (velocityY < 0 && valueX < Mood.values().length - 1) {
                valueX++;
            }
        }
        assertEquals(4, valueX);
    }

    @Test
    public void onFling_valueX_never_lowerthan0() {
        int valueX = 8;
        for (int velocityY = -1; velocityY < 10; velocityY++) {
            if (velocityY > 0 && valueX > 0) {
                valueX--;
            }
        }
        assertEquals(0, valueX);
    }
}