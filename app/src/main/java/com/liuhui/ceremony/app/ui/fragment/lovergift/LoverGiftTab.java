package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.adapter.LoverGiftTabContentAdapter;
import com.liuhui.ceremony.app.base.BaseTabPager;
import com.liuhui.ceremony.app.bean.GiftSchemeBean;

/**
 *  三级Tab页 【婚礼/暑期大作战/......】
 * Created by anany on 15/8/27.
 */
public class LoverGiftTab extends BaseTabPager {

    private GiftSchemeBean giftSchemeBean;

    private ListView lv_gift_tab_content;
    private LoverGiftTabContentAdapter loverGiftTabContentAdapter;

    public LoverGiftTab(Context context, GiftSchemeBean giftSchemeBean){
        super(context);
        this.giftSchemeBean = giftSchemeBean;
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.gif_tab_pager,null);
        lv_gift_tab_content = (ListView) view.findViewById(R.id.lv_gift_tab_content);
        return view;
    }

    @Override
    public void initData() {

        loverGiftTabContentAdapter = new LoverGiftTabContentAdapter(mContext,
                giftSchemeBean.getIdealist());
        lv_gift_tab_content.setAdapter(loverGiftTabContentAdapter);
    }
}
