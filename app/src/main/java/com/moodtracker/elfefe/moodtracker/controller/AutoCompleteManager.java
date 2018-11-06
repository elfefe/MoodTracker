package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.moodtracker.elfefe.moodtracker.model.Contacts;

import java.util.ArrayList;

class AutoCompleteManager {
    private Context context;

    AutoCompleteManager(Context context) {
        this.context = context;
    }

    AutoCompleteAdapter autoCompleteAdapter(){
        Cursor cursor = cursor();

        ArrayList<Contacts> contactsList = arrayList(cursor);

        AutoCompleteAdapter autoCompleteAdapter = new AutoCompleteAdapter(context, contactsList);

        cursor.close();

        return autoCompleteAdapter;
    }

    private Cursor cursor(){
        if(context.getContentResolver().query(
                ContactsContract
                        .CommonDataKinds
                        .Phone
                        .CONTENT_URI,
                null,
                null,
                null,
                null,
                null
        ) != null)
            return context.getContentResolver().query(
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
        else
            return null;
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
        return arrayList(cursor()).get(position);
    }
}
