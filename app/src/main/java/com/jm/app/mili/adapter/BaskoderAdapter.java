package com.jm.app.mili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jm.app.mili.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/9.
 */
public class BaskoderAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<OrderBaskBean> list;
    private LayoutInflater inflater;

    public BaskoderAdapter(Context context, ArrayList<OrderBaskBean> list) {
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
            convertView = inflater.inflate(R.layout.item_baskorder, null);
            hoder.img_gun = (ImageView) convertView.findViewById(R.id.img_gun);
            hoder.tv_gun = (TextView) convertView.findViewById(R.id.tv_gun);
            hoder.img_love = (ImageView) convertView.findViewById(R.id.img_love);
            hoder.img_nolove = (ImageView) convertView.findViewById(R.id.img_nolove);
            hoder.image = (ImageView) convertView.findViewById(R.id.img);
            hoder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            hoder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            hoder.tv_namenuber = (TextView) convertView.findViewById(R.id.tv_namenuber);
            hoder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
            hoder.tv_love = (TextView) convertView.findViewById(R.id.tv_love);
            hoder.tv_nolove = (TextView) convertView.findViewById(R.id.tv_nolove);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }
        OrderBaskBean bean = list.get(position);
        hoder.image.setBackgroundResource(bean.getImage());
        hoder.img_love.setBackgroundResource(bean.getImg_love());
        hoder.img_nolove.setBackgroundResource(bean.getImg_nolove());
        hoder.img_gun.setBackgroundResource(bean.getImg_gun());
        hoder.tv_gun.setText(bean.getTv_gun());
        hoder.tv_time.setText(bean.getTv_time());
        hoder.tv_name.setText(bean.getTv_name());
        hoder.tv_namenuber.setText(bean.getTv_namenuber());
        hoder.tv_state.setText(bean.getTv_state());
        hoder.tv_love.setText(bean.getTv_love());
        hoder.tv_nolove.setText(bean.getTv_nolove());
        return convertView;
    }

    class ViewHoder {
        private TextView tv_gun, tv_name, tv_namenuber, tv_state, tv_love, tv_nolove, tv_time;
        private ImageView img_gun, image, img_love, img_nolove;
    }
}
