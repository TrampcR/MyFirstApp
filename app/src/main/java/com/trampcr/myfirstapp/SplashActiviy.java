package com.trampcr.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by zxm on 2016/7/12.
 */
public class SplashActiviy extends Activity {

    private Handler mHandler;
    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mHandler = new Handler();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String name = mTvName.getText().toString();
                Intent intent = new Intent(SplashActiviy.this, MainActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
