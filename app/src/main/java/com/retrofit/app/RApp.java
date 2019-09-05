package com.retrofit.app;

import android.app.Application;
import android.content.Context;

import com.retrofit.util.RetrifitUtil;

public class RApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrifitUtil.getInstance().init();
        mContext = getApplicationContext();
    }

    public static Context getmContext() {
        return mContext;
    }
}
