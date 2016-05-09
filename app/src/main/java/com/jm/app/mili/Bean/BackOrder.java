package com.jm.app.mili.Bean;

/**
 * Created by Administrator on 2016/5/3.
 */
public class BackOrder {
    private String tvtime, tv_name, tv_namenuber, tv_state, tv_love, tv_nolove;
    private int image;

    public BackOrder(String tvtime, String tv_name, String tv_namenuber, String tv_state, String tv_love, String tv_nolove, int image) {
        this.tvtime = tvtime;
        this.tv_name = tv_name;
        this.tv_namenuber = tv_namenuber;
        this.tv_state = tv_state;
        this.tv_love = tv_love;
        this.tv_nolove = tv_nolove;
        this.image = image;
    }

    public String getTvtime() {
        return tvtime;
    }

    public void setTvtime(String tvtime) {
        this.tvtime = tvtime;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_namenuber() {
        return tv_namenuber;
    }

    public void setTv_namenuber(String tv_namenuber) {
        this.tv_namenuber = tv_namenuber;
    }

    public String getTv_state() {
        return tv_state;
    }

    public void setTv_state(String tv_state) {
        this.tv_state = tv_state;
    }

    public String getTv_love() {
        return tv_love;
    }

    public void setTv_love(String tv_love) {
        this.tv_love = tv_love;
    }

    public String getTv_nolove() {
        return tv_nolove;
    }

    public void setTv_nolove(String tv_nolove) {
        this.tv_nolove = tv_nolove;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
