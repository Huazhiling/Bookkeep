package com.tuita.bookkeeping;

import android.app.Application;

import com.tuita.bookkeeping.utils.RecordUtils;

public class SuApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RecordUtils.getInstance().initSimulationData();
    }
}
