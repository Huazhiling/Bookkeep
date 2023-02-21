package com.tuita.bookkeeping.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tuita.bookkeeping.room.dao.BookkeepingDao;
import com.tuita.bookkeeping.room.entity.BookkeepingEntity;

@Database(entities = {BookkeepingEntity.class}, version = 1)
public abstract class BookkeepingDatabase extends RoomDatabase {
    public abstract BookkeepingDao bookkeepingDao();
}
