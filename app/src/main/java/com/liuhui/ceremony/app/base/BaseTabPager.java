package com.liuhui.ceremony.app.base;

import android.content.Context;
import android.view.View;

/**
 *
 *  情礼攻略 三级Tab 基类
 *
 * Created by anany on 15/8/27.
 */
public abstract class BaseTabPager {

    public Context mContext;
    private View rootView;

    public BaseTabPager(Context context) {
        mContext = context;
        rootView = initView();
    }

    public abstract View initView();

    public View getRootView() {
        return rootView;
    }

    public abstract void initData();
}
