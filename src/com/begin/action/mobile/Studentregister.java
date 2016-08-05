package com.begin.action.mobile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;





import org.apache.struts2.ServletActionContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.TstduentVO;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.bean.TStudent;
import com.begin.service.TStudentService;
import com.begin.util.JSONCreater;
import com.begin.util.SimpleEmailClient;



public class Studentregister extends BaseAction {
	// 学生注册
	private TStudent student;
	@Resource
	private TStudentService tStudentService;

	private String fno;// 学号
	private String username;// 用户名
	private String password;//密码

	/**
	 * 学生注册验证
	 * 
	 * @throws IOException
	 * 
	 */
	public String myReg() throws IOException {

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		TstduentVO tv = new TstduentVO();
		TStudent ts = tStudentService.validaRegister(fno, username,
				TStudent.NORMAL_STATUS);
		if (null != ts) {
			tv.setFno(ts.getFno());
			tv.setStuRegister("success");
		}else{
			tv.setStuRegister("error");
		}
		user.put("student", tv);
		String data = JSONCreater.toJSON(user);
		out.print(data);
		//out.print("success");
		return null;
	}
	/**
	 * 学生注册
	 * 
	 * @throws IOException
	 * 
	 */
	public String myRegzc() throws IOException{
		 
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		TstduentVO tv = new TstduentVO();
		TStudent ts = tStudentService.validaRegister(fno, null,
				TStudent.NORMAL_STATUS);
		if(null!=ts){
			ts.setFpw(password);//更新密码
			ts.setFupdateTime(new Date());
			
			Set<Integer> m = new HashSet<Integer>();
		       for(int i=0;i<100;i++){
		           int a;
		           do{
		            a = (int)(Math.random()*1000000);
		           }while(m.contains(a));
		           m.add(a);
		          tv.setStuRegCode(String.valueOf(a));
		       }
		       ts.setMycode(tv.getStuRegCode());
		       tStudentService.createOrEdit(ts);
			tv.setStuRegister("success");
		}else{
			tv.setStuRegister("error");
		}
		user.put("student", tv);
		String data = JSONCreater.toJSON(user);
		out.print(data);
		return null;
	}
	
	/**
	 * 学生修改密码
	 * 
	 * @throws IOException
	 * 
	 */
	
	public String updatePwd() throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		String ypwd = getHttpRequest().getParameter("ypwd");
		String fno = getHttpRequest().getParameter("fno");
		String newPassword = getHttpRequest().getParameter("newPassword");
		TStudent ts = tStudentService.validateUser(fno, ypwd, TStudent.NORMAL_STATUS);
		if(null!=ts){
			ts.setFupdateTime(new Date());
			ts.setFpw(newPassword);
			tStudentService.createOrEdit(ts);
			out.print("success");
		}else{
			out.print("error");
		}
		
		return null;
	}
	/**
	 *学生绑定邮箱验证码
	 * 
	 * @throws IOException
	 * 
	 */
	public String stuAddEmail() throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		String uName="";
		if(null!=ps){
			uName="尊敬的"+ps.getStduentName()+"您好：";
		}
		String email = request.getParameter("email");
		SimpleEmailClient sc=new SimpleEmailClient();
		String i1="";
		Set<Integer> m = new HashSet<Integer>();
	       for(int i=0;i<100;i++){
	           int a;
	           do{
	            a = (int)(Math.random()*1000000);
	           }while(m.contains(a));
	           m.add(a);
	           i1=String.valueOf(a);
	       }
	       try {
				sc.sendSimpleEmail(email,uName, "验证码是："+i1);
				ps.setEmailCode(i1);
				ps.setEmailZC(email);
				out.print("success");
			} catch (Exception e) {
				e.printStackTrace();
				out.print("error");
			}
		return null;
	}
	
	/**
	 *学生绑定邮箱
	 * 
	 * @throws IOException
	 * 
	 */
	public String stubdEmail() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		String emailcode = request.getParameter("emailcode");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		if(null!=ps){
			if(ps.getEmailCode().equals(emailcode)){
				TStudent ts = tStudentService.searchByID(ps.getStudentFuid());
				ts.setFupdateTime(new Date());
				ts.setfEmail(ps.getEmailZC());
				tStudentService.createOrEdit(ts);
				out.print("success");
			}else{
				out.print("error");
			}
		}
		
		return null;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	

}
