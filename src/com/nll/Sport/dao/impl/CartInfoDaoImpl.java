package com.nll.Sport.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.ICartInfoDao;
import com.nll.Sport.entity.CartInfo;

public class CartInfoDaoImpl implements ICartInfoDao{

	@Override
	public List<Map<String, Object>> findCart(String uid) {
	     DBHelper db=new DBHelper();
	     String sql="select cid,gid,num,filed from cartinfo where uid=?";
		return db.finds(sql,uid);
	}

	@Override
	public int updateNum(String cid, int num) {
	    DBHelper db=new DBHelper();
	     String sql="update cartinfo set num=num+? where cid=?";
		return db.update(sql, num,cid);
	}

	@Override
	public int add(CartInfo cf) {
		DBHelper db=new DBHelper();
		String sql="insert into cartinfo values(?,?,?,?,?)";
		
		return db.update(sql, cf.getCid(),cf.getUid(),cf.getGid(),cf.getNum(),cf.getFiled());
	}

	@Override
	public List<CartInfo> finds(String uid) {
	    DBHelper db=new DBHelper();
	     String sql="select cid,c.gid,num,price,filed,pics,gname,unit,weight from cartinfo c,goodsinfo g where c.gid=g.gid and uid=?";
		return db.finds(CartInfo.class, sql,uid);
	}

	@Override
	public List<CartInfo> findByCids(String[] cids) {
		DBHelper db=new DBHelper();
		String sql="select cid,c.gid,num,price,pics,gname,unit,weight,filed from cartinfo c,goodsinfo g where c.gid=g.gid and cid in(";
		List<Object> params=new ArrayList<Object>();
		for(String cid: cids) {
			sql+="?,";
			params.add(cid);
		}
		sql=sql.substring(0, sql.lastIndexOf(","))+")";
		return db.finds(CartInfo.class,sql,params);
	}

}
