package com.begin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.json.simple.JSONObject;

public class ImgUploadAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;

  public String imgUpload()
  {
    ActionContext ac = ActionContext.getContext();
    HttpServletResponse response = (HttpServletResponse)ac.get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
    HttpServletRequest request = (HttpServletRequest)ac.get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");

    PrintWriter out = null;
    try {
      out = response.getWriter();
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    String savePath = ServletActionContext.getServletContext().getRealPath("/") + "attached/";

    String saveUrl = request.getContextPath() + "/attached/";

    HashMap extMap = new HashMap();
    extMap.put("image", "gif,jpg,jpeg,png,bmp");
    extMap.put("flash", "swf,flv");
    extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
    extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

    long maxSize = 1000000L;

    response.setContentType("text/html; charset=UTF-8");

    if (!ServletFileUpload.isMultipartContent(request)) {
      out.println(getError("请选择文件。"));
      return null;
    }

    File uploadDir = new File(savePath);
    if (!uploadDir.isDirectory()) {
      out.println(getError("上传目录不存在。"));
      return null;
    }

    if (!uploadDir.canWrite()) {
      out.println(getError("上传目录没有写权限。"));
      return null;
    }

    String dirName = request.getParameter("dir");
    if (dirName == null) {
      dirName = "image";
    }
    if (!extMap.containsKey(dirName)) {
      out.println(getError("目录名不正确。"));
      return null;
    }

    savePath = savePath + dirName + "/";
    saveUrl = saveUrl + dirName + "/";
    File saveDirFile = new File(savePath);
    if (!saveDirFile.exists()) {
      saveDirFile.mkdirs();
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String ymd = sdf.format(new Date());
    savePath = savePath + ymd + "/";
    saveUrl = saveUrl + ymd + "/";
    File dirFile = new File(savePath);
    if (!dirFile.exists()) {
      dirFile.mkdirs();
    }

    FileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    upload.setHeaderEncoding("UTF-8");
    MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)request;

    String fileName = wrapper.getFileNames("imgFile")[0];

    File file = wrapper.getFiles("imgFile")[0];

    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    if (!Arrays.asList(((String)extMap.get(dirName)).split(",")).contains(fileExt)) {
      out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + (String)extMap.get(dirName) + 
        "格式。"));
      return null;
    }

    if (file.length() > maxSize) {
      out.println(getError("上传文件大小超过限制。"));
      return null;
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    String newImgName = df.format(new Date()) + "_" + 
      new Random().nextInt(1000) + "." + fileExt;
    byte[] buffer = new byte[1024];
    try
    {
      FileOutputStream fos = new FileOutputStream(savePath + "/" + newImgName);
      InputStream in = new FileInputStream(file);
      int num = 0;
      while ((num = in.read(buffer)) > 0) {
        fos.write(buffer, 0, num);
      }
      in.close();
      fos.close();
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    JSONObject obj = new JSONObject();
    obj.put("error", Integer.valueOf(0));
    obj.put("url", saveUrl + "/" + newImgName);
    out.println(obj.toJSONString());
    return null;
  }

  private String getError(String message) {
    JSONObject obj = new JSONObject();
    obj.put("error", Integer.valueOf(1));
    obj.put("message", message);
    return obj.toJSONString();
  }
}