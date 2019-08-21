package com.retrofit.app;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

//Retrofit接口
public interface RestfulApi {

    // 登陆
    @POST("login?")
    Call<LoginBean> postLogin(@Query("key") String appCode,
                              @Query("phone") String phone,
                              @Query("passwd") String passwd);

    // Rxjava登陆
    @POST("login?")
    Observable<LoginBean> postRxLogin(@Query("key") String appCode,
                                      @Query("phone") String phone,
                                      @Query("passwd") String passwd);

}
