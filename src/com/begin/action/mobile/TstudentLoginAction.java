package com.begin.action.mobile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.TMessagesVO;
import com.begin.action.mobile.vo.TStudentIPVO;
import com.begin.action.mobile.vo.TcongfigVO;
import com.begin.action.mobile.vo.TstduentVO;
import com.begin.bean.TClass;
import com.begin.bean.TGrade;
import com.begin.bean.TLog;
import com.begin.bean.TStudent;
import com.begin.bean.TStudentIP;
import com.begin.bean.Tcongfig;
import com.begin.service.TClassService;
import com.begin.service.TGradeService;
import com.begin.service.TLogService;
import com.begin.service.TStudentIPService;
import com.begin.service.TStudentService;
import com.begin.util.Barcode;
import com.begin.util.GetAge;
import com.begin.util.GetHttp;
import com.begin.util.HealthyCommon;
import com.begin.util.IpUtil;
import com.begin.util.JSONCreater;



public class TstudentLoginAction extends BaseAction {
	
	private String username;
	private String password;
	private TStudent student;
	private TClass tclass;
	@Resource
	private TClassService tClassService;
	@Resource
	private TStudentService tStudentService;
	
	@Resource
	private TStudentIPService tStudentIPService;
	
	private TStudentIP tStudentIP;
	
	@Resource
	private TLogService tLogService;
	
	@Resource
	private TGradeService tGradeService;
	
	private TLog tLog;
	
		/**
		 * @see 学生家长登录
		 * @author yu
		 * @return
		 */
		public String login() {
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out;
			System.out.println("username="+username);
			System.out.println("password="+password);
			try {
				out = ServletActionContext.getResponse().getWriter();
				Map<String, Object> user = new HashMap<String, Object>();
				PassportStudent ps=new PassportStudent();
				TstduentVO tv=new TstduentVO();
				TStudent ts=tStudentService.validateUser(username, password, TStudent.NORMAL_STATUS);
				System.out.println("学生类型="+ts.getFpeopleType());
				
				if(null!=ts&&ts.getFpeopleType()==null){//全功能学生
					tv.setFuID(ts.getFuID());//主键
					tv.setFname(ts.getFname());//学生 姓名
					tv.setFno(ts.getFno());//学号
					tv.setFpw(ts.getFpw());//密码
					int s1=((int) HealthyCommon.getAgeByBirthday(ts.getFbirth()));
					tv.setFage(String.valueOf(s1));//几岁
					tv.setFgender(ts.getFgender());//性别
					tv.setFpeopleType("null");
					user.put("student", tv);//这里放student 前端就按这个取
					
					/*学生基本信息*/
					ps.setStudentFuid(ts.getFuID());//学生主键
					ps.setStduentName(ts.getFname());//学生姓名
					ps.setStudenAge(tv.getFage());//年龄
					if(null!=ts.gettClass()){//学生的年级 学校 信息
						TClass tclass=tClassService.searchByID(ts.gettClass().getFuID());
						ps.setStudenSchool(tclass.gettSchool().getFname());
						ps.setSchoolurl(tclass.gettSchool().getFschoolurl());//学校图片
						ps.setSchoolFuid(tclass.gettSchool().getFuID());//学校主键
						ps.setFgrade(tclass.getFgrade());//学生年级
						ps.setFgradeFuid(tclass.getFuID());//学生班级主键
						
						//TGrade tGrade =tGradeService.searchByID(tclass.getFgrade());
						//ps.settGradeName(tGrade.getFname());
					}
					ps.setFgender(ts.getFgender());//性别
					//ps.setFileNo(ts.getFileNo());//学籍号
					ps.setFno(ts.getFno());//学号
					ps.setFpeopleType("null");
			    }
				
				//部分功能受限学生
				if(null!=ts&&"student".equals(ts.getFpeopleType())){
					tv.setFuID(ts.getFuID());//主键
					tv.setFname(ts.getFname());//学生 姓名
					tv.setFno(ts.getFno());//学号
					tv.setFpw(ts.getFpw());//密码
					tv.setFgender(ts.getFgender());//性别
					int s1=GetAge.getAge(ts.getFno());
					tv.setFage(String.valueOf(s1));//几岁
					tv.setFpeopleType("student");
					
					user.put("student", tv);//这里放student 前端就按这个取
					ps.setStudentFuid(ts.getFuID());//学生主键
					ps.setStduentName(ts.getFname());//学生姓名
					ps.setStudenAge(tv.getFage());//年龄
					ps.setFgender(ts.getFgender());//性别
					ps.setFileNo(ts.getFileNo());//学籍号
					ps.setFno(ts.getFno());//学号
					ps.setFgrade(ts.getFclassNo());//学生年级
					ps.setStudenSchool(ts.getFclassNo());//学生年级
					ps.setFpeopleType("student");
					
				}
				
				//游客
				if(null!=ts&&"visitor".equals(ts.getFpeopleType())){
					tv.setFuID(ts.getFuID());//主键
					tv.setFname(ts.getFname());//学生 姓名
					tv.setFno(ts.getFno());//学号
					tv.setFpw(ts.getFpw());//密码
					tv.setFgender(ts.getFgender());//性别
					int s1=GetAge.getAge(ts.getFno());
					tv.setFage(String.valueOf(s1));//几岁
					tv.setFpeopleType("visitor");
					user.put("student", tv);//这里放student 前端就按这个取
					ps.setStudentFuid(ts.getFuID());//学生主键
					ps.setStduentName(ts.getFname());//学生姓名
					ps.setStudenAge(tv.getFage());//年龄
					ps.setFgender(ts.getFgender());//性别
					ps.setFno(ts.getFno());//学号
					ps.setFpeopleType("visitor");
					
				}
				
				
				
				/*获取用户IP地址*/
				String uip=IpUtil.getIpAddr(ServletActionContext.getRequest());
				String uipAdres=IpUtil.getAddressByIP(uip);
				HttpServletRequest request = ServletActionContext.getRequest();
		        Boolean b = GetHttp.isMobileDevice(request);
		        //记录IP
		        TStudentIP tip=new TStudentIP();
		        tip.setFuID(null);
		        tip.setFstudentFuid(ts.getFuID());//学生主键
		        tip.setFstatusCode(TStudentIP.NORMAL_STATUS);
		        tip.setFstatusDesc(TStudentIP.NORMAL_STATUS_DESC);
		        tip.setFcreateTime(new Date());
		        tip.setFlogintime(new Date());
		        if("本地".equals(uip)){
		        	 tip.setFaddress("本地");
		        }else if(uipAdres.length()==4){
		        	 tip.setFaddress("内网IP");
		        }else if(uipAdres.length()>200){
		        	 tip.setFaddress("内网IP");
		        }else{
		        	tip.setFaddress(uipAdres);
		        }
		        if (b.equals(true)) {
		        	tip.setFterminal("手机端");
		        } else{
		        	tip.setFterminal("电脑端");
		        }
		        tStudentIPService.createOrEdit(tip);
		        //记录IP结束 
				
		        //生成条形码
		        if(ts.getFbarcode()==null||ts.getFbarcode().length()==0){//这个学生不存在条形码
		        String path = ServletActionContext.getServletContext().getRealPath("/barcode");//存放路径
		        File dir = new File(path); 
		         if(!dir.exists())
		         {
		              dir.mkdir();
		         }
		        	while(true){ 
		        		String s="9000000000"+Barcode.generate1();//生成编号
		        		TStudent st=tStudentService.validafbarcode(s, TStudent.NORMAL_STATUS);
		        		if(null==st){ 
		        			//生成条形码图片
		        			Barcode.generate(s, path, s+".png");
		        			ts.setFbarcode("barcode/"+s+".png");//barcode/9000000000207.png
		        			ts.setFupdateTime(new Date());
		        			tStudentService.createOrEdit(ts);
		        		break;
		        		  }
		        		}
					        	
		        } 
		       //生成条形码
		        ps.setFbarcode(ts.getFbarcode());
		        getHttpSession().setAttribute("xqdtStudent", ps);
				

				//创建日志
				TLog tLog=new TLog();
				tLog.setFuID(null);
				tLog.setFuserID(ts.getFuID());//用户主键
				tLog.setFstatusCode(TLog.NORMAL_STATUS);
				tLog.setFstatusDesc(TLog.NORMAL_STATUS_DESC);
				tLog.setFcreateBy(ts.getFuID());
				tLog.setFcreateTime(new Date());
				tLog.setFupdateTime(new Date());
				tLog.setFupdateBy(ts.getFuID());
				tLog.setFactionName("login()");
				tLog.setFuserName(ps.getStduentName()==null?"":ps.getStduentName());//用户名称
				tLog.setFdesc("用户登录");
				tLogService.createOrEdit(tLog);
				
				
				String data = JSONCreater.toJSON(user);
				out.print(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		
		/**
		 * @see 异地登录提醒
		 * @author yu
		 * @return
		 */
		public String allopatry()throws IOException{
			 response.setContentType("text/json");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out;
			 out = ServletActionContext.getResponse().getWriter();
			 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 Map<String, Object> user = new HashMap<String, Object>();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			List<TStudentIPVO> mlist=new ArrayList<TStudentIPVO>();
			 if(null!=ps){
				 List<TStudentIP> tsl=tStudentIPService.findByqfuid(ps.getStudentFuid(), 0, 3);
				 if(tsl.size()>0){
					 for(TStudentIP tip:tsl){
						 TStudentIPVO t=new TStudentIPVO();
						 t.setFuID(tip.getFuID());//主键
						 t.setFstudentFuid(tip.getFstudentFuid());//学生主键
						 t.setFaddress(tip.getFaddress());//登录地址
						 t.setFlogintime(dateFormat.format(tip.getFlogintime()).toString());//登录时间
						 t.setFterminal(tip.getFterminal());//登录终端
						 mlist.add(t);
					 }  
				 }
			 }
			    user.put("student", mlist);
				String data = JSONCreater.toJSON(user);
				out.print(data);
				System.out.println(data); 
			return null;
		}
		
		
		/**
		 * @see 条形码
		 * @author yu
		 * @return
		 */
		public String getBarcode()throws IOException{
			 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 response.setContentType("text/json");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out;
			 out = ServletActionContext.getResponse().getWriter();
			 out.print(ps.getFbarcode().toString());
			return null;
		}
		
		/**
		 * @see 消息接受
		 * @author yu
		 * @return
		 */
		public String getMsByStud()throws IOException{
			 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 TStudent t=tStudentService.searchByID(ps.getStudentFuid());
			 String isms = getHttpRequest().getParameter("isms");
			 t.setMesreceived(isms.toString());//消息接收
			 t.setFupdateBy(ps.getStudentFuid());
			 t.setFupdateTime(new Date());
			 tStudentService.createOrEdit(t);
			 response.setContentType("text/json");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out;
			 out = ServletActionContext.getResponse().getWriter();
			 out.print("success");
			return null;
		}
		
		/**
		 * @see 新消息提醒
		 * @author yu
		 * @return
		 */
		public String getMsNewByStud()throws IOException{
			 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 TStudent t=tStudentService.searchByID(ps.getStudentFuid());
			 String isms = getHttpRequest().getParameter("isms1");
			 t.setMesrremind(isms.toString());
			 t.setFupdateBy(ps.getStudentFuid());
			 t.setFupdateTime(new Date());
			 tStudentService.createOrEdit(t);
			 response.setContentType("text/json");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out;
			 out = ServletActionContext.getResponse().getWriter();
			 out.print("success");
			return null;
		}
		/**
		 * @see意见反馈
		 * @author yu
		 * @return
		 */
		public String getYJFK()throws IOException{
			 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 TStudent t=tStudentService.searchByID(ps.getStudentFuid());
			 String tex = getHttpRequest().getParameter("tex");
			 t.setFeedback(tex.toString());
			 t.setFupdateBy(ps.getStudentFuid());
			 t.setFupdateTime(new Date());
			 tStudentService.createOrEdit(t);
			 response.setContentType("text/json");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out;
			 out = ServletActionContext.getResponse().getWriter();
			 out.print("success");
			return null;
		}
		
		/**
		 * @see 查看手机版本
		 * @return
		 * @throws IOException
		 */
		public String version() throws IOException{ 
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8"); 
			PrintWriter out= response.getWriter();
			TcongfigVO  ts=tStudentService.scVersion();
			if(null!=ts){
				out.print(ts.getFedition());
				System.out.println("手机APP版本号:"+ts.getFedition());
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


		public TStudent getStudent() {
			return student;
		}


		public void setStudent(TStudent student) {
			this.student = student;
		}


		public TClass getTclass() {
			return tclass;
		}


		public void setTclass(TClass tclass) {
			this.tclass = tclass;
		}


		public TStudentIP gettStudentIP() {
			return tStudentIP;
		}


		public void settStudentIP(TStudentIP tStudentIP) {
			this.tStudentIP = tStudentIP;
		}


		public TLog gettLog() {
			return tLog;
		}


		public void settLog(TLog tLog) {
			this.tLog = tLog;
		}




}



