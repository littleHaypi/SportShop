package com.nll.Sport.entity;

public class AdminInfo {
private Integer aid;
private String aname;
private String pwd;
private String email;
public Integer getAid() {
	return aid;
}
public void setAid(Integer aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "AdminInfo [aid=" + aid + ", aname=" + aname + ", pwd=" + pwd + ", email=" + email + "]";
}

}
