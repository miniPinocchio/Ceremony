package com.liuhui.ceremony.app.ui.activity;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 我的收藏
 * <p/>
 * Created by berial on 15/8/27.
 */
public class MyFavoriteActivity extends BaseActivity {

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_my_favorite);
		ButterKnife.inject(this);
	}
}
