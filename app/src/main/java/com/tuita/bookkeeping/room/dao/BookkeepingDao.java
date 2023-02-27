package com.tuita.bookkeeping.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.tuita.bookkeeping.room.entity.Bookkeeping;

import java.util.List;

@Dao
public interface BookkeepingDao {
    @Insert
    void insertRecord(Bookkeeping bookkeeping);

    @Delete
    void delRecord(Bookkeeping bookkeeping);

    @Query("SELECT * FROM bookkeeping")
    List<Bookkeeping> queryFromBookkeepingRecord();

}
