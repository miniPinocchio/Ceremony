package com.liuhui.ceremony.app.ui.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseHomeFragment;
import com.liuhui.ceremony.app.ui.fragment.lovergift.ContentSchemeFragment;
import com.liuhui.ceremony.app.ui.fragment.lovergift.ContentStoryFragment;
import com.liuhui.ceremony.app.util.LogUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by anany on 15/8/14.
 */
public class GiftFragment extends BaseHomeFragment {


    @InjectView(R.id.fl_gift_main_content)
    FrameLayout fl_gift_main_content;// 填充到主内容的布局

    @InjectView(R.id.line_story)
    View line_story;// 方案下面的线

    @InjectView(R.id.line_scheme)
    View line_scheme;//故事下面的线

    private FragmentManager fragmentManager;

    private FragmentTransaction transaction;

    private ContentSchemeFragment contentSchemeFragment;//方案fragment

    private ContentStoryFragment contentStoryFragment;//故事fragment
    private BaseApplication instance;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {

        LogUtil.e("GiftFragment initView");
        View view = inflater.inflate(R.layout.fragment_gift, container, false);
        ButterKnife.inject(view);
        return view;
    }


    @Override
    public void initData() {
        instance = BaseApplication.getInstance();

        if(instance.getCount() != 0){
            return;
        }

        LogUtil.e("GiftFragment initData ---");

        fragmentManager = getFragmentManager();
        switchContent(0);
    }

    @OnClick(value = {R.id.iv_btn_search, R.id.ll_scheme, R.id.ll_story})
    void setClickEvent(View v) {
        switch (v.getId()) {
            case R.id.ll_scheme:
                switchContent(0);
                break;
            case R.id.ll_story:
                switchContent(1);
                break;
            case R.id.iv_btn_search:
                break;
        }
    }

    public void switchContent(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                line_scheme.setVisibility(View.VISIBLE);
                line_story.setVisibility(View.INVISIBLE);
                if (contentSchemeFragment == null) {
                    // 如果contentSchemeFragment为空，则创建一个并添加到界面上
                    contentSchemeFragment = new ContentSchemeFragment();
                    transaction.add(R.id.fl_gift_main_content, contentSchemeFragment);
                } else {
                    // 如果contentSchemeFragment不为空，则直接将它显示出来
                    transaction.show(contentSchemeFragment);
                }
                break;
            case 1:
                line_scheme.setVisibility(View.INVISIBLE);
                line_story.setVisibility(View.VISIBLE);
                if (contentStoryFragment == null) {
                    // contentStoryFragment，则创建一个并添加到界面上
                    contentStoryFragment = new ContentStoryFragment();
                    transaction.add(R.id.fl_gift_main_content, contentStoryFragment);
                } else {
                    // 如果contentStoryFragment不为空，则直接将它显示出来
                    transaction.show(contentStoryFragment);
                }
                break;

        }
        transaction.commit();
        instance.setCount(1);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */

    private void hideFragments(FragmentTransaction transaction) {
        if (contentSchemeFragment != null) {
            transaction.hide(contentSchemeFragment);
        }
        if (contentStoryFragment != null) {
            transaction.hide(contentStoryFragment);
        }

    }
}
