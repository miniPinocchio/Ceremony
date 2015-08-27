package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseGiftContentFragment;
import com.liuhui.ceremony.app.bean.GiftSchemeBean;

import butterknife.ButterKnife;

/**
 * 情礼情境fragment
 * Created by anany on 15/8/20.
 */
public class GiftHobbyFragment extends BaseGiftContentFragment{


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.gift_situation_content, container, false);
        ButterKnife.inject(view);
        return view;
    }

    @Override
    public void initData() {

    }

    @Override
    public void setData(GiftSchemeBean giftSchemeBean) {

    }
}
