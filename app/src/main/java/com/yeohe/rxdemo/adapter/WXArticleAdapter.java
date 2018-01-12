package com.yeohe.rxdemo.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.bean.WXArticleBean;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/11
 * creator:  LYS
 * 功能描述：
 */

public class WXArticleAdapter extends BaseQuickAdapter<WXArticleBean.ResultEntity.ListEntity,BaseViewHolder> {

    private Activity activity;

    public WXArticleAdapter(Activity activity) {
        super(R.layout.item_wx_article, null);
        this.activity=activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, WXArticleBean.ResultEntity.ListEntity item) {

            helper.setText(R.id.title_tv,item.getTitle());
            helper.setText(R.id.subTitle_tv,item.getSubTitle());

            if(item.getThumbnails()!=null) {
                String arr[] = item.getThumbnails().split("$");
                if(arr.length>0){
                    Glide.with(activity)
                            .load(arr[0])
                            .override(280, 280)
                            .centerCrop()
                            .into(((ImageView) helper.getView(R.id.thumbnails_iv)));
                }else{
                    Glide.with(activity)
                            .load(item.getThumbnails().replace("$",""))
                            .override(280, 280)
                            .centerCrop()
                            .into(((ImageView) helper.getView(R.id.thumbnails_iv)));
                }
            }
    }
}
