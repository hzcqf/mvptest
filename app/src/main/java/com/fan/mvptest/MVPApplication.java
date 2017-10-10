package com.fan.mvptest;


import com.fan.base.CoreApplication;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.litepal.LitePalApplication;


/**
 * Created by Fan. on 2017/9/29.
 */

public class MVPApplication extends CoreApplication {
    private static MVPApplication mInstance = null;

    public static MVPApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
        mInstance = this;

        DisplayImageOptions defaultOptions = new DisplayImageOptions
                .Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .diskCacheSize(50 * 1024 * 1024)//
                .diskCacheFileCount(100)//缓存一百张图片
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);

        //这个还可不可以


    }

    @Override
    protected boolean isDebug() {
        return BuildConfig.IS_DEBUG;
    }
}
