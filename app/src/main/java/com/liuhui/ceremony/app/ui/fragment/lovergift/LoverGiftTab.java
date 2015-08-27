package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.liuhui.ceremony.app.base.BaseTabPager;
import com.liuhui.ceremony.app.bean.GiftSchemeBean;

/**
 * Created by anany on 15/8/27.
 */
public class LoverGiftTab extends BaseTabPager {

    private GiftSchemeBean giftSchemeBean;

    private ListView lv_gift_tab_content;

    public LoverGiftTab(Context context, GiftSchemeBean giftSchemeBean){
        super(context);
        this.giftSchemeBean = giftSchemeBean;
    }

    @Override
    public View initView() {
//        View view = View.inflate(mContext, R.layout.gif_tab_pager,null);
//        view.findViewById(R.id.lv_gift_tab_content);
        TextView tv = new TextView(mContext);
        tv.setText("B神称霸武林");
        return tv;
    }

    @Override
    public void initData() {

        //lv_gift_tab_content.setAdapter();
    }
}
