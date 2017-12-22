package fr.mds.mydogtrackermanager.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.HashMap;

import fr.mds.mydogtrackermanager.R;
import fr.mds.mydogtrackermanager.tools.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    public HashMap<String, ArrayList<Fragment>> listFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragments = new HashMap<>();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() == null){
            createNetworkErrorDialog(this);
        }

        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    protected void createNetworkErrorDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(getResources().getText(R.string.error_connectivity))
                .setTitle(getResources().getText(R.string.network_needed))
                .setCancelable(false)
                .setPositiveButton(getResources().getText(R.string.settings),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                startActivity(i);
                            }
                        }
                )
                .setNegativeButton(getResources().getText(R.string.out),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.show();
    }
}
