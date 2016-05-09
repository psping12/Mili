package com.jm.app.mili.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jm.app.mili.Bean.RecordBean;
import com.jm.app.mili.R;
import com.jm.app.mili.adapter.RecordAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/4.
 */
public class FramentRecord extends Fragment {
    private ListView listView;
    private ArrayList<RecordBean> list;
    private RecordAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fraent_record, null);
        listView = (ListView) view.findViewById(R.id.lv_Record);
        list = new ArrayList<RecordBean>();
        for (int i = 0; i < 1; i++) {
            list.add(new RecordBean(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.drawable.ic_menu_camera, "移动充值卡5000元", "期号：", "71654", "参与者：", "6阿斯顿", "共参与了：", "122", "幸运号码：", "71654", "已兑换欢乐豆"));
        }
        adapter = new RecordAdapter(view.getContext(), list);
        listView.setAdapter(adapter);
        return view;
    }
}
