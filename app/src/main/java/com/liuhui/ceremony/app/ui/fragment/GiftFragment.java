package com.liuhui.ceremony.app.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseFragment;

/**
 * Created by anany on 15/8/14.
 */
public class GiftFragment extends BaseFragment{
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        //TODO 关系图
        View view = inflater.inflate(R.layout.fragment_relationship, container, false);
        return view;
    }

    @Override
    public void initData() {

    }
}
