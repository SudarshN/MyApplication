package com.example.sudarshnanjappa.myapplication;

import java.util.List;

/**
 * Created by sudarshnanjappa on 3/19/15.
 */
public class QuestFeedItems {

    private String name;
    private String image;
    private String id;
    private String description;
    private List<quests> quests ;

    public String getDescription() { return  description;}
    public void setDescription(String Descrip) { this.description = Descrip;}
    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getThumbnail() {
        return image;
    }

    public List<quests> getqustimage() {
        return quests;
    }

    public void setThumbnail(String thumbnail) {
        this.image = thumbnail;
    }

    public void setid(String id) { this.id = id;}

    public String getid() {return id;}
}

class quests
{
    private String name;
    private String image;
    private String id;
    private giver giver;

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

    public void setid(String id) { this.id = id;}

    public String getid() {return id;}

    public giver getgiver(){ return giver;}
}

class giver
{
    private String name;
    private String image;
    private String id;

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

    public void setid(String id) { this.id = id;}

    public String getid() {return id;}
}
