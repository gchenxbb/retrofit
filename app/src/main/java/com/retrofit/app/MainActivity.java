package com.retrofit.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.retrofit.character.CharacterUtil;
import com.retrofit.imitate.DestCiew;
import com.retrofit.imitate.DyncmicProxy;
import com.retrofit.imitate.InterfaceApi;
import com.retrofit.util.CallBack;
import com.retrofit.util.HttpRequestUtil;
import com.retrofit.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CallBack {
    public final String TAG = "MainActivity";
    private Button mBtnPost;
    private Button mBtnGet;
    private Button btn_imitate;

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
        ToastUtil.showToast(sb.toString());

        mBtnPost = findViewById(R.id.btn_retfofit_post);
        mBtnGet = findViewById(R.id.btn_retfofit_get);
        btn_imitate = findViewById(R.id.btn_imitate);
        mBtnGet.setOnClickListener(this);
        mBtnPost.setOnClickListener(this);
        btn_imitate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_retfofit_get) {
            HttpRequestUtil.callGet(this);
        } else if (id == R.id.btn_retfofit_post) {
            HttpRequestUtil.callPost3(this);
        } else if (id == R.id.btn_imitate) {
            startActivity(new Intent(MainActivity.this, ImitateActivity.class));
        }
    }

    @Override
    public void onListener(boolean isSuccess) {
        if (isSuccess) {
            ToastUtil.showToast("请求成功！");
        } else {
            ToastUtil.showToast("请求失败！");
        }
    }


}
