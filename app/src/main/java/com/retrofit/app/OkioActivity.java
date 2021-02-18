package com.retrofit.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;


public class OkioActivity extends AppCompatActivity {
    private TextView mTextView;
    private TextView mTextView2;
    private TextView mTextView3;
    String TAG = "okioActivity";
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okio);
        verifyStoragePermissions(this);


        mEdit = findViewById(R.id.et_text);
        mTextView3 = findViewById(R.id.dis_text);
        mTextView = findViewById(R.id.tv_read);
        mTextView2 = findViewById(R.id.tv_write);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read();
            }
        });

        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write();
            }
        });

    }


    private void read() {
        String fileName = "chente.txt";
        okio.Source source;
        BufferedSource bufferedSource = null;

        try {
            String path = Environment.getExternalStorageDirectory().getPath();
            File file = new File(path, fileName);
            source = Okio.source(file);
            bufferedSource = Okio.buffer(source);

            String read = bufferedSource.readUtf8LineStrict();
            String read2 = bufferedSource.readUtf8LineStrict();
            String read3 = bufferedSource.readUtf8LineStrict();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(read);
            stringBuilder.append(read2);
            stringBuilder.append(read3);

            mTextView3.setText(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedSource) {
                    bufferedSource.close();
                }
            } catch (IOException e) {

            }
        }
    }


    private void write() {
        String fileName = "chente.txt";
        boolean isCreate = false;
        Sink sink;
        BufferedSink bufferedSink = null;
        String path = Environment.getExternalStorageDirectory().getPath();
        try {
            File file = new File(path, fileName);
            if (!file.exists()) {
                isCreate = file.createNewFile();
            } else {
                isCreate = true;
            }

            if (isCreate) {
                sink = Okio.sink(file);
                bufferedSink = Okio.buffer(sink);
//                String writes = mEdit.getText().toString();
                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < 100; i++) {
                    stringBuilder.append("abcdefgh=" + i);
                    stringBuilder.append("\n");
                }

                String writes = stringBuilder.toString();
                if (TextUtils.isEmpty(writes)) {
                    writes = "aaaacccddddd";
                }
                Log.d(TAG, writes.charAt(0) + "");
                bufferedSink.writeUtf8(writes);
                bufferedSink.flush();
                Log.d(TAG, "完成写入！");
                mTextView2.setText("完成写入！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedSink) {
                    bufferedSink.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    public static void verifyStoragePermissions(Activity activity) {
        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
