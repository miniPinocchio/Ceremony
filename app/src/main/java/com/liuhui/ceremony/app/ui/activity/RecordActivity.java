package com.liuhui.ceremony.app.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.adapter.QuickAdapter;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.GradeRecord;
import com.liuhui.ceremony.app.bean.GradeUser;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 打分记录、印象记录
 * <p/>
 * Created by berial on 15/8/23.
 */
public class RecordActivity extends BaseActivity {

	@InjectView(R.id.radioGroup)
	RadioGroup mRadioGroup;

	@InjectView(R.id.record)
	ListView record;

	private int recordType;
	private String mobile;

	private QuickAdapter<GradeUser> gradeUserAdapter;

	@Override
	protected void initViews() {
		setContentView(R.layout.activity_record);
		ButterKnife.inject(this);
		Intent intent = getIntent();
		recordType = intent.getIntExtra("recordType", R.id.impressionRecord);
		mobile = intent.getStringExtra(RequestParam.MOBILE);
		mRadioGroup.check(recordType);
		((TextView) ButterKnife.findById(this, R.id.actionBarTitle))
				.setText(intent.getStringExtra(RequestParam.NICKNAME));
		//ButterKnife.findById(this, R.id.back).setVisibility(View.GONE);
	}

	@Override
	protected void initData() {
		gradeUserAdapter = new QuickAdapter<GradeUser>(R.layout.item_grade_record) {

			@Override
			public void bindView(ViewHolder holder, GradeUser obj) {
				String avatarUrl = obj.getAvatar();
				if(!TextUtils.isEmpty(avatarUrl)) {
					holder.setImageUrl(R.id.avatar, Api.BASE_URL + "/" + avatarUrl);
				}

				String nickname = obj.getNickname();
				holder.setText(R.id.nickname, TextUtils.isEmpty(nickname) ?
						obj.getMobile() : nickname).setText(R.id.grade, obj.getGrade() + "分")
						.setText(R.id.praiseNum, obj.getPraisenum())
						.setText(R.id.commentNum, obj.getCommentnum());
			}
		};
		switch(recordType) {
			case R.id.gradeRecord:
				if(gradeUserAdapter.getCount() == 0) {
					OkHttpClientManager.postAsyn(Api.GRADE, new OkHttpClientManager.ResultCallback<GradeRecord>() {

						@Override
						public void onError(Request request, Exception e) {
							BaseApplication.toast("获取信息失败，请重试");
						}

						@Override
						public void onResponse(GradeRecord response) {
							gradeUserAdapter.addAll(response.getList());
						}
					}, new OkHttpClientManager.Param(RequestParam.MOBILE, mobile));
				}
				record.setAdapter(gradeUserAdapter);
				break;
			case R.id.impressionRecord:
				break;
		}
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
