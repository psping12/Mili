package com.jm.app.mili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jm.app.mili.Bean.RecordBean;
import com.jm.app.mili.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/4.
 */
public class RecordAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<RecordBean> list;
    private LayoutInflater inflater;

    public RecordAdapter(Context context, ArrayList<RecordBean> list) {
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
        ViewHodler hodler;
        hodler = new ViewHodler();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_record, null);
            hodler.img_phone = (ImageView) convertView.findViewById(R.id.img_phone);
            hodler.img_phoneYSE = (ImageView) convertView.findViewById(R.id.img_phoneYSE);
            hodler.img_back = (ImageView) convertView.findViewById(R.id.img_back);
            hodler.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            hodler.tv_QH = (TextView) convertView.findViewById(R.id.tv_QH);
            hodler.tv_QHnuber = (TextView) convertView.findViewById(R.id.tv_QHnuber);
            hodler.tv_CYZ = (TextView) convertView.findViewById(R.id.tv_CYZ);
            hodler.tv_CYZname = (TextView) convertView.findViewById(R.id.tv_CYZname);
            hodler.tv_GCY = (TextView) convertView.findViewById(R.id.tv_GCY);
            hodler.tv_GCYname = (TextView) convertView.findViewById(R.id.tv_GCYname);
            hodler.tv_XY = (TextView) convertView.findViewById(R.id.tv_XY);
            hodler.tv_XYnuber = (TextView) convertView.findViewById(R.id.tv_XYnuber);
            hodler.tv_DH = (TextView) convertView.findViewById(R.id.tv_DH);
            convertView.setTag(hodler);
        } else {
            hodler = (ViewHodler) convertView.getTag();
        }
        RecordBean bean = list.get(position);
        hodler.img_phone.setBackgroundResource(bean.getImg_phone());
        hodler.img_phoneYSE.setBackgroundResource(bean.getImg_phoneYSE());
        hodler.img_back.setBackgroundResource(bean.getImg_back());
        hodler.tv_name.setText(bean.getTv_name());
        hodler.tv_QH.setText(bean.getTv_QH());
        hodler.tv_QHnuber.setText(bean.getTv_QHnuber());
        hodler.tv_CYZ.setText(bean.getTv_CYZ());
        hodler.tv_CYZname.setText(bean.getTv_CYZname());
        hodler.tv_GCY.setText(bean.getTv_GCY());
        hodler.tv_GCYname.setText(bean.getTv_GCYname());
        hodler.tv_XY.setText(bean.getTv_XY());
        hodler.tv_XYnuber.setText(bean.getTv_XYnuber());
        hodler.tv_DH.setText(bean.getTv_DH());
        return convertView;
    }

    class ViewHodler {
        private ImageView img_phone, img_phoneYSE, img_back;
        private TextView tv_name, tv_QH, tv_QHnuber, tv_CYZ, tv_CYZname, tv_GCY, tv_GCYname, tv_XY, tv_XYnuber, tv_DH;
    }
}
