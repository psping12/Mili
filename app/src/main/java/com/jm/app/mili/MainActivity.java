package com.jm.app.mili;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jm.app.mili.Fragments.FragmentShouYe;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mContentView;
    private static FragmentShouYe fragmentShouYe;
    private ImageView main,newest,discover,mine;



//   static  Handler handler =new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 1:
//                    fragmentShouYe.CurrentBannerItem();
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {

        initButton();
        
        mContentView= (FrameLayout) findViewById(R.id.aty_main_contentview);
        fragmentShouYe =new FragmentShouYe();

        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        ft.add(R.id.aty_main_contentview,fragmentShouYe);
        ft.commit();

    }

    private void initButton() {
       main = (ImageView) findViewById(R.id.aty_main_botton_main);
       newest = (ImageView) findViewById(R.id.aty_main_botton_newset);
       discover = (ImageView) findViewById(R.id.aty_main_botton_discover);
       mine = (ImageView) findViewById(R.id.aty_main_botton_mine);

        main.setOnClickListener(buttonListener);
        newest.setOnClickListener(buttonListener);
        discover.setOnClickListener(buttonListener);
        mine.setOnClickListener(buttonListener);

    }


    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         switch (v.getId()){
             case R.id.aty_main_botton_main:
                 break;
             case R.id.aty_main_botton_newset:
                 break;
             case R.id.aty_main_botton_discover:
                 break;
             case R.id.aty_main_botton_mine:
                 break;
         }
            setBackGround(v.getId());
        }
    };

    private void setBackGround(int resourceID) {
        ImageView listbotton[] ={main,newest,discover,mine};
        for (int i=0;i< listbotton.length;i++){
            if (listbotton[i].getId()==resourceID){
                if (i==0){
                    listbotton[i].setImageResource(R.mipmap.tab_home_focus);
                }else if (i==1){
                    listbotton[i].setImageResource(R.mipmap.tab_news_focus);
                }else if (i==2){
                    listbotton[i].setImageResource(R.mipmap.tab_find_focus);
                }else {
                    listbotton[i].setImageResource(R.mipmap.tab_mine_focus);
                }
            }else {
                if (i==0){
                    listbotton[i].setImageResource(R.mipmap.tab_home_normal);
                }else if (i==1){
                    listbotton[i].setImageResource(R.mipmap.tab_news_normal);
                }else if (i==2){
                    listbotton[i].setImageResource(R.mipmap.tab_find_normal);
                }else {
                    listbotton[i].setImageResource(R.mipmap.tab_mine_normal);
                }
            }
        }
    }

/*    *//**
     * 开始轮询广告
     *//*
    public static void startBannerAd(){
         timer =new Timer();
         timer.schedule(new TimerTask() {
            @Override
            public void run() {
                fragmentShouYe.CurrentBannerItem();
            }
        },5*1000,3*1000);
    }

    *//**
     * 结束轮询
     *//*
    public static void stopBannerAd(){
        timer.cancel();
    }*/

}
