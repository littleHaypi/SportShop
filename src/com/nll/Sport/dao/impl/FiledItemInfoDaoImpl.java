package com.nll.Sport.dao.impl;

import java.util.List;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.IFiledItemInfoDao;
import com.nll.Sport.entity.FiledItemInfo;


public class FiledItemInfoDaoImpl implements IFiledItemInfoDao{

	@Override
	public int add(int gid, int fid, String[] fname) {
		DBHelper db=new DBHelper();
		for (int i = 0; i < fname.length; i++) {
			String sql="insert into fieldItemInfo values(0,?,?,?)";
			db.update(sql, gid,fid,fname[i]);
		}
		return 1;
		
		
	}

	@Override
	public List<FiledItemInfo> info(int gid) {
		DBHelper db=new DBHelper();
		String sql="select fiid,fielditeminfo.gid,fielditeminfo.fid,fname,fvalue from fielditeminfo,fieldinfo where gid=? and fielditeminfo.fid=fieldinfo.fid;";
		return db.finds(FiledItemInfo.class, sql, gid);
	}

}
