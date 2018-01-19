package com.yeohe.rxdemo.ui.gifDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.yeohe.rxdemo.R;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/19
 * creator:  LYS
 * 功能描述：
 */

public class GifDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifdemo);

        final GifMovieView gif1 = (GifMovieView) findViewById(R.id.gif1);
        gif1.setMovieResource(R.drawable.gif_heart);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onGifClick(View v) {
        GifMovieView gif = (GifMovieView) v;
        gif.setPaused(!gif.isPaused());
    }
}
