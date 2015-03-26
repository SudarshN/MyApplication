package com.example.sudarshnanjappa.myapplication;

/**
 * Created by sudarshnanjappa on 3/16/15.
 */
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<FeedListRowHolder> {

    private List<FeedItem> feedItemList;
    private Context mContext;
    OnItemClickListener mItemClickListener;
    private FragmentActivity mActivity;

    public MyRecycleAdapter(FragmentActivity mActivity) {
        this.mActivity = mActivity;
    }
    public MyRecycleAdapter(FragmentActivity mActivity, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mActivity = mActivity;
        this.mContext = mActivity;
    }

    @Override
    public FeedListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);
        FeedListRowHolder mh = new FeedListRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(FeedListRowHolder feedListRowHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);

        Picasso.with(mContext).load(feedItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(feedListRowHolder.thumbnail);

        feedListRowHolder.title.setText(Html.fromHtml(feedItem.getTitle()));
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);}

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener)
     {
        
       this.mItemClickListener = mItemClickListener;
     }

}