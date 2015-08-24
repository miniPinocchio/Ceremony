package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 * 发现 -> 相册
 * Created by anany on 15/8/21.
 */
public class DiscoverGralleryActivity extends BaseActivity{

    @InjectView(R.id.actionBarTitle)
    public TextView actionBarTitle;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);

        ButterKnife.findById(this, R.id.back).setVisibility(View.GONE);
        actionBarTitle.setText("相册");

    }

}
