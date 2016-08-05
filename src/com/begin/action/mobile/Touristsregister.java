package com.begin.action.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.TstduentVO;
import com.begin.bean.TStudent;
import com.begin.service.TStudentService;
import com.begin.util.JSONCreater;


//游客---学生注册
public class Touristsregister extends BaseAction{
	
	// 学生注册
		private TStudent student;
		
		@Resource
		private TStudentService tStudentService;

		private String fno;// 学号
		private String username;// 用户名
		private String password;//密码
		
		
		/**
		 * 学生注册
		 * 
		 * @throws IOException
		 * 
		 */
		public String mystzc() throws IOException{
			 
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out;
			out = ServletActionContext.getResponse().getWriter();
			
			
			String userName = getHttpRequest().getParameter("userName");//姓名
			String classNo = getHttpRequest().getParameter("classNo");//年级号
			String roll = getHttpRequest().getParameter("roll");//学籍号
			String fno = getHttpRequest().getParameter("fno");//身份证号
			String password = getHttpRequest().getParameter("password");//密码
			String sex = getHttpRequest().getParameter("sex");//性别
			
			TStudent ts = tStudentService.validaRegister(fno, null,
					TStudent.NORMAL_STATUS);
			if(ts!=null){
				//学生已经存在
				out.print("error");
			}else{
				TStudent st=new TStudent();
				st.setFuID(null);
				st.setFupdateBy("newstudent");
				st.setFupdateTime(new Date());
				st.setFcreateBy("newstudent");
				st.setFcreateTime(new Date());
				st.setFstatusCode(TStudent.NORMAL_STATUS);
				st.setFstatusDesc(TStudent.NORMAL_STATUS_DESC);
				st.setFpeopleType("student");//类型为学生  功能有限制
				st.setFgender(sex);//性别
				st.setFname(userName);//姓名
			    st.setFclassNo(classNo);//学生年级号
			    st.setFileNo(roll);//学籍号
			    st.setFno(fno);//身份证号
			    st.setFpw(password);//密码
			    tStudentService.createOrEdit(st);
				out.print("success");
			}
		
			
			return null;
		}
		
		/**
		 * 游客
		 * 
		 * @throws IOException
		 * 
		 */
		public String mytrzc() throws IOException{
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out;
			out = ServletActionContext.getResponse().getWriter();
			
			
			String userName = getHttpRequest().getParameter("userName");//姓名
			//String classNo = getHttpRequest().getParameter("classNo");//年级号
			String fphone = getHttpRequest().getParameter("fphone");
			String fno = getHttpRequest().getParameter("fno");//身份证号
			String password = getHttpRequest().getParameter("password");//密码
			String sex = getHttpRequest().getParameter("sex");//性别
			
			TStudent ts = tStudentService.validaRegister(fno, null,
					TStudent.NORMAL_STATUS);
			if(ts!=null){
				//游客已存在
				out.print("error");
			}else{
				TStudent st=new TStudent();
				st.setFuID(null);
				st.setFupdateBy("visitor");
				st.setFupdateTime(new Date());
				st.setFcreateBy("visitor");
				st.setFcreateTime(new Date());
				st.setFstatusCode(TStudent.NORMAL_STATUS);
				st.setFstatusDesc(TStudent.NORMAL_STATUS_DESC);
				st.setFpeopleType("visitor");//类型为游客  功能有限制
				st.setFgender(sex);//性别
				st.setFname(userName);//姓名
				st.setFphone(fphone);//手机号
			    //st.setFclassNo(classNo);//学生年级号
			    //st.setFileNo(roll);//学籍号
			    st.setFno(fno);//身份证号
			    st.setFpw(password);//密码
			    tStudentService.createOrEdit(st);
				out.print("success");
			}
		
			return null;
		}
		
		
		
		
		
		
		
		
		
		
		public TStudent getStudent() {
			return student;
		}
		public void setStudent(TStudent student) {
			this.student = student;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		
	

}
