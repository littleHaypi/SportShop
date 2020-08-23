package com.nll.Sport.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nll.Sport.biz.IOrderInfoBiz;
import com.nll.Sport.dao.IOrderInfoDao;
import com.nll.Sport.dao.impl.OrderInfoDaoImpl;
import com.nll.Sport.util.StringUtil;


public class OrderInfoBizImpl implements IOrderInfoBiz {

	@Override
	public Map<String, Object> findByPage(int page, int rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		map.put("total", orderInfoDao.total());
		map.put("rows", orderInfoDao.findByPage(page, rows));
		return map;
	}

	@Override
	public int update(String oid, int status) {
		IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		return orderInfoDao.update(oid, status);
	}

	@Override
	public int add(String cids, double totalPrice, String aid,int uid) {
		 if(StringUtil.checkNull(cids)) {
			 return -1;	 
		 }
		 IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		 return orderInfoDao.add(cids, totalPrice,aid,uid);
	}

	@Override
	public List<Map<String, String>> finds(Integer uid,int page,int rows) {
		 IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		 return orderInfoDao.finds(uid,page,rows);
	}

	@Override
	public int total(int uid) {
		 IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		 return orderInfoDao.total(uid);
	}

	@Override
	public int addcomment(int iid, String ocomment) {
		 IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		 return orderInfoDao.addcomment(iid,ocomment);
	}

	@Override
	public List<Map<String, Object>> ocomment(int gid) {
		 IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		 return orderInfoDao.ocomment(gid);
	}

	@Override
	public int send(String oid) {
		 IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		 return orderInfoDao.send(oid);
	}

	@Override
	public int pay(String oid) {
		 IOrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
		 return orderInfoDao.pay(oid);
	}

}
