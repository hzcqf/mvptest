package com.fan.mvptest.base.mvp;


public interface Presenter<V extends MvpView> {

    /**
     * 关联
     *
     * @param mvpView 视图层代表
     */
    void attachView(V mvpView);

    /**
     * 解除关联
     */
    void detachView();

}
