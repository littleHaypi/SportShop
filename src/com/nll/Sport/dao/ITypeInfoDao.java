package com.nll.Sport.dao;

import java.util.List;

import com.nll.Sport.entity.TypeInfo;


public interface ITypeInfoDao{
  public List<TypeInfo> findsByPage(int page,int rows);
  public int total();
  public int addphoto(int tid,String pic);
  public int add(String tname,String pic);
  public int update(int tid,String tname);
  public List<TypeInfo> findAll();
}
