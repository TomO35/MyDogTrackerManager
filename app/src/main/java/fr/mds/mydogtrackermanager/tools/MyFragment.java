package fr.mds.mydogtrackermanager.tools;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import fr.mds.mydogtrackermanager.fragments.MapsFragment;

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
        position = getArguments().getInt("pos");
    }

    public static MyFragment newInstance(String text) {

        MyFragment f = new MyFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
