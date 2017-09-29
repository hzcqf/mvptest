package com.fan.mvptest.base.di;


import android.support.v7.app.AppCompatActivity;

import com.fan.base.di.ActivityScope;
import com.fan.base.di.component.AppComponent;
import com.fan.base.di.moudle.ActivityModule;
import com.fan.mvptest.ui.activity.MainActivity;

import dagger.Component;


@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface AppActivityComponent {
    AppCompatActivity getActivity();

    void inject(MainActivity activity);

}