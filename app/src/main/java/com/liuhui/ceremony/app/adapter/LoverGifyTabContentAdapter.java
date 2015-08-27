package com.liuhui.ceremony.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.liuhui.ceremony.app.bean.GiftSchemeBean;

/**
 * Created by anany on 15/8/27.
 */
public class LoverGifyTabContentAdapter extends BaseAdapter {

    private Context mContext;

    private GiftSchemeBean giftSchemeBean;

    public LoverGifyTabContentAdapter(Context context, GiftSchemeBean giftSchemeBean) {
        mContext = context;
        this.giftSchemeBean = giftSchemeBean;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
