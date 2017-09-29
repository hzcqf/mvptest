package com.fan.mvptest.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fan.base.CoreActivity;
import com.fan.base.CoreApplication;
import com.fan.base.di.moudle.ActivityModule;
import com.fan.mvptest.base.di.AppActivityComponent;
import com.fan.mvptest.base.di.DaggerAppActivityComponent;
import com.fan.mvptest.base.mvp.MvpView;
import com.fan.mvptest.base.mvp.Presenter;

import javax.inject.Inject;



public abstract class MvpActivity<T extends Presenter> extends CoreActivity implements MvpView {
    @Inject
    protected T mPresenter;
    protected AppCompatActivity mContext;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        mContext = this;
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * dragger2注册
     */
    protected abstract void initInject();

    protected AppActivityComponent getActivityComponent() {
        return DaggerAppActivityComponent.builder()
                .appComponent(CoreApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}