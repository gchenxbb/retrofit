package com.retrofit.imitate;


import android.util.Log;

/**
 * 动态代理接口返回对象，通过adapter生成
 */
public class DestCiew {
    public static String TAG = "DestCiew";
    String initValue;

    public DestCiew(String initValue) {
        this.initValue = initValue;
    }

    //做事情
    public void printInitValue() {
        Log.d(TAG, initValue);
    }

}
