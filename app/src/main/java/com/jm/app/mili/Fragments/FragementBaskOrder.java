package com.jm.app.mili.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jm.app.mili.Bean.BackOrder;
import com.jm.app.mili.R;
import com.jm.app.mili.adapter.BackOrderAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class FragementBaskOrder extends Fragment {
    private ListView lv;
    private ArrayList<BackOrder> list;
    private BackOrderAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_bask_order, null);
        Log.e("---1","@@@@@@");
        lv = (ListView) view.findViewById(R.id.lv);
        Log.e("---2","@@@@@@");
        list = new ArrayList<BackOrder>();
        Log.e("---3","@@@@@@");
        for (int i = 0; i < 10; i++) {
            list.add(new BackOrder("今天","获得奖品：","移动充值卡1000元","啊啊啊啊啊啊啊啊啊啊啊啊","0","0", R.mipmap.ic_launcher));
        }
        adapter = new BackOrderAdapter(getActivity(),list);
        lv.setAdapter(adapter);
        return view;
    }
}
