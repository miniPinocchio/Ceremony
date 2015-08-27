package com.liuhui.ceremony.app.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseHomeFragment;
import com.liuhui.ceremony.app.bean.PersonalInfo;
import com.liuhui.ceremony.app.bean.User;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.ui.activity.GiftRecordActivity;
import com.liuhui.ceremony.app.ui.activity.MyFavoriteActivity;
import com.liuhui.ceremony.app.ui.activity.MyStoryActivity;
import com.liuhui.ceremony.app.ui.activity.PersonalInfoActivity;
import com.liuhui.ceremony.app.ui.activity.RecordActivity;
import com.liuhui.ceremony.app.ui.activity.SettingActivity;
import com.liuhui.ceremony.app.ui.customview.roundedimageview.RoundedImageView;
import com.liuhui.ceremony.app.util.LogUtil;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * "我的"选项卡
 * Created by Berial on 15/8/14.
 */
public class PersonalFragment extends BaseHomeFragment {

	@InjectView(R.id.avatar)
	RoundedImageView avatar;

	@InjectView(R.id.nickname)
	TextView nickname;

	private PersonalInfo mPersonalInfo;

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container) {

		LogUtil.e("PersonalFragment initView");

		View view = inflater.inflate(R.layout.fragment_personal, container, false);
		ButterKnife.findById(view, R.id.back).setVisibility(View.GONE);
		((TextView) ButterKnife.findById(view, R.id.actionBarTitle)).setText(R.string.me);
		return view;
	}

	@Override
	public void initData() {
		LogUtil.e("PersonalFragment initData ---");

		String userId = BaseApplication.getUserId();
		if(mPersonalInfo == null && !TextUtils.isEmpty(userId)) {
			OkHttpClientManager.postAsyn(Api.PERSONAL_INFO, new OkHttpClientManager
							.ResultCallback<PersonalInfo>() {

						@Override
						public void onError(Request request, Exception e) {
							BaseApplication.toast("信息加载失败，请重试");
						}

						@Override
						public void onResponse(PersonalInfo response) {
							mPersonalInfo = response;
							setPersonalInfo();
						}
					},
					new OkHttpClientManager.Param(RequestParam.UID, userId));
		}
	}

	/**
	 * 根据获取到的数据设置个人信息
	 */
	private void setPersonalInfo() {
		User user = mPersonalInfo.getUserinfo().get(0);

		String avatarUrl = user.getAvatar();
		if(!TextUtils.isEmpty(avatarUrl)) {
			String absoluteAvatarUrl = Api.BASE_URL + "/" + avatarUrl;
			Glide.with(this).load(absoluteAvatarUrl).error(R.mipmap.default_avatar)
					.into(avatar);
		}

		String strNickname = user.getNickname();
		nickname.setText(TextUtils.isEmpty(strNickname) ? user.getMobile() : strNickname);
		nickname.setTag(user.getMobile());
	}

	@OnClick({ R.id.setting, R.id.personalInfo, R.id.giftRecord, R.id.impressionRecord,
			R.id.gradeRecord, R.id.myStory, R.id.myFavorite })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.gradeRecord:
			case R.id.impressionRecord:
				if(nickname.getTag() != null) {
					startActivity(new Intent(mActivity, RecordActivity.class)
							.putExtra(RequestParam.MOBILE, nickname.getTag().toString())
							.putExtra(RequestParam.NICKNAME, nickname.getText().toString())
							.putExtra("recordType", view.getId()));
				}
				break;
			case R.id.myStory:
				startActivity(new Intent(mActivity, MyStoryActivity.class));
				break;
			case R.id.myFavorite:
				startActivity(new Intent(mActivity, MyFavoriteActivity.class));
				break;
			case R.id.giftRecord:
				startActivity(new Intent(mActivity, GiftRecordActivity.class));
				break;
			case R.id.setting:
				startActivity(new Intent(mActivity, SettingActivity.class));
				break;
			case R.id.personalInfo:
				startActivityForResult(new Intent(mActivity, PersonalInfoActivity.class)
						.putExtra("personalInfo", mPersonalInfo), 0);
				break;
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == Activity.RESULT_OK) {
			nickname.setText(data.getStringExtra(RequestParam.NICKNAME));
			//TODO 等待完成上传头像接口
		}
	}
}
