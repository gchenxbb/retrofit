package com.app.dagger2.component;


import com.app.dagger2.App;
import com.app.dagger2.activity.MyActivity;
import com.app.dagger2.module.ActivityModule;
import com.app.dagger2.module.AppModule;
import com.app.dagger2.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    //向下层提供上下文环境
    App getAContext();
}
