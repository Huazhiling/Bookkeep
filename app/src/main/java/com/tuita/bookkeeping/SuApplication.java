package com.tuita.bookkeeping;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory;

public class SuApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        RecordUtils.getInstance().initSimulationData();
        initThirdSDK();
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
