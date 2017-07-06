package com.youku.cloud.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.youku.cloud.utils.CommonHttpClient;
import com.youku.cloud.utils.DeviceInfo;
import com.youku.cloud.utils.Logger;
import com.youku.cloud.utils.SdkApplication;
import com.youku.cloud.utils.http.async.IResponseHandler;

import java.io.File;
import java.util.List;
import java.util.Map;

public class TestActivity extends Activity {

    private SurfaceView surfaceView;
    private TextView txt1;
    private String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        txt1 = (TextView) findViewById(R.id.txt1);
        String sopath = "/data/data/" + getBaseContext().getPackageName() + "/lib/";
        RecursionFindFile(new File(sopath));
        txt1.setText(txt);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void RecursionFindFile(File file) {
        if (file.isFile()) {
            txt += "\n" + file.getName();
            return;
        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                return;
            }
            for (File f : childFile) {
                RecursionFindFile(f);
            }
        }
    }
}
