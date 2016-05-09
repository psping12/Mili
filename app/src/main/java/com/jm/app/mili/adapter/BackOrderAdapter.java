package com.jm.app.mili.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jm.app.mili.Bean.BackOrder;
import com.jm.app.mili.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class BackOrderAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<BackOrder> list;
    private LayoutInflater inflater;

    public BackOrderAdapter(Context context, ArrayList<BackOrder> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder hoder;
        hoder = new ViewHoder();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_back_order, null);
            hoder.image = (ImageView) convertView.findViewById(R.id.img);
            hoder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            hoder.tvtime = (TextView) convertView.findViewById(R.id.tvtime);
            hoder.tv_namenuber = (TextView) convertView.findViewById(R.id.tv_namenuber);
            hoder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
            hoder.tv_love = (TextView) convertView.findViewById(R.id.tv_love);
            hoder.tv_nolove = (TextView) convertView.findViewById(R.id.tv_nolove);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }
        BackOrder bean = list.get(position);
        hoder.image.setBackgroundResource(bean.getImage());
        hoder.tvtime.setText(bean.getTvtime());
        hoder.tv_name.setText(bean.getTv_name());
        hoder.tv_namenuber.setText(bean.getTv_namenuber());
        hoder.tv_state.setText(bean.getTv_state());
        hoder.tv_love.setText(bean.getTv_love());
        hoder.tv_nolove.setText(bean.getTv_nolove());
        return convertView;
    }

    class ViewHoder {
        private ImageView image;
        private TextView tvtime, tv_name, tv_namenuber, tv_state, tv_love, tv_nolove;
    }
}
