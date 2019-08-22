package com.retrofit.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private String loginKey = "00d91e8e0cca2b76f515926a36db68f5";
    private String phone = "13594347817";
    private String passwd = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestfulApi api = RetrifitUtil.getInstance().getApiService();
        Call<LoginBean> call = api.postLogin(loginKey,
                phone,
                passwd);
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                    if (response.body() != null) {
                        LoginBean bean = response.body();
                        Log.d(TAG, bean.getMsg() + bean.getCode());
                    } else {
                    }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
