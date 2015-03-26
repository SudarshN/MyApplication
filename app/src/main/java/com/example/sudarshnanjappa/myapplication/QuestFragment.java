package com.example.sudarshnanjappa.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sudarshnanjappa on 3/19/15.
 */
public class QuestFragment extends android.support.v4.app.Fragment {
    private static final String API_URL = "https://challenge2015.myriadapps.com/api/v1/kingdoms";
    int id;
    int id1;
    TextView questname;
    TextView description;
    TextView giver;
    TextView giverdescription;
    ImageView image;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.questlayout, container, false);
        Bundle bundle = getArguments();
        if(bundle!=null)
        {
            id = bundle.getInt("someInt");
            Log.d("ID" ,Integer.toString(id));
        }

        id1 = this.getArguments().getInt("tempint");

        Log.d("ID1" ,String.valueOf(id1));
        questname = (TextView) rootView.findViewById(R.id.QuestnameID);
        description = (TextView) rootView.findViewById(R.id.Description);
        giver = (TextView) rootView.findViewById(R.id.QuestgiverID);
        giverdescription = (TextView) rootView.findViewById(R.id.QuestgiverDescription);
        image = (ImageView)rootView.findViewById(R.id.QuestImage);

        requestdata(API_URL);

        return rootView;
    }

    public void requestdata(String url)
    {
        RestAdapter restAdapter = (RestAdapter) new RestAdapter.Builder().setEndpoint(API_URL).build();
        MyAPI api = restAdapter.create(MyAPI.class);
        //api.id = feedItem.getid();
        api.getquestitems(id+1,  new Callback<QuestFeedItems>() {
            @Override
            public void success(QuestFeedItems QF, Response response) {
                List<quests> temp1 = QF.getqustimage();
                Log.d("Items" , String.valueOf(temp1.size()));
                Picasso.with(getActivity()).load(temp1.get(id1).getgiver().getThumbnail())
                        .error(R.drawable.placeholder)
                        .placeholder(R.drawable.placeholder)
                        .into(image);

                questname.setText(temp1.get(id1).getid());
                description.setText(temp1.get(id1).getTitle());
                giver.setText(temp1.get(id1).getgiver().getid());
                giverdescription.setText(temp1.get(id1).getgiver().getTitle());

            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("errror",error.getUrl());
            }
        });
    }
}
