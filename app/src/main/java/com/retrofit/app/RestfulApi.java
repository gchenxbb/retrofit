package com.retrofit.app;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

//Retrofit接口
public interface RestfulApi {

    @GET("gchenxbb/jsondata/post?")
    Call<PostBeanList> postItems(@Query("_start") int start,
                                   @Query("_limit") int limit);

    // Rxjava登陆
    @POST("login?")
    Observable<PostBean> postRxLogin(@Query("key") String appCode,
                                     @Query("phone") String phone,
                                     @Query("passwd") String passwd);

}
