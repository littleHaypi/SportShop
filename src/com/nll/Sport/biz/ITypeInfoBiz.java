package com.nll.Sport.biz;

import java.util.List;
import java.util.Map;

import com.nll.Sport.entity.TypeInfo;

public interface ITypeInfoBiz{
	  public Map<String,Object> findsByPage(int page,int rows);
	  public int addphoto(int tid,String pic);
	  public int add(String tname,String pic);
	  public int update(int tid,String tname);
	  public List<TypeInfo> findAll();
}
