package com.nll.Sport.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nll.Sport.biz.IFiledInfoBiz;
import com.nll.Sport.dao.IFiledInfoDao;
import com.nll.Sport.dao.impl.FiledInfoDaoImpl;
import com.nll.Sport.entity.FiledInfo;
import com.nll.Sport.util.StringUtil;


public class FiledInfoBizImpl implements IFiledInfoBiz{

	@Override
	public Map<String, Object> findByPage(int page, int rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		IFiledInfoDao filedInfoDao=new FiledInfoDaoImpl();
		map.put("total",filedInfoDao.total());
		map.put("rows", filedInfoDao.findByPage(page, rows));
		return map;
		
	}

	@Override
	public int add(FiledInfo filed) {
		if(StringUtil.checkNull(filed.getFname())) {
			return 0;
		}
		IFiledInfoDao filedInfoDao=new FiledInfoDaoImpl();
		return filedInfoDao.add(filed);
	}

	@Override
	public List<FiledInfo> findAll() {
		IFiledInfoDao filedInfoDao=new FiledInfoDaoImpl();
		return filedInfoDao.findAll();
	}

}
