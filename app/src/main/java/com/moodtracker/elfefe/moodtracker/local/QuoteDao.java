package com.moodtracker.elfefe.moodtracker.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuoteDao {
    @Query("SELECT * FROM state")
    List<Quote> getAll();

    @Query("SELECT * FROM state WHERE uid IN (:QuoteIds)")
    List<Quote> loadAllByIds(int[] QuoteIds);

    @Query("SELECT * FROM state WHERE quote LIKE :first AND "
            + "feeling LIKE :last LIMIT 1")
    Quote findByName(String first, String last);

    @Insert
    void insertAll(Quote... Quotes);

    @Delete
    void delete(Quote Quote);
}