package com.liuhui.ceremony.app.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseFragment;

import butterknife.InjectView;

/**
 * "我的"选项卡
 * Created by anany on 15/8/14.
 */
public class PersonalFragment extends BaseFragment{

    @InjectView(R.id.back)
    ImageView back;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_personal, container, false);
    }

    @Override
    public void initData() {

    }
}
