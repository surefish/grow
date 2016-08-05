package com.begin.dao;

import com.begin.bean.THospital;

public interface THospitalDAO extends BaseDAO<THospital, String>{
	
	/**
	 * 删除指医院时删除该医院下的所有医生
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	int deleteByHospitalID(String hospitalID);

}
