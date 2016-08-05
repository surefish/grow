package com.begin.action.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.TExerciseVO;
import com.begin.action.mobile.vo.TstduentVO;
import com.begin.bean.THealthy;
import com.begin.bean.THeight;
import com.begin.bean.TSchool;
import com.begin.bean.TStudent;
import com.begin.bean.TWeight;
import com.begin.service.THealthyService;
import com.begin.service.THeightService;
import com.begin.service.TSchoolService;
import com.begin.service.TStudentService;
import com.begin.service.TWeightService;
import com.begin.util.DateUtil;
import com.begin.util.JSONCreater;
import com.begin.vo.Passport;
import com.begin.vo.TSchoolVO;
import com.begin.vo.TStudentVO;

public class MyinformationAction extends BaseAction{
	
	private TStudent student;

	@Resource
	private TStudentService tStudentService;
	
	private THealthy tHealthy;
	 
	@Resource
	private THealthyService tHealthyService;
	
	private TSchool school;

	@Resource
	private TSchoolService tSchoolService;
	
	
    List<THeight> listHeight;//身高
	
	
	List<TWeight> listWeight;//体重
	@Resource
	private THeightService tHeightService;
	@Resource
	private TWeightService tWeightService;
	
	
	/**
	 * @throws IOException 
	 * @学生基本信息
	 */

	public String studentinfo() throws IOException {
		
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 TstduentVO tvo=new TstduentVO();
		 tvo.setFuID(ps.getStudentFuid());//学生主键
		 tvo.setFname(ps.getStduentName());//学生姓名
		 tvo.setFage(ps.getStudenAge());//学生年龄
		 tvo.setFgender(ps.getFgender());//性别
		 tvo.setStudenSchool(ps.getStudenSchool());
		 tvo.setStudenSchoolurl(ps.getSchoolurl());//学校图片
		 tvo.setSchoolfuid(ps.getSchoolFuid());//学校主键
		 Map<String, Object> user = new HashMap<String, Object>();
		 user.put("student", tvo);
		 String data = JSONCreater.toJSON(user);
		 out.print(data);
		 
		return null;
	}

	
	/**
	 * @throws IOException 
	 * 成长信息
	 */
	
	public String studentHealth() throws IOException {
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 TStudent ts=tStudentService.searchByID(ps.getStudentFuid());
		 TStudentVO tvo=new TStudentVO();
		  if(null!=ts){
			    THealthy th=tHealthyService.seachbyTHealthyFuid(ts.getFuID());
			    if(null!=th){
			    	tvo.setFtooth(th.getFtooth()==null?"":th.getFtooth());//牙齿
		        	tvo.setFleftv(th.getFleftv()==null?"0":th.getFleftv());//左眼 视力
		        	tvo.setFrightv(th.getFrightv()==null?"0":th.getFrightv());//右眼-视力
		        	tvo.setFresult(th.getFresult()==null?"":th.getFresult());//诊断结果
		        	tvo.setFdoctor(th.getFdoctor()==null?"":th.getFdoctor());//开单医生
			    }
			    Date beg=null;
				Date end=null;
				beg=DateUtil.getFirstDayOfMonth(new Date());//本月第一天
				end=DateUtil.getLastDayOfMonth(new Date());//本月最后一天
				
			    List<THeight> listHeight=tHeightService.findByStFuid(ts.getFuID(),beg,end);
		    	List<TWeight> listWeight=tWeightService.findByStFuid(ts.getFuID(),beg,end);
		    	if(listHeight.size()>0){
		    		  THeight t1=listHeight.get(0);
		    		  tvo.setFheight(t1.getFheight()==null?"0":t1.getFheight());//身高
		    	}
		    	if(listWeight.size()>0){
		    		TWeight t2=listWeight.get(0);
		    		tvo.setFweight(t2.getFweight()==null?"0":t2.getFweight());//体重
		    	}  
		 }
		 Map<String, Object> user = new HashMap<String, Object>();
		 user.put("student", tvo);
		 String data = JSONCreater.toJSON(user);
		 out.print(data);
		return null;
	
	}
	/**
	 * @throws IOException 
	 * 点击查看学校详情
	 */
	public String schoolInfos() throws IOException {
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 String schoolfuid = getHttpRequest().getParameter("schoolfuid");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 school=tSchoolService.searchByID(schoolfuid);
		 TSchoolVO tsc=new TSchoolVO();
		 tsc.setFname(school.getFname());
		 tsc.setFschoolurl(school.getFschoolurl());
		 tsc.setFintro(school.getFintro());
		 Map<String, Object> user = new HashMap<String, Object>();
		 user.put("student", tsc);
		 String data = JSONCreater.toJSON(user);
		 out.print(data);
		return null;
	}
	
	

	
	/**
	 * @throws IOException 
	 * 查询学生历史健康
	 */
	public String oldHealthy()throws IOException {
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 List<TStudentVO> mlist=new ArrayList<TStudentVO>();
		 if(null!=ps){
			 List<THealthy> list=tHealthyService.seachbyTHealthyFuidList(ps.getStudentFuid(),0,7);
			 if(list.size()>0){
				 for(int i=0;i<list.size();i++){
					    TStudentVO tvo=new TStudentVO();
					    tvo.setFheight(list.get(i).getFheight()==null?"0":list.get(i).getFheight());//身高
			        	tvo.setFweight(list.get(i).getFweight()==null?"0":list.get(i).getFweight());//体重
			        	tvo.setFtooth(list.get(i).getFtooth()==null?"":list.get(i).getFtooth());//牙齿
			        	tvo.setFleftv(list.get(i).getFleftv()==null?"0":list.get(i).getFleftv());//左眼 视力
			        	tvo.setFrightv(list.get(i).getFrightv()==null?"0":list.get(i).getFrightv());//右眼-视力
			        	tvo.setFresult(list.get(i).getFresult()==null?"正常":list.get(i).getFresult());//诊断结果
			        	tvo.setFdoctor(list.get(i).getFdoctor()==null?"":list.get(i).getFdoctor());//开单医生
			        	String st=dateFormat.format(list.get(i).getFfilldate()).toString();
			        	tvo.setFfilldate(list.get(i).getFfilldate()==null?"":st);//诊断时间
			        	tvo.setFweek(String.valueOf(i));
			        	mlist.add(tvo);
				       }  
			    }
		
			 Map<String, Object> user = new HashMap<String, Object>();
			 user.put("student", mlist);
			 String data = JSONCreater.toJSON(user);
			 out.print(data); 
			 
		 }
       return null;  
	}
	
	
	
	/**
	 * @throws IOException 
	 * 查询学生历史身高
	 */
	public String oldTHeight()throws IOException {
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 List<TStudentVO> mlist=new ArrayList<TStudentVO>();
		 Map<String, Object> user = new HashMap<String, Object>();
		 if(null!=ps){
			
			 List<THeight> list=tHeightService.seachbyTHealthyFuidList(ps.getStudentFuid(),0,7);
			
			 if(list.size()>0){
				 for(int i=0;i<list.size();i++){
					    TStudentVO tvo=new TStudentVO();
					    tvo.setFheight(list.get(i).getFheight()==null?"0":list.get(i).getFheight());//身高
					    tvo.setFgender(list.get(i).getFsex());//性别
					    tvo.setFname(list.get(i).getFname());//学生姓名
					    tvo.setFuID(list.get(i).getFuID());//学生主键
			        	tvo.setFweek(String.valueOf(i));
			        	mlist.add(tvo);
				       }  
			    
			    }else{
			    	 for(int i=0;i<7;i++){
						    TStudentVO tvo=new TStudentVO();
						    tvo.setFheight("0");//身高
				        	tvo.setFweek(String.valueOf(i));
				        	mlist.add(tvo);
			    }
			    }
			 user.put("student", mlist);
			 String data = JSONCreater.toJSON(user);
			 out.print(data);  
		 }
       return null;  
	}
	
	
	/**
	 * @throws IOException 
	 * 查询学生历史体重
	 */
	public String oldTWeight()throws IOException {
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 List<TStudentVO> mlist=new ArrayList<TStudentVO>();
		 Map<String, Object> user = new HashMap<String, Object>();
		 if(null!=ps){
			 List<TWeight> list=tWeightService.seachbyTHealthyFuidList(ps.getStudentFuid(),0,7);
			 if(list.size()>0){
				 for(int i=0;i<list.size();i++){
					    TStudentVO tvo=new TStudentVO();
					    tvo.setFweight(list.get(i).getFweight()==null?"0":list.get(i).getFweight());//身高
					    tvo.setFgender(list.get(i).getFsex());//性别
					    tvo.setFname(list.get(i).getFname());//学生姓名
					    tvo.setFuID(list.get(i).getFuID());//学生主键
			        	tvo.setFweek(String.valueOf(i));
			        	mlist.add(tvo);
				       }  
			    } else{
			    	 for(int i=0;i<7;i++){
						    TStudentVO tvo=new TStudentVO();
						    tvo.setFweight("0");//体重
				        	tvo.setFweek(String.valueOf(i));
				        	mlist.add(tvo);
			    }
			    }
		
			
			 user.put("student", mlist);
			 String data = JSONCreater.toJSON(user);
			 out.print(data);  
		 }
       return null;  
	}
	
	
	
	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}

	public THealthy gettHealthy() {
		return tHealthy;
	}

	public void settHealthy(THealthy tHealthy) {
		this.tHealthy = tHealthy;
	}

	public TSchool getSchool() {
		return school;
	}

	public void setSchool(TSchool school) {
		this.school = school;
	}
	
	
	
}
