package com.youku.cloud.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.youku.cloud.demo.downloader.DownLoadManager;
import com.youku.cloud.demo.widget.MySpanner;
import com.youku.cloud.player.VideoDefinition;

import java.util.ArrayList;

public class DownLoadTestAct extends Activity {

    private Button btn1, btn2;
    private MySpanner et_vid_cloud;
    private MySpanner et_vq;
    private EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load_test);
        initView();
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String selectedvid = edt1.getText().toString();
                MySpanner.VidItem sqitem = (MySpanner.VidItem) et_vq
                        .getSelectedItem();
                VideoDefinition vd = VideoDefinition.VIDEO_STANDARD;
                if (sqitem.vid.equals("高清")) {
                    vd = VideoDefinition.VIDEO_HD;
                } else if (sqitem.vid.equals("超清")) {
                    vd = VideoDefinition.VIDEO_HD2;
                }

                if (TextUtils.isEmpty(selectedvid)) {
                    Toast.makeText(getBaseContext(), "vid为空", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                boolean b= DownLoadManager.getInstance().addNewDownLoad(selectedvid, "", vd);

                if (b) {
                    Toast.makeText(getBaseContext(), "添加成功", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(getBaseContext(), "添加失败，重复添加",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getBaseContext(),
                        DownLoadStateActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        edt1 = (EditText) findViewById(R.id.edt1);
        et_vid_cloud = (MySpanner) findViewById(R.id.cloud_vid);
        ArrayList<MySpanner.VidItem> cloudItems = new ArrayList<MySpanner.VidItem>();
        cloudItems.add(new MySpanner.VidItem("优酷普通", "XMTM0Mzg5MDk2OA=="));
        cloudItems.add(new MySpanner.VidItem("优酷错误的vid", "XXXXXXXXXXXX"));
        cloudItems.add(new MySpanner.VidItem("优酷会员", "XMTc0NDYzNDYwNA=="));
        cloudItems.add(new MySpanner.VidItem("优酷版权", "XMTY5NDg2MzY5Ng=="));
        cloudItems.add(new MySpanner.VidItem("优酷付费", "XMTczOTQ0MzY3Ng=="));
        cloudItems.add(new MySpanner.VidItem("优酷无水印", "XMTU1MjQ0MTcyOA=="));
        cloudItems.add(new MySpanner.VidItem("优酷4:3", "XMTEyMDIwNDI0"));
        cloudItems.add(new MySpanner.VidItem("优酷加密", "XMTcyOTMyNzc5Ng=="));
        cloudItems.add(new MySpanner.VidItem("动画", "XMTU4MzkyNDcxMg=="));
        cloudItems.add(new MySpanner.VidItem("儿歌", "XODMxMDA1NDMy"));
        cloudItems.add(new MySpanner.VidItem("私密托管", "XMTc2ODg2Mzk0MA=="));
        et_vid_cloud.setItems(cloudItems); // cloud
        et_vid_cloud.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                MySpanner.VidItem selectItem = (MySpanner.VidItem) et_vid_cloud
                        .getSelectedItem();
                edt1.setText(selectItem.vid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        et_vq = (MySpanner) findViewById(R.id.cloud_qua);
        ArrayList<MySpanner.VidItem> cloud_qu = new ArrayList<MySpanner.VidItem>();
        cloud_qu.add(new MySpanner.VidItem("", "标清"));
        cloud_qu.add(new MySpanner.VidItem("", "高清"));
        cloud_qu.add(new MySpanner.VidItem("", "超清"));
        et_vq.setItems(cloud_qu);
    }
}
