package com.nll.Sport.biz.impl;

import com.nll.Sport.biz.IAdminInfoBiz;
import com.nll.Sport.dao.IAdminInfoDao;
import com.nll.Sport.dao.impl.AdminInfoImpl;
import com.nll.Sport.entity.AdminInfo;
import com.nll.Sport.util.StringUtil;

public class AdminInfoBizImpl implements IAdminInfoBiz{

	@Override
	public AdminInfo login(String aname, String pwd) {
		if(StringUtil.checkNull(aname)||StringUtil.checkNull(pwd)) {
			return null;
		}else {
			IAdminInfoDao adminInfoDao=new AdminInfoImpl();
			return adminInfoDao.login(aname, pwd);
		}
		
	}

}
