package com.nll.Sport.biz;

import java.util.List;
import java.util.Map;

public interface IOrderInfoBiz {
	public Map<String,Object> findByPage(int page,int rows);
	public int update(String oid, int status);
	public int add(String cids, double totalPrice, String aid,int uid);
	public List<Map<String, String>> finds(Integer uid, int page, int rows);
	public int total(int uid);
	public int addcomment(int iid, String ocomment);
	public List<Map<String,Object>> ocomment(int gid);
	public int send(String oid);
	public int pay(String oid);
}
