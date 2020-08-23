package com.nll.Sport.entity;

import java.io.Serializable;

public class AddrInfo implements Serializable{

   private static final long serialVersionUID = -954718307475150107L;
   private String aid;
   private Integer uid;//用户id
   private String name;//收货人
   private String tel;//联系电话
   private String province;//省
   private String city;//市
   private String area;//区（县）
   private String addr;
   private Integer flag;
   private String status;//1正常 0删除
public String getAid() {
	return aid;
}
public void setAid(String aid) {
	this.aid = aid;
}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public Integer getFlag() {
	return flag;
}
public void setFlag(Integer flag) {
	this.flag = flag;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "AddrInfo [aid=" + aid + ", uid=" + uid + ", name=" + name + ", tel=" + tel + ", province=" + province
			+ ", city=" + city + ", area=" + area + ", addr=" + addr + ", flag=" + flag + ", status=" + status + "]";
}

}
