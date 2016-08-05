package com.begin.dao;

import java.util.Date;
import java.util.List;

import com.begin.bean.THeight;
import com.begin.bean.TWeight;



public interface TWeightDAO extends BaseDAO<TWeight, String>{
	
	   //查询这个学生最新体重
		List<TWeight> findByStFuid(String fuid,Date beg, Date end);
		//查询学生最近7次体重
		List<TWeight>  seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize);

}
