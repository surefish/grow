package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.SysUser;
import com.begin.bean.TCourseApply;
import com.begin.util.page.ListInfo;



public interface TCourseApplyService extends BaseService<TCourseApply, String>{
	
	/**
	 *        
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	ListInfo<TCourseApply> searchByUser(String fstudentfuid, String fcoursefuid,
			 int currentPage, int pageSize);
	
	/**
	 * 根据fstudentfuid主键
	 * fcoursefuid
	 * 查找
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	Boolean findCourseBystudetnFuid(String fstudentfuid,String fcoursefuid);


}
