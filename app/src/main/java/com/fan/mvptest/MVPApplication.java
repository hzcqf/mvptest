package com.fan.mvptest;


import com.fan.base.CoreApplication;

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
//        DisplayImageOptions defaultOptions = new DisplayImageOptions
//                .Builder()
//                .showImageForEmptyUri(R.mipmap.icon_add_pic)
//                .showImageOnFail(R.mipmap.icon_add_pic)
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .build();

//        ImageLoaderConfiguration config = new ImageLoaderConfiguration
//                .Builder(getApplicationContext())
//                .defaultDisplayImageOptions(defaultOptions)
//                .diskCacheSize(50 * 1024 * 1024)//
//                .diskCacheFileCount(100)//缓存一百张图片
//                .writeDebugLogs()
//                .build();
//        ImageLoader.getInstance().init(config);


    }

    @Override
    protected boolean isDebug() {
        return BuildConfig.IS_DEBUG;
    }
}
