package com.jm.app.mili.Bean;

/**
 * Created by Administrator on 2016/5/4.
 */
public class RecordBean {
    private int img_phone, img_phoneYSE, img_back;
    private String tv_name, tv_QH, tv_QHnuber, tv_CYZ, tv_CYZname, tv_GCY, tv_GCYname, tv_XY, tv_XYnuber, tv_DH;

    public RecordBean(int img_phone, int img_phoneYSE, int img_back, String tv_name, String tv_qh, String tv_qHnuber, String tv_cyz, String tv_cyZname, String tv_gcy, String tv_gcYname, String tv_xy, String tv_xYnuber, String tv_dh) {
        this.img_phone = img_phone;
        this.img_phoneYSE = img_phoneYSE;
        this.img_back = img_back;
        this.tv_name = tv_name;
        tv_QH = tv_qh;
        tv_QHnuber = tv_qHnuber;
        tv_CYZ = tv_cyz;
        tv_CYZname = tv_cyZname;
        tv_GCY = tv_gcy;
        tv_GCYname = tv_gcYname;
        tv_XY = tv_xy;
        tv_XYnuber = tv_xYnuber;
        tv_DH = tv_dh;
    }

    public int getImg_phone() {
        return img_phone;
    }

    public void setImg_phone(int img_phone) {
        this.img_phone = img_phone;
    }

    public int getImg_phoneYSE() {
        return img_phoneYSE;
    }

    public void setImg_phoneYSE(int img_phoneYSE) {
        this.img_phoneYSE = img_phoneYSE;
    }

    public int getImg_back() {
        return img_back;
    }

    public void setImg_back(int img_back) {
        this.img_back = img_back;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_QH() {
        return tv_QH;
    }

    public void setTv_QH(String tv_QH) {
        this.tv_QH = tv_QH;
    }

    public String getTv_QHnuber() {
        return tv_QHnuber;
    }

    public void setTv_QHnuber(String tv_QHnuber) {
        this.tv_QHnuber = tv_QHnuber;
    }

    public String getTv_CYZ() {
        return tv_CYZ;
    }

    public void setTv_CYZ(String tv_CYZ) {
        this.tv_CYZ = tv_CYZ;
    }

    public String getTv_CYZname() {
        return tv_CYZname;
    }

    public void setTv_CYZname(String tv_CYZname) {
        this.tv_CYZname = tv_CYZname;
    }

    public String getTv_GCY() {
        return tv_GCY;
    }

    public void setTv_GCY(String tv_GCY) {
        this.tv_GCY = tv_GCY;
    }

    public String getTv_GCYname() {
        return tv_GCYname;
    }

    public void setTv_GCYname(String tv_GCYname) {
        this.tv_GCYname = tv_GCYname;
    }

    public String getTv_XY() {
        return tv_XY;
    }

    public void setTv_XY(String tv_XY) {
        this.tv_XY = tv_XY;
    }

    public String getTv_XYnuber() {
        return tv_XYnuber;
    }

    public void setTv_XYnuber(String tv_XYnuber) {
        this.tv_XYnuber = tv_XYnuber;
    }

    public String getTv_DH() {
        return tv_DH;
    }

    public void setTv_DH(String tv_DH) {
        this.tv_DH = tv_DH;
    }
}
