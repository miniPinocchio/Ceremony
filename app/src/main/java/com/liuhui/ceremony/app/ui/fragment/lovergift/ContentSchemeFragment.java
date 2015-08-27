package com.liuhui.ceremony.app.ui.fragment.lovergift;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseGiftContentFragment;
import com.liuhui.ceremony.app.bean.GiftSchemeBean;
import com.liuhui.ceremony.app.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 方案Fragment
 * Created by anany on 15/8/19.
 */
public class ContentSchemeFragment extends BaseGiftContentFragment {

    @InjectView(R.id.tv_qlqj)
    TextView tv_qlqj;//情礼情境

    @InjectView(R.id.tv_qldx)
    TextView tv_qldx;//情礼对象

    @InjectView(R.id.tv_dxah)
    TextView tv_dxah;//对象爱好

    @InjectView(R.id.tv_jrsl)
    TextView tv_jrsl;//节日送礼

    List<TextView> textViews = new ArrayList<TextView>();

    private FragmentManager fragmentManager;

    private GiftSituationFragment giftSituationFragment;//情礼情境
    private GiftObjectFragment giftObjectFragment;//情礼对象
    private GiftHobbyFragment giftHobbyFragment;//情礼爱好
    private GiftFestivalGiveFragment giftFestivalGiveFragment;//情礼节日送礼
    private BaseApplication instance;
    private List<GiftSchemeBean.TagsEntity> tags;
    private List<GiftSchemeBean.TypelistEntity> typelist;

    public GiftSchemeBean giftSchemeBean = null;

    public Context mContext;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.gift_fragment_content_scheme, null);
        mContext = getActivity();
        ButterKnife.inject(view);
        return view;
    }

    @OnClick(value = {R.id.ll_index_0, R.id.ll_index_1, R.id.ll_index_2, R.id.ll_index_3})
    void setClickEvent(View v) {

        switch (v.getId()) {
            case R.id.ll_index_0://情礼情境
                switchContent(0);
                break;
            case R.id.ll_index_1://情礼对象
                switchContent(1);
                break;
            case R.id.ll_index_2://对象爱好
                switchContent(2);
                break;
            case R.id.ll_index_3://节日送礼
                switchContent(3);
                break;
        }
    }

    @Override
    public void initData() {

        if (BaseApplication.getInstance().getCount() != 1) {
            return;
        }


        fragmentManager = getFragmentManager();

        LogUtil.e("ContentSchemeFragment initData");

        switchContent(0);
//

    }

    int _index = -1;
    public void switchContent(int index) {

        textViews.clear();

        textViews.add(0, tv_qlqj);
        textViews.add(1, tv_qldx);
        textViews.add(2, tv_dxah);
        textViews.add(3, tv_jrsl);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);

        switch (index) {
            case 0:
                if (giftSituationFragment == null) {
                    giftSituationFragment = new GiftSituationFragment();
                    transaction.add(R.id.fl_gift_plan_content, giftSituationFragment);
                } else {
                    transaction.show(giftSituationFragment);
                }
                break;
            case 1:
                if (giftObjectFragment == null) {
                    giftObjectFragment = new GiftObjectFragment();
                    transaction.add(R.id.fl_gift_plan_content, giftObjectFragment);
                } else {
                    transaction.show(giftObjectFragment);
                }
                break;
            case 2:
                if (giftHobbyFragment == null) {
                    giftHobbyFragment = new GiftHobbyFragment();
                    transaction.add(R.id.fl_gift_plan_content, giftHobbyFragment);
                } else {
                    transaction.show(giftHobbyFragment);
                }
                break;
            case 3:
                if (giftFestivalGiveFragment == null) {
                    giftFestivalGiveFragment = new GiftFestivalGiveFragment();
                    transaction.add(R.id.fl_gift_plan_content, giftFestivalGiveFragment);
                } else {
                    transaction.show(giftFestivalGiveFragment);
                }
                break;

        }

        /*
         * 改变Tab文字颜色
         */
        for (int i = 0; i < textViews.size(); i++) {
            if (i == index) {
                textViews.get(i).setTextColor(getResources().getColorStateList(R.color.main_color));
            } else {
                textViews.get(i).setTextColor(getResources().getColorStateList(R.color.black));
            }
        }
        BaseApplication.getInstance().setCount(2);
        transaction.commit();
        _index = index;
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */

    private void hideFragments(FragmentTransaction transaction) {
        if (giftSituationFragment != null) {
            transaction.hide(giftSituationFragment);
        }
        if (giftObjectFragment != null) {
            transaction.hide(giftObjectFragment);
        }
        if (giftHobbyFragment != null) {
            transaction.hide(giftHobbyFragment);
        }
        if (giftFestivalGiveFragment != null) {
            transaction.hide(giftFestivalGiveFragment);
        }
    }

    /**
     * 联网获取数据后设置数据
     *
     * @param giftSchemeBean
     */
    public void setData(GiftSchemeBean giftSchemeBean) {
//        tags = giftSchemeBean.getTags();
//        for (int i = 0; i < tags.size(); i++) {
//            textViews.get(i).setText(tags.get(i).getName());
//        }
        this.giftSchemeBean = giftSchemeBean;
        typelist = giftSchemeBean.getTypelist();
        for (int i =0;i<typelist.size();i++){
            LogUtil.e("联网后设置二级Tab TextView");
            textViews.get(i).setText(typelist.get(i).getTypename());
        }

        if(_index == 0){
            giftSituationFragment.setData(giftSchemeBean);
        }else if(_index == 1){
            giftObjectFragment.setData(giftSchemeBean);
        }
    }
}
