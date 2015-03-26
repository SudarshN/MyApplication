package com.example.sudarshnanjappa.myapplication;

/**
 * Created by sudarshnanjappa on 3/16/15.
 */
import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class FeedListActivity extends Fragment {

    private static final String TAG = "RecyclerViewExample";

    private List<FeedItem> feedItemList = new ArrayList<FeedItem>();

    private RecyclerView mRecyclerView;


    private MyRecycleAdapter adapter ;
    FragmentActivity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (FragmentActivity) activity;
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.feed_activity_lists, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setClickable(true);



        adapter = new MyRecycleAdapter(mActivity);
        if(adapter!=null) Log.d("not null", "Not Null");



        return rootView;
    }

    @Override
    public void onViewCreated(View view , Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
          /*Downloading data from below url*/
        final String url = "https://challenge2015.myriadapps.com/api/v1/kingdoms";
        requestdata(url);
        adapter.SetOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View v , int position) {
                // do something with position
                Toast.makeText(v.getContext(), "position = " , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void requestdata(String url)
    {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(url).build();

        MyAPI api = adapter.create(MyAPI.class);
        // MyRecycleAdapter  adapter ;
        api.getkingdoms(new Callback<List<FeedItem>>() {
            @Override
            public void success(List<FeedItem> feedItems, Response response) {
                Log.d("ITEM", feedItems.toString());
                MyRecycleAdapter adapter = new MyRecycleAdapter(mActivity, feedItems);
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}