package com.retrofit.app;

import com.retrofit.bean.Comment;
import com.retrofit.bean.GetBean;
import com.retrofit.bean.GetBeanList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

//Retrofit接口
public interface RestfulApi {

    @GET("gchenxbb/jsondata/post?")
    Call<GetBeanList> getItems(@Query("_start") int start,
                               @Query("_limit") int limit);

    // Rxjava登陆
    @POST("login?")
    Observable<GetBean> postRxLogin(@Query("key") String appCode,
                                    @Query("phone") String phone,
                                    @Query("passwd") String passwd);

//    接口暂不支持POST
//    @FormUrlEncoded
//    @POST("typicode/demo/comments?")
//    Call<List<Comment>> getItems(@Field("postId") int postId);

    @GET("typicode/demo/comments?")
    Call<List<Comment>> getItems(@Query("postId") int postId);

}
