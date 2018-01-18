package com.yeohe.rxdemo.ui.postCode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.base.BaseActivity;

/**
 * Created by Administrator on 2018/1/3.
 */

public class PostCodeActivitry extends BaseActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackArrow();
        setTitle("邮编查询");
        setContentLayout(R.layout.activity_postcode);

    }

    protected void initViews() {

    }
}
