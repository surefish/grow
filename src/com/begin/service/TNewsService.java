package com.begin.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TNews;
import com.begin.util.page.ListInfo;



public interface TNewsService extends BaseService<TNews, String>{
	
	/**
	 * 按fcatalog分类查询
	 * @param catalog 分类
	 * @param currentPageNO 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	ListInfo<TNews> searchBycatalog(String[] catalogs,String fstatusCode,
			Integer currentPageNO, Integer pageSize);	
	
	
	//按类型 时间 查询TNews
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<TNews> searchByTNew(String[] catalogs,String fstatusCode,Integer currentPageNO, Integer pageSize,Date beg,Date end);

}
