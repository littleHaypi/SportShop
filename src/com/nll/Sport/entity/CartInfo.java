package com.nll.Sport.entity;

import java.io.Serializable;

import com.nll.Sport.util.StringUtil;

public class CartInfo implements Serializable{
	private static final long serialVersionUID = -4400689913311153336L;
    private String cid;
    private Integer uid;
    private Integer gid;
    private Integer num;
    private String filed;
    
    private String gname;
    private double price;
    private String pics;
    private String unit;
    private String weight;
    private String pic;
	@Override
	public String toString() {
		return "CartInfo [cid=" + cid + ", uid=" + uid + ", gid=" + gid + ", num=" + num + ", filed=" + filed
				+ ", gname=" + gname + ", price=" + price + ", pics=" + pics + ", unit=" + unit + ", weight=" + weight
				+ ", pic=" + pic + "]";
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getFiled() {
		return filed;
	}
	public void setFiled(String filed) {
		this.filed = filed;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
		setPic(pics);
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
    

    
}
