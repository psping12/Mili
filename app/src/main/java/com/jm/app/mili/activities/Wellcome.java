package com.jm.app.mili.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jm.app.mili.MainActivity;
import com.jm.app.mili.R;
import com.jm.app.mili.Utils.SharedPreferencesUtil;
import com.jm.app.mili.adapter.ViewPagerAdapter_wellcome;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/4/12.
 * Wellcomeactivity
 */
public class Wellcome extends Activity implements ViewPager.OnPageChangeListener,View.OnClickListener{

    public static final String AppInfo="APP_INFO";

    private ArrayList<View> views;
    private ViewPagerAdapter_wellcome mAdapter;
    private ViewPager viewPager;
    private static final int[] imgs ={R.mipmap.guide1,R.mipmap.guide2,R.mipmap.guide3,R.mipmap.guide4,R.mipmap.guide5};
    //底部小点的图片
    private ImageView[] point;
    //记录当前选中位置
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//         隐藏应用程序的标题栏，即当前activity的标题栏
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        ShowGuideView();
    }

    private void ShowGuideView() {
        SharedPreferencesUtil shared =new SharedPreferencesUtil(this,AppInfo);
        if (shared.isFirstRun()){
            initView();
            initData();
        }else {
            findViewById(R.id.aty_wellcome_guide).setVisibility(View.VISIBLE);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    startActivity(new Intent(Wellcome.this,MainActivity.class));
                }
            },3*1000);

        }
    }


    private void initData() {
        LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i=0;i<imgs.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(imgs[i]);
            views.add(imageView);
        }
        viewPager.setAdapter(mAdapter);

        viewPager.addOnPageChangeListener(this);

        initPoint();
    }

    private void initPoint() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aty_wellcome_linearlayout);
        linearLayout.setVisibility(View.VISIBLE);
         point = new ImageView[imgs.length];
        for (int i=0;i<imgs.length;i++){
            point[i] = (ImageView) linearLayout.getChildAt(i);
            point[i].setEnabled(true);
            point[i].setOnClickListener(this);
            point[i].setTag(i);
        }
        currentIndex=0;

        point[currentIndex].setEnabled(false);
    }

    private void initView() {
        views =new ArrayList<View>();
        viewPager= (ViewPager) findViewById(R.id.aty_wellcome_viewpager);
        mAdapter =new ViewPagerAdapter_wellcome(views);
    }

        //当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

        //当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {
        setCurView(position);
        setCurStar(position);
        Button bt = (Button) findViewById(R.id.aty_wellcome_enter);
            if(position==imgs.length-1){
            bt.setVisibility(View.VISIBLE);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Wellcome.this, MainActivity.class));
                }
            });
        }else {
            bt.setVisibility(View.INVISIBLE);
        }
    }

        //当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        setCurView(position);
        
        setCurStar(position);

    }

    private void setCurStar(int position) {
        if (position<0||position>imgs.length-1||currentIndex==position)
            return;
        point[position].setEnabled(false);
        point[currentIndex].setEnabled(true);
        currentIndex=position;


    }

    private void setCurView(int positon) {
        if (positon<0||positon>=imgs.length)
            return;
        viewPager.setCurrentItem(positon);

    }

    
}
