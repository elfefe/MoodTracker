package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.database.Cursor;
import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class AutoCompleteManagerTest {

    private Context context = spy(MainActivity.class);
    private Cursor cursor;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    @Mock
    private ArrayList<Contacts> contacts;
    @Mock
    private AutoCompleteAdapter autoCompleteAdapter;
    @InjectMocks
    private AutoCompleteManager underTest;

    public void setArrayList() {
        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");
        arrayList.add("test4");
        arrayList.add("test5");
        arrayList.add("test6");
    }

    @Test
    public void autoCompleteAdapter_return_an_adapter() {
    }

    @Test
    public void cursor_is_not_null(){
    }

    @Test
    public void the_iteration_in_the_arrayList_work_fine(){

    }
}