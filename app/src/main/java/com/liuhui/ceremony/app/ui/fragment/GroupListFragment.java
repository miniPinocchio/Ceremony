package com.liuhui.ceremony.app.ui.fragment;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.adapter.ListFriendAdapter;
import com.liuhui.ceremony.app.base.BaseFragment;
import com.liuhui.ceremony.app.ui.customview.MyLetterListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.ceremony.app.ui.fragment
 * user  Pinocchio
 * Date 2015/8/16
 * Email:liu594545591@126.com
 */

/**
 * 关系界面 分组列表
 */
public class GroupListFragment extends BaseFragment {
    private BaseAdapter adapter;
    private ListView personList;
    private TextView overlay;
    private MyLetterListView letterListView;
    private AsyncQueryHandler asyncQuery;
    private static final String NAME = "name", NUMBER = "number", SORT_KEY = "sort_key";
    private HashMap<String, Integer> alphaIndexer;//存放存在的汉语拼音首字母和与之对应的列表位置
    private String[] sections;//存放存在的汉语拼音首字母
    private Handler handler;
    private OverlayThread overlayThread;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(
                R.layout.fragment_relationship_list_friends, container, false);

        personList = (ListView) view.findViewById(R.id.list_view);
        letterListView = (MyLetterListView) view.findViewById(R.id.MyLetterListView01);
        letterListView.setOnTouchingLetterChangedListener(new LetterListViewListener());

        asyncQuery = new MyAsyncQueryHandler(getActivity().getContentResolver());
        alphaIndexer = new HashMap<String, Integer>();
        handler = new Handler();
        overlayThread = new OverlayThread();
        initOverlay();
        return view;
    }

    //初始化汉语拼音首字母弹出提示框
    private void initOverlay() {
        Uri uri = Uri.parse("content://com.android.contacts/data/phones");
        String[] projection = {"_id", "display_name", "data1", "sort_key"};
        asyncQuery.startQuery(0, null, uri, projection, null, null,
                "sort_key COLLATE LOCALIZED asc");
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        overlay = (TextView) inflater.inflate(R.layout.relationship_list_friends_overlay,
                null);
        overlay.setVisibility(View.INVISIBLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(overlay, lp);
    }

    private void setAdapter(List<ContentValues> list) {
        adapter = new ListFriendAdapter(getActivity(), list);
        personList.setAdapter(adapter);

    }

    @Override
    public void initData() {

    }


    private class LetterListViewListener implements MyLetterListView.OnTouchingLetterChangedListener {

        @Override
        public void onTouchingLetterChanged(final String s) {
            if (alphaIndexer.get(s) != null) {
                int position = alphaIndexer.get(s);
                personList.setSelection(position);
                overlay.setText(sections[position]);
                overlay.setVisibility(View.VISIBLE);
                handler.removeCallbacks(overlayThread);
                //延迟一秒后执行，让overlay为不可见
                handler.postDelayed(overlayThread, 1500);
            }
        }

    }

    //查询联系人
    private class MyAsyncQueryHandler extends AsyncQueryHandler {

        public MyAsyncQueryHandler(ContentResolver cr) {
            super(cr);

        }

        @Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                List<ContentValues> list = new ArrayList<ContentValues>();
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    ContentValues cv = new ContentValues();
                    cursor.moveToPosition(i);
                    String name = cursor.getString(1);
                    String number = cursor.getString(2);
                    String sortKey = cursor.getString(3);
                    if (number.startsWith("+86")) {
                        cv.put(NAME, name);
                        cv.put(NUMBER, number.substring(3));  //去掉+86
                        cv.put(SORT_KEY, sortKey);
                    } else {
                        cv.put(NAME, name);
                        cv.put(NUMBER, number);
                        cv.put(SORT_KEY, sortKey);
                    }
                    list.add(cv);
                }
                if (list.size() > 0) {
                    setAdapter(list);
                }
            }
        }

    }


    //设置overlay不可见
    private class OverlayThread implements Runnable {

        @Override
        public void run() {
            overlay.setVisibility(View.GONE);
        }

    }
}
