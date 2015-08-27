package com.liuhui.ceremony.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.liuhui.ceremony.app.bean.GiftSchemeBean;

import java.util.List;

/**
 *  情礼攻略三级Tab 内容 ListView 适配器
 * Created by anany on 15/8/27.
 */
public class LoverGiftTabContentAdapter extends BaseAdapter {

    private Context mContext;

    List<GiftSchemeBean.IdealistEntity> idealistEntities;

    public LoverGiftTabContentAdapter(Context context, List<GiftSchemeBean.IdealistEntity> idealistEntities) {
        mContext = context;
        this.idealistEntities = idealistEntities;
    }

    @Override
    public int getCount() {
        return idealistEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return idealistEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    static class LoverGiftTabContentHolder{

    }
}
