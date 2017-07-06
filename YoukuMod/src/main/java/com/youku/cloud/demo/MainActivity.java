package com.youku.cloud.demo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.youku.cloud.demo.widget.MySpanner;
import com.youku.cloud.player.YoukuPlayerConfig;
import com.youku.cloud.player.YoukuProfile;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText et_ak, et_sk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn_player);
        button.setOnClickListener(this);

        et_ak = (EditText) findViewById(R.id.et_ak);
        et_sk = (EditText) findViewById(R.id.et_sk);
        et_ak.setText("21f4a662257951b4");
        et_sk.setText("432adc3edb8782aac8bd8bb24f88206d");
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 0x11);
    }

    @Override
    public void onClick(View v) {

        et_ak.setText("21f4a662257951b4");
        et_sk.setText("432adc3edb8782aac8bd8bb24f88206d");
        // TODO Auto-generated method stub
        YoukuPlayerConfig.setClientIdAndSecret(et_ak.getText().toString(),
                et_sk.getText().toString());

                Intent i = new Intent(MainActivity.this, PlayerActivity.class);
                MainActivity.this.startActivity(i);; // 跳转到播放界面



    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
}
