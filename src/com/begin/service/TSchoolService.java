package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TSchool;

public interface TSchoolService extends BaseService<TSchool, String> {

	
	/**
	 * 删除学校时删除该学校下所有的班级
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteByschoolID(String schoolID);
}
