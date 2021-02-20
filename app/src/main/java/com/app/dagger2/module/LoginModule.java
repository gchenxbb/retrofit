package com.app.dagger2.module;

import com.app.dagger2.presenter.LoginPresenter;
import com.app.dagger2.scope.ActivityScope;
import com.app.dagger2.view.ILoginView;

import java.util.Random;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private ILoginView iView;

    public LoginModule(ILoginView iView) {
        this.iView = iView;
    }

    @Provides
    @ActivityScope
    public ILoginView provideILoginView() {
        return this.iView;
    }

    @Provides
    @ActivityScope
    public long getId() {
        return new Random().nextLong();
    }

    @Provides
    @ActivityScope
    public String getUserName() {
        return String.valueOf(new Random().nextInt(100));
    }

    //让LoginPresenter单例
    @Provides
    @ActivityScope
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter(this.iView, 10, "102");
    }

}
