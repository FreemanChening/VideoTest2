package com.youku.cloud.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.youku.cloud.demo.downloader.DownLoadManager;
import com.youku.cloud.utils.ValidateUtil;
import com.youku.download.DownInfo;
import com.youku.download.InnerDownInfo;
import com.youku.download.DownLoaderListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DownLoadStateActivity extends Activity {
    private ListView list1;
    private List<DownInfo> displayItems;
    private LayoutInflater mInflater;
    private DownAdapter downAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load_state);
        mInflater = LayoutInflater.from(this);
        list1 = (ListView) findViewById(R.id.list1);
        displayItems = DownLoadManager.getInstance().getDownInfos();
        DownLoadManager.getInstance().setDownLoaderListener(
                new MyDownListener());
        downAdapter = new DownAdapter();
        list1.setAdapter(downAdapter);
        downAdapter.notifyDataSetChanged();
        list1.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                DownInfo downInfo = displayItems.get(arg2);
                if (downInfo.isDone()) {
                    Intent intent = new Intent(getBaseContext(),
                            PlayerActivity.class);
                    intent.putExtra("vid", downInfo.getVid());
                    intent.putExtra("local", true);
                    startActivity(intent);

                } else {
                    Toast.makeText(getBaseContext(), "未下载完毕",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private static long getDirSize(File file) {
        // 判断文件是否存在
        if (file.exists()) {
            // 如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                long size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {// 如果是文件则直接返回其大小,以“兆”为单位
                long size = file.length();
                return size;
            }
        } else {
            return 0;
        }
    }

    private class MyDownListener extends DownLoaderListener {
        @Override
        public void onDelete(String vid) {
            // TODO Auto-generated method stub
            super.onDelete(vid);
            downAdapter.notifyDataSetChanged();
        }

        @Override
        public void onTimeout(String vid) {
            // TODO Auto-generated method stub
            super.onTimeout(vid);
            downAdapter.notifyDataSetChanged();
        }

        @Override
        public void onStart(String vid) {
            // TODO Auto-generated method stub
            super.onStart(vid);
            downAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String vid, int errorcode, Exception e) {
            // TODO Auto-generated method stub
            super.onError(vid, errorcode, e);
            downAdapter.notifyDataSetChanged();
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
        }

        @Override
        public void onFinshed(String vid) {
            // TODO Auto-generated method stub
            super.onFinshed(vid);
            downAdapter.notifyDataSetChanged();
        }

        @Override
        public void onProgress(String vid, double p, double s) {
            // TODO Auto-generated method stub
            super.onProgress(vid, p, s);
            downAdapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(String vid) {
            // TODO Auto-generated method stub
            super.onCancelled(vid);
            downAdapter.notifyDataSetChanged();
        }

    }

    private class DownAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return displayItems.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return displayItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_down_item, null);
                holder.down_name = (TextView) convertView
                        .findViewById(R.id.down_name);

                holder.down_progress = (ProgressBar) convertView
                        .findViewById(R.id.down_progress);

                holder.down_p_txt = (TextView) convertView
                        .findViewById(R.id.down_p_txt);

                holder.down_s_txt = (TextView) convertView
                        .findViewById(R.id.down_s_txt);

                holder.btn_start = (Button) convertView
                        .findViewById(R.id.btn_start);
                holder.btn_del = (Button) convertView
                        .findViewById(R.id.btn_del);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            DownInfo dditem = displayItems.get(position);
            holder.down_name.setText(dditem.getName());
            holder.down_progress.setProgress((int) Math.round(dditem
                    .getProgress() * 100));
            holder.down_p_txt
                    .setText((int) Math.round(dditem.getProgress() * 100) + "%");
            holder.down_s_txt.setText(dditem.getSpeed() + "Kbps");
            holder.btn_start.setTag(dditem.getVid());
            holder.btn_del.setTag(dditem.getVid());
            holder.btn_start.setOnClickListener(startclick);
            holder.btn_del.setOnClickListener(delclick);
            if (dditem.isOperating()) {
                // 按钮正在操作，应该禁用按钮，防止反复点击
                holder.btn_start.setEnabled(false);
            } else {
                if (dditem.isIsstop()) {
                    holder.btn_start.setText("开始");
                } else {
                    holder.btn_start.setText("停止");
                }
                holder.btn_start.setEnabled(true);
            }

            if (dditem.isDone()) {
                holder.btn_start.setText("完成");
                holder.btn_start.setEnabled(false);
                holder.down_progress.setProgress(100);
                holder.down_p_txt.setText(100 + "%");
                holder.down_s_txt.setText(0 + "Kbps");
            }
            return convertView;
        }
    }

    private class ViewHolder {
        public TextView down_name;
        public ProgressBar down_progress;
        public TextView down_p_txt;
        public TextView down_s_txt;
        public Button btn_start;
        public Button btn_del;
    }

    private OnClickListener startclick = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            String vid = (String) v.getTag();
            DownInfo dInfo = DownLoadManager.getInstance()
                    .getDownInfoByVid(vid);
            if (ValidateUtil.isValid(dInfo)) {
                if (dInfo.isIsstop()) {
                    if (DownLoadManager.getInstance().startDownLoad(vid)) {
                        v.setEnabled(false);
                        ((Button) v).setText("开始ing");
                    }

                } else {
                    if (DownLoadManager.getInstance().stopDownLoad(vid)) {
                        v.setEnabled(false);
                        ((Button) v).setText("停止ing");
                    }
                }
            }
        }
    };
    private OnClickListener delclick = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            String vid = (String) v.getTag();
            DownLoadManager.getInstance().deleteDownLoad(vid);
        }
    };
}
