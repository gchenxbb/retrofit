package com.retrofit.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.retrofit.bean.Comment;
import com.retrofit.bean.GetBean;
import com.retrofit.bean.GetBeanList;
import com.retrofit.character.CharacterUtil;
import com.retrofit.util.CallBack;
import com.retrofit.util.HttpRequestUtil;
import com.retrofit.util.RetrifitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CallBack {
    public final String TAG = "MainActivity";
    private Button mBtnPost;
    private Button mBtnGet;

    char a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuilder sb = new StringBuilder();
        //输出ASICC码，84,101,115,116,65
        String str = "TestA";
        for (int i = 0; i < str.length(); i++) {
            sb.append(CharacterUtil.codePointAt(str, i));
            if (i != str.length() - 1) {
                sb.append("-");
            }
        }
        showToast(sb.toString());

        mBtnPost = findViewById(R.id.btn_retfofit_post);
        mBtnGet = findViewById(R.id.btn_retfofit_get);
        mBtnGet.setOnClickListener(this);
        mBtnPost.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_retfofit_get) {
            HttpRequestUtil.callGet(this);
        } else if (id == R.id.btn_retfofit_post) {
            HttpRequestUtil.callPost(this);
        }

    }

    @Override
    public void onListener(boolean isSuccess) {
        if (isSuccess) {
            showToast("请求成功！");
        } else {
            showToast("请求失败！");
        }
    }

    public void showToast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
