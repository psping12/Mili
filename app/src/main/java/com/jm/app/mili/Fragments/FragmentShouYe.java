package com.jm.app.mili.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jm.app.mili.Bean.NormalGoodsInfo;
import com.jm.app.mili.MainActivity;
import com.jm.app.mili.R;
import com.jm.app.mili.activities.BaskOrder;
import com.jm.app.mili.activities.Classify;
import com.jm.app.mili.activities.TestActivity;
import com.jm.app.mili.activities.Wellcome;
import com.jm.app.mili.adapter.GoodsAdapter;
import com.jm.app.mili.widget.mScrollview;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Administrator on 2016/4/28.
 */
public class FragmentShouYe extends Fragment implements mScrollview.OnScrollListener{
    ViewPager viewpager;
    LinearLayout lin;

    int[] adImgsURl = {R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3, R.mipmap.guide4, R.mipmap.guide5};
    ImageView points[];//广告圆点
    View views[];//广告视图
    int selectedItem;//广告选中item
    ScheduledExecutorService scheduledExecutorService;

    RecyclerView recyclearView;

    TextView allgoods,tengoods,allgoods1,tengoods1;//全部商品,十元专区
    FragmentGoodsall allGoods;//全部商品
    FragmentGoodsten tenGoods;//十元专区
    TextView classify,onebecomethirty,cheats,showorder;//分类，1变30,中奖秘籍,晒单

    mScrollview mscrollView;
    LinearLayout normalalandten,parentView,childView;
    FrameLayout topallandten;

    RecyclerView recyclerView;
    ArrayList<NormalGoodsInfo> data;
    GoodsAdapter adapter;

    int margintop;
    boolean SelectedWay =true;// 默认右边选中



    SwipeRefreshLayout swipeRefreshLayout;//下拉刷新控件

    static ArrayList<NormalGoodsInfo> datall,dataAlsl,dataten;

    public static ArrayList<NormalGoodsInfo> getDatall() {
        Random r =new Random();
        boolean a = r.nextBoolean();
        return a?dataAlsl:datall;
    }


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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_shouye, null);


         dataAlsl=new ArrayList<NormalGoodsInfo>();
        for (int i = 0; i < 10; i++) {
            NormalGoodsInfo info = new NormalGoodsInfo();
            info.setImg("http://pic32.nipic.com/20130829/12906030_124355855000_2.png");
            info.setTotal_amount(i + 200 + "");
            info.setRemains(i + 100 + "");
            dataAlsl.add(info);
        }

        datall = new ArrayList<NormalGoodsInfo>();
        for (int i = 0; i < 10; i++) {
            NormalGoodsInfo info = new NormalGoodsInfo();
            info.setImg("http://pic32.nipic.com/20130829/12906030_124355855000_2.png");
            info.setTotal_amount(i + 200 + "");
            info.setRemains(i + 100 + "");
            datall.add(info);
        }
        dataten = new ArrayList<NormalGoodsInfo>();
        for (int i = 0; i < 10; i++) {
            NormalGoodsInfo info = new NormalGoodsInfo();
            info.setImg("http://pic32.nipic.com/20130829/12906030_124355855000_2.png");
            info.setTotal_amount(i + 200 + "");
            info.setRemains(i + 100 + "");
            dataten.add(info);
        }

        initView(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private void initView(View view){


        parentView= (LinearLayout) view.findViewById(R.id.frag_shouye_parentview);
        childView = (LinearLayout) view.findViewById(R.id.frag_shouye_scrollview_child);
        childView.getParent().requestDisallowInterceptTouchEvent(true);
        topallandten= (FrameLayout) view.findViewById(R.id.frag_shouye_topallandten);
        normalalandten= (LinearLayout) view.findViewById(R.id.frag_shouye_normalallandten);
        mscrollView = (mScrollview) view.findViewById(R.id.frag_shouye_scrollview);
        mscrollView.smoothScrollBy(0,topallandten.getTop());

        topallandten.setVisibility(View.GONE);
        mscrollView.setOnScrollListener(this);
        parentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                onScroll(mscrollView.getScrollY());
            }
        });

        allgoods = (TextView) view.findViewById(R.id.frag_shouye_allgoods);
        allgoods1 = (TextView) view.findViewById(R.id.frag_shouye_allgoods1);
        tengoods = (TextView) view.findViewById(R.id.frag_shouye_tengoods);
        tengoods1 = (TextView) view.findViewById(R.id.frag_shouye_tengoods1);
        allgoods.setOnClickListener(goodsKindsListener);
        allgoods1.setOnClickListener(goodsKindsListener);
        tengoods.setOnClickListener(goodsKindsListener);
        tengoods1.setOnClickListener(goodsKindsListener);


        //中部导航按钮
        classify= (TextView) view.findViewById(R.id.frag_shouye_classify);
        onebecomethirty= (TextView) view.findViewById(R.id.frag_shouye_onebecomthirty);
        cheats= (TextView) view.findViewById(R.id.frag_shouye_cheats);
        showorder= (TextView) view.findViewById(R.id.frag_shouye_showorder);
        classify.setOnClickListener(guideListener);
        onebecomethirty.setOnClickListener(guideListener);
        cheats.setOnClickListener(guideListener);
        showorder.setOnClickListener(guideListener);


        //底部商品
//        allGoods =new FragmentGoodsall();
//        tenGoods=new FragmentGoodsten();
//        FragmentManager fm=getFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.add(R.id.frag_shouye_content_goods,new FragmentGoodsall());
//        ft.commit();

        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.aty_main_swipe);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(refreshListener);

        recyclerView = (RecyclerView) view.findViewById(R.id.frag_shouye_recyckerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        data = Wellcome.getGoodsInfos();
        adapter = new GoodsAdapter(data, getActivity());
        recyclerView.setAdapter(adapter);




    }



    @Override
    public void onScroll(int scrollY) {
        int mBuyLayout2ParentTop = Math.max(scrollY, normalalandten.getTop());
        if (scrollY>normalalandten.getBottom()){
            topallandten.setVisibility(View.VISIBLE);
        }else if (scrollY==normalalandten.getBottom()-5){
            topallandten.setVisibility(View.GONE);
        }else {
            topallandten.setVisibility(View.GONE);
        }


    }

    private View.OnClickListener goodsKindsListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            if (v.getId()==R.id.frag_shouye_allgoods|v.getId()==R.id.frag_shouye_allgoods1){
                allSelected();
                SelectedWay =true;
            }else if (v.getId()==R.id.frag_shouye_tengoods|v.getId()==R.id.frag_shouye_tengoods1){
                tenSelected();
                SelectedWay =false;
            }
            ft.commit();
        }
    };


    private void allSelected(){
        allgoods.setTextColor(getResources().getColor(R.color.colorAccent));
        allgoods1.setTextColor(getResources().getColor(R.color.colorAccent));
        tengoods1.setTextColor(Color.BLACK);
        tengoods.setTextColor(Color.BLACK);
        handler.sendEmptyMessage(1);
    }

    private void tenSelected(){
        allgoods.setTextColor(Color.BLACK);
        allgoods1.setTextColor(Color.BLACK);
        tengoods.setTextColor(getResources().getColor(R.color.colorAccent));
        tengoods1.setTextColor(getResources().getColor(R.color.colorAccent));

        handler.sendEmptyMessage(2);
    }


    private View.OnClickListener guideListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.frag_shouye_classify:
                    Toast.makeText(getActivity(), "分类", Toast.LENGTH_SHORT).show();
                    getActivity().startActivity(new Intent(getContext(), Classify.class));
                    break;
                case R.id.frag_shouye_onebecomthirty:
                    Toast.makeText(getActivity(), "1元变30", Toast.LENGTH_SHORT).show();
                    Intent intent1 =new Intent(getContext(),TestActivity.class);
                    intent1.putExtra("text","1元变30");
                    startActivity(intent1);
                    break;
                case R.id.frag_shouye_cheats:
                    Toast.makeText(getActivity(), "中奖秘籍", Toast.LENGTH_SHORT).show();
                    Intent intent2 =new Intent(getContext(),TestActivity.class);
                    intent2.putExtra("text","中奖秘籍");
                    startActivity(intent2);
                    break;
                case R.id.frag_shouye_showorder:
                    Toast.makeText(getActivity(), "分类", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(),BaskOrder.class));
                    break;
                default:
                    break;
            }
        }
    };



    //下拉刷新监听
    SwipeRefreshLayout.OnRefreshListener refreshListener =new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            handler.sendEmptyMessage(1);
        }
    };


/*    private void initView(View view) {


//        ScrollView scrollView = (ScrollView) view.findViewById(R.id.frag_shouye_scrollview);
//        scrollView.smoothScrollBy(0,0);

        *//**
         * banner Ad
         *//*
        viewpager = (ViewPager) view.findViewById(R.id.frag_shouye_banner_viewpager);
        lin = (LinearLayout) view.findViewById(R.id.frag_shouye_banner_lin);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 0, 5, 0);
        points = new ImageView[adImgsURl.length];
        for (int i = 0; i < adImgsURl.length; i++) {
            ImageView iv = new ImageView(getActivity());
            iv.setLayoutParams(params);
            iv.setId(i);
            points[i] = iv;
            if (i == 0) {
                points[i].setBackgroundResource(R.mipmap.point_select);
            } else {
                points[i].setBackgroundResource(R.mipmap.point_normal);
            }

            lin.addView(points[i]);
        }
        views = new View[adImgsURl.length];
        for (int i = 0; i < adImgsURl.length; i++) {
            View v = new View(getActivity());
            v.setBackgroundResource(adImgsURl[i]);
            views[i] = v;
        }

        viewpager.setAdapter(new BannerAdAdapter());
        viewpager.setCurrentItem(views.length * 100);
        viewpager.addOnPageChangeListener(pagelistener);


        *//**
         * goods
         *//*

        ArrayList<NormalGoodsInfo> data =new ArrayList<NormalGoodsInfo>();
        for (int i=1;i<10;i++){
            NormalGoodsInfo info =new NormalGoodsInfo();
            info.setImg(R.mipmap.test_good);
            info.setTotal_amount(i+200+"");
            info.setRemains(i+100+"");
            data.add(info);
        }

        recyclearView= (RecyclerView) view.findViewById(R.id.frag_shouye_recyckerview);
        recyclearView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclearView.setAdapter(new goodsAdapter(data));


    }

    *//**
     * 广告适配器
     *//*
    class BannerAdAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (views == null)
                return 0;
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            try {
                container.addView(views[position % views.length]);
            } catch (Exception e) {

            }
            return views[position % views.length];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views[position % views.length]);
        }
    }

    *//**
     * 广告监听
     *//*
    private ViewPager.OnPageChangeListener pagelistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setPointsBg(position % views.length);
            selectedItem = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    *//**
     * 设置广告圆点
     * @param position
     *//*
    private void setPointsBg(int position) {
        for (int i = 0; i < points.length; i++) {
            if (i == position) {
                points[i].setBackgroundResource(R.mipmap.point_select);
            } else {
                points[i].setBackgroundResource(R.mipmap.point_normal);
            }
        }
    }

    *//**
     * 商品适配器
     *//*
    class goodsAdapter extends RecyclerView.Adapter<goodsAdapter.mViewHolder>{
        private ArrayList<NormalGoodsInfo> data;

        public goodsAdapter(ArrayList<NormalGoodsInfo> data){
            this.data=data;
        }

        @Override
        public goodsAdapter.mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            mViewHolder holder =new mViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.gridview_goods_item,null));
            return holder;
        }

        @Override
        public void onBindViewHolder(goodsAdapter.mViewHolder holder, int position) {
            NormalGoodsInfo goodsinfo=data.get(position);
            holder.img.setBackgroundResource(goodsinfo.getImg());
            holder.total.setText(goodsinfo.getTotal_amount());
            holder.remains.setText(goodsinfo.getRemains());
            holder.progressbar.setProgress((int)Integer.parseInt(goodsinfo.getTotal_amount())/Integer.parseInt(goodsinfo.getRemains()));

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class mViewHolder extends RecyclerView.ViewHolder{
            TextView total,remains;
            ProgressBar progressbar;
            ImageView img;

            public mViewHolder(View itemView) {
                super(itemView);
                total= (TextView) itemView.findViewById(R.id.goods_item_total_needs);
                remains = (TextView) itemView.findViewById(R.id.goods_item_remains);
                progressbar= (ProgressBar) itemView.findViewById(R.id.goods_item_progressbar);
                img= (ImageView) itemView.findViewById(R.id.goods_item_imgv);
            }
        }
    }


    *//**
     * 切换下一张广告
     *//*
    public void CurrentBannerItem(){
      viewpager.setCurrentItem(selectedItem+1);
    }

    @Override
    public void onResume() {
        super.onResume();
//        MainActivity.startBannerAd();
        startBannerAd();
    }

    @Override
    public void onStop() {
        super.onStop();
//        MainActivity.stopBannerAd();
        stopBannerAd();
    }


    *//**
     * 开始轮询广告
     *//*
    public void startBannerAd(){
        timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               handler.sendEmptyMessage(1);
            }
        },5*1000,3*1000);
    }

    *//**
     * 结束轮询
     *//*
    public void stopBannerAd(){
        timer.cancel();
    }*/
}
