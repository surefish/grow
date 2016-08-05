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
   	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
  </head>
  
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">操作管理</a></li>
	    </ul>
    </div>
	<form id="saveForm" action="<%=basePath%>sysAction/createOrEditAction" method="post" >
		<div class="formbody">
    
	    <div class="formtitle"><span>操作信息</span></div>
	    
	    <ul class="forminfo">
				<s:hidden name="sysAction.fuID" value="%{sysAction.fuID}"></s:hidden>
				<li>
					<label>操作编码：</label>
					<input type="text" class="dfinput" value="${sysAction.factionId}" placeholder="" id="fuserId" name="sysAction.factionId" >
					<i> </i>
				</li>
				<li>
					<label>操作名称</label>
					<input type="text" class="dfinput" value="${sysAction.factionName}" placeholder="" id="fuserName" name="sysAction.factionName">
					<i> </i>
				</li>
	            <li>
					<label>操作地址</label>
					<input type="text" class="dfinput" value="${sysAction.furl}" placeholder="" id="furl" name="sysAction.furl">
					<i> </i>
				</li>
				<li>
					<label>操作描述</label>
					<input type="text" class="dfinput" value="${sysAction.fdesc}" placeholder="" id="fdesc" name="sysAction.fdesc">
					<i> </i>
				</li>
				

				<li>
					<label></label>
					<input class="btn" type="button"  onclick="goSubmit();" value="提交">
					<input class="btn" type="button" value="取消" onclick="javascript:history.back();">
				</li>
			</ul>
			</div>
		</form>
		
				<script type="text/javascript">
		  function goSubmit(){
		  if($.trim($("#fuserId").val())==""){
					alert("操作编码不能为空！");
					return false;
				}else if($.trim($("#fuserName").val())==""){
					alert("操作名称不能为空！");
					return false;
				}else if($.trim($("#furl").val())==""){
					alert("操作地址不能为空！");
					return false;
				}else if($.trim($("#fdesc").val())==""){
					alert("操作描述不能为空！");
					return false;
				}else{
				 document.getElementById("saveForm").submit();
				}
		  
		  }
		
		
		
		</script>
	</body>
</html>
