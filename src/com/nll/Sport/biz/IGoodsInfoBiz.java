package com.nll.Sport.biz;

import java.util.List;
import java.util.Map;

import com.nll.Sport.entity.GoodsInfo;

public interface IGoodsInfoBiz {
  public Map<String,Object> findByPage(int page,int rows);

  public Map<String,Object> findByCondition(String tid, String gname, int page, int rows);
  
  public int update(GoodsInfo gi);
  
  public int add(String gname, int tid, double price, String intro, int balance, String pics, String unit,
			String weight, String descr, int status);

   public Map<String,Object>  findIndex();
   
   public GoodsInfo findByGid(String gid);

   public Map<String,Object>findByTid(int tid, int page, int rows);
   public Map<String,Object>findByTids(int tid, int page, int rows);
   public Map<String,Object> findByNews(int tid);

public Map<String,Object> gprice(int tid, int page, int rows);
public Map<String,Object> gprice1(int tid, int page, int rows);
public Map<String,Object> manUse(int tid, int page, int rows);

public Map<String,Object> manUse1(int tid, int page, int rows);

public  Map<String,Object> findByNewstname(String tname);

}
