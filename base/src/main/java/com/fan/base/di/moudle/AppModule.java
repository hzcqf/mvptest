package com.fan.base.di.moudle;

import com.fan.base.CoreApplication;
import com.fan.base.di.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {
    private final CoreApplication application;

    public AppModule(CoreApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    CoreApplication provideApplicationContext() {
        return application;
    }
    
}
