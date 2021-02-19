package com.retrofit.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.retrofit.app.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends Activity {

    @BindView(R.id.tv_hello_butter)
    TextView tvHelloButter;

    @BindString(R.string.str_hi_butterknife)
    String butter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_hello_butter)
    public void onViewClicked() {
    }
}
