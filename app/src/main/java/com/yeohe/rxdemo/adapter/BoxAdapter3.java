package com.yeohe.rxdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.bean.BoxBean3;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/10
 * creator:  LYS
 * 功能描述：
 */

public class BoxAdapter3 extends BaseQuickAdapter<BoxBean3.ResultEntity,BaseViewHolder> {
    public BoxAdapter3() {
        super(R.layout.box_item3, null);
    }


    @Override
    protected void convert(BaseViewHolder helper, BoxBean3.ResultEntity item) {
        helper.setText(R.id.name_tv,"电影名称："+item.getName());
        helper.setText(R.id.weekendSum_tv,"周末票房:"+item.getWeekendSum());
        helper.setText(R.id.date_tv,"日期："+item.getWeekendPeriod());
    }
}
