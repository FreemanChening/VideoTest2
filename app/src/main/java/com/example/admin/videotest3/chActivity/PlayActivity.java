package com.example.admin.videotest3.chActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.example.admin.videotest3.R;
import com.youku.cloud.demo.PlayerActivity;
import com.youku.cloud.module.PlayerErrorInfo;
import com.youku.cloud.player.PlayerListener;
import com.youku.cloud.player.VideoDefinition;
import com.youku.cloud.player.YoukuPlayerView;

//import com.youku.cloud.demo.downloader.DownLoadManager;

/**
 * 播放器播放界面
 */
public class PlayActivity extends PlayerActivity {




    private String vid;
    private String password=null;
    private boolean local = false;
    private YoukuPlayerView youkuPlayerView;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.youku.cloud.demo.R.layout.activity_player);
        // 解析intent
        readIntent();
        youkuPlayerView = (YoukuPlayerView) findViewById(com.youku.cloud.demo.R.id.baseview);
        txt1 = (TextView) findViewById(com.youku.cloud.demo.R.id.txt1);
        // 初始化播放器
        youkuPlayerView.attachActivity(this);
        youkuPlayerView.setPreferVideoDefinition(VideoDefinition.VIDEO_HD);
        youkuPlayerView.setShowBackBtn(true);
        youkuPlayerView.setPlayerListener(new MyPlayerListener());
        Log.e("liyh", "play");

        autoplayvideo();
    }

    private void readIntent() {
        Intent intent = getIntent();
        vid = intent.getStringExtra("vid");
        /*
        local = intent.getBooleanExtra("local", false);
        password = intent.getStringExtra("password");
        */
    }

    // 进入activity后自动播放，如不需要
    private void autoplayvideo() {
        if (local) {
            youkuPlayerView.playLocalVideo(vid);
        } else {
            if (TextUtils.isEmpty(password)) {
                youkuPlayerView.playYoukuVideo(vid);
            } else {
                youkuPlayerView.playYoukuPrivateVideo(vid, password);
            }
        }

    }

    @Override
    protected void onPause() {
        youkuPlayerView.onPause();
        android.util.Log.e("liyh", "player onPause");
        super.onPause();
        // 必须重写的onPause()

    }

    @Override
    protected void onResume() {
        youkuPlayerView.onResume();
        android.util.Log.e("liyh", "player onResume");
        super.onResume();
        // 必须重写的onResume()

    }

    @Override
    protected void onDestroy() {
        youkuPlayerView.onDestroy();
        android.util.Log.e("liyh", "player onDestroy");
        super.onDestroy();
        // 必须重写的onDestroy()

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        android.util.Log.e("liyh", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        android.util.Log.e("liyh", "onSaveInstanceState2");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        //后退键的处理，当全屏时，后退为变为小屏
        if (youkuPlayerView.isFullScreen()) {
            youkuPlayerView.goSmallScreen();
        } else {
            super.onBackPressed();
        }
    }


    // 添加播放器的监听器
    private class MyPlayerListener extends PlayerListener {
        @Override
        public void onComplete() {
            // TODO Auto-generated method stub
            super.onComplete();
        }

        @Override
        public void onError(int code, PlayerErrorInfo info) {
            // TODO Auto-generated method stub
            txt1.setText(info.getDesc());
        }

        @Override
        public void OnCurrentPositionChanged(int msec) {
            // TODO Auto-generated method stub
            super.OnCurrentPositionChanged(msec);
        }

        @Override
        public void onVideoNeedPassword(int code) {
            // TODO Auto-generated method stub
            super.onVideoNeedPassword(code);
        }

        @Override
        public void onVideoSizeChanged(int width, int height) {
            // TODO Auto-generated method stub
            super.onVideoSizeChanged(width, height);
        }
    }

}
