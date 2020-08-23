package com.nll.Sport.dao;
import java.util.List;
import java.util.Map;

import com.nll.Sport.entity.GoodsInfo;

public interface IGoodsInfoDao {
public List<GoodsInfo> findByPage(int page,int rows);
public int total();
public int total(String tid, String gname);
public List<GoodsInfo> findByCondition(String tid, String gname, int page, int rows);
public int update(GoodsInfo gi);
public int add(String gname,int tid,double price,String intro,int balance,String pics,String unit,String weight,String descr,int status);
public List<GoodsInfo> findIndex();
public GoodsInfo findByGid(String gid);
public List<GoodsInfo> findByTid(int tid, int page, int rows);
public List<GoodsInfo> findByNews(int tid);
public List<GoodsInfo> gprice(int tid, int page, int rows);

public List<GoodsInfo> manUse(int tid, int page, int rows);
public int total(int tid);
public List<GoodsInfo> findByNewstname(String tname);
}
