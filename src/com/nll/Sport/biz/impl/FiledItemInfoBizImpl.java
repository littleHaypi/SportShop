package com.nll.Sport.biz.impl;

import java.util.List;

import com.nll.Sport.biz.IFiledItemInfoBiz;
import com.nll.Sport.dao.IFiledItemInfoDao;
import com.nll.Sport.dao.impl.FiledItemInfoDaoImpl;
import com.nll.Sport.entity.FiledItemInfo;

public class FiledItemInfoBizImpl implements IFiledItemInfoBiz{

	@Override
	public int add(int gid, int fid, String[] fname) {
	  IFiledItemInfoDao filedItemInfoDao=new FiledItemInfoDaoImpl();
	  return filedItemInfoDao.add(gid, fid, fname);
	}

	@Override
	public List<FiledItemInfo> info(int gid) {
		  IFiledItemInfoDao filedItemInfoDao=new FiledItemInfoDaoImpl();
		  return filedItemInfoDao.info(gid);
	}

}
