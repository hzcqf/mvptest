package com.fan.base.di.component;

import com.fan.base.CoreApplication;
import com.fan.base.di.ContextLife;
import com.fan.base.di.moudle.AppModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    /**
     * @return 提供AppApplication
     */
    @ContextLife("Application")
    CoreApplication getContext();

//    DaoSession daoSessionHHelper();

}
