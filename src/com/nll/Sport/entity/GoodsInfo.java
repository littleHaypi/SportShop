package com.nll.Sport.entity;

import java.io.Serializable;

import com.nll.Sport.util.StringUtil;


public class GoodsInfo implements Serializable{
private static final long serialVersionUID = -1766406860712450331L;
private Integer gid;
private String gname;
private Integer tid;
private double price;
private String intro;
private Integer balance;
private String pics;
private String pic;

private String unit;
private String weight;
private String descr;
private Integer status;
private String tname;
private Integer salenum;

public Integer getSalenum() {
	return salenum;
}
public void setSalenum(Integer salenum) {
	this.salenum = salenum;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public Integer getGid() {
	return gid;
}
public void setGid(Integer gid) {
	this.gid = gid;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public Integer getTid() {
	return tid;
}
public void setTid(Integer tid) {
	this.tid = tid;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public Integer getBalance() {
	return balance;
}
public void setBalance(Integer balance) {
	this.balance = balance;
}
public String getPics() {
	return pics;
}
public void setPics(String pics) {
	this.pics = pics;
	setPic(pics);
}
public String getPic() {
	return pic;
	
}
public void setPic(String pic) {
    if(!StringUtil.checkNull(pics)) {
   	 this.pic=pics.split(",")[0];
   	 return;
    }
    this.pic=pics;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getDescr() {
	return descr;
}
public void setDescr(String descr) {
	this.descr = descr;
}
//上架下架
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
@Override
public String toString() {
	return "GoodsInfo [gid=" + gid + ", gname=" + gname + ", tid=" + tid + ", price=" + price + ", intro=" + intro
			+ ", balance=" + balance + ", pics=" + pics + ", unit=" + unit + ", weight=" + weight + ", descr=" + descr
			+ ", status=" + status + ", tname=" + tname + "]";
}



}
