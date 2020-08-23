package com.nll.Sport.dao;

import java.util.List;

import com.nll.Sport.entity.FiledItemInfo;

public interface IFiledItemInfoDao {
 public int add(int gid,int fid,String[] fname);
 public List<FiledItemInfo> info(int gid);
}
