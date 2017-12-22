package fr.mds.mydogtrackermanager.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.mds.mydogtrackermanager.fragments.MapsFragment;
import fr.mds.mydogtrackermanager.fragments.SpiesFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String title[] = {"Spies", "Map"};
    List<Fragment> listFragment = new ArrayList<Fragment>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return SpiesFragment.newInstance("Spies");
            case 1:
                return MapsFragment.newInstance("Map");
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

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
