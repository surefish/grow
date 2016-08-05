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
			if($.trim($("#fname").val())==""){
					alert("姓名不能为空！");
					return false;
				}else if($.trim($("#fgender").val())==""){
					alert("性别不能为空！");
					return false;
				}else if($.trim($("#fphone").val())==""){
					alert("电话不能为空！");
					return false;
				}else if($.trim($("#faccount").val())==""){
					alert("账号不能为空！");
					return false;
				}else if($.trim($("#fpw").val())==""){
					alert("密码不能为空！");
					return false;
				}else if($.trim($("#forgcode").val())==""){
					alert("组织机构能为空！");
					return false;
				}else if ($.trim($("#cc").combobox("getValue")) == "请选择") {
				
				alert("请选择班级！");
				return false;
			} else{
			
			          $("#dthFUID").val($("#cc").combobox("getValue"));
				     var myform=$("#myform");
			         myform.attr("action","<%=basePath%>teacher/createOrEditTeacher");
				     myform.submit();
				
				}
			
		}
		function resetB(){
			//$("#myform").find(("input[type='text']")).val("");
			  $("#fname").textbox('setValue',"");
			  $("#fgender").textbox('setValue',"");
			  $("#fphone").textbox('setValue',"");
			  $("#faccount").textbox('setValue',"");
			  $("#fpw").textbox('setValue',"");
			 $("#forgcode").textbox('setValue',"");
		}
		function re(){
			window.location.href="javascript:history.back();";
		}
		$(document).ready(function() {
			
		});
		
		
	</script>
  </head>
  
  <body>
  <div style="width:auto;height:auto;" closed="true" buttons="#dlg-buttons">
    <div class="ftitle">老师信息</div>
	<form id="myform" action="" method="post" ENCTYPE="multipart/form-data"> 
        	 <s:hidden name="teacher.fuID" value="%{teacher.fuID}"></s:hidden>
         <s:hidden name="tclass.fuID" id="dthFUID"></s:hidden>
			<div class="fitem">
				<label>姓名：</label>
				<input type="text" class="easyui-textbox" value="${teacher.fname}" id="fname" name="teacher.fname"  >
			</div>
			<div class="fitem">
				<label>性别：</label>
				<input type="text" class="easyui-textbox" value="${teacher.fgender}" placeholder="" id="fgender" name="teacher.fgender" >
			</div>
			<div class="fitem">
				<label>电话：</label>
				<input type="text" class="easyui-textbox" value="${teacher.fphone}" placeholder="" id="fphone" name="teacher.fphone" >
			</div>
			<div class="fitem">
				<label>账号：</label>
				<input type="text" class="easyui-textbox" value="${teacher.faccount}" placeholder="" id="faccount" name="teacher.faccount">
			</div>
			<div class="fitem">
				<label>密码：</label>
				<input type="text" class="easyui-textbox" value="${teacher.fpw}" placeholder="" id="fpw" name="teacher.fpw" >
			</div>
			<div class="fitem">
				<label>组织机构:</label>
				<input type="text" class="easyui-textbox" value="${teacher.forgcode}" placeholder="" id="forgcode" name="teacher.forgcode">
			</div>
			<div class="fitem">
				<label>所属班级：</label>
             <input  class="easyui-combobox" data-options="editable:false"  onchange="SetSubID();" value="请选择" id="cc" name="mallId" url="<%=basePath%>teacher/goclassJson" valueField="fuID" textField="fname"  panelHeight="auto"/>

				
			</div>
			<br/>
			<div id="dlg-buttons" class="fitem">
            	<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
            	<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-reload" onclick="resetB()" style="width:90px">重置</a>
            	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="re()" style="width:90px">返回</a>
			</div>
	</form>
	</div>
  </body>
</html>
