package com.jm.app.mili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jm.app.mili.Bean.DiscoveryBean;
import com.jm.app.mili.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class DiscoveryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DiscoveryBean> list;
    LayoutInflater inflater;

    public DiscoveryAdapter(Context context, ArrayList<DiscoveryBean> list) {
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
        ViewHoder viewHoder;
        viewHoder = new ViewHoder();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_discovery, null);
            viewHoder.Img_name = (ImageView) convertView.findViewById(R.id.Img_name);
            viewHoder.Img_back = (ImageView) convertView.findViewById(R.id.Img_back);
            viewHoder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHoder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        DiscoveryBean bean = list.get(position) ;
        viewHoder.Img_name.setBackgroundResource(bean.getImg_name());
        viewHoder.Img_back.setBackgroundResource(bean.getImg_back());
        viewHoder.tv_name.setText(bean.getTv_name());
        viewHoder.tv_state.setText(bean.getTv_state());
        return convertView;
    }

    class ViewHoder {
        private ImageView Img_name, Img_back;
        private TextView tv_name, tv_state;
    }
}
