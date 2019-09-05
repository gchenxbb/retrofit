package com.retrofit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.retrofit.imitate.DestCiew;
import com.retrofit.imitate.DyncmicProxy;
import com.retrofit.imitate.InterfaceApi;
import com.retrofit.util.ToastUtil;

public class ImitateActivity extends AppCompatActivity implements View.OnClickListener {
    public final String TAG = "ImitateActivity";
    private Button mBtnDyAgent;
    DyncmicProxy dyncmicProxy;
    InterfaceApi interfaceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imitate);

        mBtnDyAgent = findViewById(R.id.btn_create_agent);
        mBtnDyAgent.setOnClickListener(this);

        //初始化动态代理
        dyncmicProxy = new DyncmicProxy();
        interfaceApi = (InterfaceApi) dyncmicProxy.create(InterfaceApi.class);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_create_agent) {
            String reValue = interfaceApi.invokeMethodTsO("name", 10);
            ToastUtil.showToast(reValue);
            DestCiew destCiew = interfaceApi.invokeMethodTsT("name2", 12);
            destCiew.printInitValue();
        }
    }

}
