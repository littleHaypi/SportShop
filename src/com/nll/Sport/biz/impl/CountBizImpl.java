package com.nll.Sport.biz.impl;

import java.util.List;
import java.util.Map;

import com.nll.Sport.biz.ICountBiz;
import com.nll.Sport.dao.ICountDao;
import com.nll.Sport.dao.impl.CountDaoImpl;

public class CountBizImpl implements ICountBiz {


	@Override
	public List<Map<String, Object>> month(int year,int month) {
		// TODO Auto-generated method stub
		 ICountDao countDao=new CountDaoImpl();
		 return countDao.month(year,month);
	}

	@Override
	public List<Map<String, Object>> year(int year) {
		 ICountDao countDao=new CountDaoImpl();
		 return countDao.year(year);
	}

	@Override
	public List<Map<String, Object>> quarter(int year) {
		// TODO Auto-generated method stub
		 ICountDao countDao=new CountDaoImpl();
		 return countDao.quarter(year);
	}

	@Override
	public List<Map<String, Object>> yearyear() {
		// TODO Auto-generated method stub
		 ICountDao countDao=new CountDaoImpl();
		 return countDao.yearyear();
	}

	@Override
	public List<Map<String, Object>> typepie() {
		// TODO Auto-generated method stub
		 ICountDao countDao=new CountDaoImpl();
		 return countDao.typepie();
	}

}
