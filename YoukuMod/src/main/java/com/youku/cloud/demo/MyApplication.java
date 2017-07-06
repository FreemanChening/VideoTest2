package com.youku.cloud.demo;

import android.app.Application;

import com.ut.mini.internal.UTTeamWork;
import com.youku.cloud.player.YoukuPlayerConfig;
import com.youku.cloud.player.YoukuProfile;
import com.youku.cloud.utils.Logger;

import java.util.HashMap;

/**
 * Created by liyh on 2017/2/8.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //YoukuPlayerConfig.setClientIdAndSecret(/*请修改成你自己的clientId和clientSecret*/YoukuProfile.CLIENT_ID,YoukuProfile.CLIENT_SECRET);
        YoukuPlayerConfig.setClientIdAndSecret(/*请修改成你自己的clientId和clientSecret*/"21f4a662257951b4", "432adc3edb8782aac8bd8bb24f88206d");
        YoukuPlayerConfig.onInitial(this);
        YoukuPlayerConfig.setLog(false);
    }
}
