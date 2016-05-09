package com.jm.app.mili.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jm.app.mili.Bean.DiscoveryBean;
import com.jm.app.mili.R;
import com.jm.app.mili.adapter.DiscoveryAdapter;

import java.util.ArrayList;

public class FragmentDiscovery extends Fragment {

    private DiscoveryAdapter adapter;
    private ArrayList<DiscoveryBean> list;
    private ListView lv_discovery;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovery, null);
        lv_discovery = (ListView) view.findViewById(R.id.lv_discovery);
        list = new ArrayList<DiscoveryBean>();
        for (int i = 0; i < 10; i++) {
            list.add(new DiscoveryBean(R.mipmap.ic_launcher, R.mipmap.ic_launcher,"新用户特权","冲50得一百"));
        }
        adapter = new DiscoveryAdapter(view.getContext(),list);
        lv_discovery.setAdapter(adapter);
        return view;
    }
}
