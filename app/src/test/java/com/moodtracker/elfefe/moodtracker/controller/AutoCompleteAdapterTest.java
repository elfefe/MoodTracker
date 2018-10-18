package com.moodtracker.elfefe.moodtracker.controller;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class AutoCompleteAdapterTest {
    private ArrayList<Contacts> original = new ArrayList<>();
    private ArrayList<Contacts> copyAll = new ArrayList<>();
    private ArrayList<Contacts> copy = new ArrayList<>();
    Contacts contacts;

    @Before
    public void setUp() throws Exception {
        try {
            original.add(new Contacts("Name1", "0001"));
            original.add(new Contacts("Name2", "0010"));
            original.add(new Contacts("Name3", "0100"));
            original.add(new Contacts("Name4", "0110"));

            copyAll.addAll(original);
        }catch (Exception e){
            Log.d("Error ", e.getMessage());
            fail();
        }
    }



    @Test
    public void performFilter_return_a_correct_filterResult(){
        String constraint = "me";

        copy.clear();
        for (Contacts contacts : copyAll) {
            if(contacts.getmName().toLowerCase().contains(constraint.toLowerCase())
                    || contacts.getmNumber().toLowerCase().contains(constraint.toLowerCase())){
                copy.add(contacts);
            }
        }
        assertArrayEquals(original.toArray(),copy.toArray());
    }
}