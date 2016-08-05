package com.begin.dao;

import java.util.List;

import com.begin.bean.THealthy;



public interface THealthyDAO extends BaseDAO<THealthy, String>{
	
	/**
	 * 根据 学生主键
	 * 查询学生健康
	 * @return
	 */
	THealthy findbyTHealthyFuid(String fuid);
	
	List<THealthy>  seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize);
}
