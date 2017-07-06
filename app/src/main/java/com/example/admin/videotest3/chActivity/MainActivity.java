package com.example.admin.videotest3.chActivity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.videotest3.R;
import com.example.admin.videotest3.myclass.Thumbnail;
import com.example.admin.videotest3.myclass.MyPagerAdapter;
import com.example.admin.videotest3.myclass.ThumbnailAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TabLayout tabLayout;

    private ViewPager viewPager;

    private List<String> mTitleList;
    private List<View> mViewList;

    private LayoutInflater mInflater;

    private View view1, view2;

    private List<Thumbnail> ThumbnailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initviews();
        initDatas();
        setTabLayout();

        initNet();

    }



    private void initviews() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        mTitleList = new ArrayList<>();
        mViewList = new ArrayList<>();
    }

    private void initDatas() {
        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.view_1, null);
        view2 = mInflater.inflate(R.layout.view_2, null);


        Button button_takeUp = (Button) view2.findViewById(R.id.button_takeupload);
        Button button_localUp = (Button) view2.findViewById(R.id.button_localupload);
        Button button_lovelist = (Button) view2.findViewById(R.id.button_lovelist);
        Button button_collectlist = (Button) view2.findViewById(R.id.button_collectlist) ;
        button_takeUp.setOnClickListener(this);
        button_localUp.setOnClickListener(this);
        button_lovelist.setOnClickListener(this);
        button_collectlist.setOnClickListener(this);


        initThumbnail();
        ThumbnailAdapter adapter = new ThumbnailAdapter(MainActivity.this,R.layout.thumbnail_item,ThumbnailList);
        ListView listView = (ListView) view1.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //Toast.makeText(MainActivity.this,"made",Toast.LENGTH_SHORT).show();

        /**
               * 响应ListView中item的点击事件
               */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Thumbnail thumbnail = ThumbnailList.get(position);
                //Toast.makeText(MainActivity.this,thumbnail.getTitle(),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,thumbnail.getId(),Toast.LENGTH_SHORT).show();

                Button button_appreciate = (Button)view1.findViewById(R.id.button_appreciate);
                Button button_collect = (Button)view1.findViewById(R.id.button_collect);
                button_appreciate.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"已确认喜爱",Toast.LENGTH_SHORT).show();
                    }
                });
                button_collect.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"已添加到收藏夹",Toast.LENGTH_SHORT).show();
                    }
                });
                go2Player(thumbnail.getId()); // 跳转到播放界面
                /*Intent i = new Intent(MainActivity.this, PlayActivity.class);
                MainActivity.this.startActivity(i);*/
            }
        });




        /*
        initFruits();
        FruitAdapter adapter = new FruitAdapter(this,R.layout.thumbnail_item,fruitList);
        ListView listView = (ListView) view1.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id){
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        */
        mViewList.add(view1);
        mViewList.add(view2);

        mTitleList.add("热门");
        mTitleList.add("我的");

    }

    private void setTabLayout() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);//系统默认模式、
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(1)));



        MyPagerAdapter mAdapter = new MyPagerAdapter(MainActivity.this, mViewList, mTitleList);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);//tablayout和viewpager关联起来
        tabLayout.setTabsFromPagerAdapter(mAdapter);//给TabLayout设置适配器


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_takeupload:
                Intent intent_takeUpstart = new Intent(MainActivity.this, TakeUploadActivity.class);
                startActivity(intent_takeUpstart);
                break;
            case R.id.button_localupload:
                Intent intent_localUpload = new Intent(MainActivity.this, LocalUploadActivity.class);
                startActivity(intent_localUpload);
                break;
            case R.id.button_lovelist:
                Intent intent_lovelist = new Intent(MainActivity.this, LovelistActivity.class);
                startActivity(intent_lovelist);
                break;
            case R.id.button_collectlist:
                Intent intent_collectlist = new Intent(MainActivity.this, CollectlistActivity.class);
                startActivity(intent_collectlist);
                break;
            //喜爱按钮响应
            /*
            case R.id.button_appreciate:
                Toast.makeText(MainActivity.this,"已确认喜爱",Toast.LENGTH_SHORT).show();
                break;
            //收藏按钮响应
            case R.id.button_collect:
                Toast.makeText(MainActivity.this,"已添加到收藏夹",Toast.LENGTH_SHORT).show();
                break;*/
            default:
                break;
        };
    }

    private void initNet(){



    }

    private  void  initThumbnail(){
        for (int i =0; i<1;i++){
            Thumbnail list_1 = new Thumbnail(R.drawable.thumbnail1,"回归后十佳香港电影","XMjg1NjcyMzQ2MA==");
            ThumbnailList.add(list_1);
            Thumbnail list_2 = new Thumbnail(R.drawable.thumbnail2,"张全蛋做客深夜食堂曝光隐藏恋情","XMjg0MzAxMTQ4OA==");
            ThumbnailList.add(list_2);
            Thumbnail list_3 = new Thumbnail(R.drawable.thumbnail3,"中国潜艇已经甩美国八条街？","XMjg1NDYzODM3Mg==");
            ThumbnailList.add(list_3);
            Thumbnail list_4 = new Thumbnail(R.drawable.thumbnail4,"夏日雨季吃什么清热","XMjg2MzU1MDAzMg==");
            ThumbnailList.add(list_4);
            Thumbnail list_5 = new Thumbnail(R.drawable.thumbnail5,"下雨天外卖迟到该投诉吗","XMjg2MjIyODcyMA==");
            ThumbnailList.add(list_5);
        }
    }

    private void go2Player(String id) {
        Intent i = new Intent(MainActivity.this, PlayActivity.class);
        i.putExtra("vid", id);
        MainActivity.this.startActivity(i);
    }
/**
    private  void  initFruits(){
        for (int i =0; i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.banana);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry",R.drawable.cherry);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.mango);
            fruitList.add(mango);
        }
    }
*/

}
