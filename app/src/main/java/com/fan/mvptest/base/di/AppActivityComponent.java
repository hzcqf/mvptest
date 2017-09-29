package com.fan.mvptest.base.di;


import android.support.v7.app.AppCompatActivity;

import com.fan.base.di.ActivityScope;
import com.fan.base.di.component.AppComponent;
import com.fan.base.di.moudle.ActivityModule;

import dagger.Component;


/**
 * Created by ganzhubing on 2017/9/6.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface AppActivityComponent {
    AppCompatActivity getActivity();

}