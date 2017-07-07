package com.example.admin.videotest3.chActivity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.admin.videotest3.R;
import com.example.admin.videotest3.myclass.Thumbnail;
import com.example.admin.videotest3.myclass.ThumbnailAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollectlistActivity extends AppCompatActivity {

    private List<Thumbnail> ThumbnailList_love = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectlist);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        //showLovelist();
    }

    /*public void showLovelist(){
        initThumbnail();
        ThumbnailAdapter adapter = new ThumbnailAdapter(CollectlistActivity.this,R.layout.collect_item,ThumbnailList_love);
        ListView listView = (ListView) findViewById(R.id.love_list);
        listView.setAdapter(adapter);
        //Toast.makeText(MainActivity.this,"made",Toast.LENGTH_SHORT).show();

    }

    private  void  initThumbnail(){
        for (int i =0; i<1;i++){
            Thumbnail list_1 = new Thumbnail(R.drawable.thumbnail1,"回归后十佳香港电影","XMjg1NjcyMzQ2MA==");
            ThumbnailList_love.add(list_1);
            Thumbnail list_2 = new Thumbnail(R.drawable.thumbnail2,"张全蛋做客深夜食堂曝光隐藏恋情","XMjg0MzAxMTQ4OA==");
            ThumbnailList_love.add(list_2);
            Thumbnail list_3 = new Thumbnail(R.drawable.thumbnail3,"中国潜艇已经甩美国八条街？","XMjg1NDYzODM3Mg==");
            ThumbnailList_love.add(list_3);
            Thumbnail list_4 = new Thumbnail(R.drawable.thumbnail4,"夏日雨季吃什么清热","XMjg2MzU1MDAzMg==");
            ThumbnailList_love.add(list_4);
            Thumbnail list_5 = new Thumbnail(R.drawable.thumbnail5,"下雨天外卖迟到该投诉吗","XMjg2MjIyODcyMA==");
            ThumbnailList_love.add(list_5);
        }
    }*/
}
