package com.fan.mvptest.base;


import android.content.Context;
import android.os.Bundle;

import com.fan.base.CoreApplication;
import com.fan.base.CoreFragment;
import com.fan.base.di.moudle.FragmentModule;
import com.fan.mvptest.base.di.AppFragmentComponent;
import com.fan.mvptest.base.di.DaggerAppFragmentComponent;
import com.fan.mvptest.base.mvp.MvpView;
import com.fan.mvptest.base.mvp.Presenter;

import javax.inject.Inject;


public abstract class MvpFragment<T extends Presenter> extends CoreFragment implements MvpView {
    protected Context mContext;
    @Inject
    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        mPresenter.attachView(this);
    }

    protected AppFragmentComponent getFragmentComponent() {
        return DaggerAppFragmentComponent.builder()
                .appComponent(CoreApplication.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract void initInject();
}