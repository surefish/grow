package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TMessages;
import com.begin.bean.TMessagesStudent;
import com.begin.dao.TMessagesStudentDAO;
import com.begin.service.TMessagesStudentService;
import com.begin.util.page.ListInfo;




public class TMessagesStudentServiceImpl extends BaseServiceImpl<TMessagesStudent, String> implements
TMessagesStudentService{

	private TMessagesStudentDAO tMessagesStudentDAO;


	public TMessagesStudentDAO gettMessagesStudentDAO() {
		return tMessagesStudentDAO;
	}


	public void settMessagesStudentDAO(TMessagesStudentDAO tMessagesStudentDAO) {
		this.tMessagesStudentDAO = tMessagesStudentDAO;
	}


	@Override
	public ListInfo<TMessagesStudent> searchBycatalog(String catalog, String fstatusCode,
			Integer currentPageNO, Integer pageSize) {
		ListInfo<TMessagesStudent> listInfo = new ListInfo<TMessagesStudent>(currentPageNO,pageSize);
		Map<String, Object> equalMap=new HashMap<String, Object>();
		Map<String,String> likeMap = new HashMap<String,String>();
		
		List<TMessagesStudent> entityList=tMessagesStudentDAO.findByMap(equalMap, likeMap,null,null, 
				listInfo.getFirst(),listInfo.getMax());
		listInfo.setCurrentList(entityList);
		listInfo.setSizeOfTotalList(tMessagesStudentDAO.countByMap(equalMap,likeMap,null));
		
		return listInfo;
	
	}
	
	
	@Override
	public List<TMessagesStudent> searchByStuFuid(String studentFuid,String messageId) {
		Map<String, Object> equalMap=new HashMap<String, Object>();
		//equalMap.put("fstatusCode", TMessages.NORMAL_STATUS);
		equalMap.put("fstudentID",studentFuid);
		equalMap.put("fMessageID",messageId);
		List<TMessagesStudent> entityList=tMessagesStudentDAO.findByMap1(equalMap);
		return entityList;
	}
	
	
}
