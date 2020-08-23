package com.nll.Sport.biz.impl;

import java.util.Collections;
import java.util.List;

import com.nll.Sport.biz.IAddrInfoBiz;
import com.nll.Sport.dao.IAddrInfoDao;
import com.nll.Sport.dao.impl.AddrInfoDaoImpl;
import com.nll.Sport.entity.AddrInfo;
import com.nll.Sport.util.StringUtil;

public class AddrInfoBizImpl implements IAddrInfoBiz{

	@Override
	public List<AddrInfo> finds(String uid) {
		if(StringUtil.checkNull(uid)) {
			return Collections.emptyList();
		}
		IAddrInfoDao addrInfoDao=new AddrInfoDaoImpl();
		return addrInfoDao.finds(uid);
	}

	@Override
	public int add(AddrInfo ai) {
		IAddrInfoDao addrInfoDao=new AddrInfoDaoImpl();
		return addrInfoDao.add(ai);
	}

	@Override
	public int delete(int uid, String aid) {
		IAddrInfoDao addrInfoDao=new AddrInfoDaoImpl();
		return addrInfoDao.delete(uid,aid);
	}

	@Override
	public int defaultAddr(int uid, String aid) {
		IAddrInfoDao addrInfoDao=new AddrInfoDaoImpl();
		return addrInfoDao.defaultAddr(uid,aid);
	}

}
