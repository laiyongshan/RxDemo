package com.yeohe.rxdemo.ui.boxoffice;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.adapter.BoxAdapter1;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.BaseFragment;
import com.yeohe.rxdemo.bean.BoxBean1;
import com.yeohe.rxdemo.base.Constact;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/3.
 */
public class BoxOfficeFragment1 extends BaseFragment {

    private View view;
    private RecyclerView box_rv1;
    private SwipeRefreshLayout refreshlayout1;
    private BoxAdapter1 boxAdapter1;
    private List<BoxBean1.ResultEntity> datas;

    protected static BoxOfficeFragment1 getinstance(){
        return  new BoxOfficeFragment1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_boxoffice1,null);
        initViews();
        initAdapter();
        initSwipeRefush();
        refresh();
        return view;
    }


    //初始化控件
    private  void initViews(){
        box_rv1=view.findViewById(R.id.box_rv1);
        box_rv1.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initSwipeRefush(){
        refreshlayout1=view.findViewById(R.id.refreshlayout1);
        refreshlayout1.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW);
        refreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        refreshlayout1.setRefreshing(true);
    }

    private void initAdapter(){
        datas=new ArrayList<>();
        boxAdapter1=new BoxAdapter1(datas);
        boxAdapter1.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        });

        boxAdapter1.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        box_rv1.setAdapter(boxAdapter1);

    }

    //初始化数据
    private void refresh(){
        loadingDialog.show();
        boxAdapter1.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        Observable<BoxBean1> observable= MainAPIServiceImp.getDayboxoffice(Constact.APP_KEY,"CN");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BoxBean1>() {
            @Override
            public void onCompleted() {
                dismissLoading();
                boxAdapter1.setEnableLoadMore(true);
                refreshlayout1.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                dismissLoading();
                boxAdapter1.setEnableLoadMore(true);
                refreshlayout1.setRefreshing(false);
            }

            @Override
            public void onNext(BoxBean1 boxBean1) {
                setData(true, boxBean1.getResult());
            }
        });
    }

    //加载更多
    private void loadMore(){

    }

    private static final int PAGE_SIZE = 6;
    private void setData(Boolean isRefresh, List datas){
        final int size = datas == null ? 0 : datas.size();
        if (isRefresh) {
            boxAdapter1.setNewData(datas);
        } else {
            if (size > 0) {
                boxAdapter1.addData(datas);
            }
        }
        if (size < PAGE_SIZE) {
            //第一页如果不够一页就不显示没有更多数据布局
            boxAdapter1.loadMoreEnd(false);
//            Toast.makeText(getActivity(), "no more data", Toast.LENGTH_SHORT).show();
        } else {
            boxAdapter1.loadMoreComplete();
            boxAdapter1.loadMoreEnd(false);
        }
    }

}