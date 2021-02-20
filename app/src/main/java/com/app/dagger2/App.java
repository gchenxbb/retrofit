package com.app.dagger2;

import android.app.Application;

import com.app.dagger2.component.AppComponent;
import com.app.dagger2.component.DaggerAppComponent;
import com.app.dagger2.module.AppModule;

public class App extends Application {
    public static App instance;
    public static AppComponent appComponent;
    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(instance)).build();
        }
        return appComponent;
    }

}
