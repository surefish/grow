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
			<li><a href="#">选项息管理</a></li>
		</ul>
	</div>
	<form id="saveForm" action="<%=basePath%>qitem/createOrEditQItem"
		method="post">
		<div class="formbody">
				<s:hidden name="item.fuID"  value="%{item.fuID}"></s:hidden>
				<s:hidden name="item.ftype" id="dthFUID" ></s:hidden>
			<div class="formtitle">
				<span>选项信息</span>
			</div>
			<ul class="forminfo">
				<li><label>标题：</label> <input type="text" class="dfinput"
					value="${item.ftitle}" id="ftitle" name="item.ftitle"> <i>
				</i></li>
				<li><label>类型：</label>
					<i></i>
					<div class="vocation">
					<select class="select1" id="sel_Sub" name="sel_Sub"
					onchange="SetSubID();">
					<option selected="selected" value="0">请选择</option>
					<option value="radio">单选</option>
					<option value="text">文本</option>
					<option value="check">复选</option>
					</select>
					</div>
					</li>
				<li><label></label> <input class="btn" type="button"
					onclick="goSubmit();" value="提交"> <input class="btn"
					type="button" value="取消" onclick="javascript:history.back();">
				</li>
			</ul>
		</div>
	</form>
	<script type="text/javascript">
		function SetSubID() {
			$("#dthFUID").val($("#sel_Sub").val());//选择的类型
		}
		
		function goSubmit() {
			if ($.trim($("#ftitle").val()) == "") {
				alert("标题不能为空！");
				return false;
			}else if ($.trim($("#sel_Sub").val()) == "0") {
				alert("请选择类型！");
				return false;
			} else {
				document.getElementById("saveForm").submit();
			}

		};
	</script>

</body>
</html>
