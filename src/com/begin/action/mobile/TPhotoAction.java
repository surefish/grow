package com.begin.action.mobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;














import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.TCourseVO;
import com.begin.action.mobile.vo.TPhotoVO;
import com.begin.bean.TBookType;
import com.begin.bean.TCourse;
import com.begin.bean.TPhoto;
import com.begin.bean.TPhotoType;
import com.begin.service.TPhotoService;
import com.begin.service.TPhotoTypeService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.gh.common.FileUpload;




//照片action
public class TPhotoAction extends BaseAction{
	
	@Resource
	private TPhotoService tPhotoService;
	@Resource
	private TPhotoTypeService tPhotoTypeService;
	
	private TPhoto tPhoto;
	private ListInfo<TPhoto> listPhoto;
	
	private TPhotoType tPhotoType;
	
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 查询班级照片
	 * @throws IOException 
	 */
	public String showPhoto() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String indexPage = getHttpRequest().getParameter("indexPage");
		//班级相册 402881e453ea831b0153ea83bae00000
		//个人相册 402881e453ea831b0153ea83bb0c0001
		 List<TPhotoVO> list=new ArrayList();
		 
		 if(null!=ps&&Integer.parseInt(indexPage)<2){
			 //查询这个班级个人的照片
			 listPhoto=tPhotoService.searchByfType(null,"402881e453ea831b0153ea83bae00000", TPhoto.NORMAL_STATUS,ps.getStudentFuid(),1, Integer.MAX_VALUE);
			 if(listPhoto.getSizeOfTotalList()>0){
				 for(TPhoto t:listPhoto.getCurrentList()){
					 TPhotoVO tv=new TPhotoVO();
					 tv.setFuID(t.getFuID());//主键
					 tv.setFname(t.getFname());//照片名
					 tv.setFurl(t.getFurl());//照片路径
					 tv.setFstudentFuid(t.getFstudentFuid());//个人
					 tv.setFcreateTime(dateFormat.format(t.getFcreateTime()==null?"":t.getFcreateTime()).toString());
					 list.add(tv);
				 }
		       }
			 }
		///查询这个班级的照片
		 //每个学生查询自己班级的照片
		 listPhoto=tPhotoService.searchByfType(null,ps.getFgradeFuid(), TPhoto.NORMAL_STATUS,null,Integer.parseInt(indexPage),5);
		 if(listPhoto.getSizeOfTotalList()>0){
			 for(TPhoto t:listPhoto.getCurrentList()){
				 if(t.getFstudentFuid()==null){
					 TPhotoVO tv=new TPhotoVO();
					 tv.setFuID(t.getFuID());//主键
					 tv.setFname(t.getFname());//照片名
					 tv.setFurl(t.getFurl());//照片路径
					 tv.setFstudentFuid(null);//
					 tv.setFcreateTime(dateFormat.format(t.getFcreateTime()==null?"":t.getFcreateTime()).toString());
					 list.add(tv);
				 }
			 }
		 }
		    user.put("student", list);
		    user.put("maxPageNO", String.valueOf(listPhoto.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 查询个人照片
	 * @throws IOException 
	 */
	public String showPhotoGR() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
	   response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 //班级相册 402881e453ea831b0153ea83bae00000
		//个人相册 402881e453ea831b0153ea83bb0c0001
		 //荣誉榜 f2b7bc9554286a1e0154286bab770000
		 listPhoto=tPhotoService.searchByfType(null,"402881e453ea831b0153ea83bb0c0001", TPhoto.NORMAL_STATUS,ps.getStudentFuid(),Integer.parseInt(indexPage),5);
		 List<TPhotoVO> list=new ArrayList();
		 if(listPhoto.getSizeOfTotalList()>0){
			 for(TPhoto t:listPhoto.getCurrentList()){
				 TPhotoVO tv=new TPhotoVO();
				 tv.setFuID(t.getFuID());//主键
				 tv.setFname(t.getFname());//照片名
				 tv.setFurl(t.getFurl());//照片路径
				 tv.setFcreateTime(dateFormat.format(t.getFcreateTime()==null?"":t.getFcreateTime()).toString());
				 list.add(tv);
			 }
		 }
		    user.put("student", list);
		    user.put("maxPageNO", String.valueOf(listPhoto.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 查询荣誉榜照片
	 * @throws IOException 
	 */
	public String showPhotoRYB() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String indexPage = getHttpRequest().getParameter("indexPage");
		//班级相册 402881e453ea831b0153ea83bae00000
		//个人相册 402881e453ea831b0153ea83bb0c0001
		 //荣誉榜  f2b7bc9554286a1e0154286bab770000
		 listPhoto=tPhotoService.searchByfType(null,"f2b7bc9554286a1e0154286bab770000", TPhoto.NORMAL_STATUS,ps.getStudentFuid(),Integer.parseInt(indexPage),5);
		 List<TPhotoVO> list=new ArrayList();
		 if(listPhoto.getSizeOfTotalList()>0){
			 for(TPhoto t:listPhoto.getCurrentList()){
				 TPhotoVO tv=new TPhotoVO();
				 tv.setFuID(t.getFuID());//主键
				 tv.setFname(t.getFname());//照片名
				 tv.setFurl(t.getFurl());//照片路径
				 tv.setFcreateTime(dateFormat.format(t.getFcreateTime()==null?"":t.getFcreateTime()).toString());
				 list.add(tv);
			 }
		 }
		    user.put("student", list);
		    user.put("maxPageNO", String.valueOf(listPhoto.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	
	
	
    
    
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";  
    
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 删除个人照片
	 * @throws IOException 
	 */
	
	public String deletePhoto() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		//String fuid = getHttpRequest().getParameter("fuid");//照片主键
		String[] temp = getHttpRequest().getParameter("ids").split(",");
		for(int i=0;i<temp.length;i++){
			TPhoto tPhoto=tPhotoService.searchByID(temp[i]);
			String root = ServletActionContext.getServletContext().getRealPath("/");
			String root1=root+"upload\\studentImage\\"+ps.getFno()+"\\"+tPhoto.getFnamejpg();
			//root:=D:\apache-tomcat-7.0.52\webapps\newbegin\
	        System.out.println("图片绝对地址："+root1);
			File file = new File(root1);  
			//double totalSize = getDirSize(file);
			//System.out.println("文件大小："+totalSize);
		    // 路径为文件且不为空则进行删除  
		    if(file.isFile() && file.exists()) {  
		       file.delete();  
		    }  
			tPhotoService.deleteByID(temp[i]);
			
		}
		out.print("success");
		return null;
	}
	
	
	public static double getDirSize(File file) {     
        //判断文件是否存在     
        if (file.exists()) {     
            //如果是目录则递归计算其内容的总大小    
            if (file.isDirectory()) {     
                File[] children = file.listFiles();     
                double size = 0;     
                for (File f : children)     
                    size += getDirSize(f);     
                return size;     
            } else {//如果是文件则直接返回其大小,以“兆”为单位   
                double size = (double) file.length() / 1024 / 1024;        
                return size;     
            }     
        } else {     
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");     
            return 0.0;     
        }     
    }  
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 加入班级
	 * @throws IOException 
	 */
	
	public String addClassPhoto() throws IOException{
		
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		//String fuid = getHttpRequest().getParameter("fuid");//照片主键
		String[] temp = getHttpRequest().getParameter("idsbj").split(",");
		int yjz=0;
		int cg=0;
		for(int i=0;i<temp.length;i++){
			TPhoto tPhoto=tPhotoService.searchByID(temp[i]);
			//查询是否已经存在班级
			listPhoto=tPhotoService.searchByfType("bj"+tPhoto.getFnamejpg(),"402881e453ea831b0153ea83bae00000", TPhoto.NORMAL_STATUS,tPhoto.getFstudentFuid(),1, Integer.MAX_VALUE);
			if(listPhoto.getSizeOfTotalList()>0){
				yjz=yjz+1;
			}else{
				//生成班级中的个人相片
				TPhoto tpn=new TPhoto();
				tpn.setFuID(null);
				tpn.setFcreateBy(ps.getStudentFuid());
				tpn.setFcreateTime(tPhoto.getFcreateTime());
				tpn.setFupdateBy(ps.getStudentFuid());
				tpn.setFupdateTime(tPhoto.getFupdateTime());
				tpn.setFstatusCode(TPhoto.NORMAL_STATUS);
				tpn.setFtype("402881e453ea831b0153ea83bae00000");///类型  班级
				tpn.setFstudentFuid(tPhoto.getFstudentFuid());//学生主键
				tpn.setFname(tPhoto.getFname());
				//newbegin/upload/studentImage/330402200709060930/img635~1642810940.jpg
				String root = ServletActionContext.getServletContext().getRealPath("/");
				String root1=root+"upload\\studentImage\\"+ps.getFno()+"\\"+tPhoto.getFnamejpg();
				String root2=root+"upload\\"+ps.getFno()+"\\"+tPhoto.getFnamejpg();
				//root:=D:\apache-tomcat-7.0.52\webapps\newbegin\
		        //System.out.println("图片绝对地址："+root1);
				 copyFile(root1,root2);
				 tpn.setFurl("newbegin/upload/"+ps.getFno()+"/"+tPhoto.getFnamejpg());
				 tpn.setFnamejpg("bj"+tPhoto.getFnamejpg());
				
				tPhotoService.createOrEdit(tpn);
				cg=cg+1;
			}
		}
		out.print("分享成功"+cg+"张，已存在班级"+yjz+"张");
		return null;
	}
	
	/**
	* 复制单个文件
	* 
	* @param oldPath
	*            String 原文件路径 如：c:/fqf.txt
	* @param newPath
	*            String 复制后路径 如：f:/fqf.txt
	* @return boolean
	* @throws Exception 
	*/
	public void copyFile(String oldPath, String newPath) throws IOException {
	    try {
	        String newPathFolder = newPath.substring(0, newPath.lastIndexOf(File.separator));
	        File folder = new File(newPathFolder);
	        if (!folder.exists()){
	            folder.mkdirs();
	        }
	                int bytesum = 0;
	            int byteread = 0;
	            File oldfile = new File(oldPath);
	            if (oldfile.exists()) { // 文件存在时
	                 InputStream inStream = new FileInputStream(oldPath); // 读入原文件
	                 FileOutputStream fs = new FileOutputStream(newPath);
	                byte[] buffer = new byte[1444];
	                while ((byteread = inStream.read(buffer)) != -1) {
	                    bytesum += byteread; // 字节数 文件大小
	                    fs.write(buffer, 0, byteread);
	                }
	                inStream.close();
	                fs.close();
	             }
	    } catch (IOException e) {
	        throw new IOException(e);
	    }
	}

	
	
	
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 修改照片名
	 * @throws IOException 
	 */
	
	public String updatePhoto() throws IOException{
		
		//PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		String fuid = getHttpRequest().getParameter("fuid");//照片主键
		String fname = getHttpRequest().getParameter("fname");//照片名
		String fms = getHttpRequest().getParameter("fms");//照片描述
		
		TPhoto tPhoto=tPhotoService.searchByID(fuid);
		if(null!=tPhoto){
			tPhoto.setFname(fname);//照片名
			tPhoto.setFremark(fms);//照片描述
			tPhotoService.createOrEdit(tPhoto);
		}	
		out.print("success");
		return null;
	}
	
	private File[] img;
	private String[] imgFileName;
	/**
	 * @see 图片上传
	 * @return
	 * @throws IOException
	 */
	public String uploadImg() throws IOException { 
		String mypoType = getHttpRequest().getParameter("mypoType");
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
        if(request.getHeader("content-type")!=null&&"application/x-www-form-urlencoded".equals(request.getHeader("content-type"))){
            return null;//不支持断点续传，直接返回null即可
        }
        String studulr="/upload/studentImage/"+ps.getFno();
        FileUpload fileUpload=new FileUpload();
        List<String> imgList= fileUpload.inFile(img,studulr.toString(), imgFileName);
       
        if(imgList!=null&&imgList.size()>0){
        	TPhoto tPhoto=new TPhoto();
            tPhoto.setFuID(null);
            tPhoto.setFnamejpg(imgList.get(0));
            tPhoto.setFstatusCode(TPhoto.NORMAL_STATUS);
    		tPhoto.setFstatusDesc(TPhoto.NORMAL_STATUS_DESC);
    		tPhoto.setFcreateBy(ps.getStudentFuid());
    		tPhoto.setFcreateTime(new Date());
    		tPhoto.setFupdateTime(new Date());
    		tPhoto.setFupdateBy(ps.getStudentFuid());
    		tPhoto.setFstudentFuid(ps.getStudentFuid());
    		if("gr".equals(mypoType)){
    			tPhoto.setFname("个人");
    			tPhoto.setFtype("402881e453ea831b0153ea83bb0c0001");
    		}
    		if("ryb".equals(mypoType)){
    			tPhoto.setFname("评优加分");
    			tPhoto.setFtype("f2b7bc9554286a1e0154286bab770000");
    		}
    		tPhoto.setFurl("newbegin/upload/studentImage/"+ps.getFno()+"/"+imgList.get(0));
    	
    		tPhotoService.createOrEdit(tPhoto);
            System.out.println("个人照片名："+imgList.get(0));
        }
 
      return null;
	
	}
	
	
	/**
	 * @查看照片详情
	 */
	public String imaInfo() throws IOException{ 
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String fuid = getHttpRequest().getParameter("fuid");
		TPhoto t=tPhotoService.searchByID(fuid);
		if(null!=t){
			 TPhotoVO tv=new TPhotoVO();
			 tv.setFuID(t.getFuID());//主键
			 tv.setFname(t.getFname());//照片名
			 tv.setFurl(t.getFurl());//照片路径
			 tv.setFcreateTime(dateFormat.format(t.getFcreateTime()==null?"":t.getFcreateTime()).toString());
			 tv.setFremark(t.getFremark()==null?"":t.getFremark());//描述
			 user.put("student", tv);
			 String data = JSONCreater.toJSON(user);
			 out.print(data);
		}
		   
		return null;
	}
	
	

	public TPhoto gettPhoto() {
		return tPhoto;
	}

	public void settPhoto(TPhoto tPhoto) {
		this.tPhoto = tPhoto;
	}

	public TPhotoType gettPhotoType() {
		return tPhotoType;
	}

	public void settPhotoType(TPhotoType tPhotoType) {
		this.tPhotoType = tPhotoType;
	}




	public ListInfo<TPhoto> getListPhoto() {
		return listPhoto;
	}




	public void setListPhoto(ListInfo<TPhoto> listPhoto) {
		this.listPhoto = listPhoto;
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
