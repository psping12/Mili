package com.jm.app.mili;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jm.app.mili.Fragments.FragmentShouYe;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {
        mContentView= (FrameLayout) findViewById(R.id.aty_main_contentview);

        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        ft.add(R.id.aty_main_contentview,new FragmentShouYe());
        ft.commit();

    }

}
