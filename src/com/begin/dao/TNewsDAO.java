package com.begin.dao;

import java.util.Date;
import java.util.List;

import com.begin.bean.TNews;

public interface TNewsDAO extends BaseDAO<TNews, String>{
	
	//按类型 时间 查询TNews
	List<TNews> searchByTNew(String[] catalogs,String fstatusCode,Integer currentPageNO, Integer pageSize,Date beg,Date end);

}
