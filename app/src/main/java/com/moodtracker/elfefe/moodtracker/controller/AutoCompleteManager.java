package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AutoCompleteManager {
    private Context context;
    private Cursor cursor;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;


    public AutoCompleteManager(Context context) {
        this.context = context;
        arrayList = new ArrayList<>();
    }

    public ArrayAdapter autoCompleteAdapter(){

        setCursor();
        setArrayList();
        setArrayAdapter();

        cursor.close();

        return arrayAdapter;
    }


    private void setCursor() {
        this.cursor = context.getContentResolver().query(
                ContactsContract
                        .CommonDataKinds
                        .Phone
                        .CONTENT_URI,
                null,
                null,
                null,
                null,
                null
        );
    }

    private void setArrayList() {
        assert cursor != null;
        while (cursor.moveToNext()){
            arrayList.add(
                    ContactsContract
                            .CommonDataKinds
                            .Phone
                            .NUMBER
            );
        }
    }

    private void setArrayAdapter() {
        this.arrayAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_list_item_1,
                arrayList);
    }
}
