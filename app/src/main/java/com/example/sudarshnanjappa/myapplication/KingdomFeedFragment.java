package com.example.sudarshnanjappa.myapplication;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sudarshnanjappa on 3/18/15.
 */
public class KingdomFeedFragment extends Fragment {

    private List<FeedItem> feedItemList = new ArrayList<FeedItem>();
    FragmentActivity mActivity;
    ImageView iv;
    TextView TV;
    TextView TV1;
    TextView TV2;
    public int id;



    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {

         id = this.getArguments().getInt("someInt");
       // Log.d("ID" ,String.valueOf(id));

        final View rootView = inflater.inflate(R.layout.kingdomlayout, container, false);
        iv = (ImageView) rootView.findViewById(R.id.KingdomImage);
        TV = (TextView) rootView.findViewById(R.id.KingdomNameID);
        TV1 = (TextView) rootView.findViewById(R.id.climatevalue);
        TV2 = (TextView) rootView.findViewById(R.id.popoulationvalue);
        return rootView;
    }

    public  void requestdata(String url)
    {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(url).build();

        MyAPI api = adapter.create(MyAPI.class);
        //api.id = feedItem.getid();
        KingdomItems feedItem = new KingdomItems();
        api.getKingdom(id+1,new Callback<KingdomItems>() {
            @Override
            public void success(KingdomItems feedItems, Response response) {
                Log.d("ITEM", feedItems.toString());


                //FeedItem feedItem = null;
                //feedItem= feedItems.get(feedItem.getid());

              //  iv.setim(feedItem.getThumbnail());
                Picasso.with(getActivity()).load(feedItems.getThumbnail())
                        .error(R.drawable.placeholder)
                        .placeholder(R.drawable.placeholder)
                        .into(iv);

               TV.setText((feedItems.getid()));
                TV1.setText((feedItems.getclimate()));
                TV2.setText((feedItems.getpopulation()));


            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("FAIL",error.getUrl());
            }
        });
    }

    @Override
    public void onViewCreated(View view , Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
          /*Downloading data from below url*/
        final String url = "https://challenge2015.myriadapps.com/api/v1/kingdoms";
        requestdata(url);


    }
}
