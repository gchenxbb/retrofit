package com.retrofit.app;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrifitUtil.getInstance().init();
    }
}
