package com.jm.app.mili.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jm.app.mili.MainActivity;
import com.jm.app.mili.R;
import com.jm.app.mili.Utils.ToolbarManager;

/**
 * Created by Administrator on 2016/5/3.
 */
public class TestActivity extends BaseActivity{
    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test);

        /**
         * 设置toolbar
         */
//        View view =findViewById(R.id.aty_test_toolbar);
//        ToolbarManager manager=new ToolbarManager(view,this);
//        manager.setImgLeft(R.mipmap.ic_launcher,true,null);
//        manager.setTitleTxt(true,"测试界面");
//        manager.setImgRight(0,true, MainActivity.class);



        tv= (TextView) findViewById(R.id.aty_test_tv);
        int a =getIntent().getIntExtra("name",999);
        String b =getIntent().getStringExtra("text");
        if (b!=null){
            tv.setText(b);
        }else {
            tv.setText(a+"");
        }

    }
}
