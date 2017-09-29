package com.fan.mvptest.base.di;


import android.support.v7.app.AppCompatActivity;

import com.fan.base.di.FragmentScope;
import com.fan.base.di.component.AppComponent;
import com.fan.base.di.moudle.FragmentModule;

import dagger.Component;


@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface AppFragmentComponent {

    AppCompatActivity getActivity();


}

