package com.moodtracker.elfefe.moodtracker.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.moodtracker.elfefe.moodtracker.model.Contacts;

import java.util.ArrayList;
import java.util.Objects;

class AutoCompleteManager {
    private Context context;

    AutoCompleteManager(Context context) {
        this.context = context;
    }

    AutoCompleteAdapter autoCompleteAdapter(){
        Cursor cursor = cursor();

        assert cursor != null;
        ArrayList<Contacts> contactsList = arrayList(cursor);

        AutoCompleteAdapter autoCompleteAdapter = new AutoCompleteAdapter(context, contactsList);

        cursor.close();

        return autoCompleteAdapter;
    }

    private Cursor cursor(){
        Cursor query = context.getContentResolver().query(
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
        if(query != null)
            return query;
        else return null;
    }

    private ArrayList<Contacts> arrayList(Cursor cursor) {
        ArrayList<Contacts> contactList = new ArrayList<>();
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
            );

            contactList.add(contacts);
        }
        return contactList;
    }

    Contacts getContacts(int position){
        Cursor cursor = cursor();
        if (cursor != null)
            return arrayList(cursor).get(position);
        else return null;
    }
}
