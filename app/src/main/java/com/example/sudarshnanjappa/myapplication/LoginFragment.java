package com.example.sudarshnanjappa.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sudarshnanjappa on 3/17/15.
 */
public class LoginFragment extends Fragment {

    private static final String API_URL = "https://challenge2015.myriadapps.com/api/v1/subscribe";
    EditText email;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.loginlayout, container, false);

        email = (EditText) rootView.findViewById(R.id.editText2);

        Button submitbutton;
        submitbutton = (Button)  rootView.findViewById(R.id.button1);
        final String useremail = email.getText().toString();
        submitbutton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                requestdata(API_URL);

                Fragment mFragment = new FeedListActivity();
                FragmentManager fm = getFragmentManager();

                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.container, mFragment);
                fragmentTransaction.commit();

            }
        });

        return rootView;
    }

    public void requestdata(String url)
    {
        RestAdapter restAdapter = (RestAdapter) new RestAdapter.Builder().setEndpoint(API_URL).build();
        final MyAPI post = restAdapter.create(MyAPI.class);

        User user = new User(email.getText().toString());

        post.submitemail(user.email, new retrofit.Callback<User>() {
            @Override
            public void success(User user, Response response) {
                Log.d("fdhf", response.getReason());
               // Toast.makeText(getActivity().getApplicationContext() ,"Thanks",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("error" ,error.getMessage());
            }
        });
    }
}

