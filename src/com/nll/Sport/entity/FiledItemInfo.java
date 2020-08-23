package com.nll.Sport.entity;

import java.io.Serializable;

public class FiledItemInfo implements Serializable{
	private static final long serialVersionUID = 7763387271439096525L;
	private Integer fiid;
	private Integer gid;
	private Integer fid;
	private String fname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	private String fvalue;
	public Integer getFiid() {
		return fiid;
	}
	public void setFiid(Integer fiid) {
		this.fiid = fiid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFvalue() {
		return fvalue;
	}
	public void setFvalue(String fvalue) {
		this.fvalue = fvalue;
	}
	@Override
	public String toString() {
		return "FiledItemInfo [fiid=" + fiid + ", gid=" + gid + ", fid=" + fid + ", fname=" + fname + ", fvalue="
				+ fvalue + "]";
	}



}
