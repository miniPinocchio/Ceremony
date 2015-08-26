package com.liuhui.ceremony.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.bean.GralleryItemList;
import com.liuhui.ceremony.app.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 相册ListView数据适配器
 * Created by anany on 15/8/25.
 */
public class GralleryListAdapter extends BaseAdapter {

    GralleryItemList gralleryItemList;
    Context context;

    public GralleryListAdapter(Context context, GralleryItemList gralleryItemList) {

        this.context = context;
        this.gralleryItemList = gralleryItemList;
    }

    @Override
    public int getCount() {
        if (gralleryItemList != null) {
            return gralleryItemList.getList().size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return gralleryItemList.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GralleryItemList.ListEntity bean = gralleryItemList.getList().get(position);

        GralleryHolder holder = null;

        if (convertView == null) {

            convertView = View.inflate(context, R.layout.item_grallery, null);
            holder = new GralleryHolder();

            holder.tv_day = (TextView) convertView.findViewById(R.id.tv_day);
            holder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);

            holder.iv_item_1 = (ImageView) convertView.findViewById(R.id.iv_item_1);
            holder.iv_item_2 = (ImageView) convertView.findViewById(R.id.iv_item_2);
            holder.iv_item_3 = (ImageView) convertView.findViewById(R.id.iv_item_3);

            convertView.setTag(holder);

        } else {
            holder = (GralleryHolder) convertView.getTag();
        }

        List<String> urlstr = bean.getImgurl();

        if (urlstr != null) {
            try {
                String imgUrl1= Api.BASE_URL + "/" + urlstr.get(0);
                String imgUrl2= Api.BASE_URL + "/" + urlstr.get(1);
                String imgUrl3= Api.BASE_URL + "/" + urlstr.get(2);

                Glide.with(context).load(imgUrl1)
                        .into(holder.iv_item_1);
                Glide.with(context).load(imgUrl2)
                        .into(holder.iv_item_2);
                Glide.with(context).load(imgUrl3)
                        .into(holder.iv_item_3);
            } catch (Exception e) {
                LogUtil.e("获取图片失败");
            }
        }

        String addtime = bean.getAddtime();

        if (!TextUtils.isEmpty(addtime)) {

            long time = Long.parseLong(addtime);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
            Date date = new Date(time * 1000);

            String str_year = sdf.format(date);

            SimpleDateFormat sdf2 = new SimpleDateFormat("dd日");
            Date date2 = new Date(time * 1000);

            String str_day = sdf2.format(date2);

            holder.tv_year.setText(str_year);
            holder.tv_day.setText(str_day);
        }


        return convertView;
    }

    static class GralleryHolder {

        public TextView tv_day;
        public TextView tv_year;

        public ImageView iv_item_1;
        public ImageView iv_item_2;
        public ImageView iv_item_3;
    }
}


