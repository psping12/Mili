package com.jm.app.mili.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jm.app.mili.Bean.NormalGoodsInfo;
import com.jm.app.mili.R;
import com.jm.app.mili.activities.TestActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.mViewHodlder> {
    private ArrayList<NormalGoodsInfo> data;
    private Context context;


    public GoodsAdapter(ArrayList<NormalGoodsInfo> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @Override
    public mViewHodlder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHodlder holder =new mViewHodlder(LayoutInflater.from(context).inflate(R.layout.gridview_goods_item,null));
        return holder;
    }

    @Override
    public void onBindViewHolder(mViewHodlder holder, final int position) {
        NormalGoodsInfo goodsinfo=data.get(position);
        holder.img.setBackgroundResource(goodsinfo.getImg());
        holder.total.setText(goodsinfo.getTotal_amount());
        holder.remains.setText(goodsinfo.getRemains());
        holder.progressbar.setProgress((int)Integer.parseInt(goodsinfo.getTotal_amount())/Integer.parseInt(goodsinfo.getRemains()));
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, TestActivity.class);
                intent.putExtra("name",position);
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
        public mViewHodlder(View itemView) {
            super(itemView);
            total= (TextView) itemView.findViewById(R.id.goods_item_total_needs);
            remains = (TextView) itemView.findViewById(R.id.goods_item_remains);
            progressbar= (ProgressBar) itemView.findViewById(R.id.goods_item_progressbar);
            img= (ImageView) itemView.findViewById(R.id.goods_item_imgv);
        }
    }
}
