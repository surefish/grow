<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id = request.getParameter("id");
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script>
		function save(){
			 //alert("aaa"+$("#cc").combobox("getValue"));
			if($.trim($("#fuserId").val())==""){
					alert("用户ID不能为空！");
					return false;
				}else if($.trim($("#fuserName").val())==""){
					alert("用户名不能为空！");
					return false;
				}else if($.trim($("#fpassWord").val())==""){
					alert("用户密码不能为空！");
					return false;
				}else if($.trim($("#fphone").val())==""){
					alert("手机号不能为空！");
					return false;
				}else if(!isEmail()){
				
					return false;
					
				}else if ($.trim($("#cc").combobox("getValue")) == "请选择") {
				
				alert("请选择角色！");
				return false;
			} else{
			        $("#dthFUID").val($("#cc").combobox("getValue"));
				     var myform=$("#myform");
			         myform.attr("action","<%=basePath%>sysUser/createOrEditUser");
				   myform.submit();
				
				}
			
		}
		function resetB(){
			//$("#myform").find(("input[type='text']")).val("");
			  $("#fuserId").textbox('setValue',"");
			  $("#fuserId").textbox('setValue',"");
			  $("#fuserName").textbox('setValue',"");
			  $("#fpassWord").textbox('setValue',"");
			  $("#fphone").textbox('setValue',"");
			  $("#femail").textbox('setValue',"");
			
			
		}
		function re(){
			window.location.href="javascript:history.back();";
		}
		$(document).ready(function() {
			  $("#fpassWord").textbox('setValue',"");
		});
		function SetSubID() {
			$("#dthFUID").val($("#cc").combobox("getValue"));//选择的角色
		}
		/** 
		 *邮箱验证
		 */
		function isEmail(){
	   		var str = jQuery("#femail").val();
	   		var regEx = /^[A-Za-z\d]+([-_\.\+]*[A-Za-z\d])*@([A-Za-z\d][A-Za-z\d-]{0,61}[A-Za-z\d]\.)+[A-Za-z\d]{2,6}$/;
	   		if($("#email").val()==""){
				alert("邮箱地址不能为空");
				return false;
			}else if (!regEx.test(str)) {
	    		alert("邮箱地址不正确");
	        	return false;
	    	}
	   		return true;
	   	}
	</script>
  </head>
  
  <body>
  <div style="width:auto;height:auto;" closed="true" buttons="#dlg-buttons">
    <div class="ftitle">用户信息</div>
	<form id="myform" action="" method="post" ENCTYPE="multipart/form-data"> 
        	 <s:hidden name="sysUser.fuID" value="%{sysUser.fuID}"></s:hidden>
    <s:hidden name="userRoleId" id="dthFUID" value=""></s:hidden>
			<div class="fitem">
				<label>用户ID：</label>
				<input type="text" class="easyui-textbox" id="fuserId" name="sysUser.fuserId" value="${sysUser.fuserId}" >
			</div>
			<div class="fitem">
				<label>用户名：</label>
				<input type="text" class="easyui-textbox" id="fuserName" name="sysUser.fuserName"  value="${sysUser.fuserName}" >
			</div>
			<div class="fitem">
				<label>密码：</label>
				<input type="text" class="easyui-textbox" id="fpassWord" name="sysUser.fpassWord" value="${sysUser.fpassWord}" >
			</div>
			<div class="fitem">
				<label>手机：</label>
				<input type="text" class="easyui-textbox" id="fphone" name="sysUser.fphone" value="${sysUser.fphone}" >
			</div>
			<div class="fitem">
				<label>邮箱：</label>
				<input type="text" class="easyui-textbox" id="femail" name="sysUser.femail" value="${sysUser.femail}" >
			</div>
			<div class="fitem">
				<label>角色：</label>
             <input  class="easyui-combobox" data-options="editable:false"  onchange="SetSubID();" value="请选择" id="cc" name="mallId" url="<%=basePath%>sysUser/goRoleJson" valueField="id" textField="text"  panelHeight="auto"/>

				
			</div>
			<br />
			<div id="dlg-buttons" class="fitem">
            	<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
            	<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-reload" onclick="resetB()" style="width:90px">重置</a>
            	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="re()" style="width:90px">返回</a>
			</div>
	</form>
	</div>
  </body>
</html>
