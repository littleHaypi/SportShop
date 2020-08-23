package com.nll.Sport.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nll.Sport.biz.IGoodsInfoBiz;
import com.nll.Sport.dao.IGoodsInfoDao;
import com.nll.Sport.dao.ITypeInfoDao;
import com.nll.Sport.dao.impl.GoodsInfoDaoImpl;
import com.nll.Sport.dao.impl.TypeInfoDaoImpl;
import com.nll.Sport.entity.GoodsInfo;
import com.nll.Sport.util.StringUtil;


public class GoodsInfoBizImpl implements IGoodsInfoBiz{

	@Override
	public Map<String, Object> findByPage(int page,int rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		IGoodsInfoDao goodInfoDao=new GoodsInfoDaoImpl();
		map.put("total",goodInfoDao.total());
		map.put("rows", goodInfoDao.findByPage(page, rows));
		return map;
		
	}

	@Override
	public Map<String, Object> findByCondition(String tid, String gname, int page, int rows) {
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		
		 map.put("total", goodsInfoDao.total(tid,gname));
		 map.put("rows",goodsInfoDao.findByCondition(tid,gname,page,rows));
		 return map;
	}

	@Override
	public int update(GoodsInfo gi) {
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 return goodsInfoDao.update(gi);
	}

	@Override
	public int add(String gname, int tid, double price, String intro, int balance, String pics, String unit,
			String weight, String descr, int status) {
		if(StringUtil.checkNull(gname)||StringUtil.checkNull(intro)||StringUtil.checkNull(pics)||StringUtil.checkNull(unit)||StringUtil.checkNull(weight)||StringUtil.checkNull(descr)) {
			return 600;
		}
		IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		return goodsInfoDao.add(gname, tid, price, intro, balance, pics, unit, weight, descr, status);
	}

	@Override
	public Map<String, Object> findIndex() {
		 ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 map.put("types", typeInfoDao.findAll());
		 map.put("goods",goodsInfoDao.findIndex());
		return map;
	}

	@Override
	public GoodsInfo findByGid(String gid) {
	    IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
	    return goodsInfoDao.findByGid(gid);
	}

	@Override
	public Map<String, Object> findByTid(int tid,int page, int rows) {
		 ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 map.put("types", typeInfoDao.findAll());
		 map.put("goods",goodsInfoDao.findByTid(tid,page,rows));
		return map;
	}
	
	public Map<String, Object> findByTids(int tid,int page, int rows) {
		 ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 map.put("types", typeInfoDao.findAll());
		 map.put("goods",goodsInfoDao.findByTid(tid,page,rows));
		 map.put("total",goodsInfoDao.total(tid));
		return map;
	}

	@Override
	public Map<String,Object> findByNews(int tid) {
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		
		 map.put("news",goodsInfoDao.findByNews(tid));
		 return map;
	}

	@Override
	public Map<String, Object> gprice(int tid,int page, int rows) {
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		 map.put("total",goodsInfoDao.total(tid));
		 map.put("goods",goodsInfoDao.gprice(tid,page,rows));
		 return map;
	}
	@Override
	public Map<String, Object> gprice1(int tid,int page, int rows) {
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		 map.put("goods",goodsInfoDao.gprice(tid,page,rows));
		 return map;
	}
	@Override
	public Map<String, Object> manUse(int tid,int page, int rows) {
		// TODO Auto-generated method stub
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		 map.put("total",goodsInfoDao.total(tid));
		 map.put("goods",goodsInfoDao.manUse(tid,page,rows));
		 System.out.println(map);
		 return map;
	}
	public Map<String, Object> manUse1(int tid,int page, int rows) {
		// TODO Auto-generated method stub
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();	 
		 map.put("goods",goodsInfoDao.manUse(tid,page,rows));
		 System.out.println(map);
		 return map;
	}

	@Override
	public Map<String, Object> findByNewstname(String tname) {
		 IGoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		 Map<String,Object> map=new HashMap<String, Object>();
		
		 map.put("news",goodsInfoDao.findByNewstname(tname));
		 return map;
	}

}
