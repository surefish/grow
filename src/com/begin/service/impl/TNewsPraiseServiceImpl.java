package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TMessages;
import com.begin.bean.TNewsClass;
import com.begin.bean.TNewsPraise;
import com.begin.dao.TNewsPraiseDAO;
import com.begin.service.TNewsClassService;
import com.begin.service.TNewsPraiseService;
import com.begin.util.page.ListInfo;

public class TNewsPraiseServiceImpl extends BaseServiceImpl<TNewsPraise, String> implements TNewsPraiseService{
	
	private TNewsPraiseDAO tNewsPraiseDAO;

	public TNewsPraiseDAO gettNewsPraiseDAO() {
		return tNewsPraiseDAO;
	}

	public void settNewsPraiseDAO(TNewsPraiseDAO tNewsPraiseDAO) {
		this.tNewsPraiseDAO = tNewsPraiseDAO;
	}

	@Override
	public ListInfo<TNewsPraise> searchBystfuid(String fstudentFuid, String fTNewsFuid,int beg,int end) {
		
		ListInfo<TNewsPraise> listInfo = new ListInfo<TNewsPraise>(beg,end);
		Map<String, Object> equalMap=new HashMap<String, Object>();
		Map<String,String> likeMap = new HashMap<String,String>();
		
		equalMap.put("fstatusCode", TMessages.NORMAL_STATUS);
		
		equalMap.put("fstudentFuid",fstudentFuid);
		equalMap.put("fTNewsFuid",fTNewsFuid);
		
		List<TNewsPraise> entityList=tNewsPraiseDAO.findByMap(equalMap, likeMap,null,null, 
				listInfo.getFirst(),listInfo.getMax());
		listInfo.setCurrentList(entityList);
		listInfo.setSizeOfTotalList(tNewsPraiseDAO.countByMap(equalMap,likeMap,null));
		
		return listInfo;
	}
	
	

}
