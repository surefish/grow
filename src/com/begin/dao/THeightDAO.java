package com.begin.dao;

import java.util.Date;
import java.util.List;

import com.begin.bean.THealthy;
import com.begin.bean.THeight;



public interface THeightDAO  extends BaseDAO<THeight, String>{
	
	//查询这个学生最新身高
	List<THeight> findByStFuid(String fuid,Date beg, Date end);
	//查询这个学生最近7次身高
	List<THeight>  seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize);

}
