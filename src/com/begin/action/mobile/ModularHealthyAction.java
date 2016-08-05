package com.begin.action.mobile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.TNewsVO;
import com.begin.bean.SysUser;
import com.begin.bean.TNews;
import com.begin.bean.TStudent;
import com.begin.service.TNewsService;
import com.begin.service.TStudentService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;

/*健康首页 标题+图片*/
@SuppressWarnings("serial")
public class ModularHealthyAction extends BaseAction implements Preparable {

	
	
	
	private TNews myNew;

	@Resource
	private TNewsService tNewsService;
	

	//健康首页
	private ListInfo<TNews> listTNews;
	
	
	
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

		/**
		 * @throws IOException 
		 * @健康
		 */

		public String modHealthy() throws IOException{	
			 response.setContentType("text/json");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out;
			 out = ServletActionContext.getResponse().getWriter();
			 Map<String, Object> user = new HashMap<String, Object>();
			 TNewsVO tvo=new TNewsVO();
			 listTNews = tNewsService.searchBycatalog(new String[]{"3"}, TNews.NORMAL_STATUS,
						1, 5);
			if(listTNews.getSizeOfTotalList()>0){
				TNews tn=listTNews.getCurrentList().get(0);
				tvo.setFuID(tn.getFuID());//主键
				tvo.setFtitle(tn.getFtitle());//大标题
				tvo.setFtag(tn.getFtag());//小标题
				tvo.setFimagesurl(tn.getFimagesurl());//图片路径
			}
			    user.put("student", tvo);
				String data = JSONCreater.toJSON(user);
				out.print(data);
			return null;
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

}
