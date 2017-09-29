package com.fan.base.component;

import io.reactivex.observers.DefaultObserver;


public abstract class EmptyDefaultObserver<T> extends DefaultObserver<T> {
    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
