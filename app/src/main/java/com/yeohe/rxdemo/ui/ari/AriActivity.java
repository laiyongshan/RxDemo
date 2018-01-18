package com.yeohe.rxdemo.ui.ari;

import android.os.Bundle;
import android.widget.Toast;

import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.base.BaseActivity;

import ren.qinc.numberbutton.NumberButton;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/17
 * creator:  LYS
 * 功能描述：
 */

public class AriActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackArrow();
        setTitle("空气质量");
        setContentLayout(R.layout.activity_ari);

        initViews();

    }

    protected void initViews() {
        NumberButton numberButton = (NumberButton) findViewById(R.id.number_button);
        //assert numberButton != null;
        numberButton.setBuyMax(5)
                .setInventory(6)
                .setCurrentNumber(0)
                .setOnWarnListener(new NumberButton.OnWarnListener() {
                    @Override
                    public void onWarningForInventory(int inventory) {
                        Toast.makeText(AriActivity.this, "当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMax(int buyMax) {
                        Toast.makeText(AriActivity.this, "超过最大购买数:" + buyMax, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
