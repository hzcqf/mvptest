package com.fan.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.Utils;
import com.fan.base.di.component.AppComponent;
import com.fan.base.di.component.DaggerAppComponent;
import com.fan.base.di.moudle.AppModule;
import com.jiahuaandroid.basetools.utils.CUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;



/**
 * Created by ganzhubing on 2017/9/6.
 */
public abstract class CoreApplication extends MultiDexApplication {
    private static CoreApplication instance;

    public static CoreApplication getInstance() {
        return instance;
    }

    private static final String TAG = CoreApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        CrashHandler.getInstance().init(instance);
        //工具加载
        CUtils.init(this);
        Utils.init(this);

        ARouter.init(this);

    }

    protected void initLog() {
        if (!isDebug()) {
            return;
        }
        ARouter.openLog();
        ARouter.openDebug();
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
//                .methodCount(0)         // (Optional) How many method line to show. Default 2
//                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(AppUtils.getAppPackageName())   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();


        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isDebug();
            }
        });
    }

    protected abstract boolean isDebug();

    public static AppComponent getAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

    /**
     * 读取上下文储存相关信息
     *
     * @param key
     * @return
     */
    public String getContextInfoString(String key) {
        SharedPreferences preferences = getApplicationContext()
                .getSharedPreferences(TAG, Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

}
