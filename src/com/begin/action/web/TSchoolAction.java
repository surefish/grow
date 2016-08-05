package com.begin.action.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.bean.SysUser;
import com.begin.bean.TSchool;
import com.begin.service.TSchoolService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.TSchoolVO;
import com.opensymphony.xwork2.Preparable;

public class TSchoolAction extends BaseAction implements Preparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TSchool school;

	@Resource
	private TSchoolService tSchoolService;

    //学校列表
	private ListInfo<TSchool> listTSchools;
	
	private File uploadFile;
	private String uploadFileFileName;
	
	/**
	 * tschool列表
	 * 
	 * @return
	 */
	public String listTSchool() {
		
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}
		listTSchools=tSchoolService.searchAll(currentPageNO, pageSize);
		
		return SUCCESS;
	}
	/**
	 * tschool列表json
	 * 
	 * @return
	 */
	public String tSchoolJson(){
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        listTSchools=tSchoolService.searchAll(intPage, number);
		List<TSchoolVO> tvo=new ArrayList();
		for(TSchool ts:listTSchools.getCurrentList()){
			TSchoolVO ts1=new TSchoolVO();
			ts1.setFuID(ts.getFuID());
			ts1.setFname(ts.getFname());//学校名称
			ts1.setFaccount(ts.getFaccount());////账号
			ts1.setFpw(ts.getFpw());//密码
			ts1.setFareacode(ts.getFareacode());//行政区划
			if(ts.getFintro().length()>20){
				ts1.setFintro(ts.getFintro().subSequence(0, 20).toString()+"...");//介绍	
			}else{
				ts1.setFintro(ts.getFintro());//介绍	
			}
			ts1.setFschoolurl(ts.getFschoolurl());//学习图片
			tvo.add(ts1);
		}
		  int total=listTSchools.getSizeOfTotalList();//总记录数
			Map<String, Object> map = new HashMap<String, Object>();   
			map.put("total", total);
			map.put("rows",tvo);
			json=JSONCreater.toJSON(map);
			System.out.println(json);
			return "json";
	}
	

	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddTSchool(){
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getTSchoolID(){
		String tschoolID = getHttpRequest().getParameter("tschoolID");
		school=tSchoolService.searchByID(tschoolID);
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditTSchool() throws Exception {
    	if (!"".equals(school.getFuID())&&null!=school.getFuID()){
    		school= tSchoolService.searchByID(school.getFuID());
		  }
	}
    /**
	 * 创建及修改学校
	 * 
	 * @return
	 */
	public String createOrEditTSchool()throws Exception{
		if ("".equals(school.getFuID()) || null == school.getFuID()) {
			school.setFuID(null);
			school.setFcreateBy("ysh");
			school.setFcreateTime(new Date());
			school.setFupdateBy("ysh");
			school.setFupdateTime(new Date());
			school.setFstatusCode(SysUser.NORMAL_STATUS);
			school.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);

		} else {
			school.setFupdateTime(new Date());
			school.setFupdateBy("ysh");
		}
		        //文件上传
				String root = ServletActionContext.getServletContext().getRealPath(
						"/uploadschool");
				String path=ServletActionContext.getRequest().getContextPath();
				
				 File dir = new File(root); 
		         if(!dir.exists())
		         {
		              dir.mkdir();
		         }
				//String root1="C:\\Users\\Administrator\\Desktop\\upload";
				//String root2="D:\\myupload";
				InputStream is = new FileInputStream(uploadFile);
				OutputStream os = new FileOutputStream(new File(root,
						uploadFileFileName));

				byte[] buffer = new byte[500];
				int length = 0;

				while (-1 != (length = is.read(buffer, 0, buffer.length))) {
					os.write(buffer);
				}

				os.close();
				is.close();
				school.setFschoolurl(path+"/uploadschool/"+uploadFileFileName);
		        tSchoolService.createOrEdit(school);
		        System.out.println("上传完成！");
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除学校
	 * 
	 * @return
	 */
	public String deleteTSchool(){
		String tschoolID = getHttpRequest().getParameter("tschoolID");
		tSchoolService.deleteByschoolID(tschoolID);
		return SUCCESS;
	}
    
	
	




	public TSchool getSchool() {
		return school;
	}


	public void setSchool(TSchool school) {
		this.school = school;
	}


	public ListInfo<TSchool> getListTSchools() {
		return listTSchools;
	}


	public void setListTSchools(ListInfo<TSchool> listTSchools) {
		this.listTSchools = listTSchools;
	}


	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	

}
