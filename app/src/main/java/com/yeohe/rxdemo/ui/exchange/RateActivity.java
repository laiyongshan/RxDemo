package com.yeohe.rxdemo.ui.exchange;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.adapter.RateAdapter;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.Constact;
import com.yeohe.rxdemo.bean.RateBean;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/10
 * creator:  LYS
 * 功能描述：
 */

public class RateActivity extends AppCompatActivity {

    private ImageView img_back;
    private RecyclerView the_rate_rv;
    private RateAdapter rateAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        initBankDatas();
        initViews();
        initAdapter();

        getRateData("0");
    }

    private void initViews(){
        img_back=findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        the_rate_rv=findViewById(R.id.the_rate_rv);
        the_rate_rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter(){
        rateAdapter=new RateAdapter();
        the_rate_rv.setAdapter(rateAdapter);
        rateAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
    }

    //获取银行汇率数据
    private void getRateData(String bankId){
        Observable<RateBean> observable=MainAPIServiceImp.getRate(Constact.APP_KEY,bankId);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<RateBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RateBean rateBean) {
                setData(rateBean.getResult());
            }
        });
    }

    private void setData(List datas){
        final int size = datas == null ? 0 : datas.size();
        rateAdapter.setNewData(datas);
    }


    private void initBankDatas(){
        MaterialSpinner spinner=findViewById(R.id.spinner);
        spinner.setItems("工商银行","招商银行","建设银行","中国银行","交通银行","农业银行");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, int i, long l, Object o) {
                switch (i){
                    case 0:
                        getRateData("0");
                        break;

                    case 1:
                        getRateData("1");
                        break;

                    case 2:
                        getRateData("2");
                        break;

                    case 3:
                        getRateData("3");
                        break;

                    case 4:
                        getRateData("4");
                        break;

                    case 5:
                        getRateData("5");
                        break;

                    default:
                        break;
                }
            }
        });

    }

}
