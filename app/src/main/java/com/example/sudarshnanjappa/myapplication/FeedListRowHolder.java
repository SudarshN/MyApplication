package com.example.sudarshnanjappa.myapplication;

/**
 * Created by sudarshnanjappa on 3/16/15.
 */

        import android.app.Fragment;
        import android.app.FragmentManager;
        import android.app.FragmentManager;
        import android.support.v4.app.FragmentActivity;
        import android.app.FragmentTransaction;
        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class FeedListRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected ImageView thumbnail;
    protected TextView title;
    public OnItemClickListener mItemClickListener;

    @Override
    public void onClick(View v) {

        Intent i = new Intent(v.getContext(), KingdomPagerActivity.class);
        i.putExtra("Operation_ID", getPosition());
        v.getContext().startActivity(i);

        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(v, getPosition()); //OnItemClickListener mItemClickListener;
        }
    }

    public FeedListRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
        view.setOnClickListener(this);
    }

}
