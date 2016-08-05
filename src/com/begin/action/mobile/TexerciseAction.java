package com.begin.action.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.TExerciseVO;
import com.begin.action.mobile.vo.TRankingVO;
import com.begin.bean.TAverage;
import com.begin.bean.TExercise;
import com.begin.bean.TExerciseStandard;
import com.begin.bean.TLog;
import com.begin.bean.TStudent;
import com.begin.service.TAverageService;
import com.begin.service.TExerciseService;
import com.begin.service.TExerciseStandardService;
import com.begin.service.TLogService;
import com.begin.service.TStudentService;
import com.begin.util.DateUtil;
import com.begin.util.JSONCreater;



/**
 * @author 每日运动
 * @ysh
 */

public class TexerciseAction extends BaseAction{
	
	@Resource
	private TExerciseService tExerciseService;//运动日志
	
	private TExercise tExercise;
	
	@Resource
	private TExerciseStandardService tExerciseStandardService;//昨日运动日志
	
	private TExerciseStandard tExerciseStandard;
	
	@Resource
	private TAverageService tAverageService;//运动平均值
	
	private TAverage tAverage;//运动平均值
	
	@Resource
	private TStudentService tStudentService;
	
	@Resource
	private TLogService tLogService;
	
	private TLog tLog;
	/**
	 * @see 显示列表页
	 * @author ysh
	 */
	public String show(){
		
		
		
		
		return null;
	}
	
	/**
	 * @see 三个项目分别录入数据
	 * @author今日运动百分比计算
	 */
   public String showTodayPercent(){
	   PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
	    response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter out;
	   try {
		 out = response.getWriter();
	   if(null!=ps){
		   String percent = tExerciseService.getTodayPercent(ps.getStudentFuid());
		   System.out.println(percent);
		   out.print(percent);
	       }

	   } catch (IOException e) {
			e.printStackTrace();
		} 
		 return null;
     }
	
	/**
	 * @see 显示列表页
	 * @author今日运动
	 */
   public String showToday(){
		//011001 坐位体前屈
	    //011003 仰卧起坐
		//011002 跳绳
	   PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
	    response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter out;
	   try {
		 out = response.getWriter();
	   if(null!=ps){
		   List<TExercise> te1=tExerciseService.searchByTady("011001", ps.getStudentFuid());//坐位体前屈
		   List<TExercise> te2=tExerciseService.searchByTady("011003", ps.getStudentFuid());// 仰卧起坐
		   List<TExercise> te3=tExerciseService.searchByTady("011002", ps.getStudentFuid());// 跳绳
		   int c1=0;
		   int c2=0;
		   int c3=0;
		   String c11="";
		   String c22="";
		   String c33="";
		   if(!te1.isEmpty()){
			   c1=te1.get(0).getFcount();
			   c11=te1.get(0).getFlevel();
		   }
		   if(!te2.isEmpty()){
			   c2=te2.get(0).getFcount();
			   c22=te2.get(0).getFlevel(); 
		   }
		   if(!te3.isEmpty()){
			   c3=te3.get(0).getFcount();
			   c33=te3.get(0).getFlevel(); 
		   }
		   out.print(c1+","+c2+","+c3+","+c11+","+c22+","+c33);
		   System.out.println(c1+","+c2+","+c3+","+c11+","+c22+","+c33);
	       }

	   } catch (IOException e) {
			e.printStackTrace();
		} 
		 return null;
     }
		
   
   
   /**
	 * @see 显示列表页
	 * @author运动图表
	 */
  public String showAnalysis(){
	    PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
	    response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		String xm = getHttpRequest().getParameter("xm");
	    PrintWriter out;
	    //011001 坐位体前屈
	    //011003 仰卧起坐
		//011002 跳绳
	    Map<String, Object> user = new HashMap<String, Object>();
	    try {
	    	List<TExerciseVO> list1=tExerciseService.searchByALL(xm,ps.getStudentFuid());//011001
	 	    //List<TExerciseVO> list2=tExerciseService.searchByALL(xm,ps.getStudentFuid());//011003
	 	    //List<TExerciseVO> list3=tExerciseService.searchByALL(xm,ps.getStudentFuid());//"011002
			out = response.getWriter();
			user.put("student", list1); 
			String data = JSONCreater.toJSON(user);
		    out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  return null;
  }
	
	
	
	/**
	 * @see 插入运动数据
	 * @author ysh
	 */
	public String insert(){
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		String count = getHttpRequest().getParameter("count");//运动数量
		String type = getHttpRequest().getParameter("type");//类型
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			tExercise=new TExercise();
			tExercise.setFuID(null);
			tExercise.setFcount(Integer.parseInt(count));
			tExercise.setFstatusCode(TExercise.NORMAL_STATUS);
			tExercise.setFstatusDesc(TExercise.NORMAL_STATUS_DESC);
			tExercise.setFcreateBy(ps.getStudentFuid());
			tExercise.setFcreateTime(new Date());
			tExercise.setFupdateTime(new Date());
			tExercise.setFupdateBy(ps.getStudentFuid());
			tExercise.setFtype(type);
			
			if(null!=ps){
				List<TExerciseStandard> t_list=tExerciseStandardService.search(ps.getFgrade(), ps.getFgender());
				if(t_list!=null&&t_list.size()>0){
					for(int a=0;a<t_list.size();a++){
						if(type.equals(t_list.get(a).getFtype())){
							if(tExercise.getFcount()>=t_list.get(a).getFnum()){
								tExercise.setFlevel(t_list.get(a).getFlevel());
								tExercise.setFscore(t_list.get(a).getFscore());
								break;
							}
						} 
					}
				}
				TStudent student=tStudentService.searchByID(ps.getStudentFuid());
				tExercise.settStudent(student);
				tExerciseService.createOrEdit(tExercise);//插入运动日记
				//Fscore 得分  //Flevel 等级  //数量
				out.print(tExercise.getFscore()+","+tExercise.getFlevel()+","+tExercise.getFcount());
				//创建日志
				TLog tLog=new TLog();
				tLog.setFuID(null);
				tLog.setFuserID(ps.getStudentFuid());//用户主键
				tLog.setFstatusCode(TLog.NORMAL_STATUS);
				tLog.setFstatusDesc(TLog.NORMAL_STATUS_DESC);
				tLog.setFcreateBy(ps.getStudentFuid());
				tLog.setFcreateTime(new Date());
				tLog.setFupdateTime(new Date());
				tLog.setFupdateBy(ps.getStudentFuid());
				tLog.setFactionName("insert()");
				tLog.setFuserName(ps.getStduentName()==null?"":ps.getStduentName());//用户名称
				tLog.setFdesc("插入运动数据");
				tLogService.createOrEdit(tLog);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 return null;
		
	}

	/**
	 * @throws IOException 
	 * @see 班级平均数/排名 
	 */
	public String ranking() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = response.getWriter();
		 String xm = getHttpRequest().getParameter("xm1");
		  Map<String, Object> user = new HashMap<String, Object>();
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		String  c1="";
		if(null!=ps){
			List<TExercise> te1=tExerciseService.searchByTady(xm, ps.getStudentFuid());//坐位体前屈
			  if(!te1.isEmpty()){
				   c1=te1.get(0).getFcount().toString();
				  
			   }
			TRankingVO ls=tExerciseService.searchByst(ps.getFgradeFuid(),ps.getFgender(),xm, c1);
			user.put("student", ls); 
			String data = JSONCreater.toJSON(user);
		    out.print(data);
		    System.out.println(data);
		}
		

		 return null;
	}
	
	
	
	

	public TExercise gettExercise() {
		return tExercise;
	}


	public void settExercise(TExercise tExercise) {
		this.tExercise = tExercise;
	}


	public TExerciseStandard gettExerciseStandard() {
		return tExerciseStandard;
	}


	public void settExerciseStandard(TExerciseStandard tExerciseStandard) {
		this.tExerciseStandard = tExerciseStandard;
	}


	public TAverage gettAverage() {
		return tAverage;
	}


	public void settAverage(TAverage tAverage) {
		this.tAverage = tAverage;
	}

	public TLog gettLog() {
		return tLog;
	}

	public void settLog(TLog tLog) {
		this.tLog = tLog;
	}
	
	
	
	

}
