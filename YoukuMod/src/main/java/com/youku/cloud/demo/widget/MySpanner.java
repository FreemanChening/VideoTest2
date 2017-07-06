package com.youku.cloud.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.youku.cloud.demo.R;

import java.util.ArrayList;


/**
 * @Author: lifujun@youku.com
 * @Date: 2016/3/16.
 * @Description:
 */
public class MySpanner extends Spinner {


    public MySpanner(Context context) {
        super(context);
    }

    public MySpanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public static class VidItem {
        public String desc;
        public String vid;

        public VidItem(String desc, String vid) {
            this.desc = desc;
            this.vid = vid;
        }
    }

    public static class ClientIdItem extends VidItem {

        public String clientId;
        public String secret;

        public ClientIdItem(String desc, String clientId, String secret) {
            super(desc, clientId);
            this.clientId = clientId;
            this.secret = secret;
        }


    }

    public void setItems(ArrayList<VidItem> items) {
        ItemAdapter adapter = new ItemAdapter(items);
        setAdapter(adapter);
        this.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				setSelection(0);
				return false;
			}
		});
    }


    private class ItemAdapter extends BaseAdapter {
        private ArrayList<VidItem> vidItems;

        public ItemAdapter(ArrayList<VidItem> items) {
            vidItems = items;
        }

        @Override
        public int getCount() {
            return vidItems.size();
        }

        @Override
        public VidItem getItem(int position) {
            return vidItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, null);
            TextView itemView = (TextView) convertView.findViewById(R.id.textView);
            VidItem vidItem = getItem(position);
            itemView.setText(vidItem.desc + " : " + vidItem.vid);
            return convertView;
        }
    }


}
