package com.jm.app.mili;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/5/9.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
