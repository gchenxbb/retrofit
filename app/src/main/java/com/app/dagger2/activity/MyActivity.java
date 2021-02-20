package com.app.dagger2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.dagger2.bean.Student;
import com.retrofit.app.R;


import javax.inject.Inject;


public class MyActivity extends AppCompatActivity  {

    @Inject
    Student mStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        DaggerActivityComponent.
    }

}
