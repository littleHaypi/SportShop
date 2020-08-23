package com.nll.Sport.dao;

import java.util.List;

import com.nll.Sport.entity.FiledInfo;

public interface IFiledInfoDao {
   public List<FiledInfo> findByPage(int page,int rows);
   public int total();
   public int add(FiledInfo filed);
   public List<FiledInfo> findAll();
}
