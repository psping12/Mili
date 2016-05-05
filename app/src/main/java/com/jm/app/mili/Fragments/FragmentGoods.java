package com.jm.app.mili.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jm.app.mili.Bean.NormalGoodsInfo;
import com.jm.app.mili.R;
import com.jm.app.mili.adapter.GoodsAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class FragmentGoods extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_goods,null);
        initView(view);
        return view;
    }

    private void initView(View v) {

        ArrayList<NormalGoodsInfo> data = new ArrayList<NormalGoodsInfo>();
        for (int i = 1; i < 10; i++) {
            NormalGoodsInfo info = new NormalGoodsInfo();
            info.setImg(R.mipmap.test_good);
            info.setTotal_amount(i + 200 + "");
            info.setRemains(i + 100 + "");
            data.add(info);
            recyclerView = (RecyclerView) v.findViewById(R.id.frag_goods_recyckerview);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            recyclerView.setAdapter(new GoodsAdapter(data, getActivity()));
        }
    }

}
