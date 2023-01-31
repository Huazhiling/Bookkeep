package com.tuita.bookkeeping.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;

import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseActivity;

@SuppressLint("CustomSplashScreen")
@XmlLayoutResId(portContentId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    private CountDownTimer countDownTimer;
    private int maxSkip = 3;

    @Override
    protected void adapterInit() {

    }

    @Override
    protected void viewInit() {
        countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                maxSkip = (int) (maxSkip - millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                countDownTimer.cancel();
                checkFirstPrivacy();
            }
        }.start();
    }

    private void checkFirstPrivacy() {
        startActivity(new Intent(getBaseContext(), MainActivity.class));
        finish();
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void initView() {

    }
}