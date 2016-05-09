package com.jm.app.mili.Bean;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ParticipationBean {
    private String tv_order_name, tv_order_LVName, tv_order_LvNameCost;

    public ParticipationBean(String tv_order_name, String tv_order_lvName, String tv_order_lvNameCost) {
        this.tv_order_name = tv_order_name;
        tv_order_LVName = tv_order_lvName;
        tv_order_LvNameCost = tv_order_lvNameCost;
    }

    public String getTv_order_name() {
        return tv_order_name;
    }

    public void setTv_order_name(String tv_order_name) {
        this.tv_order_name = tv_order_name;
    }

    public String getTv_order_LVName() {
        return tv_order_LVName;
    }

    public void setTv_order_LVName(String tv_order_LVName) {
        this.tv_order_LVName = tv_order_LVName;
    }

    public String getTv_order_LvNameCost() {
        return tv_order_LvNameCost;
    }

    public void setTv_order_LvNameCost(String tv_order_LvNameCost) {
        this.tv_order_LvNameCost = tv_order_LvNameCost;
    }
}
