package com.yeohe.rxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.WindowManager;

import com.yeohe.rxdemo.base.BaseActivity;
import com.yeohe.rxdemo.ui.WXArticle.WXArticleActivity;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/11
 * creator:  LYS
 * 功能描述：
 */

public class AppStartActivity extends BaseActivity {

    public static final String PREF_KEY_FIRST_START = "com.yeohe.proceeds.PREF_KEY_FIRST_START";
    private  boolean isFirstStart;

    private final Handler waitHandler = new Handler();
    private final Runnable waitCallback = new Runnable() {
        @Override
        public void run() {
                Intent intent = new Intent(AppStartActivity.this, WXArticleActivity.class);
                startActivity(intent);
                finish();
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fake wait 2s to simulate some initialization on cold start (never do this in production!)
        beforeInitView();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏

        isFirstStart= PreferenceManager.getDefaultSharedPreferences(AppStartActivity.this)
                .getBoolean(PREF_KEY_FIRST_START, true);

        waitHandler.postDelayed(waitCallback, 3000);

    }

    public void beforeInitView() {
        setContentView(R.layout.activity_appstart);
    }

    @Override
    protected void onDestroy() {
        waitHandler.removeCallbacks(waitCallback);
        super.onDestroy();
    }

    @Override
    protected void initViews() {

    }
}
