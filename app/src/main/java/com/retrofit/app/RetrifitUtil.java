package com.retrofit.app;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yuan on 2019/8/22.
 */

public class RetrifitUtil {

    public static String hostLogin = "https://www.apiopen.top";//登陆主机地址

    private Object apiService;//api接口

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public static RetrifitUtil getInstance(){
        return Holder.retrifitUtil;
    }

    public static class Holder{
        public static RetrifitUtil retrifitUtil = new RetrifitUtil();
    }

    public void init(){

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
