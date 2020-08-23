package com.nll.Sport.biz.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.nll.Sport.biz.ICartInfoBiz;
import com.nll.Sport.dao.ICartInfoDao;
import com.nll.Sport.dao.impl.CartInfoDaoImpl;
import com.nll.Sport.entity.CartInfo;
import com.nll.Sport.util.StringUtil;

public class CartInfoBizImpl implements ICartInfoBiz{

	@Override
	public List<Map<String, Object>> findCart(String uid) {
      if(StringUtil.checkNull(uid)) {
    	  return null;
      }
      ICartInfoDao cartInfoDao=new CartInfoDaoImpl();
	return cartInfoDao.findCart(uid);
	}

	@Override
	public int updateNum(String cid, int num) {
	    if(StringUtil.checkNull(cid)) {
	    	return -1;
	    }
		ICartInfoDao cartInfoDao=new CartInfoDaoImpl();
	    return cartInfoDao.updateNum(cid, num);
	}

	@Override
	public int add(CartInfo cf) {
		
	    if(StringUtil.checkNull(cf.getCid())) {
	    	return -1;
	    }
	    ICartInfoDao cartInfoDao=new CartInfoDaoImpl();
	    return cartInfoDao.add(cf);
	}

	@Override
	public List<CartInfo> finds(String uid) {
	    if(StringUtil.checkNull(uid)) {
	    	return Collections.emptyList();
	    }
	    ICartInfoDao cartInfoDao=new CartInfoDaoImpl();
	    return cartInfoDao.finds(uid);
	}

	@Override
	public List<CartInfo> findByCids(String cids) {
		 if(StringUtil.checkNull(cids)) {
			 return Collections.emptyList();
		 }
		 ICartInfoDao cartInfoDao=new CartInfoDaoImpl();
		 String[] temp=cids.split(",");
		 return cartInfoDao.findByCids(temp);
		
	}


}
