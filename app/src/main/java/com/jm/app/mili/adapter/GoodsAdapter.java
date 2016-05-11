package com.jm.app.mili.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jm.app.mili.Bean.NormalGoodsInfo;
import com.jm.app.mili.R;
import com.jm.app.mili.activities.GoodDetailsActivity;
import com.jm.app.mili.activities.TestActivity;
import com.jm.app.mili.activities.Wellcome;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.mViewHodlder> {
    private static ArrayList<NormalGoodsInfo> data;
    private Context context;
    ImageOptions imageOptions;

    public GoodsAdapter(ArrayList<NormalGoodsInfo> data, Context context) {
        this.data = data;
        this.context = context;

        imageOptions = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                .setRadius(DensityUtil.dip2px(5))
                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true)
                // 加载中或错误图片的ScaleType
                //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                //设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.ic_launcher)
                //设置使用缓存
                .setUseMemCache(true)
                //设置支持gif
                .setIgnoreGif(false)
                //设置显示圆形图片
//      .setCircular(false)
                .build();
    }


    @Override
    public mViewHodlder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHodlder holder =new mViewHodlder(LayoutInflater.from(context).inflate(R.layout.gridview_goods_item,null));
        return holder;
    }

    @Override
    public void onBindViewHolder(mViewHodlder holder, final int position) {
        NormalGoodsInfo goodsinfo=data.get(position);
//        holder.img.setBackgroundResource(goodsinfo.getImg());
        x.image().bind(holder.img,goodsinfo.getImg(),imageOptions);


        holder.total.setText(goodsinfo.getTotal_amount());
        holder.remains.setText(goodsinfo.getRemains());

        int total=Integer.parseInt(goodsinfo.getTotal_amount());
        int remains =Integer.parseInt(goodsinfo.getRemains());
//        holder.progressbar.setProgress((int)Integer.parseInt(goodsinfo.getTotal_amount())/Integer.parseInt(goodsinfo.getRemains()));
        holder.progressbar.setProgress(remains*100/total);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, GoodDetailsActivity.class);
                intent.putExtra("name",position);
                context.startActivity(intent);
            }
        });

        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, TestActivity.class);
                intent.putExtra("text",position+"ButtonClick");
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class  mViewHodlder extends RecyclerView.ViewHolder{
        TextView total,remains;
        ProgressBar progressbar;
        ImageView img;
        Button bt;
        public mViewHodlder(View itemView) {
            super(itemView);
            total= (TextView) itemView.findViewById(R.id.goods_item_total_needs);
            remains = (TextView) itemView.findViewById(R.id.goods_item_remains);
            progressbar= (ProgressBar) itemView.findViewById(R.id.goods_item_progressbar);
            img= (ImageView) itemView.findViewById(R.id.goods_item_imgv);
            bt= (Button) itemView.findViewById(R.id.goods_item_button);
        }
    }


    public  void add(int type){
        Log.e("------","+++++++++++++");
             data.clear();
             Wellcome.shouyeData();
             data=Wellcome.getGoodsInfos();


    }
}
