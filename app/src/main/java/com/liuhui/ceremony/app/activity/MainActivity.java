package com.liuhui.ceremony.app.activity;

import android.view.KeyEvent;
import android.widget.Toast;

import com.liuhui.ceremony.app.AppManager;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.base.BaseActivity;

/**
 * 主界面
 *
 * created by annay
 */
public class MainActivity extends BaseActivity {

    private long exitTime = 0;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
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
}
