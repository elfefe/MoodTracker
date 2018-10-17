package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

class AutoCompleteManager {
    private Context context;
    private Cursor cursor;
    private ArrayList<Contacts> contactList;
    private AutoCompleteAdapter autoCompleteAdapter;


    AutoCompleteManager(Context context) {
        this.context = context;
        contactList = new ArrayList<>();
    }

    AutoCompleteAdapter autoCompleteAdapter(){

        setCursor();
        setArrayList();
        setAdapter();

        cursor.close();

        return autoCompleteAdapter;
    }


    private void setCursor() {
        cursor = context.getContentResolver().query(
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
            Contacts contacts = new Contacts(cursor.getString(cursor.getColumnIndex(ContactsContract
                        .CommonDataKinds
                        .Phone
                        .DISPLAY_NAME_ALTERNATIVE))
                    ,cursor.getString(cursor.getColumnIndex(ContactsContract
                        .CommonDataKinds
                        .Phone
                        .NUMBER))
                    ,cursor.getString(cursor.getColumnIndex(ContactsContract
                        .CommonDataKinds
                        .Phone
                        .PHOTO_THUMBNAIL_URI))
            );
            contactList.add(contacts);
            Log.d("CONTACTS*********: ", contactList.get(contactList.size()-1).toString());
        }
    }

    private void setAdapter() {
        autoCompleteAdapter = new AutoCompleteAdapter(
                context, contactList);
    }
}
