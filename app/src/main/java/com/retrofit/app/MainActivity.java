package com.retrofit.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Button mBtn;
    RestfulApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = RetrifitUtil.getInstance().getApiService();

        mBtn = findViewById(R.id.btn_retfofit_post);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostBeanList> call = api.postItems(0, 20);
                call.enqueue(new Callback<PostBeanList>() {
                    @Override
                    public void onResponse(Call<PostBeanList> call, Response<PostBeanList> response) {
                        if (response.body() != null) {
                            PostBeanList lists = response.body();
                            if (lists != null && lists.getPostdata() != null && lists.getPostdata().size() > 0) {
                                for (PostBean bean : lists.getPostdata()) {
                                    Log.d(TAG, bean.getId() + bean.getTitle());
                                }
                            }
                        } else {
                        }
                    }

                    @Override
                    public void onFailure(Call<PostBeanList> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
//                Request request = new Request.Builder().url( "https://my-json-server.typicode.com/gchenxbb/jsondata/post?&_start=0&_limit=20").build();
//                OkHttpClient mOkHttpClient= new OkHttpClient.Builder()
//                        .connectTimeout(30, TimeUnit.SECONDS)
//                        .readTimeout(30, TimeUnit.SECONDS)
//                        .writeTimeout(30, TimeUnit.SECONDS).build();
//                okhttp3.Call mCall= mOkHttpClient.newCall(request);
//                mCall.enqueue(new okhttp3.Callback() {
//                    @Override
//                    public void onFailure(okhttp3.Call arg0, IOException arg1) {
//                        Log.d(TAG, "onFailure");
//                    }
//
//                    @Override
//                    public void onResponse(okhttp3.Call arg0, okhttp3.Response arg1) throws IOException {
//                        try {
//                            if (arg1.isSuccessful()) {
//                                String result = arg1.body().string();
//                                Log.d(TAG, result);
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
            }
        });

    }
}
