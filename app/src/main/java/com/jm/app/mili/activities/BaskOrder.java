package com.jm.app.mili.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import com.jm.app.mili.R;
import com.jm.app.mili.adapter.BaskoderAdapter;
import com.jm.app.mili.adapter.OrderBaskBean;

import java.util.ArrayList;

/**
 * 晒单
 */
public class BaskOrder extends AppCompatActivity {
    private BaskoderAdapter adapter;
    private ArrayList<OrderBaskBean> list;
    private ListView lv_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bask_order);

        lv_order = (ListView) findViewById(R.id.lv_order);
        list = new ArrayList<OrderBaskBean>();
        for (int i = 0; i < 10; i++) {
         list.add(new OrderBaskBean("夜观天象","获得商品：","打飞机","萨达是倒萨大顶顶顶顶顶顶顶顶顶顶","0","0","15分钟前",R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.drawable.aaa,R.drawable.bbb));
        }
        adapter = new BaskoderAdapter(this ,list);
        lv_order.setAdapter(adapter);
    }
}
