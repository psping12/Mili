package com.jm.app.mili.Bean;

/**
 * Created by Administrator on 2016/4/29.
 */
public class NormalGoodsInfo {
    private int Img;// 图片
    private String Total_amount;//总需
    private String Remains; //剩余

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getTotal_amount() {
        return Total_amount;
    }

    public void setTotal_amount(String total_amount) {
        Total_amount = total_amount;
    }

    public String getRemains() {
        return Remains;
    }

    public void setRemains(String remains) {
        Remains = remains;
    }
}
