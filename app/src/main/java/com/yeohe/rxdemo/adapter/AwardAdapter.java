package com.yeohe.rxdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.bean.AWardBean;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/16
 * creator:  LYS
 * 功能描述：
 */

public class AwardAdapter extends BaseQuickAdapter<AWardBean.ResultEntity.LotteryDetailsEntity,BaseViewHolder> {
    public AwardAdapter() {
        super(R.layout.item_awrd, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, AWardBean.ResultEntity.LotteryDetailsEntity item) {
        if(item.getType()!=null) {
            helper.setText(R.id.awards_tv, "" + item.getAwards()+item.getType());
        }else{
            helper.setText(R.id.awards_tv, "" + item.getAwards());
        }
        helper.setText(R.id.awardPrice_tv,"中奖金额："+(int)item.getAwardPrice()+"元");
        helper.setText(R.id.awardNumber_tv,"中奖注数："+item.getAwardNumber()+"");
    }
}
