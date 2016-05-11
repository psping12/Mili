package com.jm.app.mili;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jm.app.mili.Bean.Data;
import com.jm.app.mili.Bean.Root;
import com.jm.app.mili.Fragments.FragmentDiscovery;
import com.jm.app.mili.Fragments.FragmentPerson;
import com.jm.app.mili.Fragments.FragmentShouYe;
import com.jm.app.mili.activities.BaseActivity;
import com.jm.app.mili.activities.LogInAcitivity;
import com.jm.app.mili.widget.ImageTextView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private FrameLayout mContentView;
    private static FragmentShouYe fragmentShouYe;
    private ImageView main, newest, discover, mine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {

        initButton();

        mContentView = (FrameLayout) findViewById(R.id.aty_main_contentview);
        fragmentShouYe = new FragmentShouYe();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.aty_main_contentview, fragmentShouYe);
        ft.commit();

        ImageTextView login = (ImageTextView) findViewById(R.id.aty_mian_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LogInAcitivity.class));
            }
        });


    }


    private void initButton() {
        main = (ImageView) findViewById(R.id.aty_main_botton_main);
        newest = (ImageView) findViewById(R.id.aty_main_botton_newset);
        discover = (ImageView) findViewById(R.id.aty_main_botton_discover);
        mine = (ImageView) findViewById(R.id.aty_main_tab_mine);

        main.setOnClickListener(buttonListener);
        newest.setOnClickListener(buttonListener);
        discover.setOnClickListener(buttonListener);
        mine.setOnClickListener(buttonListener);

    }


    private void initData() {
        try {
            RequestParams params = new RequestParams("http://192.168.168.111/api/home/getindexdata");
            Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {

                    try {
                        Gson gson = new Gson();
                        Root bean = gson.fromJson(result, Root.class);

                        if (bean.getCode() != 0)
                            return;
                        Data data =gson.fromJson(bean.getData().toString(),Data.class);

                    } catch (Exception e) {

                        e.printStackTrace();
                    }


                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {

                    Log.e("---id", ex + "");

                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {

                }
            });

        } catch (Exception e) {
            Log.e("---------", e + "");
        }


    }


    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            switch (v.getId()) {
                case R.id.aty_main_botton_main:
                    fragmentShouYe = new FragmentShouYe();
                    ft.replace(R.id.aty_main_contentview, fragmentShouYe);
                    break;
                case R.id.aty_main_botton_newset:
                    Toast.makeText(MainActivity.this, "aty_main_botton_newset", Toast.LENGTH_SHORT).show();
                    initData();
                    break;
                case R.id.aty_main_botton_discover:
                    FragmentDiscovery discovery = new FragmentDiscovery();
                    ft.replace(R.id.aty_main_contentview, discovery);
                    break;
                case R.id.aty_main_tab_mine:
                    FragmentPerson person = new FragmentPerson();
                    ft.replace(R.id.aty_main_contentview, person);
                    break;
                default:
                    break;
            }
            ft.commit();
            setBackGround(v.getId());
        }
    };

    private void setBackGround(int resourceID) {
        ImageView listbotton[] = {main, newest, discover, mine};
        for (int i = 0; i < listbotton.length; i++) {
            if (listbotton[i].getId() == resourceID) {
                if (i == 0) {
                    listbotton[i].setImageResource(R.mipmap.tab_home_focus);
                } else if (i == 1) {
                    listbotton[i].setImageResource(R.mipmap.tab_news_focus);
                } else if (i == 2) {
                    listbotton[i].setImageResource(R.mipmap.tab_find_focus);
                } else {
                    listbotton[i].setImageResource(R.mipmap.tab_mine_focus);
                }
            } else {
                if (i == 0) {
                    listbotton[i].setImageResource(R.mipmap.tab_home_normal);
                } else if (i == 1) {
                    listbotton[i].setImageResource(R.mipmap.tab_news_normal);
                } else if (i == 2) {
                    listbotton[i].setImageResource(R.mipmap.tab_find_normal);
                } else {
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
public String[] GetBannerSrc(){
    String [] adUrl={};

    return adUrl;
}
}
