package com.begin.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.THealthy;
import com.begin.bean.THeight;



public interface THeightService extends BaseService<THeight, String>{
	
	   //查询这个学生最新身高
	    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
		List<THeight> findByStFuid(String fuid,Date beg, Date end);
	    //查询这个学生最近7次身高
	    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
		List<THeight>  seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize);
	
}
