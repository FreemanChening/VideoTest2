package com.youku.cloud.demo;

import com.youku.cloud.demo.downloader.DownLoadManager;
import com.youku.cloud.player.PlayerListener;
import com.youku.cloud.player.VideoDefinition;
import com.youku.cloud.player.YoukuPlayerView;
import com.youku.cloud.player.YoukuUIListener;
import com.youku.cloud.utils.PlayerUtils;
import com.youku.cloud.utils.ValidateUtil;
import com.youku.download.DownInfo;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabletPlayerActivity extends Activity implements YoukuUIListener {
    private String vid;
    private Button btn1, btn2;
    private LinearLayout baseviewlayout;
    private TextView txt1;
    protected YoukuPlayerView youkuPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet_player);
        // 解析intent
        readIntent();
        youkuPlayerView = (YoukuPlayerView) findViewById(R.id.baseview);
        // 初始化播放器
        youkuPlayerView.attachActivity(this);
        // 不使用默认的横竖屏设置
        youkuPlayerView.setUseOrientation(false);
        youkuPlayerView.setPreferVideoDefinition(VideoDefinition.VIDEO_HD);
        youkuPlayerView.setPlayerListener(new MyPlayerListener());
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        txt1 = (TextView) findViewById(R.id.txt1);
        baseviewlayout = (LinearLayout) findViewById(R.id.baseviewlayout);
        autoplayvideo();
        initView();
    }

    private void readIntent() {
        Intent intent = getIntent();
        vid = intent.getStringExtra("vid");
    }

    private void initView() {
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                youkuPlayerView.playYoukuVideo("XMjQ3Mzk2MjUxNg==");
            }
        });
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                youkuPlayerView.changeSurfaceViewSize(1080, 607);
            }
        });

        youkuPlayerView.setUIListener(this);

        // 使页面初始为横屏
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 设置播放器初始状态为平板小屏
        goTabletSmall();
    }

    // 进入activity后自动播放，如不需要
    private void autoplayvideo() {
        if (ValidateUtil.isValid(vid)) {// vid有效
            youkuPlayerView.playYoukuVideo(vid);
        }
    }

    // 添加播放器的监听器
    private class MyPlayerListener extends PlayerListener {
        // 按需添加...
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 必须重写的onPause()
        youkuPlayerView.onPause();
        android.util.Log.e("liyh", "player onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 必须重写的onResume()
        youkuPlayerView.onResume();
        android.util.Log.e("liyh", "player onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 必须重写的onDestroy()
        youkuPlayerView.onDestroy();
        android.util.Log.e("liyh", "player onDestroy");
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 即使响应为竖屏，也强制设置为横屏，这样可以始终保持横屏
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    public void onBackBtnClick() {
        // TODO Auto-generated method stub
        finish();
    }

    @Override
    public void onFullBtnClick() {
        // TODO Auto-generated method stub
        if (youkuPlayerView.isFullScreen()) {
            goTabletSmall();
        } else {
            goTabletFull();
        }
    }

    // 平板小屏状态
    private void goTabletSmall() {
        youkuPlayerView.goSmallScreen();
        youkuPlayerView.showSystemUI();
        LayoutParams params = baseviewlayout.getLayoutParams();
        params.width = PlayerUtils.dip2px(400);
        params.height = PlayerUtils.dip2px(400f * 9f / 16f);
        baseviewlayout.setLayoutParams(params);
    }

    // 平板全屏状态
    private void goTabletFull() {
        youkuPlayerView.goFullScreen();
        youkuPlayerView.hideSystemUI();
        LayoutParams params = baseviewlayout.getLayoutParams();
        params.width = LayoutParams.MATCH_PARENT;
        params.height = LayoutParams.MATCH_PARENT;
        baseviewlayout.setLayoutParams(params);
    }

}
