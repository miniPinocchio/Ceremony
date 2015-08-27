package com.liuhui.ceremony.app.ui.activity;

import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.Impression;
import com.liuhui.ceremony.app.ui.customview.FlowLayout;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 编辑个人标签
 * <p/>
 * Created by berial on 15/8/26.
 */
public class EditPersonalLabelActivity extends BaseActivity {

	@InjectView(R.id.personalLabelList)
	FlowLayout personalLabelList;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_edit_personal_label);
		ButterKnife.inject(this);

		String nickname = getIntent().getStringExtra("nickname");
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText("给 " + nickname + " 的印象");

		((CheckBox) ButterKnife.findById(this, R.id.setAnon))
				.setText(Html.fromHtml("<font color='#111111'>匿名</font>" +
						"<font color='#808080'> (你的昵称将不被大家看到) </font>"));
	}

	@Override
	protected void initData() {
		String personalLabelJson = getIntent().getStringExtra("personalLabelJson");
		ArrayList<Impression> impressionList = new Gson().fromJson(personalLabelJson,
				new TypeToken<ArrayList<Impression>>() {}.getType());
		FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(-2, -2);//-2:WRAP_CONTENT
		params.setMargins(0, 0, 16, 20);
		for(Impression i : impressionList) {
			TextView textView = new TextView(this);
			textView.setText(i.getImpress());
			textView.setPadding(10, 6, 10, 6);
			textView.setTextColor(Color.WHITE);
			textView.setTextSize(14);
			textView.setBackgroundResource(R.drawable.shape_personal_label);
			textView.setLayoutParams(params);
			personalLabelList.addView(textView);
		}
		//添加自定义标签
		TextView textView = new TextView(this);
		textView.setText("+");
		textView.setPadding(16, 6, 16, 6);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(14);
		textView.setBackgroundResource(R.drawable.shape_personal_label);
		textView.setLayoutParams(params);
		personalLabelList.addView(textView);
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
