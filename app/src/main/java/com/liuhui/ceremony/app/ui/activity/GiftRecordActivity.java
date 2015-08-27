package com.liuhui.ceremony.app.ui.activity;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 情礼记录
 * <p/>
 * Created by berial on 15/8/27.
 */
public class GiftRecordActivity extends BaseActivity{

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_gift_record);
		ButterKnife.inject(this);
	}
}
