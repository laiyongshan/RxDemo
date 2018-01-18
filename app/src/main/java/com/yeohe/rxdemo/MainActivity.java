package com.yeohe.rxdemo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.yeohe.rxdemo.adapter.TypeAdapter;
import com.yeohe.rxdemo.ui.WXArticle.WXArticleActivity;
import com.yeohe.rxdemo.ui.ari.AriActivity;
import com.yeohe.rxdemo.ui.boxoffice.BoxOfficeActivity;
import com.yeohe.rxdemo.ui.exchange.RateActivity;
import com.yeohe.rxdemo.ui.lottery.LotteryActivity;
import com.yeohe.rxdemo.ui.mobileAddress.MobileAddressActivity;
import com.yeohe.rxdemo.ui.postCode.PostCodeActivitry;
import com.yeohe.rxdemo.ui.share.ShareDemoActivity;
import com.yeohe.rxdemo.ui.tiku.TikuActivity;
import com.yeohe.rxdemo.utils.ToastUtil;
import com.yeohe.rxdemo.widgets.MyGridView;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.checkSelfPermission;

public class MainActivity extends AppCompatActivity {

    private MyGridView gv_type;//新增功能按钮
    private ArrayList<Integer> types;
    private TypeAdapter typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData(this);
    }


    Intent intent;
    private void initData(final Context context){
        gv_type=findViewById(R.id.gv_type);
        String[] type_strArr = {"手机号码归属地", "邮编查询", "空气质量", "驾考题库", "电影票房", "货币汇率","彩票开奖结果","微信精选","分享Demo"};
        types = new ArrayList<Integer>();
        types.add(R.drawable.ic_launcher_foreground);//手机号码归属地
        types.add(R.drawable.ic_launcher_foreground);//邮编查询
        types.add(R.drawable.ic_launcher_foreground);//空气质量
        types.add(R.drawable.ic_launcher_foreground);//驾考题库
        types.add(R.drawable.ic_launcher_foreground);//电影票房
        types.add(R.drawable.ic_launcher_foreground);//货币汇率
        types.add(R.drawable.ic_launcher_foreground);//彩票开奖结果
        types.add(R.drawable.ic_launcher_foreground);//微信精选
        types.add(R.drawable.ic_launcher_foreground);//Android系统分享Demo
        typeAdapter = new TypeAdapter(types, context, type_strArr, 2);
        gv_type.setAdapter(typeAdapter);
        gv_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        intent=new Intent(MainActivity.this, MobileAddressActivity.class);
                        break;

                    case 1:
                        intent=new Intent(MainActivity.this, PostCodeActivitry.class);
                        break;

                    case 2:
                        intent=new Intent(MainActivity.this, AriActivity.class);
                        break;

                    case 3:
                        intent=new Intent(MainActivity.this, TikuActivity.class);
                        break;

                    case 4:
                        intent=new Intent(MainActivity.this, BoxOfficeActivity.class);
                        break;
                    case 5:
                        intent=new Intent(MainActivity.this, RateActivity.class);
                        break;

                    case 6:
                        intent=new Intent(MainActivity.this, LotteryActivity.class);
                        break;

                    case 7:
                        intent=new Intent(MainActivity.this, WXArticleActivity.class);
                        break;

                    case 8:
                        intent=new Intent(MainActivity.this, ShareDemoActivity.class);
                        break;
                }

                startActivity(intent);

            }
        });
    }



    //退出时的时间
    private long mExitTime;
    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            ToastUtil.showMessage(MainActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT);
            mExitTime = System.currentTimeMillis();
        } else {
//            MyConfig.clearSharePre(this, "users");
            finish();
            System.exit(0);
        }
    }

}
