package com.jm.app.mili.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jm.app.mili.R;
import com.jm.app.mili.activities.PersonalCenterActivity;
import com.jm.app.mili.widget.XCRoundImageView;

/**
 * Created by Administrator on 2016/5/3.
 */
public class FragmentPerson extends Fragment implements View.OnClickListener {
    private Button tv_yes, tv_snatch, tv_backOrder,recharge,signin;
    private XCRoundImageView  head;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_wode, null);
        tv_yes = (Button) view.findViewById(R.id.tv_yes);
        tv_snatch = (Button) view.findViewById(R.id.tv_snatch);
        tv_backOrder = (Button) view.findViewById(R.id.tv_backOrder);
        head= (XCRoundImageView) view.findViewById(R.id.frag_person_head);
        signin= (Button) view.findViewById(R.id.frag_person_signin);
        recharge= (Button) view.findViewById(R.id.frag_person_recharge);


        tv_yes.setOnClickListener(this);
        tv_snatch.setOnClickListener(this);
        tv_backOrder.setOnClickListener(this);
        head.setOnClickListener(this);
        signin.setOnClickListener(this);
        recharge.setOnClickListener(this);



        isShow();
        return view;
    }

    @Override
    public void onClick(View v) {
        // 获取Framgment管理器，开启管理
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tt = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.tv_yes:
                FramentRecord fragmentFriend = new FramentRecord();
                tt.replace(R.id.fragment_persion, fragmentFriend);
                tt.commit();
                break;
            case R.id.tv_snatch:
                FramentWinning framentWinning = new FramentWinning();
                tt.replace(R.id.fragment_persion, framentWinning);
                tt.commit();
                break;
            case R.id.tv_backOrder:
                FragementBaskOrder fragementBaskOrder = new FragementBaskOrder();
                tt.replace(R.id.fragment_persion, fragementBaskOrder);
                tt.commit();
                break;
                //头像
            case R.id.frag_person_head:
                startActivity(new Intent(getContext(), PersonalCenterActivity.class));
                break;
                //签到
            case R.id.frag_person_signin:
                Toast.makeText(getContext(), "签到", Toast.LENGTH_SHORT).show();
                break;
                //头像
            case R.id.frag_person_recharge:
                Toast.makeText(getContext(), "充值", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    public void isShow() {
        FragmentManager ft = getFragmentManager();
        FragmentTransaction tt = ft.beginTransaction();

        FramentRecord fragmentFriend = new FramentRecord();
        tt.replace(R.id.fragment_persion, fragmentFriend);
        tt.commit();
    }
}
