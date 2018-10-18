package com.moodtracker.elfefe.moodtracker.controller;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HistoryActivityTest {
    
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<TextView> allTextView = new ArrayList<>();

    @Before
    public void init(){
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");

        allTextView.add(new TextView(null));
        allTextView.add(new TextView(null));
        allTextView.add(new TextView(null));
        allTextView.add(new TextView(null));
        allTextView.add(new TextView(null));
        allTextView.add(new TextView(null));
        allTextView.add(new TextView(null));

    }

    @Test
    public void HistoryOnClickListener_load_no_more_or_less_than_7_times() {
        int HistoryOnClickListener = 0;
        if (arrayList.size() != 0) {
            int x = 0;
            if (arrayList.size() >= allTextView.size())
                x = arrayList.size() - allTextView.size();
            while(x < arrayList.size()) {
                HistoryOnClickListener++;
                x++;
            }
        }
        assertEquals(7, HistoryOnClickListener);
    }
}