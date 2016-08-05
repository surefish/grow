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
<link href="<%=basePath%>css/select.css" rel="stylesheet" type="text/css" />
<!-- 文本编辑器开始 --> 
<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
</style>
<link rel="stylesheet" href="<%=basePath%>kindeditor/themes/default/default.css" />
<script charset="utf-8" src="<%=basePath%>kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					allowFileManager : true
				});
			});
		</script>
		<!-- K('input[name=getHtml]').click(function(e) {
					alert(editor.html());
				});
				K('input[name=isEmpty]').click(function(e) {
					alert(editor.isEmpty());
				});
				K('input[name=getText]').click(function(e) {
					alert(editor.text());
				});
				K('input[name=selectedHtml]').click(function(e) {
					alert(editor.selectedHtml());
				});
				K('input[name=setHtml]').click(function(e) {
					editor.html('<h3>Hello KindEditor</h3>');
				});
				K('input[name=setText]').click(function(e) {
					editor.text('<h3>Hello KindEditor</h3>');
				});
				K('input[name=insertHtml]').click(function(e) {
					editor.insertHtml('<strong>插入HTML</strong>');
				});
				K('input[name=appendHtml]').click(function(e) {
					editor.appendHtml('<strong>添加HTML</strong>');
				});
				K('input[name=clear]').click(function(e) {
					editor.html('');
				}); -->
				
<!-- 文本编辑器结束--> 				
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
		var fcont=$("#fcontent").val();
		//alert(fcont);
		if(""!=fcont&&undefined!=fcont){
		   editor.text(fcont);
		}

	});
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a>首页</a></li>
			<li><a>医院咨询管理</a></li>
		</ul>
	</div>
	<form id="saveForm" action="<%=basePath%>tplatformnews/CreateOrEditTNews"
		method="post">
		<div class="formbody">
			<s:hidden name="myNew.fuID" value="%{myNew.fuID}"></s:hidden>
			<input type="hidden" value="${myNew.fcontent}" id="fcontent" name="myNew.fcontent">
			<input type="hidden" id="dthFUID" name="myNew.fcatalog" value="%{myNew.fcatalog}"></input>
			<div class="formtitle">
				<span>医院咨询信息</span>
			</div>
			<ul class="forminfo">
				<li><label>标题：</label> <input type="text" class="dfinput"
					value="${myNew.ftitle}" id="ftitle" name="myNew.ftitle"> <i>
				</i></li>
				<li><label>标签：</label> <input type="text" class="dfinput"
					value="${myNew.ftag}" id="ftag" name="myNew.ftag">
					<i> </i></li>
				<li><label>新闻分类</label> 
				<div class="vocation">
						<select class="select1" id="sel_Sub" name="sel_Sub"  onchange="SetSubID();">
						<option value="0">请选择</option>
						<option value="1">医院咨询</option>
						<option value="2">学校咨询</option>
						<option value="3">平台咨询</option>
						<option value="4">其他平台咨询</option>
						</select>
				</div>
				</li>
				<li><label>内容：</label>
				<!-- 
				<input type="text" class="dfinput"
					value="${myNew.fcontent}" id="fcontent" name="myNew.fcontent">
					<p>
				<input type="button" name="getHtml" value="取得HTML" />
				<input type="button" name="getText" value="取得文本(包含img,embed)" />
				<input type="button" name="isEmpty" value="判断是否为空" />
				<input type="button" name="getText" value="取得文本(包含img,embed)" />
				<input type="button" name="selectedHtml" value="取得选中HTML" />
				<br />
				<br />
				<input type="button" name="setHtml" value="设置HTML" />
				<input type="button" name="setText" value="设置文本" />
				<input type="button" name="insertHtml" value="插入HTML" />
				<input type="button" name="appendHtml" value="添加HTML" />
				<input type="button" name="clear" value="清空内容" />
				<input type="reset" name="reset" value="Reset" />
			</p>
					 -->
					<textarea name="content" style="width:700px;height:300px;visibility:hidden;"></textarea>
					
					<i> </i></li>
					<li><label>发布时间：</label>
					<input value="${myNew.fpublishtime}"   class="dfinput tfinput" name="myNew.fpublishtime" id="d11" type="text" onClick="WdatePicker()"/>
					
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
			$("#dthFUID").val($("#sel_Sub").val());//选择分类
			//alert($("#dthFUID").val());
		}
		function goSubmit() {
			if ($.trim($("#ftitle").val()) == "") {
				alert("标题不能为空！");
				return false;
			} else if ($.trim($("#ftag").val()) == "") {
				alert("标签不能为空！");
				return false;
			} else if ($.trim($("#sel_Sub").val()) == "0") {
				alert("请选择分类！");
				return false;
			} else if (editor.isEmpty()==true) {
			    //alert(editor.isEmpty());
				alert("内容不能为空！");
				return false;
			}else if ($.trim($("#d11").val()) == "") {
				alert("发布时间不能为空！");
				return false;
			} else {
			   
			    $("#fcontent").val(editor.text());
			    //alert( $("#fcontent").val());
				document.getElementById("saveForm").submit();
			}

		};
	</script>

</body>
</html>
