package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.adapter.LoverGiftPagerAdapter;
import com.liuhui.ceremony.app.bean.GiftSchemeBean;
import com.liuhui.ceremony.app.util.LogUtil;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 情礼情境fragment
 * Created by anany on 15/8/20.
 */
public class GiftSituationFragment extends Fragment implements ViewPager.OnPageChangeListener {

    ViewPager mViewPager;

    SmartTabLayout viewPagerTab;

    private String[] mTitle;
    private String[] mData;

    private Context mContext;
    private GiftSchemeBean giftSchemeBean;
    private List<GiftSchemeBean.TagsEntity> tags;
    private LoverGiftPagerAdapter loverGiftPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gift_situation_content, container, false);

        mContext = getActivity();

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

        if (BaseApplication.getInstance().getCount() != 2) {
            return;
        }

        BaseApplication.getInstance().setCount(3);

        LogUtil.w("GiftSituationFragment initData");

        List<LoverGiftTab> loverGiftTabList = new ArrayList<LoverGiftTab>();

        loverGiftPagerAdapter = new LoverGiftPagerAdapter(tags, loverGiftTabList);
//        if (tags != null) {
//            for (int i = 0; i < tags.size(); i++) {
//                LoverGiftTab loverGiftTab = new LoverGiftTab(mContext, giftSchemeBean);
//                loverGiftTabList.add(loverGiftTab);
//            }
//
//
//            mViewPager.setAdapter(loverGiftPagerAdapter);
//
//            viewPagerTab.setViewPager(mViewPager);
//            viewPagerTab.setOnPageChangeListener(this);
//        }
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

    /**
     * 联网获取数据后设置数据
     *
     * @param giftSchemeBean
     */
    public void setData(GiftSchemeBean giftSchemeBean) {
        this.giftSchemeBean = giftSchemeBean;
        tags = giftSchemeBean.getTags();

        List<LoverGiftTab> loverGiftTabList = new ArrayList<LoverGiftTab>();
        for (int i = 0; i < tags.size(); i++) {
            LoverGiftTab loverGiftTab = new LoverGiftTab(mContext, giftSchemeBean);
            loverGiftTabList.add(loverGiftTab);
        }

        loverGiftPagerAdapter.setData(giftSchemeBean,loverGiftTabList);
        mViewPager.setAdapter(loverGiftPagerAdapter);

        viewPagerTab.setViewPager(mViewPager);
        viewPagerTab.setOnPageChangeListener(this);
    }
}
