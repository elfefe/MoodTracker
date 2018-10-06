package com.moodtracker.elfefe.moodtracker;

import com.moodtracker.elfefe.moodtracker.controller.GestureListener;
import com.moodtracker.elfefe.moodtracker.controller.LoaderMainView;
import com.moodtracker.elfefe.moodtracker.model.Mood;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void mood_get_five_objects(){assertEquals(5, Mood.values().length);}
    @Test
    public void gesturelistener_valueX_begin_with_one(){
        GestureListener gestureListener = new GestureListener(new LoaderMainView(null,
                                                                              null,
                                                                                  null,
                                                                             null,
                                                                           null));
        assertEquals(1,gestureListener.getValueX());
    }
}