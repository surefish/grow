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
					alert("班级名称不能为空！");
					return false;
				}else if($.trim($("#fgrade").val())==""){
					alert("年级不能为空！");
					return false;
				}else if($.trim($("#forgcode").val())==""){
					alert("机构代码不能为空！");
					return false;
				}else if($.trim($("#cc").combobox("getValue"))=="请选择"){
					alert("所属学校必须选择！");
					return false;
				}else{
				    $("#dthFUID").val($("#cc").combobox("getValue"));
				    //alert($("#dthFUID").val());
				     var myform=$("#myform");
			         myform.attr("action","<%=basePath%>tclass/createOrEditTClass");
				     myform.submit();
				
				}
			
		}
		function SetSubID() {
			$("#dthFUID").val($("#cc").combobox("getValue"));//选择的角色
		}
		function resetB(){
			//$("#myform").find(("input[type='text']")).val("");
			  $("#fname").textbox('setValue',"");
			  $("#fgrade").textbox('setValue',"");
			  $("#forgcode").textbox('setValue',"");
			  //$("#fdesc").textbox('setValue',"");
			 
			
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
    <div class="ftitle">班级信息</div>
	<form id="myform" action="" method="post" ENCTYPE="multipart/form-data"> 
        	 <s:hidden name="tclass.fuID" value="%{tclass.fuID}"></s:hidden>
        	<s:hidden name="school.fuID" id="dthFUID" value=""></s:hidden>
			<div class="fitem">
				<label>班级名称：</label>
				<input type="text" class="easyui-textbox" value="${tclass.fname}" id="fname" name="tclass.fname" >
			</div>
			<div class="fitem">
				<label>年级：</label>
				<input type="text" class="easyui-textbox" value="${tclass.fgrade}" id="fgrade" name="tclass.fgrade" >
			</div>
			<div class="fitem">
				<label>机构代码：</label>
				<input type="text" class="easyui-textbox"  value="${tclass.forgcode}" id="forgcode" name="tclass.forgcode" >
			</div>
			<div class="fitem">
				<label>所属学校：</label>
				 <input  class="easyui-combobox" data-options="editable:false"  onchange="SetSubID();" value="请选择" id="cc" name="mallId" url="<%=basePath%>tclass/goTclassJson" valueField="fuID" textField="fname"  panelHeight="auto"/>
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
