package com.begin.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.THeight;
import com.begin.bean.TWeight;



public interface TWeightService extends BaseService<TWeight, String>{
	
	 //查询这个学生最新体重
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<TWeight> findByStFuid(String fuid,Date beg, Date end);

	
	
	 //查询这个学生最近7次体重
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<TWeight>  seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize);
}
