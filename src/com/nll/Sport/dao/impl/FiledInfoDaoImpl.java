package com.nll.Sport.dao.impl;

import java.util.List;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.IFiledInfoDao;
import com.nll.Sport.entity.FiledInfo;
import com.nll.Sport.entity.GoodsInfo;

public class FiledInfoDaoImpl implements IFiledInfoDao{

	@Override
	public List<FiledInfo> findByPage(int page, int rows) {
		DBHelper db=new DBHelper();
		String sql="select fid,fname from fieldinfo limit ?,?";
		return db.finds(FiledInfo.class, sql, (page-1)*rows,rows);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(fid) from fieldinfo";
		return db.total(sql);
		
	}

	@Override
	public int add(FiledInfo filed) {
		DBHelper db=new DBHelper();
		String sql="insert into fieldinfo values(0,?)";
		return db.update(sql,filed.getFname());
	}

	@Override
	public List<FiledInfo> findAll() {
		DBHelper db=new DBHelper();
		String sql="select fid,fname from fieldinfo";
		return db.finds(FiledInfo.class, sql);
	}

}
