package com.moyu.dingbuxuanfuproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.moyu.dingbuxuanfuproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SimpleStick(View view) {
        startActivity(new Intent(this, SimpleStickActivity.class));
    }

    public void StickPullRefresh(View view) {
        startActivity(new Intent(this, PullToRefreshStickActivity.class));
    }

    public void TopViewOverOne(View view) {
        startActivity(new Intent(this, TopViewOverOneScreenActivity.class));
    }

    public void SwipeRefresh(View view) {
        startActivity(new Intent(this, SwipeRefreshLayoutActivity.class));
    }

    public void onClickTopOperate(View view) {
        startActivity(new Intent(this, TopOperateActivity.class));
    }

}
