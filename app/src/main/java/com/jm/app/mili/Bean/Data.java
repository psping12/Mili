package com.jm.app.mili.Bean;

import java.util.List;
public class Data {
private List<Yunbuy> yunbuy ;

private List<Gg> gg ;

private List<Banner> banner ;

public void setYunbuy(List<Yunbuy> yunbuy){
this.yunbuy = yunbuy;
}
public List<Yunbuy> getYunbuy(){
return this.yunbuy;
}
public void setGg(List<Gg> gg){
this.gg = gg;
}
public List<Gg> getGg(){
return this.gg;
}
public void setBanner(List<Banner> banner){
this.banner = banner;
}
public List<Banner> getBanner(){
return this.banner;
}

}