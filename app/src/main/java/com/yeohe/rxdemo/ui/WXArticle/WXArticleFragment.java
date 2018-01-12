package com.yeohe.rxdemo.ui.WXArticle;


import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.adapter.WXArticleAdapter;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.Constact;
import com.yeohe.rxdemo.base.LazyFragment;
import com.yeohe.rxdemo.bean.WXArticleBean;
import com.yeohe.rxdemo.ui.web.WebActivity;

import java.util.ArrayList;
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

@SuppressLint("ValidFragment")
public class WXArticleFragment extends LazyFragment {

    private String cid;
    private View view;

    private SwipeRefreshLayout wxSwipeRefreshLayout;
    private RecyclerView wx_rv;
    private WXArticleAdapter mAdapter;

    private static int SIZE=6;
    private static int PAGE=1;
    private static final int PAGE_SIZE = 6;



    public WXArticleFragment(String cid){
            this.cid=cid;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_wxarticle,null);

        //初始化view的各控件
        initViews();
        initSwipeLayout();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
    }

    /*
        * 初始化控件
        * */
    private void initViews(){
        wx_rv=view.findViewById(R.id.wx_rv);
        wx_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        wx_rv.setAdapter(mAdapter);
        wx_rv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
//                Toast.makeText(getActivity(), mAdapter.getData().get(position).getSourceUrl(), Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url",mAdapter.getData().get(position).getSourceUrl()+"");
                intent.putExtra("title",mAdapter.getData().get(position).getTitle()+"");
                startActivity(intent);
            }
        });
    }


    /**
     * 初始化下拉刷新
     * */
    private void initSwipeLayout(){
        wxSwipeRefreshLayout=view.findViewById(R.id.wxSwipeRefreshLayout);
        wxSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW);
        wxSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reflush(cid);
            }
        });

    }


    /**
     * 初始化Adapter
     * */
    private void initAdapter(){
        mAdapter = new WXArticleAdapter(getActivity());
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        });
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        mAdapter.setPreLoadNumber(3);

    }

    /**
     * 刷新数据
     * */
    private void reflush(String cid){
        PAGE = 1;
        mAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        wxSwipeRefreshLayout.setRefreshing(true);
        Observable<WXArticleBean> observable= MainAPIServiceImp.getWxArticle(Constact.APP_KEY,cid,PAGE,SIZE);
        observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Subscriber<WXArticleBean>() {
            @Override
            public void onCompleted() {
                mAdapter.setEnableLoadMore(true);
                wxSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                mAdapter.setEnableLoadMore(true);
                wxSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onNext(WXArticleBean wxArticleBean) {
                datas=wxArticleBean.getResult().getList();
                setData(true);
            }
        });
    }


    /**
     * 加载下一页
     * */
    private void loadMore(){
        Observable<WXArticleBean> observable= MainAPIServiceImp.getWxArticle(Constact.APP_KEY,cid,PAGE,SIZE);
        observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Subscriber<WXArticleBean>() {
            @Override
            public void onCompleted() {
                mAdapter.setEnableLoadMore(true);
                wxSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                mAdapter.setEnableLoadMore(true);
                wxSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onNext(WXArticleBean wxArticleBean) {
                datas=wxArticleBean.getResult().getList();
                setData(false);
            }
        });
    }


    /**
     * 设置数据
     * */
    private List<WXArticleBean.ResultEntity.ListEntity> datas=new ArrayList<>();
    private void setData(boolean isRefresh){
        PAGE++;
        final int size = datas == null ? 0 : datas.size();
        if (isRefresh) {
            mAdapter.setNewData(datas);
        } else {
            if (size > 0) {
                mAdapter.addData(datas);
            }
        }
        if (size < PAGE_SIZE) {
            //第一页如果不够一页就不显示没有更多数据布局
            mAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(getActivity(), "no more data", Toast.LENGTH_SHORT).show();
        } else {
            mAdapter.loadMoreComplete();
        }
    }


    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
//            notifyDataSetChanged();
        }
    }

    //第一次课件加载
    @Override
    protected void onFragmentFirstVisible() {
        reflush(cid);
//        Toast.makeText(getActivity(),cid+"初始化",Toast.LENGTH_SHORT).show();
    }

}
