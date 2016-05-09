package com.jm.app.mili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jm.app.mili.Bean.WinningBean;
import com.jm.app.mili.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/3.
 */
public class WinningAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<WinningBean> list;
    private LayoutInflater inflater;

    public WinningAdapter(Context context, ArrayList<WinningBean> list) {
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

        ViewHodle hodle;
        hodle = new ViewHodle();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_winning, null);
            hodle.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            hodle.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            hodle.tv_issue = (TextView) convertView.findViewById(R.id.tv_issue);
            hodle.tv_issueNuber = (TextView) convertView.findViewById(R.id.tv_issueNuber);
            hodle.tv_participation = (TextView) convertView.findViewById(R.id.tv_participation);
            hodle.tv_participationNuber = (TextView) convertView.findViewById(R.id.tv_participationNuber);
            hodle.tv_prize_winner = (TextView) convertView.findViewById(R.id.tv_prize_winner);
            hodle.tv_prize_winnerName = (TextView) convertView.findViewById(R.id.tv_prize_winnerName);
            hodle.tv_in_all = (TextView) convertView.findViewById(R.id.tv_in_all);
            hodle.tv_in_allNuber = (TextView) convertView.findViewById(R.id.tv_in_allNuber);
            hodle.tv_lucky_number = (TextView) convertView.findViewById(R.id.tv_lucky_number);
            hodle.tv_lucky_numberName = (TextView) convertView.findViewById(R.id.tv_lucky_numberName);
            hodle.tv_details = (TextView) convertView.findViewById(R.id.tv_details);
            convertView.setTag(hodle);
        } else {

            hodle = (ViewHodle) convertView.getTag();
        }
        WinningBean bean = list.get(position);
        hodle.imageView.setBackgroundResource(bean.getImageview());
        hodle.tv_name.setText(bean.getTv_name());
        hodle.tv_details.setText(bean.getTv_details());
        hodle.tv_in_all.setText(bean.getTv_in_all());
        hodle.tv_in_allNuber.setText(bean.getTv_in_allNuber());
        hodle.tv_issue.setText(bean.getTv_issue());
        hodle.tv_issueNuber.setText(bean.getTv_lucky_number());
        hodle.tv_lucky_number.setText(bean.getTv_lucky_number());
        hodle.tv_participationNuber.setText(bean.getTv_participationNuber());
        hodle.tv_participation.setText(bean.getTv_participation());
        hodle.tv_prize_winner.setText(bean.getTv_prize_winner());
        hodle.tv_prize_winnerName.setText(bean.getTv_prize_winnerName());
        hodle.tv_lucky_numberName.setText(bean.getTv_prize_winnerName());
        return convertView;
    }

    class ViewHodle {
        private ImageView imageView;
        private TextView tv_name, tv_issue, tv_issueNuber, tv_participation, tv_participationNuber, tv_prize_winner, tv_prize_winnerName, tv_in_all, tv_in_allNuber, tv_lucky_number, tv_lucky_numberName, tv_details;
    }
}
