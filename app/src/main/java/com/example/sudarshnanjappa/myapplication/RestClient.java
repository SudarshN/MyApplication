package com.example.sudarshnanjappa.myapplication;


import retrofit.RestAdapter;

/**
 * Created by sudarshnanjappa on 3/15/15.
 */
public class RestClient
{
    private static final String API_URL = "https://challenge2015.myriadapps.com/api/v1/subscribe";

    public static void main(String[] args) {
        // Build the Retrofit REST adaptor pointing to the URL specified
        RestAdapter restAdapter;
        restAdapter = (RestAdapter) new RestAdapter.Builder().setEndpoint(API_URL)
                .build().create(MyAPI.class);


    }
}
