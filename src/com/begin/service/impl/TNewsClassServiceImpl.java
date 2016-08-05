package com.begin.service.impl;

import java.util.List;

import com.begin.action.mobile.vo.TNewsClassVO;
import com.begin.bean.TMessagesStudent;
import com.begin.bean.TNewsClass;
import com.begin.dao.TNewsClassDAO;
import com.begin.service.TNewsClassService;

public class TNewsClassServiceImpl extends BaseServiceImpl<TNewsClass, String> implements TNewsClassService{
	
	private TNewsClassDAO tNewsClassDAO;

	public TNewsClassDAO gettNewsClassDAO() {
		return tNewsClassDAO;
	}

	public void settNewsClassDAO(TNewsClassDAO tNewsClassDAO) {
		this.tNewsClassDAO = tNewsClassDAO;
	}

	@Override
	public List<TNewsClass> searyByFname(String fName, String fparentID) {
		// TODO Auto-generated method stub
		return tNewsClassDAO.searyByFname(fName, fparentID);
	}

	@Override
	public List<TNewsClassVO> searyBySubmenu(String fparentID) {
		// TODO Auto-generated method stub
		return tNewsClassDAO.searyBySubmenu(fparentID);
	}
	
	

}
