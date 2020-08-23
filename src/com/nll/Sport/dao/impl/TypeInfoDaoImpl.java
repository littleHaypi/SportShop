package com.nll.Sport.dao.impl;

import java.util.List;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.ITypeInfoDao;
import com.nll.Sport.entity.TypeInfo;

public class TypeInfoDaoImpl implements ITypeInfoDao{

	@Override
	public List<TypeInfo> findsByPage(int page, int rows) {
		 DBHelper db=new DBHelper();
		 String sql="select tid,tname,pic from goodstype limit ?,?"; 
		return db.finds(TypeInfo.class, sql, (page-1)*rows,rows);
	}

	@Override
	public int total() {
		 DBHelper db=new DBHelper();
		 String sql="select count(tid) from goodstype"; 
		 return db.total(sql);
	}

	@Override
	public int addphoto(int tid, String pic) {
		 DBHelper db=new DBHelper();
		 String sql="update goodstype set pic=? where tid=?"; 
		return db.update(sql, pic,tid);
	}

	@Override
	public int add(String tname, String pic) {
		 DBHelper db=new DBHelper();
		 String sql="insert into goodstype values(0,?,?)"; 
		return db.update(sql, tname,pic);
	}

	@Override
	public int update(int tid, String tname) {
		DBHelper db=new DBHelper();
		String sql="update goodstype set tname=? where tid=?";
		return db.update(sql,tname,tid);
	}

	@Override
	public List<TypeInfo> findAll() {
		DBHelper db=new DBHelper();
		String sql="select tid,tname,pic from goodstype";
		return db.finds(TypeInfo.class, sql);
	}
	

}
