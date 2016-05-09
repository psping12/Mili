package com.jm.app.mili.Utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jm.app.mili.MainActivity;
import com.jm.app.mili.R;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ToolbarManager {
    private ImageView imgLeft,imgRight;
    private RelativeLayout centerlayout;
    private TextView centerTxt;

    private Activity aty;

    public ToolbarManager(View view, Activity activity) {
        super();
        this.aty=activity;
        imgLeft= (ImageView) view.findViewById(R.id.normal_toolbar_leftimg);
        imgRight= (ImageView) view.findViewById(R.id.normal_toolbar_rightimg);
        centerlayout= (RelativeLayout) view.findViewById(R.id.normal_toolbar_centerlayout);
        centerTxt= (TextView) view.findViewById(R.id.normal_toolbar_titletxt);
        setDefultFunction();
    }

    private void setDefultFunction() {
        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aty.finish();
            }
        });

        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(aty, MainActivity.class);
                aty.startActivity(in);
                aty.finish();
            }
        });


    }

    //设置左边

    /**
     *
     * @param ImageResource 图片背景
     * @param isVisible      是否可见
     * @param intentActivity 点击后要跳转的界面
     */
    public void setImgLeft(int ImageResource, boolean isVisible, final Class intentActivity){
        if (ImageResource!=0)
        this.imgLeft.setImageResource(ImageResource);

        if (!isVisible)
            this.imgLeft.setVisibility(View.INVISIBLE);

        if (intentActivity!=null)
            imgLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aty.startActivity(new Intent(aty,intentActivity));
                }
            });
    }


    /**
     *
     * @param ImageResource 图片背景
     * @param isVisible      是否可见
     * @param intentActivity 点击后要跳转的界面
     */
    public void setImgRight(int ImageResource, boolean isVisible, final Class intentActivity){
        if (ImageResource!=0)
            this.imgRight.setImageResource(ImageResource);

        if (!isVisible)
            this.imgRight.setVisibility(View.INVISIBLE);

        if (intentActivity!=null)
            imgRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aty.startActivity(new Intent(aty,intentActivity));
                }
            });
    }




    //设置中间文字
    public void setTitleTxt(boolean isVisible, String text){
        if (!isVisible)
        this.centerTxt.setVisibility(View.INVISIBLE);

        if (text!=null)
        this.centerTxt.setText(text);
    }


}
