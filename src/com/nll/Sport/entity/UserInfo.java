package com.nll.Sport.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
 
	private static final long serialVersionUID = 8109993616391935238L;
    private Integer uid;
    private String email;
    private String pwd;
    private String uname;
    private String photo;
    private Integer status;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", email=" + email + ", pwd=" + pwd + ", uname=" + uname + ", photo=" + photo
				+ ", status=" + status + "]";
	}
	
   
}
