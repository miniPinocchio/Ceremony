package com.liuhui.ceremony.app.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.liuhui.ceremony.app.bean.GiftSchemeBean;
import com.liuhui.ceremony.app.ui.fragment.lovergift.LoverGiftTab;

import java.util.List;

/**
 *  情礼攻略三级Tab viewpager Tab适配器
 * Created by anany on 15/8/27.
 */
public class LoverGiftPagerAdapter extends PagerAdapter {

    private List<GiftSchemeBean.TagsEntity> tags = null;// Tab 标题

    private List<LoverGiftTab> loverGiftTabList;

    public LoverGiftPagerAdapter(List<GiftSchemeBean.TagsEntity> tags,
                                 List<LoverGiftTab> loverGiftTabList) {
        this.tags = tags;
        this.loverGiftTabList = loverGiftTabList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tags.get(position).getName();
    }

    @Override
    public int getCount() {
        return tags != null ? tags.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = loverGiftTabList.get(position).getRootView();
        container.removeView(view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = loverGiftTabList.get(position).getRootView();
        container.addView(view);
        return view;
    }

    public void setData(GiftSchemeBean giftSchemeBean, List<LoverGiftTab> loverGiftTabList) {
        this.tags = giftSchemeBean.getTags();
        this.loverGiftTabList = loverGiftTabList;
        this.notifyDataSetChanged();
    }
}
