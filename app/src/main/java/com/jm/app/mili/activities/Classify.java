package com.jm.app.mili.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.jm.app.mili.Bean.ClassifyBean;
import com.jm.app.mili.MainActivity;
import com.jm.app.mili.R;
import com.jm.app.mili.Utils.ToolbarManager;
import com.jm.app.mili.adapter.ClassifyAdapter;
import com.jm.app.mili.widget.DividerGridItemDecoration;

import java.util.ArrayList;

//分类
/**
 * Created by Administrator on 2016/5/5.
 */
public class Classify extends AppCompatActivity{
    RecyclerView recyclerView;
    ArrayList<ClassifyBean> data;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);

        initView();

    }

    private void initView() {

        /**
         * 设置toolbar
         */
//        View view =findViewById(R.id.aty_classify_toolbar);
//        ToolbarManager manager=new ToolbarManager(view,this);
//        manager.setImgLeft(R.mipmap.ic_launcher,true,null);
//        manager.setTitleTxt(true,"分类");
//        manager.setImgRight(0,false, MainActivity.class);
//
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        Log.e("----",""+height);





        Log.e("----data.size"," asda ");
        recyclerView= (RecyclerView) findViewById(R.id.aty_classify_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerView.setMinimumHeight(height/2);

        data=new ArrayList<ClassifyBean>();
        for (int i=0;i<10;i++){
            ClassifyBean bean =new ClassifyBean();
            bean.setImage(R.mipmap.item_classify_testimg);
            bean.setText("苹果专场"+i);
            data.add(bean);
        }
        Log.e("----data.size","  "+data.size());
        recyclerView.setAdapter(new ClassifyAdapter(data,this));
    }


}
