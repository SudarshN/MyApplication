package com.example.sudarshnanjappa.myapplication;

/**
 * Created by sudarshnanjappa on 3/18/15.
 */
public class KingdomItems {

    private String name;
    private String image;
    private String id;
    private String climate;
    private String population;

    public String getTitle() {
        return name;
    }

    public String getclimate(){ return  climate;}

    public void SetClimate(String climate){ this.climate = climate;}

    public String getpopulation (){ return population;}

    public void setpopulation(String pop){ this.population = pop;}


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
