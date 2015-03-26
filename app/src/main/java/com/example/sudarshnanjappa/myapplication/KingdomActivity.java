package com.example.sudarshnanjappa.myapplication;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by sudarshnanjappa on 3/18/15.
 */
public class KingdomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kactivity);
        // RestAdapter restAdapter;

        Bundle args = getIntent().getExtras();
        int id= args.getInt("Operation_ID");
       // int id = Integer.parseInt(value);
       Log.d("ID", String.valueOf(id));

        Bundle bundle = new Bundle();
        bundle.putInt("ID" , id);
        Fragment mFragment = new KingdomFeedFragment();
        mFragment.setArguments(bundle);
        FragmentManager fm = getFragmentManager();

        //FragmentTransaction fragmentTransaction = fm.beginTransaction();
        //fragmentTransaction.add(R.id.container, mFragment);
        //fragmentTransaction.commit();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
