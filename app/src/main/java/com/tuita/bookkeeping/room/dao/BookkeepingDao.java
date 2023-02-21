package com.tuita.bookkeeping.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import com.tuita.bookkeeping.room.entity.BookkeepingEntity;

@Dao
public interface BookkeepingDao {

    @Insert
    void insertRecord(BookkeepingEntity bookkeeping);

    @Delete
    void delRecord(BookkeepingEntity bookkeeping);

    

}
