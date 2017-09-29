package com.fan.mvptest.base.mvp;


import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;


public interface ActivityView extends MvpView, LifecycleProvider<ActivityEvent> {

}
