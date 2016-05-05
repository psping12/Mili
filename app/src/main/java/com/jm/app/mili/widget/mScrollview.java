package com.jm.app.mili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/5/3.
 */
public class mScrollview extends ScrollView{
    private OnScrollListener onScrollListener;
    public mScrollview(Context context) {
        this(context,null);
    }

    public mScrollview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public mScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 设置滚动接口
     * @param onScrollListener
     */
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(onScrollListener != null){
            onScrollListener.onScroll(t);
//            onScrollListener.onScroll(getContext(),l,t,oldl,oldt);
        }
    }


    /**
     *
     * 滚动的回调接口
     *
     * @author xiaanming
     *
     */
    public interface OnScrollListener{
        /**
         * 回调方法， 返回MyScrollView滑动的Y方向距离
//         * @param scrollY
         * 				、
         */
        public void onScroll(int scrollY);
//        public void onScroll(Context context,int x,int y,int oldx,int oldy);
    }

}
