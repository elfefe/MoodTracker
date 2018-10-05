package com.moodtracker.elfefe.moodtracker.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.ColorRes;

import java.util.List;

@Dao
public interface QuoteDao {
    @Query("SELECT * FROM state")
    List<Quote> getAll();

    @Query("SELECT * FROM state WHERE uid IN (:QuoteIds)")
    List<Quote> loadAllByIds(int[] QuoteIds);

    @Insert
    void insertAll(Quote... Quotes);

    @Query("UPDATE state SET quote = :comment, feeling = :feeling WHERE uid = :id ")
    void replaceField(int id,String comment,@ColorRes int feeling);

    @Delete
    void delete(Quote Quote);
}