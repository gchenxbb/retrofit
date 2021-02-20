package com.app.dagger2.component;


import com.app.dagger2.activity.LoginActivity;
import com.app.dagger2.module.LoginModule;
import com.app.dagger2.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
