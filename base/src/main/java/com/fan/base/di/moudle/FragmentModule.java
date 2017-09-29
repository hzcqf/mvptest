package com.fan.base.di.moudle;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.fan.base.di.FragmentScope;

import dagger.Module;
import dagger.Provides;


@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public AppCompatActivity provideActivity() {
        return (AppCompatActivity) fragment.getActivity();
    }
}