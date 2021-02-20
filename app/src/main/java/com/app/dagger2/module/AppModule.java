package com.app.dagger2.module;


import com.app.dagger2.App;
import com.app.dagger2.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    public final App application;

    public AppModule(App application) {
        this.application = application;
    }

    //负责提供getAContext的App对象
    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }
}
