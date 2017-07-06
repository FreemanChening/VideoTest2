package com.example.admin.videotest3.myclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.videotest3.R;
import com.example.admin.videotest3.myclass.Thumbnail;

import java.util.List;

/**
 * Created by admin on 2017/6/15.
 */

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail>{
    private int resourceId;

    public ThumbnailAdapter(Context context, int textViewResourceId, List<Thumbnail> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Thumbnail thumbnail = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.thumbnailImage = (ImageView) view.findViewById(R.id.video_image);
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        //ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        //TextView fruitname = (TextView) view.findViewById(R.id.fruit_name);
        //fruitImage.setImageResource(fruit.getImageId());
        //fruitname.setText(fruit.getName());
        viewHolder.thumbnailImage.setImageResource(thumbnail.getImageId());
        viewHolder.title.setText(thumbnail.getTitle());
        return view;
    }

    class ViewHolder{
        ImageView thumbnailImage;
        TextView title;
    }


    /**
     75      * 用于回调的抽象类
     76      * @author Ivan Xu
     77      * 2014-11-26
     78      */
     public static abstract class MyClickListener implements View.OnClickListener {
         /**
           * 基类的onClick方法
           */
         @Override
         public void onClick(View v) {
                         myOnClick((Integer) v.getTag(), v);
                     }
         public abstract void myOnClick(int position, View v);
     }
}
