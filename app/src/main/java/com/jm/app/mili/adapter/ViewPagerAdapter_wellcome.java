package com.jm.app.mili.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/12.
 */
public class ViewPagerAdapter_wellcome extends PagerAdapter {
   private ArrayList<View> views;

    public ViewPagerAdapter_wellcome(ArrayList<View> views){
        this.views=views;
    }

    //获得当前界面数
    @Override
    public int getCount() {
        if (views!=null)
            return  views.size();
        return 0;
    }

    //初始化position位置的界面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position),0);
        return views.get(position);
    }

    // 判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }

    //销毁position位置的界面
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
