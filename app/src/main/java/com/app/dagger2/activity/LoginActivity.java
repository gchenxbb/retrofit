package com.app.dagger2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.app.dagger2.bean.LoginInfo;
import com.app.dagger2.component.DaggerLoginComponent;
import com.app.dagger2.module.LoginModule;
import com.app.dagger2.presenter.LoginPresenter;
import com.app.dagger2.view.ILoginView;
import com.retrofit.app.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Inject
    LoginPresenter mLoginPresenter;
    //配置生产LoginPresenter单例，因此两者指向同一个对象
    @Inject
    LoginPresenter mLoginPresenter2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);

    }

    @Override
    public void loginSuccess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError(String msg) {

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        mLoginPresenter.login(new LoginInfo());
        mLoginPresenter2.login(new LoginInfo());
        startActivity(new Intent(LoginActivity.this, MyActivity.class));
//        registerImpl.register();
    }

}
