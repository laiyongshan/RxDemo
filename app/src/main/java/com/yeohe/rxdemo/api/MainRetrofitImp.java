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

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chenchangjun on 17/8/10.
 */

public interface MainRetrofitImp {


    /*
    * 獲取手機號碼歸屬地
    * */
    @GET("v1/mobile/address/query")
    Observable<MobileAddressBean> getMobileAddress(@Query("key") String appkey,@Query("phone") String phoneNum);

    /*
    * 获取日票房
    * */
    @GET("boxoffice/day/query")
    Observable<BoxBean1> getDayBoxoffice(@Query("key") String appkey,@Query("area") String area);

    /**
     * 获取周票房
     * */
    @GET("boxoffice/week/query")
    Observable<BoxBean2> getWeekBoxoffice(@Query("key") String appkey,@Query("area") String area);

    /**
     * 获取周末票房
     * */
    @GET("boxoffice/weekend/query")
    Observable<BoxBean3> getWeekendBoxoffice(@Query("key") String appkey, @Query("area") String area);

    /**
     * 各大银行货币汇率查询
     * */
    @GET("exchange/rmbquot/query")
    Observable<RateBean> getRate(@Query("key") String appkey,@Query("bank") String bank);


    /**
     * 微信精选分类查询
     * */
    @GET("wx/article/category/query")
    Observable<WXCategoryBean> getWxCategory(@Query("key") String appkey);


    /**
     *
     * 微信精选列表
     *
     */
    @GET("wx/article/search")
    Observable<WXArticleBean> getWxArticle(@Query("key") String appkey,@Query("cid") String cid,@Query("page") int page,@Query("size") int siz);


    /**
     * 获取支持彩票种类
     * */
    @GET("lottery/list")
    Observable<LotteryTypeBean> getLotteryType(@Query("key") String appkey);


    /**
     *获取中奖详情
    */
    @GET("lottery/query")
    Observable<AWardBean> getAwardDetail(@Query("key") String appkey,@Query("name") String name);




    /**
     * 获取天气数据(测试)
     * @param cityname
     * @param key
     * @return
     */

//    @GET("/weather/index")
//    Observable<WeatherData> getWeatherData(@Query("format") String format, @Query("cityname") String cityname, @Query("key") String key);
//
//
//    @GET("/api/data/福利/{date}")
//    Observable<Meizhi> getMeiZhi(@Path("date") String date);
//
//    @GET("http://www.baidu.com")
//    Observable<String> getData();
//
//    @GET("api/data/Android/10/{page}")
//    Observable<GankBean> getGankData(@Path("page") int page);


    /**
     * post请求
     * */

    //Body请求参数
//    @POST("user/login")
//    Call<User> login(@Body LoginInfo loginInfo);

    //Field方式
//    @FormUrlEncoded
//    @POST("user/login")
//    Call<User> login(@Field("username") String username,
//                     @Field(password) String password);

    //FieldMap方式
//    @FormUrlEncoded
//    @POST("user/login")
//    Call<User> login(@FieldMap Map<String,String> map);


    /**
     * Get请求
     * */
    //直接请求某一地址获取列表
//    @GET("news/toplist")
//    Call<ArrayList<News> news> getNewsList();

    //url拼接固定查询条件
//    @GET("news/toplist?date=20161030")
//    Call<ArrayList<News> news> getNewsList();


    //url中拼接地址信息
//    @GEt("news/{city}/newslist")
//    Call<ArrayList<News> news> getCityNewsList(@Path("city") String city);

    //通过Query注解添加其他查询条件
//    @GET("news/{city}/newslist")
//    Call<ArrayList<News> news> getCityNewsList(@Path("city") String city
//                                         @Query("date") String date
//                                                 @Query("newsType") String newsType);

    //查询条件较多时同样有QueryMap注解方法供使用
//    @GET("news/{city}/newslist")
//    Call<ArrayList<News> news> getCityNewsList(@Path("city") String city
//                                         @QueryMap<String, String> options);

    /*
    * Header请求头设置
    * */
    //为请求添加固定请求头
    //添加单个固定请求头
//    @Header("Cache-Control: max-aget-640000")
//    @GET("news/toplist?date=20161030")
//    Call<ArrayList<News> news> getNewsList();
//多个请求头以数组的形式提交
//    @Header(
//            {"Accept: application/vnd.github.v3.full+json",
//                    "User-Agent: Retrofit-Sample-App"
//            })
//    @GET("news/toplist?date=20161030")
//    Call<ArrayList<News> news> getNewsList();


    //动态添加请求头
    //添加动态请求头，比如获取的认证信息等
//    @GET("news/toplist?date=20161030")
//    Call<ArrayList<News> news> getNewsList(@Header(Authorization) String authorization);

}
