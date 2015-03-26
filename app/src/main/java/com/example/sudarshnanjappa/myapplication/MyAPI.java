package com.example.sudarshnanjappa.myapplication;


import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by sudarshnanjappa on 3/15/15.
 */
public interface MyAPI {

    //public String id = null;
    @FormUrlEncoded
    @POST("/")
    void submitemail( @Field("email") String first, Callback<User> cb);

    @GET("/")
    void getkingdoms(Callback<List<FeedItem>> response);

    @GET("/{id}")
    void getKingdom(@Path("id") int id ,Callback<KingdomItems> response);

    @GET("/{id}")
    void getquestitems(@Path("id") int id ,Callback<QuestFeedItems> response);
}