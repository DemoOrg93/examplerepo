package com.sonika.onlineshoes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.onlineshoes.Adapter.PagerrAdapter;
import com.sonika.onlineshoes.R;


public class UserPanel extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

     ViewPager viewPager;
    String musername;
    TextView username;
    SharedPreferences sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Ladies Shoes"));
        tabLayout.addTab(tabLayout.newTab().setText("Gents Shoes"));
        tabLayout.addTab(tabLayout.newTab().setText("Kids Shoes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        SharedPreferences sm = getSharedPreferences("USER_LOGIN", 0);
        SharedPreferences.Editor editor = sm.edit();

        musername = sm.getString("name", null);


        viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerrAdapter adapter = new PagerrAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        username = (TextView)header.findViewById(R.id.user_name);
        username.setText(musername);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
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

        else if (id == R.id.action_logout)
        {
            sm = getSharedPreferences("USER_LOGIN", 0);
            SharedPreferences.Editor editor = sm.edit();
            editor.clear();
            editor.commit();

            Intent intent = new Intent(UserPanel.this, UserLogin.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ladiesshoe) {

            viewPager.setCurrentItem(0);

        } else if (id == R.id.nav_gentsshoe) {

            viewPager.setCurrentItem(1);


        } else if (id == R.id.nav_kidsshoe) {
            viewPager.setCurrentItem(2);

        } else if (id == R.id.nav_help) {
            viewPager.setCurrentItem(1);

        } else if (id == R.id.nav_myorders) {
            Intent i = new Intent(UserPanel.this, MyOrders.class);
            startActivity(i);

        } else if (id == R.id.nav_feedback) {
            viewPager.setCurrentItem(0);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
