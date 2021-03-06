package com.liuhui.ceremony.app.ui.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseHomeFragment;
import com.liuhui.ceremony.app.ui.activity.DiscoverGalleryActivity;
import com.liuhui.ceremony.app.ui.activity.DiscoverMsgTemplateActivity;
import com.liuhui.ceremony.app.util.LogUtil;

import butterknife.OnClick;

/**
 * Created by anany on 15/8/14.
 */
public class DiscoverFragment extends BaseHomeFragment {


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {

        LogUtil.e("DiscoverFragment initView");

        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ImageView back = (ImageView) view.findViewById(R.id.back);
        back.setVisibility(View.GONE);
        TextView actionBarTitle = (TextView) view.findViewById(R.id.actionBarTitle);
        actionBarTitle.setText("发现");
        return view;
    }

    @Override
    public void initData() {
    }

    @OnClick(value = {R.id.tv_discover_gralley,
            R.id.tv_discover_ghht, R.id.tv_discover_msg_template
            , R.id.tv_discover_mycard, R.id.tv_discover_qltx, R.id.tv_discover_scan})
    void setClickEvent(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tv_discover_gralley://相册
                intent = new Intent(getActivity(), DiscoverGalleryActivity.class);
                break;
            case R.id.tv_discover_qltx://情礼提醒
                break;
            case R.id.tv_discover_msg_template://短信模板
                intent = new Intent(getActivity(), DiscoverMsgTemplateActivity.class);
                break;
            case R.id.tv_discover_scan://扫一扫
                break;
            case R.id.tv_discover_mycard://我的卡券
                break;
            case R.id.tv_discover_ghht://关怀话题
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
