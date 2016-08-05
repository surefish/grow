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
			<li><a href="#">调查问卷管理</a></li>
		</ul>
	</div>
	<form id="saveForm" action="<%=basePath%>qSurvey/createOrEditQSurvey"
		method="post">
		<div class="formbody">
			<s:hidden name="survey.fuID" value="%{survey.fuID}"></s:hidden>
			<div class="formtitle">
				<span>调查表信息</span>
			</div>
			<ul class="forminfo">
				<li><label>名称：</label> <input type="text" class="dfinput"
					value="${survey.fname}" id="fname" name="survey.fname"> <i>
				</i></li>
				<li><label>开始时间：</label>
				<!-- 
				<input type="text" class="dfinput"
					value="${qSurvey.fbegindate}" id="fbegindate" name="qSurvey.fbegindate">
					 -->
					<input  class="dfinput tfinput"  value="${survey.fbegindate}" name="survey.fbegindate" id="d11" type="text" onClick="WdatePicker()"/>
					
					<i> </i></li>
				<li><label>结束时间：</label> 
				<!--  
				<input type="text" class="dfinput"
					value="${qSurvey.fenddate}" id="fenddate" name="tclass.forgcode">
					-->
					<input  class="dfinput tfinput"  value="${survey.fenddate}" name="survey.fenddate" id="d12" type="text" onClick="WdatePicker()"/>
					
					<i> </i></li>
					
					<li><label>简介：</label> 
					<textarea class="dfinput tfinput"   id="fintro" style="height:150;width:500" name="survey.fintro">
					<s:property value="survey.fintro" />
					</textarea>
					
					 <i>
				</i></li>
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
		
		function goSubmit(){
			if ($.trim($("#fname").val()) == "") {
				alert("名称不能为空！");
				return false;
			} else if ($.trim($("#d11").val()) == "") {
				alert("开始时间不能为空！");
				return false;
			} else if ($.trim($("#d12").val()) == "") {
				alert("结束时间不能为空！");
				return false;
			} else if ($.trim($("#fintro").val()) == "0") {
				alert("请输入简介！");
				return false;
			} else {
				document.getElementById("saveForm").submit();
			}

		};
	</script>

</body>
</html>
