package com.begin.action.system;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysRole;
import com.begin.bean.SysUser;
import com.begin.service.SysRoleService;
import com.begin.service.SysUserService;
import com.begin.util.JSONCreater;
import com.begin.util.MD5Util;
import com.begin.util.page.ListInfo;
import com.begin.vo.Passport;
import com.begin.vo.SysRoleVO;
import com.begin.vo.SysUserVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.Preparable;

import flex.messaging.io.ArrayList;

@SuppressWarnings("serial")
public class SystemUser extends BaseAction implements Preparable {

	private SysUser sysUser;

	private String userName;
	private String passWord;
	private String checkCode;
	private String userRoleId;

	@Resource
	private SysUserService sysUserService;

	// 用户列表
	private ListInfo<SysUser> sysUseres;
	
	@Resource
	private SysRoleService sysRoleService;

	// 角色列表
	private ListInfo<SysRole> sysRoles;
	private SysRole sysRole;

	/**
	 * 跳转转到登录主页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() {

		return SUCCESS;
	}

	/**
	 * 登录
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String logining() {

		// 查询账号
		String code=(getHttpSession().getAttribute("CHECK_CODE").toString());
		if(!code.equals(checkCode)){
			addActionMessage("验证码错误");
			return "input";
		}else{
			sysUser = sysUserService.validateUser(userName, passWord,SysUser.NORMAL_STATUS);
			if (null != sysUser) {
				System.out.println("登录成功！");
				Passport ps = new Passport();
				ps.setUserID(sysUser.getFuID());
				ps.setUserName(sysUser.getFuserName());
				ps.setLastLoginTime(sysUser.getLastLoginTime());
				Set<SysRole> roles=sysUser.getRoles();
				if(!roles.isEmpty()){
					
					Iterator iterator = roles.iterator();
				    while (iterator.hasNext()){  
				    	SysRole sr = (SysRole) iterator.next();
				      ps.setRolefuID(sr.getFuID());
				    }
				}
				//ps.setRolefuID("402881e4528bef4e01528bf067550000");//管理员ROID
				getHttpSession().setAttribute("xqdPassport", ps);
				sysUser.setLastLoginTime(new Date());
				sysUser.setFupdateTime(new Date());
				sysUser.setFupdateBy(sysUser.getFuID());
				sysUserService.createOrEdit(sysUser);
				return SUCCESS;

			} else {
				addActionMessage("用户名或密码错误");
				return "input";
			}
			
		}
		
		
		

	}

	
	/**
	 * 用户列表json
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String userjson() {
		
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
		
		sysUseres = sysUserService.searchAll(intPage, number);
		
		List<SysUserVO> mList=new ArrayList();
		
		for(SysUser sy:sysUseres.getCurrentList()){
			SysUserVO svo=new SysUserVO();
			svo.setFuID(sy.getFuID());
			svo.setFuserId(sy.getFuserId());
			svo.setFname(sy.getFname());//角色名
			svo.setFuserName(sy.getFuserName());
			//svo.setFpassWord(sy.getFpassWord());
			svo.setFphone(sy.getFphone());
			svo.setFemail(sy.getFemail());
			mList.add(svo);
		}
		int total=sysUseres.getSizeOfTotalList();//总记录数
		Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",mList);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
	}

	/**
	 * 去添加用户
	 * 
	 * @return
	 */
	public String goAddUser() {

		
		return SUCCESS;
	}
	/**
	 * 用户列表
	 * 
	 * @return
	 */
	public String listSysUser() {

		return SUCCESS;
	}
	
	/**
	 * role json
	 * @return
	 */
	public String goRoleJson() {
		sysRoles=sysRoleService.searchAll(1, Integer.MAX_VALUE);
		List<SysRoleVO> svo=new ArrayList();
		for(SysRole sy:sysRoles.getCurrentList()){
			SysRoleVO sr=new SysRoleVO();
			sr.setId(sy.getFuID());
			sr.setText(sy.getFrolename());
			svo.add(sr);
		}
		 json=JSONCreater.toJSON(svo);
		 System.out.println(json);
		return "json";
	}
	
	

	/**
	 * 去编辑用户
	 * 
	 * @return
	 */

	public String getUserID() {
		String userID = getHttpRequest().getParameter("userID");
		sysUser = sysUserService.searchByID(userID);
		//sysRoles=sysRoleService.searchAll(1, Integer.MAX_VALUE);

		return SUCCESS;
	}

	public void prepareCreateOrEditUser() throws Exception {
		if (!"".equals(sysUser.getFuID()) && null != sysUser.getFuID()) {
			sysUser = sysUserService.searchByID(sysUser.getFuID());
		}
	}

	/**
	 * 创建及修改用户
	 * 
	 * @return
	 */
	public String createOrEditUser() {
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		if ("".equals(sysUser.getFuID()) || null == sysUser.getFuID()) {
			sysUser.setFuID(null);
			sysUser.setFpassWord(MD5Util.MD5(sysUser.getFpassWord()));//加密
			sysUser.setFcreateBy(ps.getUserID());
			sysUser.setFcreateTime(new Date());
			sysUser.setFupdateBy(ps.getUserID());
			sysUser.setFupdateTime(new Date());
			sysUser.setFstatusCode(SysUser.NORMAL_STATUS);
			sysUser.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			sysUser.setLastLoginTime(new Date());
		} else {
			sysUser.setFpassWord(MD5Util.MD5(sysUser.getFpassWord()));//加密
			sysUser.setFupdateTime(new Date());
			sysUser.setFupdateBy(ps.getUserID());
		}
		if(null!=userRoleId&&!"".equals(userRoleId)){
			SysRole  sr=sysRoleService.searchByID(userRoleId);
			Set<SysRole> roles=new HashSet<SysRole>();
			roles.add(sr);
			sysUser.setRoles(roles);
		}
		
		sysUserService.createOrEdit(sysUser);
		return SUCCESS;
	}

	/**
	 * 按用户名搜索
	 * 
	 * @return
	 */
	public String searchByname() {
		String fuserName = getHttpRequest().getParameter("fuserName");
		// String fphone=getHttpRequest().getParameter("fphone");
		// String femail=getHttpRequest().getParameter("femail");

		sysUseres = sysUserService.searchByUser(fuserName, "", "",
				currentPageNO, pageSize);

		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String deleteUser() {
		
		String userID = getHttpRequest().getParameter("userID");
		sysUserService.deleteRole(userID);
		sysUserService.deleteByID(userID);

		return SUCCESS;
	}
	
	/**
	 *退出
	 * 
	 * @return
	 */
	
	public String loginout() {
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		sysUser=sysUserService.searchByID(ps.getUserID());
		sysUser.setLastLoginTime(new Date());
		sysUser.setFupdateTime(new Date());
		sysUser.setFupdateBy(ps.getUserID());
		sysUserService.createOrEdit(sysUser);
		
		return SUCCESS;
	}
	
	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public ListInfo<SysUser> getSysUseres() {
		return sysUseres;
	}

	public void setSysUseres(ListInfo<SysUser> sysUseres) {
		this.sysUseres = sysUseres;
	}

	public ListInfo<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(ListInfo<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
	
	

}
