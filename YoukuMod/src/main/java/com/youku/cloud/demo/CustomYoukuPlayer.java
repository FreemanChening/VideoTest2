package com.youku.cloud.demo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

import com.youku.cloud.player.IYoukuPlayer;
import com.youku.cloud.player.PlayerListener;
import com.youku.cloud.player.VideoDefinition;
import com.youku.cloud.player.YoukuPlayerResId;
import com.youku.cloud.player.YoukuRelativeLayout;
import com.youku.cloud.player.YoukuUIListener;
import com.youku.cloud.playerbase.R;
import com.youku.cloud.utils.PlayerUiUtile;

import java.util.List;


/**
 * 可以重写此类
 */
public class CustomYoukuPlayer extends YoukuRelativeLayout {

    private IYoukuPlayer youkuPlayer;

    public CustomYoukuPlayer(Context context) {
        super(context);
        init();
    }

    public CustomYoukuPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomYoukuPlayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        youkuPlayer = PlayerUiUtile.getInstance().getYoukuPlayer();
        if (youkuPlayer != null) {
            youkuPlayer.setResId(generateResId());
            youkuPlayer.init(this);
        } else {
        }
    }

    public void attachActivity(Activity activity) {
        youkuPlayer.attachActivity(activity);
    }

    public void changeSurfaceViewSize(int width, int height) {
        // TODO Auto-generated method stub
        youkuPlayer.changeSurfaceViewSize(width, height);
    }

    public void adaptVideoSize() {
        // TODO Auto-generated method stub
        youkuPlayer.adaptVideoSize();
    }

    public void setPlayerListener(PlayerListener playerListener) {
        // TODO Auto-generated method stub
        youkuPlayer.setPlayerListener(playerListener);
    }

    public void setUIListener(YoukuUIListener uiListener) {
        youkuPlayer.setUIListener(uiListener);
    }

    public void onPause() {
        // TODO Auto-generated method stub
        youkuPlayer.onPause();
    }

    public void onResume() {
        // TODO Auto-generated method stub
        youkuPlayer.onResume();
    }

    public void onDestroy() {
        // TODO Auto-generated method stub
        youkuPlayer.onDestroy();
    }

    public void changeOrientation() {
        // TODO Auto-generated method stub
        youkuPlayer.changeOrientation();

    }

    public boolean isFullScreen() {
        return youkuPlayer.isFullScreen();
    }

    public void goSmallScreen() {
        youkuPlayer.goSmallScreen();
    }

    public void goFullScreen() {
        youkuPlayer.goFullScreen();
    }

    public void showSystemUI() {
        youkuPlayer.showSystemUI();
    }

    public void hideSystemUI() {
        youkuPlayer.hideSystemUI();
    }

    /**
     * 锁定播放器旋转
     *
     * @param isLock 是否锁定
     */
    public void lockOrientation(boolean isLock) {
        // TODO Auto-generated method stub
        youkuPlayer.lockOrientation(isLock);
    }


    public void playYoukuPrivateVideo(String vid, String password) {
        // TODO Auto-generated method stub
        youkuPlayer.playYoukuPrivateVideo(vid, password);
    }


    public void playYoukuVideo(String vid) {
        // TODO Auto-generated method stub
        youkuPlayer.playYoukuVideo(vid);
    }

    @Deprecated
    public void playLocalVideo(String vid, String url, String title,
                               int totalSec, VideoDefinition quality, int progress) {
        // TODO Auto-generated method stub
        youkuPlayer
                .playLocalVideo(vid, url, title, totalSec, quality, progress);
    }

    public void playLocalVideo(String vid) {
        // TODO Auto-generated method stub
        youkuPlayer
                .playLocalVideo(vid);
    }


    public boolean getUseOrientation() {
        return youkuPlayer.getUseOrientation();
    }

    /**
     * 设置是否使用默认的转屏设置，禁用后可以自定义转屏，需要自己写代码实现
     *
     * @param useOrientation
     */
    public void setUseOrientation(boolean useOrientation) {
        youkuPlayer.setUseOrientation(useOrientation);
    }

    public boolean isShowBackBtn() {
        return youkuPlayer.isShowBackBtn();
    }

    /**
     * @param isshow false隐藏后退键
     */
    public void setShowBackBtn(boolean isshow) {
        youkuPlayer.setShowBackBtn(isshow);
    }

    public void setShowFullBtn(boolean isshow) {
        youkuPlayer.setShowFullBtn(isshow);
    }

    public void setIsStartWhenPrepared(boolean isStartWhenPrepared) {
        youkuPlayer.setIsStartWhenPrepared(isStartWhenPrepared);
    }

    public List<VideoDefinition> getSupportVideoDefinitions() {
        // TODO Auto-generated method stub
        return youkuPlayer.getSupportVideoDefinitions();
    }

    public void changeVideoDefinition(VideoDefinition definition) {
        // TODO Auto-generated method stub
        youkuPlayer.changeVideoDefinition(definition);
    }

    public void setPreferVideoDefinition(VideoDefinition definition) {
        // TODO Auto-generated method stub
        youkuPlayer.setPreferVideoDefinition(definition);
    }

    public VideoDefinition getCurrentVideoDefinition() {
        // TODO Auto-generated method stub
        return youkuPlayer.getCurrentVideoDefinition();
    }

    public void play() {
        // TODO Auto-generated method stub
        youkuPlayer.play();
    }

    public void pause() {
        // TODO Auto-generated method stub
        youkuPlayer.pause();
    }

    public void stop() {
        // TODO Auto-generated method stub
        youkuPlayer.stop();
    }

    public void release() {
        // TODO Auto-generated method stub
        youkuPlayer.release();
    }

    public void seekTo(int whereto) {
        // TODO Auto-generated method stub
        youkuPlayer.seekTo(whereto);
    }

    public int getCurrentPosition() {
        // TODO Auto-generated method stub
        return youkuPlayer.getCurrentPosition();
    }

    public boolean isPlaying() {
        // TODO Auto-generated method stub
        return youkuPlayer.isPlaying();
    }

    public boolean isReleased() {
        // TODO Auto-generated method stub
        return youkuPlayer.isReleased();
    }

    public long getDuration() {
        // TODO Auto-generated method stub
        return youkuPlayer.getDuration();
    }

    public int getHeadPosition() {
        // TODO Auto-generated method stub
        return youkuPlayer.getHeadPosition();
    }

    public int getTailPosition() {
        // TODO Auto-generated method stub
        return youkuPlayer.getTailPosition();
    }

    public String getTitle() {
        // TODO Auto-generated method stub
        return youkuPlayer.getTitle();
    }

    public void setSkipHead(boolean isskip) {
        // TODO Auto-generated method stub
        youkuPlayer.setSkipHead(isskip);
    }

    /**
     * 请勿修改！ 请勿修改！ 请勿修改！
     *
     * @return
     */
    private YoukuPlayerResId generateResId() {
        YoukuPlayerResId resId = new YoukuPlayerResId();

        // 广告控件id
        resId.setLayout_ad(R.layout.layout_ad);
        resId.setLayout_ad_pre(R.id.layout_ad_pre);
        resId.setLayout_ad_pause(R.id.layout_ad_pause);
        resId.setLayout_ad_sec(R.id.layout_ad_sec);
        resId.setLayout_ad_more(R.id.layout_ad_more);
        resId.setBtn_ad_back(R.id.btn_ad_back);
        resId.setBtn_ad_audio_vol(R.id.btn_ad_audio_vol);
        resId.setBtn_ad_fullscreen(R.id.btn_ad_fullscreen);
        resId.setImg_ad_pause(R.id.img_ad_pause);
        resId.setTxt_ad_pause_hint(R.id.txt_ad_pause_hint);
        resId.setBtn_ad_pause_close(R.id.btn_ad_pause_close);
        resId.setTxt_ad_sec(R.id.txt_ad_sec);
        // 播放器控件id
        resId.setLayout_player(R.layout.layout_player);
        resId.setLayout_player_head(R.id.layout_player_head);
        resId.setLayout_loading_head(R.id.layout_loading_head);
        resId.setLayout_player_loading(R.id.layout_player_loading);
        resId.setBtn_player_back2(R.id.btn_player_back2);
        resId.setLayout_player_foot(R.id.layout_player_foot);
        resId.setBtn_player_back(R.id.btn_player_back);
        resId.setBtn_player_play(R.id.btn_player_play);
        resId.setBtn_player_fullscreen(R.id.btn_player_fullscreen);
        resId.setTxt_player_title(R.id.txt_player_title);
        resId.setTxt_player_vq(R.id.txt_player_vq);
        resId.setBtn_player_replay(R.id.btn_player_replay);
        resId.setTxt_player_ctime(R.id.txt_player_ctime);
        resId.setTxt_player_ttime(R.id.txt_player_ttime);
        resId.setImg_player_headlogo(R.id.img_player_headlogo);
        resId.setSb_player_progress(R.id.sb_player_progress);
        resId.setImg_player_watermaker(R.id.img_watermarker);
        resId.setBar_loading_normal(R.id.bar_loading_normal);
        resId.setBar_loading_youku(R.id.bar_loading_youku);


        // 清晰度下拉菜单
        resId.setLayout_pop_vq(R.layout.vidqitem);
        resId.setVq0(R.id.vq0);
        resId.setVq1(R.id.vq1);
        resId.setVq2(R.id.vq2);
        // 部分图片资源
        resId.setNonedrawable(R.drawable.nonedrawable);
        resId.setAd_icon_volume_off(R.drawable.ad_icon_volume_off);
        resId.setAd_icon_volume(R.drawable.ad_icon_volume);
        resId.setIcon_pause_noband(R.drawable.icon_pause_noband);
        resId.setIcon_pause(R.drawable.icon_pause);
        resId.setIcon_play_noband(R.drawable.icon_play_noband);
        resId.setIcon_play(R.drawable.icon_play);
        resId.setVertical_logo(R.drawable.vertical_logo);
        resId.setPlayer_logo_youku(R.drawable.player_logo_youku);
        resId.setVertical_logo_tudou(R.drawable.vertical_logo_tudou);
        resId.setPlayer_logo_tudou(R.drawable.player_logo_tudou);
        resId.setIcon_smallscreen(R.drawable.icon_smallscreen);
        resId.setIcon_fullscreen(R.drawable.icon_fullscreen);


        //播放器surfaceView与播放器控件之间的view，此view可以自定义
        resId.setLayout_mid(R.layout.layout_mid);

        return resId;
    }
}
