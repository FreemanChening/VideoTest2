package com.example.admin.videotest3.myclass;

/**
 * Created by admin on 2017/6/15.
 */

public class Thumbnail {
    private int imageId;
    private String title;
    private String id;
    public Thumbnail(int imageId,String titleInput,String id){
        this.imageId = imageId;
        this.title = titleInput;
        this.id = id;
    }


    public int getImageId(){
        return imageId;
    }

    public String getTitle(){return title;}

    public String getId(){return id;}
}
