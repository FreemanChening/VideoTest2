package com.example.admin.videotest3.myclass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.videotest3.R;
import com.example.admin.videotest3.chActivity.MainActivity;
import com.example.admin.videotest3.myclass.Thumbnail;

import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;

/**
 * Created by admin on 2017/6/15.
 */

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail>{
    private int resourceId;


    private List<String> ThumbnailList;
    private LayoutInflater mInflater;
    private Callback mCallback;
    /**
       * 自定义接口，用于回调按钮点击事件到Activity
       */

    public interface Callback {

        public void click(View v);
     }



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

/*
            viewHolder.btn1 = (Button) convertView.findViewById(R.id.button_appreciate);
            viewHolder.btn2 = (Button) convertView.findViewById(R.id.button_collect);
*/
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
        Button btn1;
        Button btn2;
    }


}
