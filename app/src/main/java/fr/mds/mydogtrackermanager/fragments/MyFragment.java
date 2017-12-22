package fr.mds.mydogtrackermanager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MyFragment extends Fragment {

    int position;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        MapsFragment tabFragment = new MapsFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
