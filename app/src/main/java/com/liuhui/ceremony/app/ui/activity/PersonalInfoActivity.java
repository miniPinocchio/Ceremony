package com.liuhui.ceremony.app.ui.activity;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.Constellation;
import com.liuhui.ceremony.app.bean.Impression;
import com.liuhui.ceremony.app.bean.PersonalInfo;
import com.liuhui.ceremony.app.bean.User;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.ui.customview.FlowLayout;
import com.liuhui.ceremony.app.ui.customview.roundedimageview.RoundedImageView;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 个人信息
 * <p>
 * Created by berial on 15/8/21.
 */
public class PersonalInfoActivity extends BaseActivity {

	@InjectView(R.id.avatar)
	RoundedImageView avatar;

	@InjectView(R.id.nickname)
	TextView nickname;

	@InjectView(R.id.birthday)
	TextView birthday;

	@InjectView(R.id.constellation)
	TextView constellation;

	@InjectView(R.id.age)
	TextView age;

	@InjectView(R.id.sex)
	TextView sex;

	@InjectView(R.id.shippingAddress)
	TextView shippingAddress;

	@InjectView(R.id.personalLabelList)
	FlowLayout personalLabelList;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_personal_info);
		ButterKnife.inject(this);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText(R.string.personal_info_title);
		((TextView) ButterKnife.findById(this, R.id.actionBarRightText))
				.setText(R.string.complete);
	}

	@Override
	protected void initData() {
		OkHttpClientManager.postAsyn(Api.PERSONAL_INFO, new OkHttpClientManager
						.ResultCallback<PersonalInfo>() {

					@Override
					public void onError(Request request, Exception e) {
						BaseApplication.toast("信息加载失败，请重试");
					}

					@Override
					public void onResponse(PersonalInfo response) {
						setPersonalInfo(response);
					}
				},
				new OkHttpClientManager.Param(RequestParam.UID, BaseApplication.getUserId()));
	}

	/**
	 * 根据获取到的数据设置个人信息
	 */
	private void setPersonalInfo(PersonalInfo personalInfo) {
		List<Constellation> xzlist = personalInfo.getXzlist();

		User user = personalInfo.getUserinfo().get(0);

		String avatarUrl = user.getAvatar();
		if(!TextUtils.isEmpty(avatarUrl)) {
			Picasso.with(this).load(Api.BASE_URL + "/" + avatarUrl)
					.error(R.mipmap.default_avatar).into(avatar);
		}
		nickname.setText(user.getNickname());

		String year = user.getYear();
		if(TextUtils.isEmpty(year)) {
			birthday.setText(user.getMonth() + "/" + user.getDay());
		} else {
			age.setText(Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR)
					- Integer.parseInt(year) + "");
			birthday.setText(year + "/" + user.getMonth() + "/" + user.getDay());
		}

		String xzId = user.getXingzuo();
		for(Constellation xz : xzlist) {
			if(xz.getId().equals(xzId)) {
				constellation.setText(xz.getName());
			}
		}

		sex.setText(user.getSex().equals("0") ? "女" : "男");
		shippingAddress.setText(user.getAddress());

		FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(-2, -2);//-2:WRAP_CONTENT
		params.setMargins(0, 0, 16, 20);
		for(Impression i : personalInfo.getImpresslist()) {
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
	@OnClick({ R.id.back, R.id.actionBarRightText, R.id.setAvatar })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.actionBarRightText:
				submitPersonalInfo();
				break;
			case R.id.setAvatar:
				break;
		}
	}

	/**
	 * 设置头像
	 */
	private void setAvatar() {

	}

	/**
	 * 提交编辑过的个人信息
	 */
	private void submitPersonalInfo() {
		//TODO 等待接口完善
	}
}
