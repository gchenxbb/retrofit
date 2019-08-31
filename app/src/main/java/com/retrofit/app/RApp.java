package com.retrofit.app;

import android.app.Application;

import com.retrofit.util.RetrifitUtil;

public class RApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrifitUtil.getInstance().init();
    }
}
