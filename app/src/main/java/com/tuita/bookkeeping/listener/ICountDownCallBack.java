package com.tuita.bookkeeping.listener;

public interface ICountDownCallBack {

    void onTick(long millisUntilFinished);

    void onFinish();
}
