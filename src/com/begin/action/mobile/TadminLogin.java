package com.begin.action.mobile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.TstduentVO;
import com.begin.bean.TAdministrator;
import com.begin.bean.TClass;
import com.begin.bean.TLog;
import com.begin.bean.TStudent;
import com.begin.bean.TStudentIP;
import com.begin.bean.TTeacher;
import com.begin.service.TAdministratorService;
import com.begin.service.TLogService;
import com.begin.util.Barcode;
import com.begin.util.GetAge;
import com.begin.util.GetHttp;
import com.begin.util.HealthyCommon;
import com.begin.util.IpUtil;
import com.begin.util.JSONCreater;
import com.begin.vo.TAdministratorVO;

public class TadminLogin extends BaseAction{
	
	private String username;
	private String password;
	@Resource
	private TAdministratorService tAdministratorService;
	
	private TAdministrator tAdministrator;

	@Resource
	private TLogService tLogService;
	
	private TLog tLog;
	
	
	/**
	 * @see 老师管理员登录
	 * @author yu
	 * @return
	 */
	public String login() {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			
			out = ServletActionContext.getResponse().getWriter();
			Map<String, Object> user = new HashMap<String, Object>();
			TAdministratorVO tv=new TAdministratorVO();
			
			TTeacher ts=tAdministratorService.validateUser(username, password, TAdministrator.NORMAL_STATUS);
			if(null!=ts){
				tv.setFuID(ts.getFuID());//主键
				tv.setFname(ts.getFname());//老师姓名
				tv.setFpw(ts.getFpw());//密码
				tv.setFclassuid(ts.getFclassuid());//班级主键
				user.put("student", tv);
			}
			
			String data = JSONCreater.toJSON(user);
			out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TAdministrator gettAdministrator() {
		return tAdministrator;
	}

	public void settAdministrator(TAdministrator tAdministrator) {
		this.tAdministrator = tAdministrator;
	}


	public TLog gettLog() {
		return tLog;
	}


	public void settLog(TLog tLog) {
		this.tLog = tLog;
	}
	
	
	
	
	
	
	
	
     
}
