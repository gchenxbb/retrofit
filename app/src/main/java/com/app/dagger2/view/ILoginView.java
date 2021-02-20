package com.app.dagger2.view;

import android.content.Context;

public interface ILoginView {
    void loginSuccess(String msg);
    void loginError(String msg);
}
