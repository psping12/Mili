package com.jm.app.mili.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/4/19.
 */
public class SharedPreferencesUtil {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPreferencesUtil(Context context, String file){
        sharedPreferences=context.getSharedPreferences(file,Context.MODE_PRIVATE);
        editor =sharedPreferences.edit();
    }

    /**
     * 是否首次启动程序
     * @return
     */
    public boolean isFirstRun(){
       boolean isFirstRun=  sharedPreferences.getBoolean("isFirstRun",true);
        if (!isFirstRun){
            return  false;
        }else {
            editor.putBoolean("isFirstRun",false).commit();
            return  true;
        }
    }


}
