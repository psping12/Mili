package com.jm.app.mili.adapter;

/**
 * Created by Administrator on 2016/5/9.
 */
public class OrderBaskBean {
    private String tv_gun, tv_name, tv_namenuber, tv_state, tv_love, tv_nolove, tv_time;
    private int img_gun, image, img_love, img_nolove;

    public OrderBaskBean(String tv_gun, String tv_name, String tv_namenuber, String tv_state, String tv_love, String tv_nolove, String tv_time, int img_gun, int image, int img_love, int img_nolove) {
        this.tv_gun = tv_gun;
        this.tv_name = tv_name;
        this.tv_namenuber = tv_namenuber;
        this.tv_state = tv_state;
        this.tv_love = tv_love;
        this.tv_nolove = tv_nolove;
        this.tv_time = tv_time;
        this.img_gun = img_gun;
        this.image = image;
        this.img_love = img_love;
        this.img_nolove = img_nolove;
    }

    public String getTv_gun() {
        return tv_gun;
    }

    public void setTv_gun(String tv_gun) {
        this.tv_gun = tv_gun;
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

    public String getTv_time() {
        return tv_time;
    }

    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }

    public int getImg_gun() {
        return img_gun;
    }

    public void setImg_gun(int img_gun) {
        this.img_gun = img_gun;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImg_love() {
        return img_love;
    }

    public void setImg_love(int img_love) {
        this.img_love = img_love;
    }

    public int getImg_nolove() {
        return img_nolove;
    }

    public void setImg_nolove(int img_nolove) {
        this.img_nolove = img_nolove;
    }
}
