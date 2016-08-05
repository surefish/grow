package com.begin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TNews;
import com.begin.dao.TNewsDAO;
import com.begin.service.TNewsService;
import com.begin.util.page.ListInfo;




public class TNewsServiceImpl extends BaseServiceImpl<TNews, String> implements
TNewsService{

	private TNewsDAO tNewsDAO;

	public TNewsDAO gettNewsDAO() {
		return tNewsDAO;
	}

	public void settNewsDAO(TNewsDAO tNewsDAO) {
		this.tNewsDAO = tNewsDAO;
	}

	@Override
	public ListInfo<TNews> searchBycatalog(String[] catalogs, String fstatusCode,
			Integer currentPageNO, Integer pageSize) {
		ListInfo<TNews> listInfo = new ListInfo<TNews>(currentPageNO,pageSize);
		Map<String, Object> equalMap=new HashMap<String, Object>();
		
		Map<String, Object[]> inMap = new HashMap<String, Object[]>();
		if(null!=catalogs){
			inMap.put("fcatalog", catalogs);
		}
		equalMap.put("fstatusCode", TNews.NORMAL_STATUS);
		//equalMap.put("fcatalog",catalog.toString());
		
		List<TNews> entityList=tNewsDAO.findByMap(equalMap, null,inMap,null, 
				listInfo.getFirst(),listInfo.getMax());
		listInfo.setCurrentList(entityList);
		listInfo.setSizeOfTotalList(tNewsDAO.countByMap(equalMap,null,inMap));
		
		return listInfo;
	
	}

	@Override
	public List<TNews> searchByTNew(String[] catalogs, String fstatusCode,
			Integer currentPageNO, Integer pageSize, Date beg, Date end) {
		// TODO Auto-generated method stub
		return tNewsDAO.searchByTNew(catalogs, fstatusCode, currentPageNO, pageSize, beg, end);
	}
	
	
	
	
	
}
