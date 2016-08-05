<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/select.css" rel="stylesheet"
	type="text/css" />
<script language="javascript" type="text/javascript" src="<%=basePath%>/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/select-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});

	});
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">学生信息管理</a></li>
		</ul>
	</div>
	<form id="saveForm" action="<%=basePath%>tstudent/createOrEditTStudent"
		method="post">
		<div class="formbody">
			<s:hidden name="student.fuID" value="%{student.fuID}"></s:hidden>
			<div class="formtitle">
				<span>学生信息</span>
			</div>
			<ul class="forminfo">
				<li><label>姓名：</label> <input type="text" class="dfinput"
					value="${student.fname}" id="fname" name="student.fname"> <i>
				</i></li>
				<li><label>姓别：</label><input type="text" class="dfinput"
					value="${student.fgender}" id="fgrade" name="student.fgender">
					<i> </i></li>
				<li><label>学号：</label> <input type="text" class="dfinput"
					value="${student.fno}" id="fno" name="student.fno">
					<i> </i></li>
				<li><label>出生日期：</label>
				<!--  
					<input type="text" class="dfinput"
					value="${student.fbirth}" id="fbirth" name="student.fbirth">
				-->
				<input  class="dfinput tfinput"  value="${student.fbirth}" name="student.fbirth" id="d11" type="text" onClick="WdatePicker()"/>

		     <i></i></li>
					 	<li><label>家长姓名：</label>
					<input type="text" class="dfinput"
					value="${student.fparentname}" id="fparentname" name="student.fparentname">
					 <i></i></li>
					 <li><label>家长手机：</label>
					<input type="text" class="dfinput"
					value="${student.fparentphone}" id="fparentphone" name="student.fparentphone">
					 <i></i></li>
					 <li><label>登录密码：</label>
					<input type="text" class="dfinput"
					value="${student.fpw}" id="fpw" name="student.fpw">
					 <i></i></li>
				<li><label></label> <input class="btn" type="button"
					onclick="goSubmit();" value="提交"> <input class="btn"
					type="button" value="取消" onclick="javascript:history.back();">
				</li>
			</ul>
		</div>
	</form>
	<script type="text/javascript">
		function SetSubID() {
			$("#dthFUID").val($("#sel_Sub").val());//选择的学校
		}
		$(function() {

			
		});

		function goSubmit() {
			if ($.trim($("#fname").val()) == "") {
				alert("姓名不能为空！");
				return false;
			} else if ($.trim($("#fgrade").val()) == "") {
				alert("姓别不能为空！");
				return false;
			} else if ($.trim($("#fno").val()) == "") {
				alert("学号不能为空！");
				return false;
			} else if ($.trim($("#d11").val()) == "") {
				alert("出生日期不能为空！");
				return false;
			}else if ($.trim($("#fparentname").val()) == "") {
				alert("家长姓名不能为空！");
				return false;
			} else if ($.trim($("#fparentphone").val()) == "") {
				alert("家长手机不能为空！");
				return false;
			}else if ($.trim($("#fpw").val()) == "") {
				alert("登录密码不能为空！");
				return false;
			}   else {
				document.getElementById("saveForm").submit();
			}

		};
	</script>

</body>
</html>
