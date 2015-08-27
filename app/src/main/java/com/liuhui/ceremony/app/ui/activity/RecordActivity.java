package com.liuhui.ceremony.app.ui.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 打分记录、印象记录
 * <p>
 * Created by berial on 15/8/23.
 */
public class RecordActivity extends BaseActivity {

	@InjectView(R.id.actionBarTitle)
	TextView title;

	@InjectView(R.id.radioGroup)
	RadioGroup mRadioGroup;

	@InjectView(R.id.record)
	ListView record;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_record);

		ButterKnife.inject(this);

		//ButterKnife.findById(this, R.id.back).setVisibility(View.GONE);
	}

	/**
	 * 设置点击事件
	 */
	@OnClick({ R.id.back })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
		}
	}
}
