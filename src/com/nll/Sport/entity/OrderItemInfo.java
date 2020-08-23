package com.nll.Sport.entity;

import java.io.Serializable;

public class OrderItemInfo implements Serializable{
	private static final long serialVersionUID = 1389536322695491885L;
    private Integer iid;
    private Integer oid;
    private Integer gid;
    private Integer nums;
    private double price;
    private Integer status;
    private String comment;
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "OrderItemInfo [iid=" + iid + ", oid=" + oid + ", gid=" + gid + ", nums=" + nums + ", price=" + price
				+ ", status=" + status + ", comment=" + comment + "]";
	}
    
    
}
