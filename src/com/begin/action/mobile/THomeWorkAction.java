package com.begin.action.mobile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
import com.begin.action.mobile.vo.QSurveyVO;
import com.begin.bean.TAdministrator;
import com.begin.bean.THomeWork;
import com.begin.bean.TPhoto;
import com.begin.service.TAdministratorService;
import com.begin.service.THomeWorkService;
import com.begin.util.JSONCreater;
import com.begin.vo.TAdministratorVO;
import com.begin.vo.THomeWorkVO;
import com.gh.common.FileUpload;

public class THomeWorkAction extends BaseAction{
	
	/*作业表*/
    private THomeWork tHomeWork;
    
    @Resource
	private THomeWorkService tHomeWorkService;
    /*老师管理者*/
    private TAdministrator tAdministrator;
    @Resource
	private TAdministratorService tAdministratorService;
    
    
    /*文本类作业*/
    public String addHomeWorktext() throws ParseException{
    	
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 out = ServletActionContext.getResponse().getWriter();
			 String adminfuid = getHttpRequest().getParameter("fuid");
			 String testMy = getHttpRequest().getParameter("testMy");//内容
			 String ftype = getHttpRequest().getParameter("ftype");//类别
			 String infotime = getHttpRequest().getParameter("infotime");//失效时间
			 String fclassuid = getHttpRequest().getParameter("fclassuid");//班级主键
			 
			 Date d=dateFormat.parse(infotime.toString());
			 
			    THomeWork t=new THomeWork();
			    t.setFuID(null);
				t.setFstatusCode(THomeWork.NORMAL_STATUS);
				t.setFstatusDesc(THomeWork.NORMAL_STATUS_DESC);
				t.setFcreateBy(adminfuid);
				t.setFcreateTime(new Date());
				t.setFupdateTime(new Date());
				t.setFupdateBy(adminfuid);
				t.setFdminfuid(adminfuid);//布置人主键
				t.setFcontent(testMy);
				t.setFtype(ftype);//类别
				t.setFlastTime(d);//失效时间
				t.setFclassuid(fclassuid);//班级主键
				tHomeWorkService.createOrEdit(t);
				
			    out.print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    
    
    
    
    private File[] img;
	private String[] imgFileName;
	/**
	 * @see 图片上传
	 * @return
	 * @throws IOException
	 * @throws ParseException 
	 */
	public String uploadImgst() throws IOException, ParseException { 
		 String fuid = getHttpRequest().getParameter("fuid");//老师主键
		 String ftype = getHttpRequest().getParameter("ftype");//类别
		 String infotime = getHttpRequest().getParameter("infotime");//失效时间、
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String fclassuid = getHttpRequest().getParameter("fclassuid");//班级主键
		 Date d=dateFormat.parse(infotime.toString());
		//PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
        if(request.getHeader("content-type")!=null&&"application/x-www-form-urlencoded".equals(request.getHeader("content-type"))){
            return null;//不支持断点续传，直接返回null即可
        }
        String studulr="/upload/studHomeWorkImage/";
        FileUpload fileUpload=new FileUpload();
        List<String> imgList= fileUpload.inFile(img,studulr.toString(), imgFileName);
       
        if(imgList!=null&&imgList.size()>0){
        	THomeWork t=new THomeWork();
            t.setFuID(null);
            t.setFstatusCode(THomeWork.NORMAL_STATUS);
    		t.setFstatusDesc(THomeWork.NORMAL_STATUS_DESC);
    		t.setFcreateBy(fuid);
			t.setFcreateTime(new Date());
			t.setFupdateTime(new Date());
			t.setFupdateBy(fuid);
			t.setFdminfuid(fuid);//布置人主键
			t.setFnamejpg(imgList.get(0));//照片名
    		t.setFurl("newbegin/upload/studHomeWorkImage/"+imgList.get(0));
    		t.setFdminfuid(fuid);//布置人主键
    		t.setFcontent("照片作业");
			t.setFtype(ftype);//类别
			t.setFlastTime(d);//失效时间
		    t.setFclassuid(fclassuid);//班级主键
			tHomeWorkService.createOrEdit(t);
            System.out.println("今日作业照片："+imgList.get(0));
        }
 
      return null;
	
	}
    
    
    
    /*学生查看作业*/
    public String studLokWork() throws ParseException{
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 out = ServletActionContext.getResponse().getWriter();
			 Map<String, Object> user = new HashMap<String, Object>();
			 String ftype = getHttpRequest().getParameter("ftype");
			 List<THomeWork> lworks=tHomeWorkService.seachbywork(ftype);
			 List<THomeWorkVO> list=new ArrayList();
			 for(THomeWork th:lworks){
				 THomeWorkVO tvo=new THomeWorkVO();
				 tvo.setFuID(th.getFuID());
				 tvo.setFcreateTime(dateFormat.format(th.getFcreateTime()).toString());
				 if(null!=th.getFurl()&&!"".equals(th.getFurl())){
					 tvo.setFnamejpg(th.getFnamejpg());
					 tvo.setFurl(th.getFurl());
				 }
				 tvo.setFcontent(th.getFcontent());//内容
                 if(ps.getFgradeFuid().equals(th.getFclassuid())){
                	 list.add(tvo);
				 } 
			 }
			    user.put("student", list);
				String data = JSONCreater.toJSON(user);
				out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    
    

    /*学生查看作业*/
    public String workInfo() throws ParseException{
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 out = ServletActionContext.getResponse().getWriter();
			 Map<String, Object> user = new HashMap<String, Object>();
			 String fuid = getHttpRequest().getParameter("fuid");
			     THomeWork th=tHomeWorkService.searchByID(fuid);
				 THomeWorkVO tvo=new THomeWorkVO();
				 tvo.setFuID(th.getFuID());
				 tvo.setFcreateTime(dateFormat.format(th.getFcreateTime()).toString());
				 tvo.setFlastTime(dateFormat.format(th.getFlastTime()).toString());
				 tvo.setFcontent(th.getFcontent());//内容
				 if(null!=th.getFurl()&&!"".equals(th.getFurl())){
					 tvo.setFnamejpg(th.getFnamejpg());
					 tvo.setFurl(th.getFurl());
				 }
			    user.put("student", tvo);
				String data = JSONCreater.toJSON(user);
				out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    
    
    
    
    
	public THomeWork gettHomeWork() {
		return tHomeWork;
	}
	public void settHomeWork(THomeWork tHomeWork) {
		this.tHomeWork = tHomeWork;
	}
	public TAdministrator gettAdministrator() {
		return tAdministrator;
	}
	public void settAdministrator(TAdministrator tAdministrator) {
		this.tAdministrator = tAdministrator;
	}














	public File[] getImg() {
		return img;
	}














	public void setImg(File[] img) {
		this.img = img;
	}














	public String[] getImgFileName() {
		return imgFileName;
	}














	public void setImgFileName(String[] imgFileName) {
		this.imgFileName = imgFileName;
	}
    
    
    
    
	
	
    

}
