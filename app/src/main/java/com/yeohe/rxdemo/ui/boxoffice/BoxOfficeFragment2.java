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
import com.yeohe.rxdemo.adapter.BoxAdapter2;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.BaseFragment;
import com.yeohe.rxdemo.bean.BoxBean1;
import com.yeohe.rxdemo.bean.BoxBean2;
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

public class BoxOfficeFragment2 extends BaseFragment {

    private View view;
    private RecyclerView box_rv2;
    private SwipeRefreshLayout refreshlayout2;
    private BoxAdapter2 boxAdapter2;
    private List<BoxBean2.ResultEntity> datas;

    protected static BoxOfficeFragment2 getinstance(){
        return  new BoxOfficeFragment2();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_boxoffice2,null);
        initViews();
        initSwipeRefreshLayout();
        initAdapter();
        getData();
        return view;
    }

    private void initViews(){
        box_rv2=view.findViewById(R.id.box_rv2);
        box_rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initSwipeRefreshLayout(){
        refreshlayout2=view.findViewById(R.id.refreshlayout2);
        refreshlayout2.setColorSchemeColors(Color.GREEN,Color.BLUE);
        refreshlayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        refreshlayout2.setRefreshing(true);
    }

    private void initAdapter(){
        datas=new ArrayList<>();
        boxAdapter2=new BoxAdapter2();
        boxAdapter2.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        });

        boxAdapter2.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        box_rv2.setAdapter(boxAdapter2);

    }

    //初始化数据
    private void getData(){
        loadingDialog.show();
        Observable<BoxBean2> observable= MainAPIServiceImp.getWeekboxoffice(Constact.APP_KEY,"CN");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BoxBean2>() {
            @Override
            public void onCompleted() {
                dismissLoading();
                boxAdapter2.setEnableLoadMore(true);
                refreshlayout2.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                dismissLoading();
                boxAdapter2.setEnableLoadMore(true);
                refreshlayout2.setRefreshing(false);
            }

            @Override
            public void onNext(BoxBean2 boxBean2) {
                setData(true, boxBean2.getResult());

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
            boxAdapter2.setNewData(datas);
        } else {
            if (size > 0) {
                boxAdapter2.addData(datas);
            }
        }
        if (size < PAGE_SIZE) {
            //第一页如果不够一页就不显示没有更多数据布局
            boxAdapter2.loadMoreEnd(false);
//            Toast.makeText(getActivity(), "no more data", Toast.LENGTH_SHORT).show();
        } else {
            boxAdapter2.loadMoreComplete();
            boxAdapter2.loadMoreEnd(false);
        }
    }

}
