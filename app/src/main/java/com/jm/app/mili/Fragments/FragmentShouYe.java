package com.jm.app.mili.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jm.app.mili.Bean.NormalGoodsInfo;
import com.jm.app.mili.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/4/28.
 */
public class FragmentShouYe extends Fragment {
    ViewPager viewpager;
    LinearLayout lin;

    int[] adImgsURl = {R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3, R.mipmap.guide4, R.mipmap.guide5};
    ImageView points[];//广告圆点
    View views[];//广告视图
    int selectedItem;//广告选中item
//    ScheduledExecutorService scheduledExecutorService;
    Timer timer;

    RecyclerView recyclearView;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    viewpager.setCurrentItem(selectedItem+1);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_shouye, null);
        initView(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    private void initView(View view) {


        ScrollView scrollView = (ScrollView) view.findViewById(R.id.frag_shouye_scrollview);
        scrollView.smoothScrollBy(0,0);

        /**
         * banner Ad
         */
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


        /**
         * goods
         */

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

    /**
     * 广告适配器
     */
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

    /**
     * 广告监听
     */
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

    /**
     * 设置广告圆点
     * @param position
     */
    private void setPointsBg(int position) {
        for (int i = 0; i < points.length; i++) {
            if (i == position) {
                points[i].setBackgroundResource(R.mipmap.point_select);
            } else {
                points[i].setBackgroundResource(R.mipmap.point_normal);
            }
        }
    }

    /**
     * 商品适配器
     */
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


    /**
     * 循环轮播
     */
    private void loopAd() {
        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        },3*1000,3*1000);

//        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        // 当Activity显示出来后，每两秒切换一次图片显示
//        scheduledExecutorService.scheduleAtFixedRate(new adTask(), 3, 3,
//                TimeUnit.SECONDS);
    }

    class adTask implements Runnable{
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
        }
    }

    private void stopAd(){
//        scheduledExecutorService.shutdown();
        timer.cancel();
    }


    @Override
    public void onResume() {
        super.onResume();
        loopAd();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopAd();
    }
}
