package com.yeohe.rxdemo.ui.tiku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.base.BaseActivity;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/4
 * creator:  LYS
 * 功能描述：
 */
public class TikuActivity extends BaseActivity implements View.OnClickListener{

    private Button  class_one_btn,class_four_btn,one_by_one_btn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackArrow();
        setTitle("驾考题库");
        setContentLayout(R.layout.activity_tiku);
        initViews();
    }

    @Override
    protected void initViews() {
        class_one_btn=findViewById(R.id.class_one_btn);
        class_four_btn=findViewById(R.id.class_four_btn);
        one_by_one_btn=findViewById(R.id.one_by_one_btn);

    }

    Intent intent;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.class_one_btn:
                intent=new Intent(TikuActivity.this,ClassOneActivity.class);
                break;

            case R.id.class_four_btn:
                intent=new Intent(mContext,ClassFourActivity.class);
                break;

            case R.id.one_by_one_btn:
                intent=new Intent(mContext,OneByOneActivity.class);
                break;
        }

        startActivity(intent);
    }
}
