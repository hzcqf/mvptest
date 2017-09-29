package com.fan.mvptest.base.mvp;


import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.FragmentEvent;


public interface FragmentView extends MvpView, LifecycleProvider<FragmentEvent> {

}
