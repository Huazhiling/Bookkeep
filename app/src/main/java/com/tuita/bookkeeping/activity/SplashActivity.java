package com.tuita.bookkeeping.activity;

import android.view.View;

import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseActivity;

@XmlLayoutResId(portContentId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    @Override
    protected void adapterInit() {

    }

    @Override
    protected void viewInit() {

    }

    @Override
    protected void findView() {
        findViewById(R.id.status_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initView() {

    }
}