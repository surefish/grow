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
			if($.trim($("#frolename").val())==""){
					alert("角色名不能为空！");
					return false;
				}else if($.trim($("#fdesc").val())==""){
					alert("描述不能为空！");
					return false;
				}else{
				 var t=$('#cc').combotree('getValues');
				 //alert(t);
				 jQuery("#menuIDs").val(t);
				 //var t1= $('#cc').combotree('getText');
		        var myform=$("#myform");
			    myform.attr("action","<%=basePath%>sysRole/createOrEditRole");
				myform.submit();
				    
				}
			
		}
		function resetB(){
			//$("#myform").find(("input[type='text']")).val("");
			  $("#frolename").textbox('setValue',"");
			  $("#fdesc").textbox('setValue',"");
			
			
			
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
    <div class="ftitle">用户信息</div>
	<form id="myform" action="" method="post" ENCTYPE="multipart/form-data"> 
        	 <s:hidden name="sysRole.fuID" value="%{sysRole.fuID}"></s:hidden>
   <input type="hidden" id="menuIDs" name="ids" />
			<div class="fitem">
				<label>角色名称：</label>
				<input type="text" class="easyui-textbox"   id="frolename" name="sysRole.frolename"  value="${sysRole.frolename}" >
			</div>
			<div class="fitem">
				<label>备注</label>
				<input type="text" class="easyui-textbox" id="fdesc" name="sysRole.fdesc"  value="${sysRole.fdesc}" >
			</div>
			
			<div class="fitem">
				<label>菜单：</label>
				
				<input type="text" id="cc" multiple="true"   cascadeCheck="fasle" class="easyui-combotree" name="" value='请选择' url="<%=basePath%>sysRole/roleMenuJson">
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
