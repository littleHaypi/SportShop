package com.nll.Sport.entity;

import java.io.Serializable;

public class TypeInfo implements Serializable{

	private static final long serialVersionUID = 9161689012051559175L;
	private Integer tid;
	private String tname;
	private String pic;
	private Integer status;
	@Override
	public String toString() {
		return "TypeInfo [tid=" + tid + ", tname=" + tname + ", pic=" + pic + ", status=" + status + "]";
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	

}
