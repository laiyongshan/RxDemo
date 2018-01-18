package com.yeohe.rxdemo.api;


import com.yeohe.rxdemo.bean.AWardBean;
import com.yeohe.rxdemo.bean.BoxBean1;
import com.yeohe.rxdemo.bean.BoxBean2;
import com.yeohe.rxdemo.bean.BoxBean3;
import com.yeohe.rxdemo.bean.LotteryTypeBean;
import com.yeohe.rxdemo.bean.MobileAddressBean;
import com.yeohe.rxdemo.bean.RateBean;
import com.yeohe.rxdemo.bean.WXArticleBean;
import com.yeohe.rxdemo.bean.WXCategoryBean;

import rx.Observable;

/**
 * 继承
 * Created by chenchangjun on 17/8/10.
 */

public class MainAPIServiceImp extends APIService {

    protected static final MainRetrofitImp apiManager = APIService.getIntance().sRetrofit.create(MainRetrofitImp.class);
//    protected static final MainRetrofitImp apiManager=APIService.getIntance().getsRetrofit().create(MainRetrofitImp.class);

    /**
     * 獲取手機號碼歸屬地
     * */
    public static Observable<MobileAddressBean> getMobileAddress(String appKey, String phoneNum){
        Observable<MobileAddressBean> mab_obserable=apiManager.getMobileAddress(appKey,phoneNum);
        return  mab_obserable;
    }


    /**
     * 实时票房查询
     * */
    public static Observable<BoxBean1> getDayboxoffice(String appkey,String area){
        Observable<BoxBean1> box1_obserable=apiManager.getDayBoxoffice(appkey,area);
        return box1_obserable;
    }


    /**
     * 周票房查询
     * */
    public static Observable<BoxBean2> getWeekboxoffice(String appkey, String area){
        Observable<BoxBean2> box2_obserable=apiManager.getWeekBoxoffice(appkey,area);
        return box2_obserable;
    }


    /**
     * 周末票房查询
     * */
    public static Observable<BoxBean3> getWeekendboxoffice(String appkey,String area){
        Observable<BoxBean3> box3_obserable=apiManager.getWeekendBoxoffice(appkey,area);
        return box3_obserable;
    }

    /**
     * 货币汇率查询
     * */
    public static Observable<RateBean> getRate(String appkey,String bank){
        Observable<RateBean> rate_Observable=apiManager.getRate(appkey,bank);
        return rate_Observable;
    }

    /**
     * 微信精选分类查询
     * */
    public static Observable<WXCategoryBean> getWxCategory(String appkey){
        Observable<WXCategoryBean> wxCategory_Observable=apiManager.getWxCategory(appkey);
        return wxCategory_Observable;
    }

    /**
     * 微信精选列表
     * */
    public static Observable<WXArticleBean> getWxArticle(String appkey,String cid,int page,int size){
        Observable<WXArticleBean> wxArticle_Observable=apiManager.getWxArticle(appkey, cid,page,size);
        return wxArticle_Observable;
    }


    /**
     * 获取支持彩票种类
     * */
    public static Observable<LotteryTypeBean> getLotteryType(String appkey){
        Observable<LotteryTypeBean> lotteryType_Observable=apiManager.getLotteryType(appkey);
        return lotteryType_Observable;
    }



    /**
     *获取中奖详情
     */
    public static Observable<AWardBean> getAwardDetail(String appkey,String name){
        Observable<AWardBean> aWard_Observable=apiManager.getAwardDetail(appkey,name);
        return aWard_Observable;
    }


    /**
     * @return
     */
//    public static Observable<Meizhi> getMeiZhi(String date){
//        Observable<Meizhi> ss = apiManager.getMeiZhi( date);
//        TLog.logI(date);
//        return  ss;
//    }


}
