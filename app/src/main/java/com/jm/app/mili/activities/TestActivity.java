package com.jm.app.mili.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jm.app.mili.R;

/**
 * Created by Administrator on 2016/5/3.
 */
public class TestActivity extends Activity{
    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test);
        tv= (TextView) findViewById(R.id.aty_test_tv);
        int a =getIntent().getIntExtra("name",999);
        tv.setText(a+"");
    }
}
