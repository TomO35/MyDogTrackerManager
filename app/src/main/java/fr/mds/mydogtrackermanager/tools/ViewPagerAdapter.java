package fr.mds.mydogtrackermanager.tools;

import android.content.Context;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.mds.mydogtrackermanager.activity.MainActivity;
import fr.mds.mydogtrackermanager.fragments.MapsFragment;
import fr.mds.mydogtrackermanager.fragments.SpiesFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    Context context;
    private String title[] = {"Spies", "Map"};

    public ViewPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                SpiesFragment spiesFragment = new SpiesFragment();
                ArrayList<Fragment> listSFragments = new ArrayList<>();
                listSFragments.add(spiesFragment);
                ((MainActivity) context).listFragments.put("Spies", listSFragments);
                return spiesFragment;
            case 1:
                MapsFragment mapsFragment = new MapsFragment();
                ArrayList<Fragment> listMFragments = new ArrayList<>();
                listMFragments.add(mapsFragment);
                ((MainActivity) context).listFragments.put("Map", listMFragments);
                return mapsFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}
