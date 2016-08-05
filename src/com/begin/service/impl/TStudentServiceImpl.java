package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.action.mobile.vo.TcongfigVO;
import com.begin.bean.QTopic;
import com.begin.bean.SysUser;
import com.begin.bean.TAccount;
import com.begin.bean.TStudent;
import com.begin.dao.TStudentDAO;
import com.begin.service.TStudentService;
import com.begin.util.MD5Util;
import com.begin.util.page.ListInfo;

public class TStudentServiceImpl extends BaseServiceImpl<TStudent, String> implements
		TStudentService {
    private TStudentDAO tStudentDAO;

	public TStudentDAO gettStudentDAO() {
		return tStudentDAO;
	}

	public void settStudentDAO(TStudentDAO tStudentDAO) {
		this.tStudentDAO = tStudentDAO;
	}

	@Override
	public ListInfo<TStudent> searchByTStudent(String fname, String fno,
			String fparentname, String fparentphone, String fstatus,
			int currentPageNO, int pageSize) {
		ListInfo<TStudent> listInfo = new ListInfo<TStudent>(currentPageNO,
				pageSize);
		
		listInfo.setCurrentList(tStudentDAO.findQtopicByTStudent(fname, fno, fparentname, fparentphone, fstatus, listInfo.getFirst(), listInfo.getMax()));
		listInfo.setSizeOfTotalList(tStudentDAO.countQtopicByTStudent(fname, fno, fparentname, fparentphone, fstatus));
		
		return listInfo;
	}

	@Override
	public TStudent validateUser(String fno, String fpw, String statusCode) {
		Map<String, Object> equalMap = new HashMap<String, Object>();
		equalMap.put("fno", fno);
		equalMap.put("fpw",fpw);
		equalMap.put("fstatusCode", TStudent.NORMAL_STATUS);
		List<TStudent> list=tStudentDAO.findByMap(equalMap);
		
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public TStudent validaRegister(String fno, String name, String statusCode) {
		Map<String, Object> equalMap = new HashMap<String, Object>();
		if(null!=fno){
			equalMap.put("fno", fno);
		}
		if(null!=name){
			equalMap.put("fname",name);
		}
		equalMap.put("fstatusCode", TStudent.NORMAL_STATUS);
		List<TStudent> list=tStudentDAO.findByMap(equalMap);
		
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public TStudent validafbarcode(String fbarcode, String statusCode) {
		Map<String, Object> equalMap = new HashMap<String, Object>();
		equalMap.put("fbarcode", fbarcode);
		equalMap.put("fstatusCode", TStudent.NORMAL_STATUS);
		List<TStudent> list=tStudentDAO.findByMap(equalMap);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public TcongfigVO scVersion() {
		// TODO Auto-generated method stub
		return tStudentDAO.scVersion();
	}
    
    
    
	
}
