package com.moodtracker.elfefe.moodtracker;

import com.moodtracker.elfefe.moodtracker.controller.GestureListener;
import com.moodtracker.elfefe.moodtracker.controller.LoaderMainView;
import com.moodtracker.elfefe.moodtracker.controller.MessageManager;
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
    public void mood_get_five_objects(){assertEquals(5, Mood.values().length);}
    @Test
    public void gesturelistener_valueX_begin_with_one(){
        GestureListener gestureListener = new GestureListener(new LoaderMainView(null,
                                                                              null,
                                                                                  null));
        assertEquals(1,gestureListener.getValueX());
    }
    @Test
    public void MessageManager_return_state(){
        String state = "fonctionne";
        MessageManager messageManager = new MessageManager(null,state,null,null);
        assertEquals(state, messageManager.getState());
    }
    @Test
    public void gesturelistener_onfling_velocity_up_to_bottom_negative(){

    }
}