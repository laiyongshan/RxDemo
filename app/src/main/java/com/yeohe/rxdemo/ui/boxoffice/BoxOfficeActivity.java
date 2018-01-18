package com.yeohe.rxdemo.ui.boxoffice;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.yeohe.rxdemo.R;
import com.yeohe.rxdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class BoxOfficeActivity extends BaseActivity {

    private ViewPager mViewPager;
    private  TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_boxoffice);
        setBackArrow();
        setTitle("电影票房");
        initViews();
    }

    protected void initViews() {
        mViewPager=findViewById(R.id.viewpager);
        tabLayout= findViewById(R.id.tabs);
        if(mViewPager!=null){
            setupViewPager(mViewPager);
            tabLayout.setupWithViewPager(mViewPager);
        }
    }


    private void setupViewPager(ViewPager viewPager) {
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        adapter.addFragment(BoxOfficeFragment1.getinstance(), "实时票房");
        adapter.addFragment(BoxOfficeFragment2.getinstance(), "周票房");
        adapter.addFragment(BoxOfficeFragment3.getinstance(), "周末票房");
        viewPager.setAdapter(adapter);
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
}
