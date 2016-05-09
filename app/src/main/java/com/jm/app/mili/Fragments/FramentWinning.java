package com.jm.app.mili.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jm.app.mili.Bean.WinningBean;
import com.jm.app.mili.R;
import com.jm.app.mili.adapter.WinningAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class FramentWinning extends Fragment {
    private ListView lv;
    private ArrayList<WinningBean> list;
    private WinningAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_winning, null);
        lv = (ListView) view.findViewById(R.id.lv_win);
        list = new ArrayList<WinningBean>();
        for (int i = 1; i < 10; i++) {
            list.add(new WinningBean(R.mipmap.ic_launcher,"iphone6s64G","期号：","1986","本期参与：","10人次","获奖者：","SB","共参与了：","100次","幸运号码：","1986","参与详情"));
        }
        adapter = new WinningAdapter(view.getContext(),list);
        lv.setAdapter(adapter);
        return view;
    }
}
