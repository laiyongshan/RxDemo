package com.yeohe.rxdemo.ui.WXArticle;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.yeohe.rxdemo.MainActivity;
import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.api.MainAPIServiceImp;
import com.yeohe.rxdemo.base.BaseActivity;
import com.yeohe.rxdemo.base.Constact;
import com.yeohe.rxdemo.bean.WXCategoryBean;
import com.yeohe.rxdemo.ui.boxoffice.BoxOfficeActivity;
import com.yeohe.rxdemo.ui.boxoffice.BoxOfficeFragment1;
import com.yeohe.rxdemo.ui.boxoffice.BoxOfficeFragment2;
import com.yeohe.rxdemo.ui.boxoffice.BoxOfficeFragment3;
import com.yeohe.rxdemo.utils.ToastUtil;
import com.yeohe.rxdemo.widgets.SlidingTabLayout;

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

public class WXArticleActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_wxarticle);
//        setBackArrow();
        setTitle("WA News");
        initViews();
        getWxCategory();
    }

    @Override
    protected void initViews() {
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tabs);
    }


    private void getWxCategory(){
        progressDialog.show();
        Observable<WXCategoryBean> observable= MainAPIServiceImp.getWxCategory(Constact.APP_KEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WXCategoryBean>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onNext(WXCategoryBean wxCategoryBean) {
                        setupViewPager(viewPager,wxCategoryBean);
                    }
                });
    }



    private void setupViewPager(ViewPager viewPager,WXCategoryBean wxCategoryBean) {
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        String cid="";
        for(int i=0;i<wxCategoryBean.getResult().size();i++){
            cid=wxCategoryBean.getResult().get(i).getCid();
            adapter.addFragment(new WXArticleFragment(cid),wxCategoryBean.getResult().get(i).getName()+"");
        }
        viewPager.setAdapter(adapter);
        if(viewPager!=null)
            tabLayout.setupWithViewPager(viewPager);
    }


    static class VPAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public VPAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }


    //退出时的时间
    private long mExitTime;
    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            ToastUtil.showMessage(WXArticleActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT);
            mExitTime = System.currentTimeMillis();
        } else {
//            MyConfig.clearSharePre(this, "users");
            finish();
            System.exit(0);
        }
    }

}
