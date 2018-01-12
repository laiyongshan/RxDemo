package com.yeohe.rxdemo.ui.web;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yeohe.rxdemo.R;

import cn.droidlover.xstatecontroller.XStateController;


/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/5
 * creator:  LYS
 * 功能描述：WebView
 */

public class WebActivity extends AppCompatActivity {

    private View view;
    private WebView collection_wv;
    private SwipeRefreshLayout swipeRefreshLayout;
    private XStateController contentLayout;

    private ImageView back;
    private TextView title;

    String url="";//
    String tileStr="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        url= getIntent().getStringExtra("url");
        tileStr=getIntent().getStringExtra("title");

        initViews();
        initContentLayout();
        initRefreshLayout();
        initWebView();

        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title = (TextView) findViewById(R.id.title);
        if(tileStr!=null)
            title.setText(tileStr);
        else
            title.setText("WA");
    }

    private void initViews(){
        collection_wv= (WebView) findViewById(R.id.collection_webView);
        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        contentLayout= (XStateController) findViewById(R.id.contentLayout);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && collection_wv.canGoBack()) {
            collection_wv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void initContentLayout() {
        contentLayout.loadingView(View.inflate(WebActivity.this, R.layout.view_loading, null));
    }

    private void initRefreshLayout() {
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                collection_wv.loadUrl(url);
            }
        });

    }


    private void initWebView() {
        collection_wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    swipeRefreshLayout.setRefreshing(false);
                    if (contentLayout != null)
                        contentLayout.showContent();
                    if (collection_wv != null)
                        url = collection_wv.getUrl();
                } else {
                    if (contentLayout != null)
                        contentLayout.showLoading();
                }
            }
        });
        collection_wv.setWebViewClient(new WebViewClient());
        collection_wv.getSettings().setBuiltInZoomControls(true);
        collection_wv.getSettings().setJavaScriptEnabled(true);
        collection_wv.getSettings().setDomStorageEnabled(true);
        collection_wv.getSettings().setDatabaseEnabled(true);
        collection_wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        collection_wv.getSettings().setLoadWithOverviewMode(true);
        collection_wv.getSettings().setAppCacheEnabled(true);
        //设置视图客户端
        collection_wv.setWebViewClient(new MyWebViewClient());

        collection_wv.loadUrl(url);
    }


    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }


        @Override
        public void onPageFinished(WebView view, String url) {
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            Toast.makeText(WebActivity.this, "请检查网络连接设置！", Toast.LENGTH_LONG).show();
        }
    }


}
