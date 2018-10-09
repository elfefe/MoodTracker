package com.moodtracker.elfefe.moodtracker.model;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.moodtracker.elfefe.moodtracker.local.AppDatabase;

public class DataManagement {

    private AppDatabase appDatabase;

    public DataManagement(Context context) {
        appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "state_db").allowMainThreadQueries().build();
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public void setAppDatabase(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }



}
