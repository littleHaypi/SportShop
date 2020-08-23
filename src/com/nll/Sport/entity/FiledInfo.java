package com.nll.Sport.entity;

import java.io.Serializable;

public class FiledInfo implements Serializable{
private static final long serialVersionUID = -1000765228644639963L;
private Integer fid;
private String fname;
public Integer getFid() {
	return fid;
}
public void setFid(Integer fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
@Override
public String toString() {
	return "FiledInfo [fid=" + fid + ", fname=" + fname + "]";
}



}
