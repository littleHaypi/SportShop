package com.nll.Sport.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nll.Sport.biz.IUserInfoBiz;
import com.nll.Sport.dao.IUserInfoDao;
import com.nll.Sport.dao.impl.UserInfoDaoImpl;
import com.nll.Sport.entity.UserInfo;
import com.nll.Sport.util.StringUtil;

public class UserInfoBizImpl implements IUserInfoBiz {

	@Override
	public Map<String,Object> findByPage(int page, int rows) {
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total",userInfodao.total() );
		map.put("rows",userInfodao.findByPage(page, rows));
		return map;
	}

	@Override
	public int update(int uid, String email, String uname, String photo, int status) {
		if(StringUtil.checkNull(email)||StringUtil.checkNull(uname)||StringUtil.checkNull(photo)) {
			return 0;
		}
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.update(uid, email, uname, photo, status);
	}

	@Override
	public int addphoto(int uid, String photo) {
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.addphoto(uid, photo);
	}

	@Override
	public UserInfo login(String uname, String pwd) {
		if(StringUtil.checkNull(uname)||StringUtil.checkNull(pwd)) {
			return null;
		}
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.login(uname, pwd);
	}

	@Override
	public Map<String, Object> img(String uname) {
		if(StringUtil.checkNull(uname)) {
			return null;
		}
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.img(uname);
	}

	@Override
	public Map<String, Object> existname(String uname) {
		if(StringUtil.checkNull(uname)) {
			return null;
		}
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.existname(uname);
	}

	@Override
	public Map<String, Object> existemail(String email) {
		if(StringUtil.checkNull(email)) {
			return null;
		}
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.existemail(email);
	}

	@Override
	public int register(String uname, String email, String pwd, String photo) {
		if(StringUtil.checkNull(uname)||StringUtil.checkNull(email)||StringUtil.checkNull(pwd)||StringUtil.checkNull(photo)) {
			return 0;
		}
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.register(uname, email, pwd, photo);
	}

	@Override
	public int repwd(String email, String pwd) {
		if(StringUtil.checkNull(email)||StringUtil.checkNull(pwd)) {
			return 0;
		}
		IUserInfoDao userInfodao=new UserInfoDaoImpl();
		return userInfodao.repwd(email, pwd);
	}


}
