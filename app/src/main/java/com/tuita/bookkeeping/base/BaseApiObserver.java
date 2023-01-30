package com.tuita.bookkeeping.base;

import androidx.annotation.NonNull;

import io.reactivex.rxjava3.observers.DisposableObserver;

/**
 * @author Administrator
 */
public abstract class BaseApiObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
