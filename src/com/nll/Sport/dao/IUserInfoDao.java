package com.nll.Sport.dao;

import java.util.List;
import java.util.Map;

import com.nll.Sport.entity.UserInfo;

public interface IUserInfoDao{
  public List<UserInfo> findByPage(int page,int rows);
  public int total();
  public int update(int uid,String email,String uname,String photo,int status);
  public int addphoto(int uid, String photo);
  public  UserInfo login(String uname,String pwd);
  public  Map<String,Object> img(String uname);
  public  Map<String,Object> existname(String uname);
  public  Map<String,Object> existemail(String email);
  public int register(String uname,String email,String pwd,String photo);
public int repwd(String email, String pwd);
  
}
