package com.nll.Sport.biz;

import java.util.List;

import com.nll.Sport.entity.FiledItemInfo;

public interface IFiledItemInfoBiz {
	 public int add(int gid,int fid,String[] fname);
	 public List<FiledItemInfo> info(int gid);
}
