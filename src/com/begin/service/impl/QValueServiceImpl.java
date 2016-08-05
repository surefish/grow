package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.QValue;
import com.begin.bean.SysUser;
import com.begin.bean.TNews;
import com.begin.dao.QValueDAO;
import com.begin.service.QValueService;
import com.begin.util.page.ListInfo;



public class QValueServiceImpl extends BaseServiceImpl<QValue, String> implements QValueService{
	
	private QValueDAO qValueDAO;

	public QValueDAO getqValueDAO() {
		return qValueDAO;
	}

	public void setqValueDAO(QValueDAO qValueDAO) {
		this.qValueDAO = qValueDAO;
	}

	@Override
	public ListInfo<QValue> searchByQValue(String fstudentuid,
			String fsurveyuid, String ftopicuid, String fitemuid,
			int currentPage, int pageSize) {
		ListInfo<QValue> listInfo = new ListInfo<QValue>(currentPage,pageSize);
		Map<String, Object> equalMap=new HashMap<String, Object>();
		Map<String,String> likeMap = new HashMap<String,String>();
		if(null!=fstudentuid&&!"".equals(fstudentuid)){
			equalMap.put("fstudentuid",fstudentuid);
		}
		if(null!=fsurveyuid&&!"".equals(fsurveyuid)){
			equalMap.put("fsurveyuid",fsurveyuid);
		}
		if(null!=ftopicuid&&!"".equals(ftopicuid)){
			equalMap.put("ftopicuid",ftopicuid);
		}
		if(null!=fitemuid&&!"".equals(fitemuid)){
			equalMap.put("fitemuid",fitemuid);
		}
		equalMap.put("fstatusCode", TNews.NORMAL_STATUS);
		
		List<QValue> entityList=qValueDAO.findByMap(equalMap, likeMap,null,null, 
				listInfo.getFirst(),listInfo.getMax());
		listInfo.setCurrentList(entityList);
		listInfo.setSizeOfTotalList(qValueDAO.countByMap(equalMap,likeMap,null));
		
		return listInfo;
	}
	
	

}
