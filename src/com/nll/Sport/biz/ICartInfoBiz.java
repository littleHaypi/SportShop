package com.nll.Sport.biz;

import java.util.List;
import java.util.Map;

import com.nll.Sport.entity.CartInfo;

public interface ICartInfoBiz {
	public List<Map<String, Object>> findCart(String uid);

	public int updateNum(String cid, int num);

	public int add(CartInfo cf);

	public List<CartInfo> finds(String valueOf);

	public List<CartInfo> findByCids(String cids);
	
	
}
