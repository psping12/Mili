package com.jm.app.mili.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jm.app.mili.R;

import org.xutils.x;

/**
 * Created by Administrator on 2016/5/6.
 */
public class BaseActivity extends AppCompatActivity {
    private NetworkInfo netInfo;
    private ConnectivityManager mConnectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initNetWork();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void initNetWork() {

        // 动态组成广播
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, mFilter);
    }


    BroadcastReceiver receiver =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action =intent.getAction();
            if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                mConnectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                netInfo = mConnectivityManager.getActiveNetworkInfo();
                if(netInfo != null && netInfo.isAvailable()) {
                    /////////////网络连接
                    String name = netInfo.getTypeName();

                    if(netInfo.getType()==ConnectivityManager.TYPE_WIFI){
                        /////WiFi网络

                    }else if(netInfo.getType()==ConnectivityManager.TYPE_ETHERNET){
                        /////有线网络

                    }else if(netInfo.getType()==ConnectivityManager.TYPE_MOBILE){
                        /////////3g网络

                    }
                } else {
                    ////////网络断开
                    Toast.makeText(BaseActivity.this, "网络链接异常，请检查网络", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

}
