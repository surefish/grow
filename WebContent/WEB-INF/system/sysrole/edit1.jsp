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
    <li><a href="#">角色管理</a></li>
    </ul>
    </div>
	<form id="saveForm" action="<%=basePath%>sysRole/createOrEditRole" method="post">
		<div class="formbody">
    
	    <div class="formtitle"><span>角色信息</span></div>
	    
	    <ul class="forminfo">
				<s:hidden name="sysRole.fuID" value="%{sysRole.fuID}"></s:hidden>
				<li>
					<label>角色名称：</label>
					<input type="text" class="dfinput" value="${sysRole.frolename}" placeholder="" id="frolename" name="sysRole.frolename">
					<i> </i>
				</li>
				<li>
					<label>备注</label>
					<input type="text" class="dfinput" value="${sysRole.fdesc}" placeholder="" id="fdesc" name="sysRole.fdesc">
					<i> </i>
				</li>
	

				<li>
					<label></label>
					<input class="btn" type="button" onclick="goSubmit();" value="提交" >
					<input class="btn" type="button" value="取消" onclick="javascript:history.back();" >
					<i></i>
				</li>
			</ul>
			</div>
		</form>
		<script type="text/javascript">
		
		  function goSubmit(){
				if($.trim($("#frolename").val())==""){
					alert("角色名称不能为空！");
					return false;
				}else if($.trim($("#fdesc").val())==""){
					alert("备注不能为空！");
					return false;
				}else{
				
				document.getElementById("saveForm").submit();
				
				}
				
			};
		
		</script>
	</body>
</html>
