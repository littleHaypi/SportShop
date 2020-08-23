package com.nll.Sport.biz;

import java.util.List;
import java.util.Map;

import com.nll.Sport.entity.FiledInfo;
import com.nll.Sport.entity.TypeInfo;

public interface IFiledInfoBiz {
   public Map<String,Object> findByPage(int page,int rows);

   public int add(FiledInfo filed);

   public List<FiledInfo> findAll();
}
