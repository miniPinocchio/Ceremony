package com.liuhui.ceremony.app.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.liuhui.ceremony.app.Api;
import com.liuhui.ceremony.app.BaseApplication;
import com.liuhui.ceremony.app.R;
import com.liuhui.ceremony.app.adapter.GalleryListAdapter;
import com.liuhui.ceremony.app.base.BaseActivity;
import com.liuhui.ceremony.app.bean.GralleryItemList;
import com.liuhui.ceremony.app.ui.customview.SwRefreshLayout;
import com.liuhui.ceremony.app.util.LogUtil;
import com.liuhui.ceremony.app.util.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 发现 -> 相册
 * Created by anany on 15/8/21.
 */
public class DiscoverGalleryActivity extends BaseActivity {

    @InjectView(R.id.actionBarTitle)
    public TextView actionBarTitle;

    @InjectView(R.id.swipe_container)
    public SwRefreshLayout swipe_container;

    @InjectView(R.id.lv_grallery)
    public ListView lv_grallery;

    private String userId;

    GralleryItemList gralleryItemListBean;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_grallery);

        ButterKnife.inject(this);

        actionBarTitle.setText("相册");
        ((TextView) ButterKnife.findById(this, R.id.actionBarRightText)).setText("发布");

        userId = BaseApplication.getInstance().getUserId();

        swipe_container.setColorScheme(R.color.green,
                R.color.gray, R.color.lightblue, R.color.red);//设置跑动的颜色值

        /**
         * 下拉刷新
         */
        swipe_container.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                //重新刷新页面
            }
        });

//        swipe_container.setOnLoadListener(new SwRefreshLayout.OnLoadListener() {
//            @Override
//            public void onLoad() {
//            }
//        });

        final GalleryListAdapter adapter = new GalleryListAdapter(DiscoverGalleryActivity.this
                , gralleryItemListBean);

        lv_grallery.setAdapter(adapter);

        OkHttpClientManager.postAsyn(Api.GALLERY,
                new OkHttpClientManager.ResultCallback<GralleryItemList>() {

                    @Override
                    public void onError(Request request, Exception e) {
                        LogUtil.e(e.toString());
                    }

                    @Override
                    public void onResponse(GralleryItemList gralleryItemList) {
                        //list = gralleryItemList;
                        adapter.setData(gralleryItemList);
                        adapter.notifyDataSetChanged();
                    }
                }
                , new OkHttpClientManager.Param("uid", userId));
    }


}
