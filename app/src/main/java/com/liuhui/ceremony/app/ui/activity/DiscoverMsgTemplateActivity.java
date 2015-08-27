package com.liuhui.ceremony.app.ui.activity;

import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.util.LogUtil;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by anany on 15/8/26.
 */
public class DiscoverMsgTemplateActivity extends BaseActivity{

    @InjectView(R.id.actionBarTitle)
    public TextView actionBarTitle;

    private String userId;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_grallery);

        ButterKnife.inject(this);

        actionBarTitle.setText("祝福语");

        userId = BaseApplication.getInstance().getUserId();
    }

    @Override
    protected void initData() {

        OkHttpClientManager.getAsyn(Api.MSG_TEMPLATE, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtil.e(e.toString());
            }

            @Override
            public void onResponse(String response) {
                LogUtil.e(response);
            }
        });
    }
}
