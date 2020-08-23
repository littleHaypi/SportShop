package com.nll.Sport.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nll.Sport.biz.ITypeInfoBiz;
import com.nll.Sport.dao.ITypeInfoDao;
import com.nll.Sport.dao.impl.TypeInfoDaoImpl;
import com.nll.Sport.entity.TypeInfo;
import com.nll.Sport.util.StringUtil;

public class TypeInfoBizImpl implements ITypeInfoBiz{

	@Override
	public Map<String,Object> findsByPage(int page, int rows) {
		ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total",typeInfoDao.total());
		map.put("rows",typeInfoDao.findsByPage(page, rows));
		return map;
	}

	@Override
	public int addphoto(int tid, String pic) {
		if(StringUtil.checkNull(pic)) {
			return 0;
		}
		ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
		return typeInfoDao.addphoto(tid, pic);
	}

	@Override
	public int add(String tname, String pic) {
		
	    if(StringUtil.checkNull(tname)||StringUtil.checkNull(pic)) {
	    	return 0;
	    }
	    ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
	    return typeInfoDao.add(tname, pic);
	}

	@Override
	public int update(int tid, String tname) {
	    ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
	    return typeInfoDao.update(tid, tname);
	}

	@Override
	public List<TypeInfo> findAll() {
	    ITypeInfoDao typeInfoDao=new TypeInfoDaoImpl();
	    return typeInfoDao.findAll();
	}

}
