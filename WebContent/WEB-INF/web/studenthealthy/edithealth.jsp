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
    <script language="javascript" type="text/javascript" src="<%=basePath%>/js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script>
		function save(){
			 //alert("aaa"+$("#cc").combobox("getValue"));
			if($.trim($("#fname").val())==""){
					alert("姓名不能为空！");
					return false;
				}else if($.trim($("#fgrade").val())==""){
					alert("性别不能为空！");
					return false;
				}else if($.trim($("#fno").val())==""){
					alert("学号不能为空！");
					return false;
				}else if($.trim($("#fparentname").val())==""){
					alert("家长姓名不能为空！");
					return false;
				}else if($.trim($("#fparentphone").val())==""){
					alert("家长手机不能为空！");
					return false;
				}else if($.trim($("#fpw").val())==""){
					alert("登录密码不能为空！");
					return false;
				}  else{
				     var myform=$("#myform");
			         myform.attr("action","<%=basePath%>tstudenthealthy/createOrEditTStudent");
				     myform.submit();
				
				}
			
		}
		function resetB(){
			//$("#myform").find(("input[type='text']")).val("");
			  $("#fname").textbox('setValue',"");
			  $("#fgrade").textbox('setValue',"");
			  $("#fno").textbox('setValue',"");
			  $("#fparentname").textbox('setValue',"");
			  $("#fparentphone").textbox('setValue',"");
			  $("#fpw").textbox('setValue',"");
			
			
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
	
	</script>
  </head>
  
  <body>
  <div style="width:auto;height:auto;" closed="true" buttons="#dlg-buttons">
    <div class="ftitle">学生信息</div>
	<form id="myform" action="" method="post" ENCTYPE="multipart/form-data"> 
        	 <s:hidden name="student.fuID" value="%{student.fuID}"></s:hidden>
   
			<div class="fitem">
				<label>姓名：</label>
				<input type="text" class="easyui-textbox" value="${student.fname}" id="fname" name="student.fname" >
			</div>
			<div class="fitem">
				<label>姓别：</label>
				<input type="text" class="easyui-textbox" value="${student.fgender}" id="fgrade" name="student.fgender" >
			</div>
			<div class="fitem">
				<label>学号：</label>
				<input type="text" class="easyui-textbox" value="${student.fno}" id="fno" name="student.fno">
			</div>
			<div class="fitem">
				<label>出生日期：</label>
				<input  class="dfinput tfinput"  value="${student.fbirth}" name="student.fbirth" id="d11" type="text" onClick="WdatePicker()"/>
			</div>
			<div class="fitem">
				<label>家长姓名：</label>
				<input type="text" class="easyui-textbox" value="${student.fparentname}" id="fparentname" name="student.fparentname" >
			</div>
			<div class="fitem">
				<label>家长手机：</label>
            <input type="text" class="easyui-textbox" value="${student.fparentphone}" id="fparentphone" name="student.fparentphone">
			</div>
			<div class="fitem">
				<label>登录密码：</label>
            <input type="text" class="easyui-textbox" value="${student.fpw}" id="fpw" name="student.fpw">
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
