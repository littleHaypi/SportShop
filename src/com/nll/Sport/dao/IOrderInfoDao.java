package com.nll.Sport.dao;

import java.util.List;
import java.util.Map;

public interface IOrderInfoDao {
    public List<Map<String,Object>> findByPage(int page,int rows);
    public int total();
    public int update(String oid,int status);
	public int add(String cids, double totalPrice, String aid,int uid);
	public List<Map<String, String>> finds(int uid, int page, int rows);
	 public int total(int uid);
	public int addcomment(int iid, String ocomment);
	public List<Map<String, Object>>  ocomment(int gid);
	public int send(String oid);
	public int pay(String oid);
}
