package com.liuhui.ceremony.app.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.adapter.ListFriendsViewpagerAdapter;
import com.liuhui.ceremony.app.base.BaseFragment;
import com.liuhui.ceremony.app.util.LogUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anany on 15/8/14.
 */
public class RelationshipFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup listGroup;
    private ViewPager viewpager;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        //TODO 关系图
        View view = inflater.inflate(R.layout.fragment_relationship, container, false);
        Button contacts = (Button) view.findViewById(R.id.relationship_contacts);
        Button netPicture = (Button) view.findViewById(R.id.relationship_net_picture);
        Button groupAssistant = (Button) view.findViewById(R.id.relationship_group_assistant);

        LinearLayout impress = (LinearLayout) view.findViewById(R.id.realationship_my_impress_linearlayout);
        LinearLayout rank = (LinearLayout) view.findViewById(R.id.realationship_my_rank_linearlayout);
        LinearLayout scores = (LinearLayout) view.findViewById(R.id.realationship_my_scores_linearlayout);

        listGroup = (RadioGroup) view.findViewById(R.id.realationship_list_group);

        viewpager = (ViewPager) view.findViewById(R.id.relationship_viewpager);

        listGroup.setOnCheckedChangeListener(this);

        viewpager.addOnPageChangeListener(this);
        viewpager.setCurrentItem(0);

        FriendsListFragment listFragment = new FriendsListFragment();
        GroupListFragment groupListFragment = new GroupListFragment();

        List<Fragment> fragments = new LinkedList<Fragment>();
        fragments.add(listFragment);
        fragments.add(groupListFragment);
        ListFriendsViewpagerAdapter adapter = new ListFriendsViewpagerAdapter(
                getActivity().getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        return view;
    }

    @Override
    public void initData() {
        LogUtil.e("RelationshipFragment initData ---");
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        int currentItem = viewpager.getCurrentItem();
        switch (currentItem){
            case 0:
                listGroup.check(R.id.realationship_list_group_button1);
                break;
            case 1:
                listGroup.check(R.id.realationship_list_group_button2);
                break;
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.realationship_list_group_button1:
                viewpager.setCurrentItem(0);
                break;
            case R.id.realationship_list_group_button2:
                viewpager.setCurrentItem(1);
                break;
        }
    }
}
