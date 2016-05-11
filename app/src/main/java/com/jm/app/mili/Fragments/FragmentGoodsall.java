package com.jm.app.mili.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jm.app.mili.Bean.NormalGoodsInfo;
import com.jm.app.mili.R;
import com.jm.app.mili.adapter.GoodsAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class FragmentGoodsall extends Fragment {
    static RecyclerView recyclerView;
    static int a;
    static GoodsAdapter adapter;
    static ArrayList<NormalGoodsInfo> data;
    int start, limit, lastVisibleItem, totalCount;
    GridLayoutManager manager;
    SwipeRefreshLayout swipeRefreshLayout;//下拉刷新控件

    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    adapter.add(1);
                    adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                    break;
                case 2:
                    swipeRefreshLayout.setRefreshing(false);
                    break;
            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods, null);
//        initView(view, a);
        return view;
    }

    private void initView(View v, int a) {

      /*  swipeRefreshLayout= (SwipeRefreshLayout) v.findViewById(R.id.aty_main_swipe);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(refreshListener);

        recyclerView = (RecyclerView) v.findViewById(R.id.frag_goods_recyckerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        data = FragmentShouYe.getDatall();
        adapter = new GoodsAdapter(data, getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            //用来标记是否正在向最后一个滑动，既是否向右滑动或向下滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                 manager = (GridLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem == (totalItemCount -1) ) {
                        //加载更多功能的代码
                        Toast.makeText(getContext(),"加载更多",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if(dx > 0){
                    //大于0表示，正在向右滚动
                    isSlidingToLast = true;
                }else{
                    //小于等于0 表示停止或向左滚动
                    isSlidingToLast = false;
                }

            }
        });
*/
    }

    private void calculate() {
        int current = adapter.getItemCount();
        if (current + limit < totalCount) {
            start = current;
        } else {
            start = current;
            limit = totalCount - current;
        }
    }

//    private void loadListMore() {
//        mListDataMore.clear();
//        for (int i = start; i < start + limit; i++) {
//            RecycleBean recycleBean = new RecycleBean();
//            recycleBean.setId(i);
//            recycleBean.setName("更多name" + i);
//            recycleBean.setContent("更多content" + i);
//            List<RecycleImageBean> imageList = new ArrayList<>();
//            for (int j = 0; j < i + 1; j++) {
//                RecycleImageBean imageBean = new RecycleImageBean();
//                imageBean.setId(j);
//                imageBean.setImage(sampleUrl);
//                imageList.add(imageBean);
//            }
//            recycleBean.setImageList(imageList);
//            mListData.add(recycleBean);
//        }
//
//        mListData.addAll(mListDataMore);
//        adapter.notifyDataSetChanged();
////        adapter.notifyItemInserted(); // 建议使用这种更新adapter方式，带position参数
//        if (adapter.getItemCount() >= totalCount) {
//            Toast.makeText(TestRecyclerViewActivity.this, "数据全部加载完毕", Toast.LENGTH_SHORT).show();
//        }
//
//    }


//    private void loadData() {
//        // 加载数据
//        mListData.clear();
//        for (int i = start + limit - 1; i >= 0; i--) {
//            RecycleBean recycleBean = new RecycleBean();
//            recycleBean.setId(i);
//            recycleBean.setName("name" + i);
//            recycleBean.setContent("content" + i);
//            List<RecycleImageBean> imageList = new ArrayList<>();
//            for (int j = 0; j < i + 1; j++) {
//                RecycleImageBean imageBean = new RecycleImageBean();
//                imageBean.setId(j);
//                imageBean.setImage(sampleUrl);
//                imageList.add(imageBean);
//            }
//            recycleBean.setImageList(imageList);
//            mListData.add(recycleBean);
//        }
//
//        // 创建Adapter，并指定数据集
//        adapter = new MyRecyclerAdapter(getActivity(), mListData);
//        // 绑定Adapter到RecyclerView上
//        mRecyclerView.setAdapter(adapter);
//        // 停止刷新
//        swipeRefreshLayout.setRefreshing(false);
//        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(TestRecyclerViewActivity.this, "点击了item" + position, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }


    //下拉刷新监听
    SwipeRefreshLayout.OnRefreshListener refreshListener =new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            handler.sendEmptyMessage(1);
        }
    };

}
