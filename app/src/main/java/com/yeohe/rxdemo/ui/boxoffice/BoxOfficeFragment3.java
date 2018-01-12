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
import com.yeohe.rxdemo.adapter.BoxAdapter2;
import com.yeohe.rxdemo.adapter.BoxAdapter3;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.BaseFragment;
import com.yeohe.rxdemo.bean.BoxBean2;
import com.yeohe.rxdemo.bean.BoxBean3;
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

public class BoxOfficeFragment3 extends BaseFragment {

    private View view;
    private RecyclerView box_rv3;
    private SwipeRefreshLayout refreshlayout3;
    private BoxAdapter3 boxAdapter3;
    private List<BoxBean3.ResultEntity> datas;

    protected static BoxOfficeFragment3 getinstance(){
        return  new BoxOfficeFragment3();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_boxoffice3,null);
        initViews();
        initSwipeRefreshLayout();
        initAdapter();
        getData();
        return view;
    }



    private void initViews(){
        box_rv3=view.findViewById(R.id.box_rv3);
        box_rv3.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initSwipeRefreshLayout(){
        refreshlayout3=view.findViewById(R.id.refreshlayout3);
        refreshlayout3.setColorSchemeColors(Color.GREEN,Color.BLUE);
        refreshlayout3.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        refreshlayout3.setRefreshing(true);
    }

    private void initAdapter(){
        datas=new ArrayList<>();
        boxAdapter3=new BoxAdapter3();
        boxAdapter3.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        });

        boxAdapter3.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        box_rv3.setAdapter(boxAdapter3);

    }


    //初始化数据
    private void getData(){
        loadingDialog.show();
        Observable<BoxBean3> observable= MainAPIServiceImp.getWeekendboxoffice(Constact.APP_KEY,"CN");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BoxBean3>() {
            @Override
            public void onCompleted() {
                dismissLoading();
                boxAdapter3.setEnableLoadMore(true);
                refreshlayout3.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                dismissLoading();
                boxAdapter3.setEnableLoadMore(true);
                refreshlayout3.setRefreshing(false);
            }

            @Override
            public void onNext(BoxBean3 boxBean3) {
                setData(true,boxBean3.getResult());
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
            boxAdapter3.setNewData(datas);
        } else {
            if (size > 0) {
                boxAdapter3.addData(datas);
            }
        }
        if (size < PAGE_SIZE) {
            //第一页如果不够一页就不显示没有更多数据布局
            boxAdapter3.loadMoreEnd(false);
//            Toast.makeText(getActivity(), "no more data", Toast.LENGTH_SHORT).show();
        } else {
            boxAdapter3.loadMoreComplete();
            boxAdapter3.loadMoreEnd(false);
        }
    }

}
