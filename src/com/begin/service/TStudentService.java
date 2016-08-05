package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.action.mobile.vo.TcongfigVO;
import com.begin.bean.QTopic;
import com.begin.bean.SysUser;
import com.begin.bean.TStudent;
import com.begin.util.page.ListInfo;

public interface TStudentService extends BaseService<TStudent, String> {
	
	/**
	 * 按
	 * 学生姓名
	 * 学号
	 * 家长姓名
	 * 家长手机
	 * 学生状态
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	ListInfo<TStudent> searchByTStudent(String fname,String fno,String fparentname,String fparentphone,String fstatus,int currentPageNO, int pageSize);
	
	/**
	 * 学生登录
	 * @param loginName  帐号
	 * @param password  密码
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	TStudent validateUser(String fno, String fpw,String statusCode);
	
	/**
	 * 学生注册
	 * @param fno  学号
	 * @param 姓名   name 
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	TStudent validaRegister(String fno, String name,String statusCode);
	
	/**
	 * 条形码
	 * @param fbarcode 条形码
	 * @param 
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	TStudent validafbarcode(String fbarcode,String statusCode);
	
	/**
	 * 版本号
	 * @param 
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	TcongfigVO scVersion();

}
