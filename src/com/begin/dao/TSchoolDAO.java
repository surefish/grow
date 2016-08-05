package com.begin.dao;

import com.begin.bean.TSchool;

public interface TSchoolDAO extends BaseDAO<TSchool, String>{
	/**
	 * 删除学校时删除该学校下所有的班级
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	int deleteByschoolID(String schoolID);

}
