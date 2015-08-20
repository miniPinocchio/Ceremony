package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseGiftContentFragment;
import com.liuhui.ceremony.app.util.LogUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 情礼情境fragment
 * Created by anany on 15/8/20.
 */
public class GiftSituationFragment extends BaseGiftContentFragment{

    @InjectView(R.id.vp_gift_scheme_content)
    public ViewPager mViewPager;

    @InjectView(R.id.tl_tab)
    public TabLayout mTabLayout;
    private String[] mTitle;
    private String[] mData;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.gift_situation_content, null);
        ButterKnife.inject(view);
        return view;
    }

    @Override
    public void initData() {

        LogUtil.w("GiftSituationFragment initData");

        mTitle = new String[20];
        mData = new String[20];

        {
            for(int i=0;i<20;i++) {
                mTitle[i] = "title" + i;
                mData[i] = "data" + i;
            }
        }

        mTabLayout.setTabsFromPagerAdapter(mAdapter);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mViewPager.setAdapter(mAdapter);
    }



    private PagerAdapter mAdapter = new PagerAdapter() {
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
}
