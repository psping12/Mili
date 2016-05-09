package com.jm.app.mili.Bean;

/**
 * Created by Administrator on 2016/5/3.
 */
public class DiscoveryBean {
    private int Img_name,Img_back;
    private String tv_name,tv_state;

    public DiscoveryBean(int img_name, int img_back, String tv_name, String tv_state) {
        Img_name = img_name;
        Img_back = img_back;
        this.tv_name = tv_name;
        this.tv_state = tv_state;
    }

    public int getImg_back() {
        return Img_back;
    }

    public void setImg_back(int img_back) {
        Img_back = img_back;
    }

    public int getImg_name() {
        return Img_name;
    }

    public void setImg_name(int img_name) {
        Img_name = img_name;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_state() {
        return tv_state;
    }

    public void setTv_state(String tv_state) {
        this.tv_state = tv_state;
    }
}
