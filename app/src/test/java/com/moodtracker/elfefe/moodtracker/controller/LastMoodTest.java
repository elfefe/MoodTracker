package com.moodtracker.elfefe.moodtracker.controller;

import com.moodtracker.elfefe.moodtracker.model.Mood;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LastMoodTest {

    private final long feeling = 0x7f050046;

    @Test
    public void getMoodFeeling_return_an_integer() {

        if (feeling ==  Mood.HAPPY.getColor())
            fail();
        else if (feeling ==  Mood.GOOD.getColor())
            assertEquals(Mood.GOOD.getColor(),feeling);
        else if (feeling ==  Mood.AVERAGE.getColor())
            fail();
        else if (feeling ==  Mood.SAD.getColor())
            fail();
        else if (feeling ==  Mood.ANGRY.getColor())
            fail();
        else
            fail();
    }

    @Test
    public void getMoodColor_return_an_integer() {

        if (feeling ==  Mood.HAPPY.getColor())
            fail();
        else if (feeling ==  Mood.GOOD.getColor())
            assertEquals(Mood.GOOD.getColor(),feeling);
        else if (feeling ==  Mood.AVERAGE.getColor())
            fail();
        else if (feeling ==  Mood.SAD.getColor())
            fail();
        else if (feeling ==  Mood.ANGRY.getColor())
            fail();
        else
            fail();
    }
}