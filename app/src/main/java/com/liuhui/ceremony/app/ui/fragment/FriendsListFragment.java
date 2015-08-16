package com.liuhui.ceremony.app.ui.fragment;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.ceremony.app.ui.fragment
 * user  Pinocchio
 * Date 2015/8/16
 * Email:liu594545591@126.com
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseFragment;

/**
 * 关系界面 好友列表
 */
public class FriendsListFragment extends BaseFragment {


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.
                inflate(R.layout.fragment_relationship_list_group,
                        container, false);
        return view;
    }

    @Override
    public void initData() {


    }
}
