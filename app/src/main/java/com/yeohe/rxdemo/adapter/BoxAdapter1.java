package com.yeohe.rxdemo.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.bean.BoxBean1;

import java.util.List;

/**
 * 轻轻的我来了，不留下一个Bug
 * <p>
 * 创建时间：2018/1/10
 * creator:  LYS
 * 功能描述：
 */

public class BoxAdapter1 extends BaseQuickAdapter<BoxBean1.ResultEntity,BaseViewHolder> {
    public BoxAdapter1(List<BoxBean1.ResultEntity> datas) {
        super(R.layout.box_item1, datas);
    }

    @Override
    protected void convert(BaseViewHolder helper, BoxBean1.ResultEntity item) {
        ((TextView) helper.getView(R.id.name_tv)).setText("电影名称："+item.getName());
        helper.setText(R.id.days_tv,"上映日期："+item.getDays());
        helper.setText(R.id.cur_tv,"当日票房："+item.getCur());
        helper.setText(R.id.sum_tv,"当前总票房："+item.getSum());
    }

}
