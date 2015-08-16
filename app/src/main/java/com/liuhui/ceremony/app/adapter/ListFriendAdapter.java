package com.liuhui.ceremony.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.liuhui.ceremony.app.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.ceremony.app.adapter
 * user  Pinocchio
 * Date 2015/8/16
 * Email:liu594545591@126.com
 */
public class ListFriendAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<ContentValues> list;
    private Map<String,Integer> alphaIndexer;
    private String [] sections;
    private static final String NAME = "name", NUMBER = "number", SORT_KEY = "sort_key";


    public ListFriendAdapter(Context context, List<ContentValues> list) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        alphaIndexer = new HashMap<String, Integer>();
        sections = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            //当前汉语拼音首字母
            String currentStr = getAlpha(list.get(i).getAsString(SORT_KEY));
            //上一个汉语拼音首字母，如果不存在为“ ”
            String previewStr = (i - 1) >= 0 ? getAlpha(list.get(i - 1).getAsString(SORT_KEY)) : " ";

            if (!previewStr.equals(currentStr)) {
                String name = getAlpha(list.get(i).getAsString(SORT_KEY));
                alphaIndexer.put(name, i);
                sections[i] = name;
            }
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.relationship_list_friend_item,parent,false);
            holder = new ViewHolder();
            holder.alpha = (TextView) convertView.findViewById(R.id.alpha);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.number = (TextView) convertView.findViewById(R.id.number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ContentValues cv = list.get(position);
        holder.name.setText(cv.getAsString(NAME));
        holder.number.setText(cv.getAsString(NUMBER));
        //当前首字母
        String currentStr = getAlpha(list.get(position).getAsString(SORT_KEY));

        //前一个首字母
        String previewStr = (position - 1) >= 0 ? getAlpha(list.get(position - 1).getAsString(SORT_KEY)) : " ";
        if (!previewStr.equals(currentStr)) {
            holder.alpha.setVisibility(View.VISIBLE);
            holder.alpha.setText(currentStr);
        } else {
            holder.alpha.setVisibility(View.GONE);
        }
        return convertView;
    }

    private class ViewHolder {
        TextView alpha;
        TextView name;
        TextView number;
    }
    //获得汉语拼音首字母
    private String getAlpha(String str) {
        if (str == null) {
            return "#";
        }

        if (str.trim().length() == 0) {
            return "#";
        }

        char c = str.trim().substring(0, 1).charAt(0);
        // 正则表达式，判断首字母是否是英文字母
        Pattern pattern = Pattern.compile("^[A-Za-z]+$");
        if (pattern.matcher(String.valueOf(c)).matches()) {
            return (String.valueOf(c)).toUpperCase();
        } else {
            return "#";
        }
    }
}
