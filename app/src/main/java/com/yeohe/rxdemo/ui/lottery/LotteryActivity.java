package com.yeohe.rxdemo.ui.lottery;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.adapter.AwardAdapter;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.BaseActivity;
import com.yeohe.rxdemo.base.Constact;
import com.yeohe.rxdemo.bean.AWardBean;
import com.yeohe.rxdemo.bean.LotteryTypeBean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/16
 * creator:  LYS
 * 功能描述：
 */

public class LotteryActivity extends BaseActivity {

    private ImageView img_back;
    private MaterialSpinner period_spinner,lottery_spinner;
    private TextView pool_tv,sales_tv,awardDateTime_tv;

    private TextView awardNumber_1,awardNumber_2,awardNumber_3,awardNumber_4,awardNumber_5,awardNumber_6,awardNumber_7;
    private List<TextView> awardnums=new ArrayList<TextView>();

    private RecyclerView awards_rv;

    private AwardAdapter awardAdapter;

    private List<String> period_list=new ArrayList<String>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);

        initViews();
        initAdapter();
        getLotteryData();
        getAwardData("双色球");
    }

    public void initViews(){
        img_back=findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        period_spinner=findViewById(R.id.period_spinner);
        lottery_spinner=findViewById(R.id.lottery_spinner);
        lottery_spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, int i, long l, Object o) {
                switch (i){
                    case 0:
                        awardNumber_6.setBackgroundColor(Color.RED);
                        getAwardData("双色球");
                        break;

                    case 1:
                        awardNumber_6.setBackgroundColor(Color.BLUE);
                        getAwardData("大乐透");
                        break;
                }
            }
        });
        pool_tv=findViewById(R.id.pool_tv);
        sales_tv=findViewById(R.id.sales_tv);
        awardDateTime_tv=findViewById(R.id.awardDateTime_tv);

        awardNumber_1=findViewById(R.id.awardNumber_1);
        awardnums.add(awardNumber_1);
        awardNumber_2=findViewById(R.id.awardNumber_2);
        awardnums.add(awardNumber_2);
        awardNumber_3=findViewById(R.id.awardNumber_3);
        awardnums.add(awardNumber_3);
        awardNumber_4=findViewById(R.id.awardNumber_4);
        awardnums.add(awardNumber_4);
        awardNumber_5=findViewById(R.id.awardNumber_5);
        awardnums.add(awardNumber_5);
        awardNumber_6=findViewById(R.id.awardNumber_6);
        awardnums.add(awardNumber_6);
        awardNumber_7=findViewById(R.id.awardNumber_7);
        awardnums.add(awardNumber_7);

        awards_rv=findViewById(R.id.awards_rv);
        awards_rv.setLayoutManager(new LinearLayoutManager(LotteryActivity.this));
    }




    private void  initAdapter(){
        awardAdapter=new AwardAdapter();
        awardAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
    }

    //获取彩票种类数据
    private void getLotteryData(){
        progressDialog.show();
        Observable<LotteryTypeBean> observable= MainAPIServiceImp.getLotteryType(Constact.APP_KEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LotteryTypeBean>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onNext(LotteryTypeBean lotteryTypeBean) {
                        setLotteryData(lotteryTypeBean.getResult());
                    }
                });
    }

    //获取中奖情况数据
    private void getAwardData(String name){
        progressDialog.show();
        Observable<AWardBean> observable= MainAPIServiceImp.getAwardDetail(Constact.APP_KEY,name);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AWardBean>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onNext(AWardBean aWardBean) {
                        setAWardTv(aWardBean.getResult().getLotteryNumber());
                        pool_tv.setText("奖金池金额："+(int)aWardBean.getResult().getPool()+"￥");
                        sales_tv.setText("销售金额："+(int)aWardBean.getResult().getSales()+"￥");
                        awardDateTime_tv.setText("开奖时间："+aWardBean.getResult().getAwardDateTime());

                        setAwardData(aWardBean.getResult().getLotteryDetails());

                        period_list.clear();
                        period_list.add(aWardBean.getResult().getPeriod()+"");
                        period_spinner.setItems(period_list);
                    }
                });
    }

    private void setLotteryData(List<String> datas){
        datas=new ArrayList<String>();
        datas.add("双色球");
        datas.add("大乐透");
        lottery_spinner.setItems(datas);
    }


    private void setAwardData(List datas){
        awardAdapter.setNewData(datas);
        awards_rv.setAdapter(awardAdapter);

    }

    private void setAWardTv(List datas){
        for (int i=0;i<datas.size();i++) {
            awardnums.get(i).setText((String) datas.get(i)+"");
        }
    }



}
