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
			if($.trim($("#ftype").val())==""){
					alert("类型不能为空！");
					return false;
				}else if($.trim($("#fage").val())==""){
					alert("周岁不能为空！");
					return false;
				}else if($.trim($("#fnum").val())==""){
					alert("数值不能为空！");
					return false;
				}else if($.trim($("#flownum").val())==""){
					alert("低数值不能为空！");
					return false;
				}else if($.trim($("#fhighnum").val())==""){
					alert("高数值不能为空！");
					return false;
				}else{
				     var myform=$("#myform");
			         myform.attr("action","<%=basePath%>thealthstd/createOrEditTHealthStd");
				     myform.submit();
				
				}
			
		}
		function resetB(){
			//$("#myform").find(("input[type='text']")).val("");
			  $("#ftype").textbox('setValue',"");
			  $("#fage").textbox('setValue',"");
			  $("#fnum").textbox('setValue',"");
			  $("#flownum").textbox('setValue',"");
			  $("#fhighnum").textbox('setValue',"");
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
    <div class="ftitle">健康标准</div>
	<form id="myform" action="" method="post" ENCTYPE="multipart/form-data"> 
        	 <s:hidden name="thealth.fuID" value="%{thealth.fuID}"></s:hidden>
			<div class="fitem">
				<label>类型：</label>
				<input type="text" class="easyui-textbox" value="${thealth.ftype}" id="ftype" name="thealth.ftype" >
			</div>
			<div class="fitem">
				<label>周岁：</label>
				<input type="text" class="easyui-textbox" value="${thealth.fage}" id="fage" name="thealth.fage" >
			</div>
			<div class="fitem">
				<label>数值：</label>
				<input type="text" class="easyui-textbox" value="${thealth.fnum}" id="fnum" name="thealth.fnum">
			</div>
			<div class="fitem">
				<label>低数值：</label>
				<input type="text" class="easyui-textbox" value="${thealth.flownum}" id="flownum" name="thealth.flownum" >
			</div>
			<div class="fitem">
				<label>高数值：</label>
				<input type="text" class="easyui-textbox" value="${thealth.fhighnum}" id="fhighnum" name="thealth.fhighnum">
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
