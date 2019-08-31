package com.retrofit.util;

import com.retrofit.app.RestfulApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrifitUtil {
    public static String hostLogin = "https://my-json-server.typicode.com";//主机地址
    private Object apiService;//api接口
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public static RetrifitUtil getInstance(){
        return RetrifitUtil.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final RetrifitUtil INSTANCE = new RetrifitUtil();

        private SingletonHolder(){
        }
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

    public RestfulApi getApiService() {
        return (RestfulApi)apiService;
    }

    public void setApiService(Object apiService) {
        this.apiService = apiService;
    }
}
