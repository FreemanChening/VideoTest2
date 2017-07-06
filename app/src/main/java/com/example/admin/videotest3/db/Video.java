package com.example.admin.videotest3.db;

import android.provider.MediaStore;

import org.litepal.crud.DataSupport;

/**
 * Created by admin on 2017/7/3.
 */

public class Video extends DataSupport{
    private int id;

    private String videouri;

    private String videoabout;

    private int good;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getGood(){
        return good;
    }
    public void setGood(int good){
        this.good = good;
    }

    public String getVideouri(){
        return getVideouri();
    }
    public void setVideouri(String videouri){
        this.videouri = videouri;
    }

    public String getVideoabout(){
        return getVideoabout();
    }
    public void setVideoabout(String videoabout){
        this.videoabout = videoabout;
    }

}
