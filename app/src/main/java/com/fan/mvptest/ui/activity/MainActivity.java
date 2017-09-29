package com.fan.mvptest.ui.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.fan.mvptest.R;
import com.fan.mvptest.base.BaseActivity;
import com.fan.mvptest.databinding.ActivityMainBinding;

public class MainActivity  extends BaseActivity<MainPresenter> implements MainContract.IView {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected View loadContentView() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.activity_main, null, false);
        return binding.getRoot();
    }



    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initEvents() {
        super.initEvents();
    }
}
