package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TBook;
import com.begin.dao.TBookDAO;
import com.begin.service.TBookService;
import com.begin.util.page.ListInfo;

public class TBookServiceImpl extends BaseServiceImpl<TBook, String> implements TBookService{
	
	private TBookDAO tBookDAO;

	public TBookDAO gettBookDAO() {
		return tBookDAO;
	}

	public void settBookDAO(TBookDAO tBookDAO) {
		this.tBookDAO = tBookDAO;
	}

	@Override
	public ListInfo<TBook> searchByTBook(String fBookStorefuid,
			String fBookTypefuid, int currentPage, int pageSize) {
		
		  ListInfo<TBook> listInfo = new ListInfo<TBook>(currentPage,pageSize);
			//Map<String,String> likeMap = new HashMap<String,String>();
			Map<String,Object> equalMap=new HashMap<String,Object>();
			if(fBookStorefuid!=""&&null!=fBookStorefuid){
			equalMap.put("fBookStorefuid", fBookStorefuid);
			}
			if(fBookTypefuid!=""&&null!=fBookTypefuid){
				equalMap.put("fBookTypefuid", fBookTypefuid);
			}
			equalMap.put("fstatusCode", TBook.NORMAL_STATUS);
			List<TBook> entityList=tBookDAO.findByMap(equalMap, null,null,null, listInfo.getFirst(),listInfo.getMax());
			
			listInfo.setCurrentList(entityList);
			listInfo.setSizeOfTotalList(tBookDAO.countByMap(equalMap, null, null));
			return listInfo;
	}
	
	

}
