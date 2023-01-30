package com.tuita.bookkeeping.utils;


import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author Administrator
 */
public class RxUtils {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void register(Disposable dp){
        compositeDisposable.add(dp);
    }
    public void unSubscribe(){
        compositeDisposable.dispose();
    }
}
