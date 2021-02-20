package com.app.dagger2.presenter;

import android.util.Log;

import com.app.dagger2.bean.LoginInfo;
import com.app.dagger2.scope.ActivityScope;
import com.app.dagger2.view.ILoginView;

import javax.inject.Inject;

public class LoginPresenter {
    String TAG = getClass().getSimpleName();
    ILoginView iLoginView;
    private long id;
    private String userName;

    //注入对象用Inject标注
    @Inject
    public LoginPresenter(ILoginView iView, long id, String userName) {
        this.iLoginView = iView;
        this.id = id;
        this.userName = userName;
    }

    public void login(LoginInfo user) {
        Log.d(TAG, id + "_" + userName);
        iLoginView.loginSuccess("登陆成功!");
    }
}
