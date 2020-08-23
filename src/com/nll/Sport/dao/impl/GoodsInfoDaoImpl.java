package com.nll.Sport.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.IGoodsInfoDao;
import com.nll.Sport.entity.GoodsInfo;
import com.nll.Sport.util.StringUtil;


public class GoodsInfoDaoImpl implements IGoodsInfoDao{

	@Override
	public List<GoodsInfo> findByPage(int page, int rows) {
	DBHelper db=new DBHelper();
	String sql="select gid,g.tid,tname,gname,price,balance,concat(weight,'/',unit) weight,intro,descr,status from goodsinfo g, goodstype t where g.tid=t.tid order by gid desc limit ?,?";
	return db.finds(GoodsInfo.class, sql, (page-1)*rows,rows);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(gid) from goodsinfo";
		return db.total(sql);
	}
	public int total(int tid) {
		DBHelper db=new DBHelper();
		String sql="select count(gid) from goodsinfo where tid=?";
		return db.total(sql,tid);
	}
	@Override
	public int total(String tid, String gname) {
		DBHelper db=new DBHelper();
		String sql="select count(gno) from goodsinfo where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(!StringUtil.checkNull(tid)) {
			sql+=" and tno=?";
			params.add(tid);
		}
		if(!StringUtil.checkNull(gname)) {
			sql+=" and gname like concat('%',?,'%')";
			params.add(gname);
		}
		return db.total(sql, params);
		
	}

	@Override
	public List<GoodsInfo> findByCondition(String tid, String gname, int page, int rows) {
		
		DBHelper db=new DBHelper();
		String sql="select gid,g.tid,tname,gname,price,balance,concat(weight,'/',unit) weight,intro,descr,status from goodsinfo g, goodstype t where g.tid=t.tid";
		List<Object> params=new ArrayList<Object>();
		if(!StringUtil.checkNull(tid)) {
			sql+=" and g.tid=?";
			params.add(tid);
		}
		if(!StringUtil.checkNull(gname)) {
			sql+=" and gname like concat('%',?,'%')";
			params.add(gname);
		}
		sql+=" order by gid desc limit ?,?";
		params.add((page-1)*rows);
		params.add(rows);
		return db.finds(GoodsInfo.class, sql, params);
	}

	@Override
	public int update(GoodsInfo gi) {
		DBHelper db=new DBHelper();
	    String sql="update goodsinfo set gname=?,tid=?,price=?,intro=?,balance=?,unit=?,weight=?,status=? where gid=?";
	    return db.update(sql, gi.getGname(),gi.getTid(),gi.getPrice(),gi.getIntro(),gi.getBalance(),gi.getUnit(),gi.getWeight(),gi.getStatus(),gi.getGid());
	}

	@Override
	public int add(String gname, int tid, double price, String intro, int balance, String pics, String unit,
			String weight, String descr, int status) {
		DBHelper db=new DBHelper();
		String sql="insert into goodsinfo values(0,?,?,?,?,?,?,?,?,?,0,?)";
		return db.update(sql,gname,tid,price,intro,balance,pics,unit,weight,descr,status);
	}

	@Override
	public List<GoodsInfo> findIndex() {
		DBHelper db=new DBHelper();
		String sql="select gid,gname,price,tid,pics from goodsinfo g1 where 4>(select count(gid) from goodsinfo g2 where g1.tid=g2.tid and g1.gid<g2.gid) order by g1.tid asc, g1.gid desc";
		return db.finds(GoodsInfo.class, sql);
		
	}

	@Override
	public GoodsInfo findByGid(String gid) {
		DBHelper db=new DBHelper();
		String sql="select gid,gname,price,intro,balance,pics,unit,weight,descr from goodsinfo where gid=?";
		return db.find(GoodsInfo.class, sql, gid);
	}

	@Override
	public List<GoodsInfo> findByTid(int tid,int page, int rows) {
		DBHelper db=new DBHelper();
		String sql="select gid,gname,price,tid,pics,concat(weight,'/',unit) weight,salenum from goodsinfo g1 where tid=? order by g1.tid asc, g1.gid desc limit ?,?";
		return db.finds(GoodsInfo.class, sql,tid,(page-1)*rows,rows);
	}

	@Override
	public List<GoodsInfo> findByNews(int tid) {
		DBHelper db=new DBHelper();
		String sql="select gid,gname,price,tid,pics,salenum from goodsinfo g1 where g1.tid=? order by gid desc limit 2";
		return db.finds(GoodsInfo.class, sql,tid);
	}

	@Override
	public List<GoodsInfo> gprice(int tid,int page, int rows) {
		DBHelper db=new DBHelper();
		String sql="select gid,gname,price,tid,pics,salenum from goodsinfo g1 where g1.tid=? order by price desc limit ?,?";
		return db.finds(GoodsInfo.class, sql,tid,(page-1)*rows,rows);
	}

	@Override
	public List<GoodsInfo> manUse(int tid,int page, int rows) {
		DBHelper db=new DBHelper();
		String sql="select gid,gname,price,tid,pics,salenum from goodsinfo g1 where g1.tid=? order by salenum desc limit ?,?";
		return db.finds(GoodsInfo.class, sql,tid,(page-1)*rows,rows);

	}

	@Override
	public List<GoodsInfo> findByNewstname(String tname) {
		
		DBHelper db=new DBHelper();
		String sql="select gid,gname,price,tid,pics from goodsinfo g1 where g1.tid=(select tid from goodstype where tname=?) order by gid desc limit 2";
		return db.finds(GoodsInfo.class, sql,tname);
	}

}
