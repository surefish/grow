package com.begin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class FileUploadAction extends ActionSupport {

	private String username;
	private File uploadFile;
	private String uploadFileFileName;

   
	
	public String goUpload() {

		return SUCCESS;
	}

	public String myUpload() throws Exception {
		System.out.println("username=" + username);
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		//String root1="C:\\Users\\Administrator\\Desktop\\upload";
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

		System.out.println("上传完成！");

		return SUCCESS;
	}
	
	
	public String goExcl() {

		return SUCCESS;
	}
	private File upload;
	public final Log logger = LogFactory.getLog(getClass()); //日志
	private String message;
	private String uploadFileName;
	/**
	 * 会员导入
	 * @return
	 */
	public String importDataforSql() {
		
		try{
			File savePath = new File(ServletActionContext.getServletContext().getRealPath("//temp"));
			if (!savePath.exists()) {
				savePath.mkdirs();
			}
			System.out.println("savePath="+savePath);
			String types = uploadFileName.substring(uploadFileName.lastIndexOf("."),
					uploadFileName.length());    //文件类型
			String uuid = UUID.randomUUID().toString();
			
			if (".xls".equals(types.toLowerCase())) {
				//文件上传
				//FileUtil.copyFile(upload, new File(savePath + "/" + uuid + ".xls"));
				InputStream is = new FileInputStream(upload);

				OutputStream os = new FileOutputStream(new File(savePath,
						"/" + uuid + ".xls"));

				byte[] buffer = new byte[500];
				int length = 0;

				while (-1 != (length = is.read(buffer, 0, buffer.length))) {
					os.write(buffer);
				}

				os.close();
				is.close();
			}
		
			//读取文件
			File file = new File(savePath + "/" + uuid + ".xls");
			if(null!=file){
				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFSheet sheet = wb.getSheetAt(0);
				
				List<String> temp=new ArrayList<String>();
				List<String> companyNames=new ArrayList<String>();
				List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
				Iterator<Row> ir = sheet.rowIterator();
				//遍历每一行
				while (ir.hasNext()) {
					Map<String, String> columnMap = new HashMap<String, String>();
					for (Cell cell : ir.next()) {
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							columnMap.put(cell.getColumnIndex() + "", new Double(cell.getNumericCellValue()).toString());
						} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							columnMap.put(cell.getColumnIndex() + "", cell.getStringCellValue());
						}
						resultList.add(columnMap);
						temp.add(columnMap.get("3")+columnMap.get("4"));
						companyNames.add(columnMap.get("3"));
					}

				}	
			
				for (Map<String, String> map : resultList){
						for (String key : map.keySet()) {
							if (key.equals("0")) {
								System.out.println(map.get(key));
								
							}else if (key.equals("1")) {
								System.out.println(map.get(key));
							}else if (key.equals("2")) {
								System.out.println(map.get(key));
							}else if (key.equals("3")) {
								System.out.println(map.get(key));
							}else if (key.equals("4")) {
								System.out.println(map.get(key));
							}else if (key.equals("5")) {
								System.out.println(map.get(key));
							}else if (key.equals("6")) {
								System.out.println(map.get(key));
							}else if (key.equals("7")) {
								System.out.println(map.get(key));
							}else if (key.equals("8")) {
								System.out.println(map.get(key));
							}else if (key.equals("9")) {
								System.out.println(map.get(key));
							}else if (key.equals("10")) {
								System.out.println(map.get(key));
							}else if (key.equals("11")) {
								System.out.println(map.get(key));
							}else if (key.equals("12")) {
								System.out.println(map.get(key));
							}else if (key.equals("13")) {
								System.out.println(map.get(key));
							}
						
						}
				message="导入成功";
			}
			}}catch(Exception e){
			logger.fatal(e);
			e.printStackTrace();
			message="导入失败";
		}
		
		return SUCCESS;
	}

	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
	

}