package com.tuita.bookkeeping.utils;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;


public abstract class OnItemTimeClick implements BaseQuickAdapter.OnItemChildClickListener {
    private long lastStartClickTime;
    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 2000;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastStartClickTime) >= MIN_CLICK_DELAY_TIME) {
            // 超过点击间隔后再将lastClickTime重置为当前点击时间
            lastStartClickTime = curClickTime;
            timeClick(adapter, view, position);
        } else {
            Log.e("OnItemTimeClick", "不要重复点击");
            timeClickError();
        }
    }

    public abstract void timeClick(BaseQuickAdapter adapter, View view, int position);

    public void timeClickError() {
//        ToastUtils.toast(AppApplication.getActManager().getTopActivity().getApplicationContext(), "请不要重复点击");
    }
}
