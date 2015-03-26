package com.example.sudarshnanjappa.myapplication;

/**
 * Created by sudarshnanjappa on 3/17/15.
 */

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class KingdomPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;

    FragmentManager fm= getSupportFragmentManager();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewpager);
        setContentView(mViewPager);


        int recordID = Integer.parseInt(getIntent().getSerializableExtra(
                "Operation_ID").toString());


        mViewPager.setAdapter(new MyAdapter(fm,recordID));

        android.support.v4.app.Fragment fragment =null;
        fragment = new KingdomFeedFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", recordID);
        fragment.setArguments(args);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                String title = new String();
                if(position == 0)
                    setTitle("Add Fragment");

                if(position == 1)
                    setTitle("Sub Fragment");

                if(position == 2)
                    setTitle( "Mul Fragment");

                if(position == 3)
                    setTitle("Div Fragment");

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}

class MyAdapter extends FragmentStatePagerAdapter
{
    public int posit;
    public int temp =0;

    public MyAdapter(FragmentManager fm,int pos) {
        super(fm);
        posit = pos;
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getCount() {
       // Log.d("PagerActivity","geitem");
        return 5;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int temp) {
       // Log.d("ff23",Integer.toString(posit));
        android.support.v4.app.Fragment fragment =null;

        switch(temp)
        {
            case 0:

                fragment = new KingdomFeedFragment();
                Bundle args = new Bundle();
                args.putInt("someInt", posit);
                fragment.setArguments(args);


                break;

            case 1:

                fragment = new QuestFragment();
                Bundle args1 = new Bundle();
                args1.putInt("tempint", 0);
                args1.putInt("someInt", posit);
                fragment.setArguments(args1);

                break;

            case 2:

                fragment = new QuestFragment();
                Bundle args2 = new Bundle();
                args2.putInt("tempint", 1);
                args2.putInt("someInt", posit);
                fragment.setArguments(args2);

                break;
            case 3:

                fragment = new QuestFragment();
                Bundle args3 = new Bundle();
                args3.putInt("tempint", 2);
                args3.putInt("someInt", posit);
                fragment.setArguments(args3);

                break;

            case 4:
                fragment = new QuestFragment();
                Bundle args4 = new Bundle();
                args4.putInt("tempint", 3);
                args4.putInt("someInt", posit);
                fragment.setArguments(args4);

                break;

            case 5:
                fragment = new QuestFragment();
                Bundle args5 = new Bundle();
                args5.putInt("tempint", 4);
                args5.putInt("someInt", posit);
                fragment.setArguments(args5);

                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = new String();
        if(position == 0)
            title = "Add Fragment";

        if(position == 1)
            title = "Sub Fragment";

        if(position == 2)
            title = "Mul Fragment";

        if(position == 3)
            title = "Div Fragment";

        return title;
    }



}
