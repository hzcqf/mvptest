package com.fan.mvptest.base.mvp;


public interface MvpView {
    void showLoading();

    void showLoading(String msg);

    void hideLoading();

    void toast(String msg);

    void toast(int resId);

    void backgroundAlpha(float to);
}
