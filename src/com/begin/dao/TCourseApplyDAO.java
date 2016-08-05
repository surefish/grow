package com.begin.dao;

import java.util.List;


import com.begin.bean.TCourseApply;



public interface TCourseApplyDAO extends BaseDAO<TCourseApply, String>{
	
	/**
	 * 根据fstudentfuid主键
	 * fcoursefuid
	 * 查找
	 * @return
	 */

	Boolean findCourseBystudetnFuid(String fstudentfuid,String fcoursefuid);

}
