package com.tuita.bookkeeping.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.tuita.bookkeeping.room.dao.BookkeepingDao;
import com.tuita.bookkeeping.room.entity.Bookkeeping;

@Database(entities = {Bookkeeping.class}, version = 2,exportSchema = false)
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
        return Room.databaseBuilder(context, BookkeepingDatabase.class, DB_NAME)
                .addMigrations(MIGRATION_1_2)
                .build();
    }

    public abstract BookkeepingDao bookkeepingDao();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 因为没有变化，所以是一个空实现
            database.execSQL("ALTER TABLE Bookkeeping ADD COLUMN recordPerson TEXT");
            database.execSQL("ALTER TABLE Bookkeeping ADD COLUMN userAccount TEXT");
        }
    };
}
