package com.example.fragmentsimplestapp.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fragmentsimplestapp.R;
import com.example.fragmentsimplestapp.adapters.ListAdapter;
import com.example.fragmentsimplestapp.fragments.AnimationFragment;
import com.example.fragmentsimplestapp.fragments.DefaultFragment;
import com.example.fragmentsimplestapp.fragments.NavigationContentFragment;

/**
 * Created by Anna on 13.10.13.
 */
public class HomeActivity extends ActionBarActivity implements ActionBar.TabListener {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private ActionBar bar;
    private DrawerLayout drawerLayout;
    private ListView drawerListView;
    private String[] drawerItems;
    private String[] drawerItemDescriptions;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.home);

            bar = getSupportActionBar();

            ActionBar.Tab drawerTab = bar.newTab()
                    .setText(R.string.action_bar_tab_drawer)
                    .setTabListener(this);
            bar.addTab(drawerTab);

            ActionBar.Tab animationTab = bar.newTab()
                    .setText(R.string.action_bar_tab_animation)
                    .setTabListener(this);
            bar.addTab(animationTab);

            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            drawerListView = (ListView) findViewById(R.id.list_navigation);

            drawerItems = getResources().getStringArray(R.array.chapters);
            drawerItemDescriptions = getResources().getStringArray(R.array.descriptions);

            ListAdapter listAdapter = new ListAdapter(this, drawerItems);
            drawerListView.setAdapter(listAdapter);
            drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new NavigationContentFragment(drawerItemDescriptions[position])).commit();
                }
            });

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

            actionBarDrawerToggle = new ActionBarDrawerToggle(
                    this,
                    drawerLayout,
                    R.drawable.ic_navigation_drawer_indicator,
                    R.string.drawer_opened,
                    R.string.drawer_closed
            );

            drawerLayout.setDrawerListener(actionBarDrawerToggle);

            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public Fragment getContentFragment(int itemPosition) {
        Fragment fragment = null;
        switch (itemPosition) {
            case 0:
                fragment = new DefaultFragment();
                break;
            case 1:
                fragment = new AnimationFragment();
                break;
        }
        return fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        fragmentTransaction.replace(R.id.content_frame, getContentFragment(tab.getPosition()));
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Log.d(TAG, "unselected Tab: " + tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Log.d(TAG, "reselected Tab: " + tab.getText());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
