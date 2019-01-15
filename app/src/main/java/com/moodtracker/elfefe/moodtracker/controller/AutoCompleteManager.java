package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.moodtracker.elfefe.moodtracker.model.Contacts;

import java.util.ArrayList;

class AutoCompleteManager {
    private final Context context;
    private final ArrayList<Contacts> contactsList;

    AutoCompleteManager(Context context) {
        this.context = context;
        contactsList = contactsList();
    }

    private Cursor cursor() {
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
        if (query != null)
            return query;
        else return null;
    }

    private ArrayList<Contacts> contactsList() {
        ArrayList<Contacts> contactList = new ArrayList<>();
        Cursor cursor = cursor();
        assert cursor != null;
        while (cursor.moveToNext()) {
            Contacts contacts = new Contacts(cursor.getString(cursor.getColumnIndex(ContactsContract
                    .CommonDataKinds
                    .Phone
                    .DISPLAY_NAME_ALTERNATIVE))
                    , cursor.getString(cursor.getColumnIndex(ContactsContract
                    .CommonDataKinds
                    .Phone
                    .NUMBER))
            );
            contactList.add(contacts);
        }
        cursor.close();
        return contactList;
    }

    ArrayList<Contacts> getContactsList() {
        return contactsList;
    }
}
