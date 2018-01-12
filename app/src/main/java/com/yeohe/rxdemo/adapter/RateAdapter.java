package com.yeohe.rxdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.bean.RateBean;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/10
 * creator:  LYS
 * 功能描述：
 */

public class RateAdapter extends BaseQuickAdapter<RateBean.ResultEntity,BaseViewHolder> {
    public RateAdapter() {
        super(R.layout.item_rate, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, RateBean.ResultEntity item) {

        helper.setText(R.id.currencyName_tv,item.getCurrencyName()+"("+item.getCurrencyCode()+")");
        helper.setText(R.id.fBuyPri_tv,item.getFBuyPri());
        helper.setText(R.id.mBuyPri_tv,item.getMBuyPri());
        helper.setText(R.id.bankConversionPri_tv,item.getBankConversionPri());
        helper.setText(R.id.mSellPri_tv,item.getMSellPri());
        helper.setText(R.id.fSellPri_tv,item.getFSellPri());
        helper.setText(R.id.time_tv,item.getDate()+"  "+item.getTime());

    }
}
