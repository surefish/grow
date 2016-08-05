<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会员导入</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
</head>

</head>

<body>
<s:hidden id="message" name="message" />
<div class="clr"></div>
<div class="tab_a">
	<table width="100%" id="tInfo">
    	<tr class="title_t">
        	<td colspan="7" align="center">
        		<span>导入数据</span>
        	</td>
  	 	</tr>
		 <form action="<%=basePath%>goUpload/importDataforSql.action"  id="saveForm" method="post" enctype="multipart/form-data">
			<div>
				<table width="100%" border="1" cellpadding="5" cellspacing="0" bordercolor="#eeeeee" class="tabBor3">
				  <tr>
				    <td align="center">请导入Excel 2003格式的文件</td>
				  </tr>
				  <tr>
				    <td align="center">
				    	<input type="file" id="uploades" name="upload"/>
				    </td>
				  </tr>
				  <tr>
				    <td align="center">
				    	<input type="button" id="btn_ok" value="确定"  onclick="uploadExcel();"/>
				    </td>
				  </tr>
				</table>
				<div class="clr"></div>
				
			</div>
		</form>
	</table>
</div>
		
		
</body>
<SCRIPT type="text/javascript">
	var message=document.getElementById("message").value;
	if(message!=""){
		alert(message);
	}

    function uploadExcel(){
	    var	uploades=document.getElementById("uploades").value;
	    if(uploades==""){
	    	alert("请选择文件!");
	    }else{
	    	document.getElementById("btn_ok").style.display="none";
	    	document.getElementById("saveForm").submit();
      	}
    }
</SCRIPT>
</html>