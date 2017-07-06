package com.example.admin.videotest3.chActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.admin.videotest3.R;
import com.youku.cloud.demo.*;

public class WelcomePageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomePageActivity.this,MainActivity.class);
                startActivity(intent);
                WelcomePageActivity.this.finish();
            }
        },3000);
    }
}


