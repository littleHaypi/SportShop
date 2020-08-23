package com.nll.Sport.biz;

import java.util.List;
import java.util.Map;

public interface ICountBiz {
	public List<Map<String, Object>> month(int year,int month);
	public List<Map<String,Object>> year(int year);
	public List<Map<String,Object>> quarter(int year);
	public List<Map<String,Object>> yearyear();
	public List<Map<String,Object>> typepie();
}
