package com.nll.Sport.dao.impl;

import java.util.List;
import java.util.Map;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.IUserInfoDao;
import com.nll.Sport.entity.UserInfo;


public class UserInfoDaoImpl implements IUserInfoDao{


	@Override
	public List<UserInfo> findByPage(int page, int rows) {
		
		DBHelper db=new DBHelper();
		String sql="select uid,email,pwd,uname,photo,status from userinfo limit ?,?";
		return db.finds(UserInfo.class,sql,(page-1)*rows,rows);
		
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(uid) from userinfo";
		return db.total(sql);
	}

	@Override
	public int update(int uid,String email, String uname, String photo, int status) {
		DBHelper db=new DBHelper();
		String sql="update userinfo set email=?,uname=?,photo=?,status=? where uid=?";
		return db.update(sql, email,uname,photo,status,uid);
	}

	@Override
	public int addphoto(int uid, String photo) {
		DBHelper db=new DBHelper();
		String sql="update userinfo set photo=? where uid=?";
		return db.update(sql,photo,uid);
	}

	@Override
	public UserInfo login(String uname, String pwd) {
		DBHelper db=new DBHelper();
		String sql="select uid,email,pwd,uname,photo,status from userinfo where (uname=? or email=?) and pwd=md5(?)";
		return db.find(UserInfo.class, sql, uname,uname,pwd);
	}

	@Override
	public Map<String,Object> img(String uname) {
		DBHelper db=new DBHelper();
		String sql="select photo from userinfo where (uname=? or email=?)";
		return db.find(sql, uname,uname);
	
	}

	@Override
	public Map<String, Object> existname(String uname) {
		DBHelper db=new DBHelper();
		String sql="select photo from userinfo where uname=?";
		return db.find(sql, uname);
	}

	@Override
	public Map<String, Object> existemail(String email) {
		DBHelper db=new DBHelper();
		String sql="select photo from userinfo where email=?";
		return db.find(sql,email);
	}

	@Override
	public int register(String uname, String email, String pwd, String photo) {
		 DBHelper db=new DBHelper();
		 String sql="insert into userinfo values(0,?,md5(?),?,?,1)"; 
		 return db.update(sql,uname,email,pwd,photo);
	}

	@Override
	public int repwd(String email, String pwd) {
		 DBHelper db=new DBHelper();
		 String sql="update userinfo set pwd=? where email=?"; 
		 return db.update(sql,pwd,email);
	}

}
