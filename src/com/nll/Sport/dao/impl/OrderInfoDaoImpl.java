package com.nll.Sport.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.nll.Sport.dao.DBHelper;
import com.nll.Sport.dao.IOrderInfoDao;

public  class OrderInfoDaoImpl implements IOrderInfoDao{

	@Override
	public List<Map<String, Object>> findByPage(int page,int rows) {
		DBHelper db=new DBHelper();
		String sql="select oid,date_format(odate,'%Y-%m-%d %H:%i:%s') odate,concat(province,'/',city,'/',area,'/',addr)addr,o.price,rdate,sdate,o.status from orderinfo o,addrinfo a where a.aid=o.aid  order by odate desc limit ?,?";
		return db.finds(sql, (page-1)*rows,rows);
	}

	@Override
	public int total() {
		DBHelper db=new DBHelper();
		String sql="select count(oid) from orderinfo";
		return db.total(sql);
	}
	public int total(int uid) {
		DBHelper db=new DBHelper();
		String sql="select count(oid) from orderinfo where uid=?";
		return db.total(sql,uid);
	}

	@Override
	public int update(String oid, int status) {
		DBHelper db=new DBHelper();
		String sql="update orderinfo set status=? where oid=?";
		return db.update(sql,status,oid);
	}

	public int add(String cids, double totalPrice, String aid,int uid) {
	     //添加一条数据到订单表中，订单编号 总价
			String oid=UUID.randomUUID().toString().replace("-","");
			String sql="insert into orderinfo values(?,now(),?,?,null,null,2,?)";
			List<Object> param1=new ArrayList<Object>();
			param1.add(oid);
			param1.add(uid);
			param1.add(aid);
			param1.add(totalPrice);
			
			//添加多条记录到订单详细表 non,gno,nums,price
			String sql2="insert into orderiteminfo select 0,?,c.gid,c.num,price,null,c.filed,1,null from cartinfo c,goodsinfo g where c.gid=g.gid and cid in(";
			List<Object> param2=new ArrayList<Object>();
			param2.add(oid);
			String[] temp=cids.split(",");
			for (String cid:temp) {
				sql2+="?, ";
				param2.add(cid);
			}
			sql2=sql2.substring(0, sql2.lastIndexOf(","))+")";
			
			List<String> sqls=new ArrayList<String>();
			List<List<Object>> params=new ArrayList<List<Object>>();
			
			sqls.add(sql);
			params.add(param1);
			
			sqls.add(sql2);
			params.add(param2);
			
			//修改商品的库存 gno nums
			String sql3=null;
			List<Object> param=null;
			for(String cid:temp) {
				param=new ArrayList<Object>();
				sql3="update goodsinfo set balance=balance-(select num from cartinfo where cid=?) where gid=(select gid from cartinfo where cid=?)";
			    param.add(cid);
			    param.add(cid);
			    
			    sqls.add(sql3);
			    params.add(param);
			}
			
			//修改商品的销量 gid salenum
			String sql5=null;
			List<Object> param5=null;
			for(String cid:temp) {
				param5=new ArrayList<Object>();
				sql3="update goodsinfo set salenum=salenum+(select num from cartinfo where cid=?) where gid=(select gid from cartinfo where cid=?)";
			    param5.add(cid);
			    param5.add(cid);
			    
			    sqls.add(sql3);
			    params.add(param5);
			}
			
			//删除购物车表
			String sql4="delete from cartinfo where cid in(";
			List<Object> param4=new ArrayList<Object>();
			for(String cid:temp) {
				sql4+="?,";
				param4.add(cid);
			}
			
			sql4=sql4.substring(0,sql4.lastIndexOf(","))+")";
			sqls.add(sql4);
			params.add(param4);
			
			DBHelper db=new DBHelper();
			return db.updates(sqls, params);
	}

	@Override
	public List<Map<String, String>> finds(int uid,int page,int rows) {
	     DBHelper db=new DBHelper();
	        String sql="select o.oid,date_format(odate,'%Y-%m-%d %H:%i:%s') odate,o.price totalPrice,o.status,i.gid,i.iid,i.ocomment,nums,i.price,i.filed,gname,pics,weight,unit from orderinfo o,goodsinfo g,orderiteminfo i,addrinfo a where o.oid=i.oid and i.gid=g.gid and a.aid=o.aid and a.uid=? order by odate desc limit ?,?";
			return db.gets(sql, uid, (page-1)*rows,rows);
	}

	@Override
	public int addcomment(int iid, String ocomment) {
	     DBHelper db=new DBHelper();
	        String sql="update orderiteminfo set ocomment=? where iid=?";
			return db.update(sql,ocomment,iid);
	}

	@Override
	public List<Map<String, Object>> ocomment(int gid) {
		 DBHelper db=new DBHelper();
		 String sql="select ocomment from orderiteminfo where gid=?";
		 return db.finds(sql, gid);
	}

	@Override
	public int send(String oid) {
	     DBHelper db=new DBHelper();
	        String sql="update orderinfo set status=4 where oid=?";
			return db.update(sql,oid);
	}

	@Override
	public int pay(String oid) {
	     DBHelper db=new DBHelper();
	        String sql="update orderinfo set status=2 where oid=?";
			return db.update(sql,oid);
	}
   
}
