package com.tuita.bookkeeping;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory;
import com.tuita.bookkeeping.room.database.BookkeepingDatabase;
import com.tuita.bookkeeping.room.entity.Bookkeeping;
import com.tuita.bookkeeping.utils.RecordUtils;

import java.util.List;

public class SuApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initThirdSDK();
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Bookkeeping> bookkeepings = BookkeepingDatabase.getInstance(SuApplication.this).bookkeepingDao().queryFromBookkeepingRecord();
                for (Bookkeeping bookkeeping : bookkeepings) {
                    RecordUtils.getInstance().insertBookkeepingRecord(bookkeeping);
                }
            }
        }).start();
    }

    /**
     * 初始化一些三方的SDK
     */
    private void initThirdSDK() {
        //Google的FireBase，AppCheck组件
        FirebaseApp.initializeApp(this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(PlayIntegrityAppCheckProviderFactory.getInstance());
    }
}
