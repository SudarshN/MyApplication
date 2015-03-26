package com.example.sudarshnanjappa.myapplication;

/**
 * Created by sudarshnanjappa on 3/16/15.
 */
public class FeedItem {
    private String name;
    private String image;
    private int id;

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getThumbnail() {
        return image;
    }

    public void setThumbnail(String thumbnail) {
        this.image = thumbnail;
    }

    public void setid(int id) { this.id = id;}

    public int getid() {return id;}
}
