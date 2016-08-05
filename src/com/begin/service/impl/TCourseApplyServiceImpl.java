package com.begin.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.begin.bean.TCourseApply;
import com.begin.dao.TCourseApplyDAO;
import com.begin.service.TCourseApplyService;
import com.begin.util.page.ListInfo;

public class TCourseApplyServiceImpl extends BaseServiceImpl<TCourseApply, String> implements TCourseApplyService{
	
	private TCourseApplyDAO tCourseApplyDAO;
	
	

	public TCourseApplyDAO gettCourseApplyDAO() {
		return tCourseApplyDAO;
	}



	public void settCourseApplyDAO(TCourseApplyDAO tCourseApplyDAO) {
		this.tCourseApplyDAO = tCourseApplyDAO;
	}



	@Override
	public ListInfo<TCourseApply> searchByUser(String fstudentfuid,
			String fcoursefuid, int currentPage, int pageSize) {
		  ListInfo<TCourseApply> listInfo = new ListInfo<TCourseApply>(currentPage,pageSize);
			//Map<String,String> likeMap = new HashMap<String,String>();
			Map<String,Object> equalMap=new HashMap<String,Object>();
			equalMap.put("fstatusCode", TCourseApply.NORMAL_STATUS);
			equalMap.put("fstudentfuid", fstudentfuid);
			equalMap.put("fcoursefuid", fcoursefuid);
			List<TCourseApply> entityList=tCourseApplyDAO.findByMap(equalMap, null,null,null, listInfo.getFirst(),listInfo.getMax());
			
			listInfo.setCurrentList(entityList);
			listInfo.setSizeOfTotalList(tCourseApplyDAO.countByMap(equalMap, null, null));	
			System.out.println(listInfo);
			
		return listInfo;
	}



	@Override
	public Boolean findCourseBystudetnFuid(String fstudentfuid,
			String fcoursefuid) {
		// TODO Auto-generated method stub
		return tCourseApplyDAO.findCourseBystudetnFuid(fstudentfuid, fcoursefuid);
	}

}
