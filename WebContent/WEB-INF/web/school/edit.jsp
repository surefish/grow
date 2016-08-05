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
					alert("学校名称不能为空！");
					return false;
				}else if($.trim($("#faccount").val())==""){
					alert("账号不能为空！");
					return false;
				}else if($.trim($("#fpw").val())==""){
					alert("密码不能为空！");
					return false;
				}else if($.trim($("#fareacode").val())==""){
					alert("区域代码不能为空！");
					return false;
				}else if($.trim($("#fintro").val())==""){
					alert("介绍不能为空！");
					return false;
				}else if ($.trim($("#uploadFile").val())==""){
				   alert("上传文件不能为空！");
				   return false;
			     }else{
				     var myform=$("#myform");
			         myform.attr("action","<%=basePath%>tSchool/createOrEditTSchool");
				     myform.submit();
				}
			
		}
		function resetB(){
			//$("#myform").find(("input[type='text']")).val("");
			  $("#fname").textbox('setValue',"");
			  $("#faccount").textbox('setValue',"");
			  $("#fpw").textbox('setValue',"");
			  $("#fareacode").textbox('setValue',"");
			  $("#fintro").textbox('setValue',"");
			 $("#fintro").textbox('setValue',"");
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
    <div class="ftitle">学校信息</div>
	<form id="myform" action="" method="post" enctype="multipart/form-data"> 
        	 <s:hidden name="school.fuID" value="%{school.fuID}"></s:hidden>
			<div class="fitem">
				<label>学校名称：</label>
				<input type="text" class="easyui-textbox" value="${school.fname}" id="fname" name="school.fname" >
			</div>
			<div class="fitem">
				<label>账号：</label>
				<input type="text" class="easyui-textbox" value="${school.faccount}"  id="faccount" name="school.faccount">
			</div>
			<div class="fitem">
				<label>密码：</label>
				<input type="text" class="easyui-textbox" value="${school.fpw}" placeholder="" id="fpw" name="school.fpw" >
			</div>
			<div class="fitem">
				<label>区域代码：</label>
				<input type="text" class="easyui-textbox" value="${school.fareacode}" placeholder="" id="fareacode" name="school.fareacode" >
			</div>
			<div class="fitem">
				<label>介绍：</label>
				<input type="text" class="easyui-textbox" value="${school.fintro}" placeholder="" id="fintro" name="school.fintro" >
			</div>
			<div class="fitem">
				<label>学习图片：</label>
				<s:file id="uploadFile" name="uploadFile"></s:file>
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
