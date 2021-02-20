package com.app.dagger2.component;

import android.app.Activity;

import com.app.dagger2.activity.MyActivity;
import com.app.dagger2.module.ActivityModule;
import com.app.dagger2.scope.ActivityScope;
import dagger.Component;

//Component和他所依赖的Component不能公用相同的Scope
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    //将当前的activity暴露出去
   Activity getAActivity();

    void inject(MyActivity myActivity);

}
