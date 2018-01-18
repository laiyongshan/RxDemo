package com.yeohe.rxdemo.ui.mobileAddress;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.BaseActivity;
import com.yeohe.rxdemo.base.Constact;
import com.yeohe.rxdemo.bean.MobileAddressBean;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/3.
 */

public class MobileAddressActivity extends BaseActivity {

    private EditText phone_et;
    private Button serchea_btn;
    private TextView result_tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_mobile_address);
        setTitle("手機號碼歸屬地查詢");
        setBackArrow();

        initViews();
    }

    protected void initViews() {
        phone_et=findViewById(R.id.phone_et);
        result_tv=findViewById(R.id.result_tv);
        serchea_btn=findViewById(R.id.serchea_btn);
        serchea_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                Observable<MobileAddressBean> observable= MainAPIServiceImp.getMobileAddress(Constact.APP_KEY,phone_et.getText().toString().trim());
                observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MobileAddressBean>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onNext(MobileAddressBean mobileAddressBean) {
                        if(mobileAddressBean.getMsg().equals("success")){
                            result_tv.setText("所属城市:"+mobileAddressBean.getResult().getProvince()+mobileAddressBean.getResult().getCity()+"\n"
                            +"所属运营商："+mobileAddressBean.getResult().getOperator()+"\n"
                                    +"邮编号码："+mobileAddressBean.getResult().getZipCode()+"\n"
                            );
                            result_tv.setTextColor(Color.BLACK);
                        }else{
                            result_tv.setText("");
                            result_tv.setText(mobileAddressBean.getMsg());
                            result_tv.setTextColor(Color.RED);
                        }
                    }
                });
            }
        });
    }
}
