package com.nll.Sport.entity;

import java.io.Serializable;

public class OrderInfo implements Serializable{
	private static final long serialVersionUID = 8850958984455892979L;
    private Integer oid;
    private String odate;
    private Integer uid;
    private Integer aid;
    private String sdate;
    private String rdate;
    private Integer status;
    private double price;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderInfo [oid=" + oid + ", odate=" + odate + ", uid=" + uid + ", aid=" + aid + ", sdate=" + sdate
				+ ", rdate=" + rdate + ", status=" + status + ", price=" + price + "]";
	}
    
    
}
