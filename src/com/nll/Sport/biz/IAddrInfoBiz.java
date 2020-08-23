package com.nll.Sport.biz;

import java.util.List;

import com.nll.Sport.entity.AddrInfo;

public interface IAddrInfoBiz {

public	List<AddrInfo> finds(String uid);

public int add(AddrInfo ai);

public int delete(int uid, String aid);

public int defaultAddr(int uid, String aid);

}
