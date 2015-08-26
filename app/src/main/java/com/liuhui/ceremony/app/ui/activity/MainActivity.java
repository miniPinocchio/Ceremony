package com.liuhui.ceremony.app.ui.activity;

import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;
import com.liuhui.ceremony.app.AppManager;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.ui.fragment.DiscoverFragment;
import com.liuhui.ceremony.app.ui.fragment.GiftFragment;
import com.liuhui.ceremony.app.ui.fragment.PersonalFragment;
import com.liuhui.ceremony.app.ui.fragment.RelationshipFragment;

/**
 * 主界面
 * <p/>
 * created by annay
 */
public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    private long exitTime = 0;

    //定义FragmentTabHost对象
    private FragmentTabHost mTabHost;

    //定义一个布局
    private LayoutInflater layoutInflater;

    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {RelationshipFragment.class, GiftFragment.class, DiscoverFragment.class, PersonalFragment.class};

    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.tab_reationship_btn,
            R.drawable.tab_gift_btn, R.drawable.tab_discover_btn,
            R.drawable.tab_personal_btn};

    //定义数组来存放文字颜色
    private int mTextColorArray[] = {R.drawable.tab_reationship_text_color,
            R.drawable.tab_gift_text_color, R.drawable.tab_discover_text_color,
            R.drawable.tab_personal_text_color};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"关系", "情礼", "发现", "我的"};

    @Override
    protected void initViews() {

        setContentView(R.layout.activity_main);

        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }


        //得到fragment的个数
        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //设置Tab按钮的背景
           // mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
        mTabHost.setOnTabChangedListener(this);
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView iv_tab_icon = (ImageView) view.findViewById(R.id.iv_tab_icon);
        iv_tab_icon.setImageResource(mImageViewArray[index]);

        TextView tv_tab_text = (TextView) view.findViewById(R.id.tv_tab_text);
        tv_tab_text.setText(mTextviewArray[index]);
        tv_tab_text.setTextColor(getResources().getColorStateList(mTextColorArray[index]));

        return view;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                AppManager.getAppManager().AppExit(this);
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onTabChanged(String tabId) {
        final int size = mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
            View v = mTabHost.getTabWidget().getChildAt(i);
            if (i == mTabHost.getCurrentTab()) {
                v.setSelected(true);
            } else {
                v.setSelected(false);
            }
        }

        supportInvalidateOptionsMenu();
    }
}
