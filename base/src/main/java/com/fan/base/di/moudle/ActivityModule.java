package com.fan.base.di.moudle;


import android.support.v7.app.AppCompatActivity;

import com.fan.base.di.ActivityScope;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public AppCompatActivity provideActivity() {
        return mActivity;
    }
}
