package com.tuita.bookkeeping.utils;

import android.view.View;

public abstract class TimeClick implements View.OnClickListener {
    private long lastStartClickTime;
    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 2000;

    @Override
    public void onClick(View v) {
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastStartClickTime) >= MIN_CLICK_DELAY_TIME) {
            // 超过点击间隔后再将lastClickTime重置为当前点击时间
            lastStartClickTime = curClickTime;
            timeClick(v);
        } else {
            timeClickError();
        }
    }

    public abstract void timeClick(View v);

    public void timeClickError() {
//        ToastUtils.toast(AppApplication.getActManager().getTopActivity().getApplicationContext(), "请不要重复点击");
    }
}
