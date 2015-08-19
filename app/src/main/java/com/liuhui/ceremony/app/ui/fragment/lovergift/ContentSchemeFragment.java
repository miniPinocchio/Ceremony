package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseGiftContentFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 方案Fragment
 * Created by anany on 15/8/19.
 */
public class ContentSchemeFragment extends BaseGiftContentFragment {

    @InjectView(R.id.vp_gift_scheme_content)
    public ViewPager vp_gift_scheme_content;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.gift_fragment_content_scheme, null);
        ButterKnife.inject(view);
        return view;

    }

    @Override
    public void initData() {
        //vp_gift_scheme_content.setAdapter();
    }

    @OnClick(value = {R.id.ll_index_0, R.id.ll_index_1, R.id.ll_index_2, R.id.ll_index_3})
    void setClickEvent(View v) {
        switch (v.getId()) {
            case R.id.ll_index_0:
                break;
            case R.id.ll_index_1:
                break;
            case R.id.ll_index_2:
                break;
            case R.id.ll_index_3:
                break;
        }
    }
}
