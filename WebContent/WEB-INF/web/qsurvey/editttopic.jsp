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
			<li><a href="#">项目表管理</a></li>
		</ul>
	</div>
	<form id="saveForm" action="<%=basePath%>qTopic/createOrEditTopic"
		method="post">
		<div class="formbody">
			<s:hidden name="topic.fuID" value="%{topic.fuID}"></s:hidden>
			<div class="formtitle">
				<span>项目表信息</span>
			</div>
			<ul class="forminfo">
				<li><label>项目名称：</label> <input type="text" class="dfinput"
					value="${topic.ftitle}" id="ftitle" name="topic.ftitle"> <i>
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
			if ($.trim($("#ftitle").val()) == "") {
				alert("名称不能为空！");
				return false;
			}else {
				document.getElementById("saveForm").submit();
			}

		};
	</script>

</body>
</html>
