package com.example.admin.videotest3.chActivity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.admin.videotest3.R;
import com.example.admin.videotest3.myclass.Fruit;
import com.example.admin.videotest3.myclass.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TabLayout tabLayout;

    private ViewPager viewPager;

    private List<String> mTitleList;
    private List<View> mViewList;

    private LayoutInflater mInflater;

    private View view1, view2;

    private String[] data = { "Apple" , "Banana" , "Orange" , "Watermelon" ,
            "pear" , "Grape" , "Pineapple" , "Strawberry" , "Cherry" , "Mango" ,
            "Apple" , "Banana" , "Orange" , "Watermelon" , "pear" , "Grape" ,
            "Pineapple" , "Strawberry" , "Cherry" , "Mango" };
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initviews();
        initDatas();
        setTabLayout();









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

        Button button1 = (Button) view1.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button_takeUp = (Button) view2.findViewById(R.id.button_takeupload);
        Button button_localUp = (Button) view2.findViewById(R.id.button_localupload);
        button_takeUp.setOnClickListener(this);
        button_localUp.setOnClickListener(this);

        /*
        initFruits();
        FruitAdapter adapter = new FruitAdapter(this,R.layout.fruit_item,fruitList);
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
            case R.id.button1:
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                startActivity(intent);
                break;
            case R.id.button_takeupload:
                Intent intent_takeUpstart = new Intent(MainActivity.this, TakeUploadActivity.class);
                startActivity(intent_takeUpstart);
                break;
            case R.id.button_localupload:
                Intent intent_localUpload = new Intent(MainActivity.this, LocalUploadActivity.class);
                startActivity(intent_localUpload);
                break;
            default:
                break;
        }

        ;
    }


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


}
