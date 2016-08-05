package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TMessages;
import com.begin.dao.TMessagesDAO;
import com.begin.service.TMessagesService;
import com.begin.util.page.ListInfo;




public class TMessagesServiceImpl extends BaseServiceImpl<TMessages, String> implements
TMessagesService{

	private TMessagesDAO tMessagesDAO;

	public TMessagesDAO gettMessagesDAO() {
		return tMessagesDAO;
	}

	public void settMessagesDAO(TMessagesDAO tMessagesDAO) {
		this.tMessagesDAO = tMessagesDAO;
	}

	@Override
	public ListInfo<TMessages> searchBycatalog(String catalog, String fstatusCode,
			Integer currentPageNO, Integer pageSize) {
		ListInfo<TMessages> listInfo = new ListInfo<TMessages>(currentPageNO,pageSize);
		Map<String, Object> equalMap=new HashMap<String, Object>();
		Map<String,String> likeMap = new HashMap<String,String>();
		
		equalMap.put("fstatusCode", TMessages.NORMAL_STATUS);
		equalMap.put("fcatalog",catalog.toString());
		
		List<TMessages> entityList=tMessagesDAO.findByMap(equalMap, likeMap,null,null, 
				listInfo.getFirst(),listInfo.getMax());
		listInfo.setCurrentList(entityList);
		listInfo.setSizeOfTotalList(tMessagesDAO.countByMap(equalMap,likeMap,null));
		
		return listInfo;
	
	}

	@Override
	public List<Object[]> gettopMessages(String studentID,String fcaalog) {
		// TODO Auto-generated method stub
		return tMessagesDAO.gettopMessages(studentID,fcaalog);
	}

	@Override
	public List<Object[]> gettopMessagesAll(String studentID, String fcaalog) {
		// TODO Auto-generated method stub
		return tMessagesDAO.gettopMessagesAll(studentID, fcaalog);
	}

	
	
}
