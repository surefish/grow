package com.begin.action.mobile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.TNewsVO;
import com.begin.bean.SysUser;
import com.begin.bean.TNews;
import com.begin.bean.TNewsClass;
import com.begin.bean.TStudent;
import com.begin.service.TNewsClassService;
import com.begin.service.TNewsService;
import com.begin.service.TStudentService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;

/*安全首页 标题+图片*/
@SuppressWarnings("serial")
public class ModularSecurityAction extends BaseAction implements Preparable {

	
	
	private TNews myNew;

	@Resource
	private TNewsService tNewsService;
	

	//健康首页
	private ListInfo<TNews> listTNews;
	
	@Resource
	private TNewsClassService tNewsClassService;
	
	private TNewsClass tNewsClass;
	
	@Resource
	private TStudentService tStudentService;


	private List<TStudent> listStudents;
	
	private File uploadFile;
	private String uploadFileFileName;
	
	/*健康模块*/
	/**catalog
	 * 1代表 安全
	 * 2代表快乐
	 * 3代表健康
	 */
	
    /***web端开始*********************************************************************************/
	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTNews() {

		//402881e453f87c180153f87c6df00000 眼球的结构
		//402881e453f87c180153f87c6e1a0001 近视的类型及原因
		//402881e453f87c180153f87c6e240002 近视的早期征兆
		//402881e453f87c180153f87c6e3a0003 近视的预防
		//402881e453f87c180153f87c6e410004 近视的治疗
		/*
		 * <option value="5acee0c158b54bf8a2b6504f78429a35">安全首页</option>
						<option value="0a16eb9a251f4232a982464a09e83feb">快乐首页</option>
						<option value="eae82ff16dd6470f8382656f2c75f779">健康首页</option>
						<option value="2d40cec6e7454084b6755f55e68fd279">安全--急救知识库</option>
						<option value="28121e31c8b74be0b74f622d18e665b4">安全--安全科普课堂</option>
						<option value="5ccec116a27e4d5a8ba64135928b846b">安全--突发事件应对</option>
						<option value="47577afd13c84d89b073ce74400a5cc7">健康--营养饮食</option>
						<option value="f371f185c21944799b66d34c02f465d4">健康--营养指导</option>
						<option value="cb40060d4ac749b9b1b6c066eb5af58c">健康--心灵鸡汤</option>
						<option value="392379ebcb8d4d89b96d1c3967f1a59d">快乐--活动报名</option>
						<option value="4646ea2313ca4ccaad2199ceaf01fd56">快乐--快乐分享</option>
						<option value="06e2a5d36f8d4d3a847e6c1419fd2fa4">健康讲堂</option>
						<option value="402881e453f87c180153f87c6df00000">眼科--眼球的结构</option>
						<option value="402881e453f87c180153f87c6e1a0001">眼科--近视的类型及原因</option>
						<option value="402881e453f87c180153f87c6e240002">眼科--近视的早期征兆</option>
						<option value="402881e453f87c180153f87c6e3a0003">眼科--近视的预防</option>
						<option value="402881e453f87c180153f87c6e410004 ">眼科--近视的治疗</option>
		 * */
		
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if ("" == cNO || null == cNO) {
			currentPageNO = 1;
		} else {
			currentPageNO = Integer.parseInt(cNO);
		}
		
		listTNews = tNewsService.searchBycatalog(new String[]{"4646ea2313ca4ccaad2199ceaf01fd56","392379ebcb8d4d89b96d1c3967f1a59d","402881e453f87c180153f87c6df00000","402881e453f87c180153f87c6e1a0001","402881e453f87c180153f87c6e240002","402881e453f87c180153f87c6e3a0003","402881e453f87c180153f87c6e410004"},TNews.NORMAL_STATUS,currentPageNO, pageSize);

		return SUCCESS;
	}

	/**
	 * 去添加
	 * 
	 * @return
	 */
	public String goAddTNews() {

		// listTSchools=tSchoolService.searchAll(1, Integer.MAX_VALUE);

		return SUCCESS;
	}

	/**
	 * 去编辑
	 * 
	 * @return
	 */

	public String getTNewsID() {
		String tNewsID = getHttpRequest().getParameter("tNewsID");
		myNew = tNewsService.searchByID(tNewsID);

		return SUCCESS;
	}

	public void prepareCreateOrEditTNews() throws Exception {
		System.out.println(myNew.getFuID());
		if (!"".equals(myNew.getFuID()) && null != myNew.getFuID()) {
			myNew = tNewsService.searchByID(myNew.getFuID());
		}
		System.out.println(myNew.getFuID());
	}

	/**
	 * 创建及修改
	 * 
	 * @return
	 * @throws throws Exception 
	 */
	public String CreateOrEditTNews() throws Exception {
		if ("".equals(myNew.getFuID()) || null == myNew.getFuID()) {
			myNew.setFuID(null);
			myNew.setFcreateBy("ysh");
			myNew.setFcreateTime(new Date());
			myNew.setFupdateBy("ysh");
			myNew.setFupdateTime(new Date());
			myNew.setFstatusCode(SysUser.NORMAL_STATUS);
			myNew.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
		} else {
			myNew.setFupdateTime(new Date());
			myNew.setFupdateBy("ysh");

		}
		//查询类别
		tNewsClass=tNewsClassService.searchByID(myNew.getFcatalog());
		
		String tn=tNewsClass.getFuID()==null?"wz":tNewsClass.getFuID();
		String tn1="myNews\\"+tn;
		//文件上传
		
		String root = ServletActionContext.getServletContext().getRealPath("/");
		String rot1=root+tn1;
		System.out.println("root："+rot1);
		String path=ServletActionContext.getRequest().getContextPath();
		//D:\apache-tomcat-7.0.52\webapps\newbegin\;
		 File dir = new File(rot1); 
         if(!dir.exists())
         {
              dir.mkdir();
         }
         SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
         String newImgName = df.format(new Date()) + "_" + 
           new Random().nextInt(1000) + "_" + uploadFileFileName;
		//String root1="C:\\Users\\Administrator\\Desktop\\upload";
		//String root2="D:\\myupload";
		InputStream is = new FileInputStream(uploadFile);
		OutputStream os = new FileOutputStream(new File(rot1,
				newImgName));

		byte[] buffer = new byte[500];
		int length = 0;

		while (-1 != (length = is.read(buffer, 0, buffer.length))) {
			os.write(buffer);
		}

		os.close();
		is.close();
       
		System.out.println("上传完成！");
		myNew.setFimagesurl(path+"/myNews/"+tn+"/"+newImgName);
		tNewsService.createOrEdit(myNew);
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTNews() {
		String tNewsID = getHttpRequest().getParameter("tNewsID");
		tNewsService.deleteByID(tNewsID);
		return SUCCESS;
	}
    /***web端结束*********************************************************************************/
	
	
	
   /***手机端开始*********************************************************************************/
	/**
	 * @throws IOException 
	 * @安全
	 */

	public String modSecurity() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 TNewsVO tvo=new TNewsVO();
		 listTNews = tNewsService.searchBycatalog(new String[]{"1"}, TNews.NORMAL_STATUS,1, 5);
		if(listTNews.getSizeOfTotalList()>0){
			TNews tn=listTNews.getCurrentList().get(0);
			tvo.setFuID(tn.getFuID());//主键
			tvo.setFtitle(tn.getFtitle());//大标题
			tvo.setFtag(tn.getFtag());//小标题
			tvo.setFimagesurl(tn.getFimagesurl());//图片路径
			System.out.println("图片路径:"+tvo.getFimagesurl());
		}
		    user.put("student", tvo);
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	
	
	
	
	
	
	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public TNews getMyNew() {
		return myNew;
	}

	public void setMyNew(TNews myNew) {
		this.myNew = myNew;
	}

	public ListInfo<TNews> getListTNews() {
		return listTNews;
	}

	public void setListTNews(ListInfo<TNews> listTNews) {
		this.listTNews = listTNews;
	}

	public List<TStudent> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<TStudent> listStudents) {
		this.listStudents = listStudents;
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

	public TNewsClass gettNewsClass() {
		return tNewsClass;
	}

	public void settNewsClass(TNewsClass tNewsClass) {
		this.tNewsClass = tNewsClass;
	}
	

}

