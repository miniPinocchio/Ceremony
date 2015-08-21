package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.util.LogUtil;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * 情礼情境fragment
 * Created by anany on 15/8/20.
 */
public class GiftSituationFragment extends Fragment implements ViewPager.OnPageChangeListener {

    ViewPager mViewPager;

    SmartTabLayout viewPagerTab;

    private String[] mTitle;
    private String[] mData;

    private DisplayMetrics dm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gift_situation_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_gift_scheme_content);
        viewPagerTab = (SmartTabLayout) view.findViewById(R.id.viewpagertab);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initData() {

        if(BaseApplication.getInstance().getCount() != 2){
            return;
        }

        BaseApplication.getInstance().setCount(3);

        LogUtil.w("GiftSituationFragment initData");

        mTitle = new String[20];
        mData = new String[20];

        {
            for(int i=0;i<20;i++) {
                mTitle[i] = "title" + i;
                mData[i] = "data" + i;
            }
        }

        PagerAdapter mAdapter = new PagerAdapter() {
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position];
            }

            @Override
            public int getCount() {
                return mData.length;
            }

            @Override
            public Object instantiateItem(View container, int position) {
                TextView tv = new TextView(BaseApplication.context);
                tv.setTextSize(30.f);
                tv.setText(mData[position]);
                ((ViewPager) container).addView(tv);
                return tv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };

        mViewPager.setAdapter(mAdapter);
        dm = getResources().getDisplayMetrics();

        viewPagerTab.setViewPager(mViewPager);
        viewPagerTab.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
