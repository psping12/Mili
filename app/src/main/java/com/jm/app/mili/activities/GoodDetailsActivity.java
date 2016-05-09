package com.jm.app.mili.activities;

import android.app.Activity;
import android.os.Bundle;

import com.jm.app.mili.R;
import com.jm.app.mili.widget.TimeTextView;

/**
 * Created by Administrator on 2016/5/6.
 */
//商品详情
public class GoodDetailsActivity extends Activity{
private TimeTextView mCountdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_details);
        mCountdown= (TimeTextView) findViewById(R.id.aty_good_details_countdown);
        mCountdown.setTime("0","24","00","00");
    }
}
