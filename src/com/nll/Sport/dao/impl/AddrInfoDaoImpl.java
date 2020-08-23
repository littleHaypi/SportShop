package com.nll.Sport.dao.impl;

import java.util.List;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.IAddrInfoDao;
import com.nll.Sport.entity.AddrInfo;


public class AddrInfoDaoImpl implements IAddrInfoDao{

	@Override
	public List<AddrInfo> finds(String uid) {
		   DBHelper db=new DBHelper();
		   String sql="select aid,uid,name,tel,province,city,area,addr,flag from addrinfo where status!=0 and uid=?";
		   return db.finds(AddrInfo.class, sql, uid);
	}

	@Override
	public int add(AddrInfo ai) {
		DBHelper db=new DBHelper();
		if(ai.getFlag()==1) {
			String sql="update addrinfo set flag=2 where uid=?";
			db.update(sql,ai.getUid());
		}
		String sql="insert into addrinfo values(?,?,?,?,?,?,?,?,?,?)";
     	return db.update(sql,ai.getAid(),ai.getUid(),ai.getName(),ai.getTel(),ai.getProvince(),ai.getCity(),ai.getArea(),ai.getAddr(),ai.getFlag(),ai.getStatus());

	}

	@Override
	public int delete(int uid, String aid) {
		DBHelper db=new DBHelper();
		
			String sql="update addrinfo set status=0 where aid=?";
			return db.update(sql,aid);
		
	}

	@Override
	public int defaultAddr(int uid, String aid) {
		DBHelper db=new DBHelper();
		String sql="update addrinfo set flag=2 where uid=?";
		db.update(sql,uid);
		String sql2="update addrinfo set flag=1 where aid=?";
		return db.update(sql2,aid);
	}

}
