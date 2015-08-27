package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseGiftContentFragment;
import com.liuhui.ceremony.app.bean.GiftSchemeBean;

/**
 * 方案Fragment
 * Created by anany on 15/8/19.
 */
public class ContentStoryFragment extends BaseGiftContentFragment {

//    @InjectView(R.id.fl_gift_scheme_content)
//    public FrameLayout fl_gift_scheme_content;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.gift_fragment_content_scheme,container, false);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setData(GiftSchemeBean giftSchemeBean) {

    }

}
