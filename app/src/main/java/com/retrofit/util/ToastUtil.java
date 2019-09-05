package com.retrofit.util;

import android.widget.Toast;

import com.retrofit.app.RApp;

public class ToastUtil {
    public static void showToast(String msg) {
        Toast.makeText(RApp.getmContext(), msg, Toast.LENGTH_LONG).show();
    }
}
