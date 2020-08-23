package com.nll.Sport.dao.impl;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.IAdminInfoDao;
import com.nll.Sport.entity.AdminInfo;


public class AdminInfoImpl implements IAdminInfoDao{

	@Override
	public AdminInfo login(String aname, String pwd) {
		DBHelper db=new DBHelper();
		String sql="select aid,aname,pwd,email from admininfo where aname=? and pwd=?";
		return db.find(AdminInfo.class,sql,aname,pwd);
	}

}
