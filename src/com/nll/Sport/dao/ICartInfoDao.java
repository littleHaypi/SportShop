package com.nll.Sport.dao;

import java.util.List;
import java.util.Map;

import com.nll.Sport.entity.CartInfo;

public interface ICartInfoDao {
	 public List<Map<String, Object>> findCart(String uid);

	public int updateNum(String cid, int num);

	public int add(CartInfo cf);
	
	public List<CartInfo> finds(String uid);

	public List<CartInfo> findByCids(String[] cids);
}
