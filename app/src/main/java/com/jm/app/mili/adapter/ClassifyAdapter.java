package com.jm.app.mili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jm.app.mili.Bean.ClassifyBean;
import com.jm.app.mili.R;
import com.jm.app.mili.activities.TestActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ClassifyAdapter extends RecyclerView.Adapter<ClassifyAdapter.mViewHodlders> {
    private ArrayList<ClassifyBean> data;
    private Context context;

    public ClassifyAdapter(ArrayList<ClassifyBean> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @Override
    public mViewHodlders onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHodlders hodlders=new mViewHodlders(LayoutInflater.from(context).inflate(R.layout.item_classify,null));
        return hodlders;
    }

    @Override
    public void onBindViewHolder(mViewHodlders holder, final int position) {
        ClassifyBean bean;
        bean=data.get(position);

        holder.img.setImageResource(bean.getImage());
        holder.txt.setText(bean.getText());

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

    class  mViewHodlders extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txt;
        public mViewHodlders(View itemView) {
            super(itemView);
            txt= (TextView) itemView.findViewById(R.id.item_classfy_txt);
            img= (ImageView) itemView.findViewById(R.id.item_classfy_img);
        }
    }
}
