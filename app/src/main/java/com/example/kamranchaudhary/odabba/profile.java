package com.example.kamranchaudhary.odabba;

import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    boolean doubleBackToExitPressedOnce = false;
    LinearLayout ll;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ll = (LinearLayout) toolbar.findViewById(R.id.app_bar_ll);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.removeAllViews();
        createView();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_main, new home())
                .commit();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

        ll.removeAllViews();
        createView();
        toolbar.setElevation(10);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_main, new home())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }
/*
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
*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_home) {
            ll.removeAllViews();
            createView();
            toolbar.setElevation(10);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main, new home())
                    .commit();
        }else if (id == R.id.nav_profile) {
            ll.removeAllViews();
            createTextView("Profile");
            toolbar.setElevation(0);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main, new Profile_View_Fragment())
                    .commit();
        } else if (id == R.id.nav_promo) {
            ll.removeAllViews();

            fragmentManager.beginTransaction()
                    .replace(R.id.content_main, new promo_code_frag())
                    .commit();
            createTextView("Promo Code");
            toolbar.setElevation(10);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_packages) {
            ll.removeAllViews();
            createView();
            toolbar.setElevation(10);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main, new home())
                    .commit();
        } else if (id == R.id.nav_subs) {
            ll.removeAllViews();
            createTextView("My Subscriptions");
            toolbar.setElevation(10);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main, new My_Subs_Fragment())
                    .commit();
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void createView(){

        LinearLayout.LayoutParams lparams1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lparams2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams2.weight = 2f;
        LinearLayout.LayoutParams lparams3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams3.weight = 1f;
        lparams3.gravity = Gravity.CENTER;

        Typeface tf1 = Typeface.create("Roboto bold",Typeface.BOLD);
        Typeface tf2 = Typeface.create("Roboto bold",Typeface.NORMAL);

        TextView tv1 = new TextView(profile.this);
        tv1.setLayoutParams(lparams1);
        tv1.setText("Package: ");
        tv1.setTextSize(18);
        tv1.setTypeface(tf1);
        tv1.setTextColor(Color.WHITE);
        tv1.setTextColor(getResources().getColor(R.color.cardview_dark_background));

        TextView tv2 = new TextView(profile.this);
        tv2.setLayoutParams(lparams2);
        tv2.setText("No Package");
        tv2.setTextSize(17);
        tv2.setTypeface(tf2);
        tv2.setTextColor(Color.WHITE);
        tv2.setTextColor(getResources().getColor(R.color.odabba_color_main));

        ImageView img = new ImageView(profile.this);
        img.setLayoutParams(lparams3);
        img.setImageResource(R.drawable.bell_icon);

        ll.addView(tv1);
        ll.addView(tv2);
        ll.addView(img);
    }
    public void createTextView(String txt){

        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Typeface tf1 = Typeface.create("Roboto bold",Typeface.BOLD);

        TextView tv1 = new TextView(profile.this);
        tv1.setLayoutParams(lparams);
        tv1.setText(txt);
        tv1.setTextSize(18);
        tv1.setTypeface(tf1);
        tv1.setTextColor(Color.BLACK);

        ll.addView(tv1);
    }
}
