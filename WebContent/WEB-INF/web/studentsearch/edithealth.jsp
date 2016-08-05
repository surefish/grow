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
			         myform.attr("action","<%=basePath%>tstudentsearch/createOrEditTStudent");
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
   

 
<!--2. 对<div>标签引用'easyui-layout'类,fit="true"自动适应父窗口,这里我们指定了宽度和高度-->
<div id="cc"  class="easyui-layout" style="width:650px;height:400px;">  
   
     <div region="west"  style="width:250px;">
     <div  class="fitem"></div>
     <div  class="fitem"></div>
     <div  class="fitem"></div>
      <div    class="fitem">
				<label>姓名：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${student.fname}" id="fname" name="student.fname" >
			</div>
			<div class="fitem">
				<label>姓别：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${student.fgender}" id="fgrade" name="student.fgender" >
			</div>
			<div class="fitem">
				<label>学号：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${student.fno}" id="fno" name="student.fno">
			</div>
			<div class="fitem">
				<label>左眼-视力：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fleftv}" id="fleftv" name="">
			</div>
		     <div class="fitem">
				<label>左眼-球镜：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fleftm}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>左眼-柱镜：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fleftc}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>右眼-视力：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.frightv}" id="fleftv" name="">
			</div>
		     <div class="fitem">
				<label>右眼-球镜：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.frightm}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>右眼-柱镜：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fleftc}" id="fleftm" name="">
			</div>
			
    </div>  
    
    <div region="east"   style="width:300px;">
     <div class="fitem"></div>
     <div class="fitem"></div>
     <div class="fitem"></div>
    
			<div class="fitem">
				<label>左眼-散光方向：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.flefta}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>左眼-角膜曲率：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fleftq}" id="fleftm" name="">
			</div>
			
			<div class="fitem">
				<label>右眼-散光方向：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.frighta}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>右眼-角膜曲率：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.frightq}" id="fleftm" name="">
			</div>
        <div class="fitem">
				<label>身高：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fheight}" id="fleftm" name="">
			</div>
          <div class="fitem">
				<label>体重：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fweight}" id="fleftm" name="">
			</div>
			 <div class="fitem">
				<label>牙齿：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.ftooth}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>诊断结果：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fresult}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>开单医生：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.fdoctor}" id="fleftm" name="">
			</div>
			<div class="fitem">
				<label>填写日期：</label>
				<input type="text" class="easyui-textbox" editable="false" value="${thealthy.ffilldate}" id="fleftm" name="">
			</div>
    </div>  
   
   
 </div>  
 

  
  
  
  
  
  
			
			<br />
			<div id="dlg-buttons" class="fitem">
            	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="re()" style="width:90px">返回</a>
			</div>
	
  </body>
</html>
