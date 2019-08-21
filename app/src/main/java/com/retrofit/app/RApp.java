package com.retrofit.app;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RApp extends Application {
    public static String hostLogin = "https://www.apiopen.top";//登陆主机地址

    private Object apiService;//api接口

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrifitUtil.getInstance().init();

        OkHttpClient.Builder httpBuilder = new OkHttpClient().newBuilder();
        httpBuilder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        okHttpClient = httpBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(hostLogin)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        apiService = retrofit.create(RestfulApi.class);
    }
}
