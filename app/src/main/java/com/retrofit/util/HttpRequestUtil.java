package com.retrofit.util;

import android.util.Log;

import com.retrofit.app.RestfulApi;
import com.retrofit.bean.Comment;
import com.retrofit.bean.GetBean;
import com.retrofit.bean.GetBeanList;
import com.retrofit.bean.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpRequestUtil {


    public static final String TAG = "HttpRequestUtil";
    static RestfulApi api = RetrifitUtil.getInstance().getApiService();

    public static void callGet(final CallBack callBack) {
        Call<GetBeanList> call = api.getItems(0, 10);
        call.enqueue(new Callback<GetBeanList>() {
            @Override
            public void onResponse(Call<GetBeanList> call, Response<GetBeanList> response) {
                if (response.body() != null) {
                    GetBeanList lists = response.body();
                    if (lists != null && lists.getPostdata() != null && lists.getPostdata().size() > 0) {
                        callBack.onListener(true);
                        for (GetBean bean : lists.getPostdata()) {
                            Log.d(TAG, bean.getId() + bean.getTitle());
                        }
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<GetBeanList> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                callBack.onListener(false);
            }
        });
    }

    public static void callPost2(final CallBack callBack) {
        Call<List<Comment>> call = api.getItems(1);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.body() != null) {
                    List<Comment> lists = response.body();
                    if (lists != null && lists.size() > 0) {
                        callBack.onListener(true);
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                callBack.onListener(false);
            }
        });
    }

    public static void callPost3(final CallBack callBack) {
        Call<Post> call = api.postItems(100);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.body() != null) {
                    Post post = response.body();
                    if (post != null && post.getPostId() == 100) {
                        callBack.onListener(true);
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                callBack.onListener(false);
            }
        });
    }

}
