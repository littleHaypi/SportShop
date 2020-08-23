package com.nll.Sport.dao.impl;

import java.util.List;
import java.util.Map;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.ICountDao;

public class CountDaoImpl implements ICountDao{

	@Override
	public List<Map<String, Object>> month(int year,int month) {
	  DBHelper db=new DBHelper();
	  String sql="SELECT sum(price) price,day(odate) odate FROM orderinfo WHERE month(odate)=? and  year(odate)=? and status>0 GROUP BY day(odate) order by odate asc";
	  return db.finds(sql,month,year);
	}
	@Override
	public List<Map<String, Object>> year(int year) {
	  DBHelper db=new DBHelper();
	  String sql="SELECT sum(price) price,month(odate) odate FROM orderinfo WHERE year(odate)=? and status>0 GROUP BY month(odate) order by odate asc";
	  return db.finds(sql,year);
	}
	@Override
	public List<Map<String, Object>> quarter(int year) {
		  DBHelper db=new DBHelper();
		  String sql="SELECT sum(price) price,quarter(odate) odate FROM orderinfo WHERE year(odate) =? and status>0 GROUP BY quarter(odate) order by odate asc";
		  return db.finds(sql,year);
	}
	@Override
	public List<Map<String, Object>> yearyear() {
		  DBHelper db=new DBHelper();
		  String sql="SELECT sum(price) price,year(odate) odate FROM orderinfo where status>0 GROUP BY year(odate) order by odate asc";
		  return db.finds(sql);
	}
	@Override
	public List<Map<String, Object>> typepie() {
		  DBHelper db=new DBHelper();
		  String sql="SELECT sum(o.price) value,(tname) name FROM orderiteminfo o,goodsinfo g,goodstype t where g.tid=t.tid and o.gid=g.gid GROUP BY t.tname;";
		  return db.finds(sql);
	}

}
