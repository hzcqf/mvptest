package com.fan.mvptest.ui.activity;

import com.fan.mvptest.base.mvp.ActivityPresenter;

import javax.inject.Inject;

/**
 * Created by Fan. on 2017/9/29.
 */

public class MainPresenter extends ActivityPresenter<MainContract.IView,MainMoudle> implements MainContract.IPresenter{

    @Inject
    public MainPresenter() {

    }
}
