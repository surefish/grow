package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.begin.bean.SysOrg;



public interface SysOrgService extends BaseService<SysOrg, String> {
	
	/**
	 * 查出所有菜单，并按父级子级关系封装
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<SysOrg> searchAllOrgs();
	
	/**
	 * 查找父级菜单
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<SysOrg> findParentOrgs(String forgId);
	
	
	/**
	 * 删除父级菜单，并删除掉子级菜单
	 * @param menuID	父级菜单主键
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteParentOrgs(String forgId);

}
