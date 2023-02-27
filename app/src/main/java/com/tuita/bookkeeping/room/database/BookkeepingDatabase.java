package com.tuita.bookkeeping.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tuita.bookkeeping.room.dao.BookkeepingDao;
import com.tuita.bookkeeping.room.entity.Bookkeeping;

@Database(entities = {Bookkeeping.class}, version = 1,exportSchema = false)
public abstract class BookkeepingDatabase extends RoomDatabase {
    private static final String DB_NAME = "bookkeepingDatabase.db";
    private static volatile BookkeepingDatabase bookkeepingDatabase;
    private static final Object obj = new Object();

    public static BookkeepingDatabase getInstance(Context context) {
        if (bookkeepingDatabase == null) {
            synchronized (obj) {
                if (bookkeepingDatabase == null) {
                    bookkeepingDatabase = createBookkeepingDB(context);
                }
            }
        }
        return bookkeepingDatabase;
    }

    private static BookkeepingDatabase createBookkeepingDB(Context context) {
        return Room.databaseBuilder(context, BookkeepingDatabase.class, DB_NAME).build();
    }

    public abstract BookkeepingDao bookkeepingDao();
}
