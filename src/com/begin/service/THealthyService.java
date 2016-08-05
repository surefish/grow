package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.THealthy;



public interface THealthyService extends BaseService<THealthy, String>{

	/**
	 * 根据 学生主键
	 * 查询学生健康
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	THealthy seachbyTHealthyFuid(String fuid);
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<THealthy>  seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize);
	
}
