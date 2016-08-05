<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <body>
   <form action="<%=basePath%>goUpload/myUpload.action" method="post" enctype="multipart/form-data">
               username:<s:textfield name="username"></s:textfield>
                <br />
			   <s:file name="uploadFile"></s:file>
			   <br />
			  <s:submit value="提交"></s:submit>
   </form>
	</body>
  </body>
</html>
