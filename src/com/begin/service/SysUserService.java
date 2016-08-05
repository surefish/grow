package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.SysUser;
import com.begin.util.page.ListInfo;




public interface SysUserService extends BaseService<SysUser, String>{
	
	/**
	 * 用户登录
	 * @param loginName  帐号
	 * @param password  密码
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	SysUser validateUser(String loginName, String password,String statusCode);
	
	
	
	/**
	 *        
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	ListInfo<SysUser> searchByUser(String fuserName, String fphone,
			String femail, int currentPage, int pageSize);

	/**
	 * 
	 * @param roleIDs
	 * @param userID
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	int assignRole(String[] roleIDs,String userID);
	
	/**
	 * 
	 * @param roleIDs
	 * @param userID
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	int removeRole(String[] roleIDs,String userID);
	
	/**
	 * 删用户时，删除关联角色
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	int deleteRole(String userid);
	
}
