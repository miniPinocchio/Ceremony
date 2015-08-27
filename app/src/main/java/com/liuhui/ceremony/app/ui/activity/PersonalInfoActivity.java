package com.liuhui.ceremony.app.ui.activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.Constellation;
import com.liuhui.ceremony.app.bean.Impression;
import com.liuhui.ceremony.app.bean.PersonalInfo;
import com.liuhui.ceremony.app.bean.ResponseBody;
import com.liuhui.ceremony.app.bean.User;
import com.liuhui.ceremony.app.constant.RequestParam;
import com.liuhui.ceremony.app.ui.customview.FlowLayout;
import com.liuhui.ceremony.app.ui.customview.roundedimageview.RoundedImageView;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 个人信息
 * <p/>
 * Created by berial on 15/8/21.
 */
public class PersonalInfoActivity extends BaseActivity {

	private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
	private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	private static final int PHOTO_REQUEST_CUT = 3;// 结果

	@InjectView(R.id.avatar)
	RoundedImageView avatar;

	@InjectView(R.id.nickname)
	EditText nickname;

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

	private Intent data = new Intent();
	private File image;

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
		PersonalInfo personalInfo = getIntent().getParcelableExtra("personalInfo");
		String userId = BaseApplication.getUserId();
		if(personalInfo != null) {
			setPersonalInfo(personalInfo);
		} else if(!TextUtils.isEmpty(userId)) {
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
					new OkHttpClientManager.Param(RequestParam.UID, userId));
		}
	}

	/**
	 * 根据获取到的数据设置个人信息
	 */
	private void setPersonalInfo(PersonalInfo personalInfo) {
		List<Constellation> xzlist = personalInfo.getXzlist();
		User user = personalInfo.getUserinfo().get(0);

		String avatarUrl = user.getAvatar();
		if(!TextUtils.isEmpty(avatarUrl)) {
			String absoluteAvatarUrl = Api.BASE_URL + "/" + avatarUrl;
			Glide.with(this).load(absoluteAvatarUrl).error(R.mipmap.default_avatar)
					.into(avatar);
		}

		String strNickname = user.getNickname();
		nickname.setText(TextUtils.isEmpty(strNickname) ? user.getMobile() : strNickname);

		String year = user.getYear();
		if(!TextUtils.isEmpty(year)) {
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

		List<Impression> impressionList = personalInfo.getImpresslist();
		personalLabelList.setTag(new Gson().toJson(impressionList));
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
	@OnClick({ R.id.back, R.id.actionBarRightText, R.id.setAvatar, R.id.setBirthday,
			R.id.setSex, R.id.editPersonalLabel })
	void setClickEvent(View view) {
		switch(view.getId()) {
			case R.id.back:
				setResult(RESULT_OK, data);
				finish();
				break;
			case R.id.actionBarRightText:
				submitPersonalInfo();
				break;
			case R.id.setAvatar:
				setAvatar();
				break;
			case R.id.setBirthday:
				setBirthday();
				break;
			case R.id.setSex:
				setSex();
				break;
			case R.id.editPersonalLabel:
				startActivityForResult(new Intent(this, EditPersonalLabelActivity.class)
						.putExtra("nickname", nickname.getText().toString()).putExtra("personalLabelJson",
								personalLabelList.getTag().toString()), 0);
				break;
		}
	}

	/**
	 * 设置头像
	 */
	private void setAvatar() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setItems(R.array.set_avatar, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch(which) {
					case 0:
						image = new File(getExternalFilesDir(Environment.DIRECTORY_DCIM),
								System.currentTimeMillis() + ".png");
						Intent i = new Intent();
						i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
						i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image));
						startActivityForResult(i, PHOTO_REQUEST_CAMERA);
						break;
					case 1:
						Intent intent = new Intent();
						intent.setAction(Intent.ACTION_PICK);
						intent.setType("image/*");
						startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
						break;
				}
				dialog.dismiss();
			}
		});
		builder.show();
	}

	/**
	 * 设置性别
	 */
	private void setSex() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final String[] sexes = { "保密", "男", "女" };
		builder.setItems(sexes, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				sex.setText(sexes[which]);
				sex.setTag(which + "");
				dialog.dismiss();
			}
		});
		builder.show();
	}

	/**
	 * 设置生日
	 */
	private void setBirthday() {
		Calendar calendar = Calendar.getInstance();
		new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				birthday.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
				birthday.setTag(new String[]{ year + "", monthOfYear + 1 + "", dayOfMonth + "" });
			}
		}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH)).show();
	}

	/**
	 * 提交编辑过的个人信息
	 */
	private void submitPersonalInfo() {
		HashMap<String, String> editedPersonalInfo = new HashMap<>(6);

		editedPersonalInfo.put(RequestParam.NICKNAME, nickname.getText().toString());

		String strSex = (String) sex.getTag();
		if(!TextUtils.isEmpty(strSex)) {
			editedPersonalInfo.put(RequestParam.SEX, strSex);
		}

		String[] arrBirthday = (String[]) birthday.getTag();
		if(arrBirthday != null) {
			editedPersonalInfo.put(RequestParam.YEAR, arrBirthday[0]);
			editedPersonalInfo.put(RequestParam.MONTH, arrBirthday[1]);
			editedPersonalInfo.put(RequestParam.DAY, arrBirthday[2]);
		}

		//TODO 修改送货地址

		OkHttpClientManager.postAsyn(Api.EDIT_PERSONAL_INFO, new OkHttpClientManager
				.ResultCallback<ResponseBody>() {

			@Override
			public void onError(Request request, Exception e) {
				BaseApplication.toast("信息加载失败，请重试");
			}

			@Override
			public void onResponse(ResponseBody response) {
				switch(response.getStatus()) {
					case "1":
						BaseApplication.toast("修改成功");
						finish();
						break;
					case "0":
						BaseApplication.toast("修改失败，请重试");
						break;
				}
			}
		}, editedPersonalInfo);
	}

	/**
	 * 图片缩放
	 */
	private void startPhotoZoom(Uri uri, int size) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// crop为true是设置在开启的intent中设置显示的view可以剪裁
		intent.putExtra("crop", "true");
		intent.putExtra("scale", true);// 去黑边
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);

		// outputX,outputY 是剪裁图片的宽高
		intent.putExtra("outputX", size);
		intent.putExtra("outputY", size);
		intent.putExtra("return-data", true);

		startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}

	/**
	 * 将进行剪裁后的图片显示到UI界面上
	 */
	private void setPicToView(Intent data) {
		Bitmap photo = data.getParcelableExtra("data");
		avatar.setImageBitmap(photo);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode) {
			case PHOTO_REQUEST_CAMERA:
				startPhotoZoom(Uri.fromFile(image), 128);
				break;
			case PHOTO_REQUEST_GALLERY:
				if(data != null) {
					startPhotoZoom(data.getData(), 128);
				}
				break;
			case PHOTO_REQUEST_CUT:
				if(data != null) {
					setPicToView(data);
				}
				break;
		}
	}
}
