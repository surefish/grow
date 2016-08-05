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
	
			KindEditor.ready(function(K){
			editor=K.create('textarea[name="content"]', {
				themeType: 'simple',
				resizeType: 1,
				uploadJson: '<%=basePath %>json/imgUpload.action',
				fileManagerJson: '<%=basePath %>kindeditor/jsp/file_manager_json.jsp',
				allowFileManager: true,
				//经测试，下面这行代码可有可无，不影响获取textarea的值
				//afterCreate: function(){this.sync();}
				//下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
				afterBlur: function(){this.sync();}
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
			<li><a>安全咨询管理</a></li>
		</ul>
	</div>
	<form id="saveForm" action="<%=basePath%>modularSecurity/CreateOrEditTNews"
		method="post" enctype="multipart/form-data">
		<div class="formbody">
			<s:hidden name="myNew.fuID" value="%{myNew.fuID}"></s:hidden>
			<input type="hidden" value="" id="fcontent" name="myNew.fcontent"></input>
			<input type="hidden" id="dthFUID" name="myNew.fcatalog" value="%{myNew.fcatalog}"></input>
			<div class="formtitle">
				<span>安全咨询信息</span>
			</div>
			<ul class="forminfo">
				<li><label>大标题：</label> <input type="text" class="dfinput"
					value="${myNew.ftitle}" id="ftitle" name="myNew.ftitle"> <i>
				</i></li>
				<li><label>小标题：</label> <input type="text" class="dfinput"
					value="${myNew.ftag}" id="ftag" name="myNew.ftag">
					<i> </i></li>
				<li><label>咨询分类</label> 
				<div class="vocation">
						<select class="select1" id="sel_Sub" name="sel_Sub"  onchange="SetSubID();">
						<option value="0">请选择</option>
						<option value="5acee0c158b54bf8a2b6504f78429a35">安全首页</option>
						<option value="0a16eb9a251f4232a982464a09e83feb">快乐首页</option>
						<option value="eae82ff16dd6470f8382656f2c75f779">健康首页</option>
						<option value="2d40cec6e7454084b6755f55e68fd279">安全--急救知识库</option>
						<option value="28121e31c8b74be0b74f622d18e665b4">安全--安全科普课堂</option>
						<option value="5ccec116a27e4d5a8ba64135928b846b">安全--突发事件应对</option>
						<option value="47577afd13c84d89b073ce74400a5cc7">健康--营养饮食</option>
						<option value="f371f185c21944799b66d34c02f465d4">健康--营养指导</option>
						<option value="cb40060d4ac749b9b1b6c066eb5af58c">健康--心灵鸡汤</option>
						<option value="392379ebcb8d4d89b96d1c3967f1a59d">快乐--活动报名</option>
						<option value="4646ea2313ca4ccaad2199ceaf01fd56">快乐--快乐分享</option>
						<option value="f2b7bc95542cfc9b01542cfcfa750000">快乐--名师讲学</option>
						<option value="f2b7bc95542cfc9b01542cfcfac70001">快乐--学习分享</option>
						<option value="f2b7bc95542cfc9b01542cfcfaca0002">快乐--微课堂</option>
						<option value="06e2a5d36f8d4d3a847e6c1419fd2fa4">健康讲堂</option>
						<option value="402881e453f87c180153f87c6df00000">眼科--眼球的结构</option>
						<option value="402881e453f87c180153f87c6e1a0001">眼科--近视的类型及原因</option>
						<option value="402881e453f87c180153f87c6e240002">眼科--近视的早期征兆</option>
						<option value="402881e453f87c180153f87c6e3a0003">眼科--近视的预防</option>
						<option value="402881e453f87c180153f87c6e410004 ">眼科--近视的治疗</option>
						</select>
				</div>
				</li>
				<li><label>内容：</label>
					<textarea name="content"  style="width:700px;height:300px;visibility:hidden;">${myNew.fcontent}</textarea>
					</li>
					<li><label>发布时间：</label>
					<input  value="${myNew.fpublishtime}" class="dfinput tfinput" name="myNew.fpublishtime" id="d11" type="text" onClick="WdatePicker()"/>
					<i></i>
					</li>
					<li><label>图片说明</label>
					<input type="text" class="dfinput" value="${myNew.fimages}" id="fimages" name="myNew.fimages">
					<s:file id="uploadFile" name="uploadFile"></s:file>
					<i></i>
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
			} else if ($.trim($("#fimages").val()) == "") {
				alert("图片名称不能为空！");
				return false;
			} else if ($.trim($("#uploadFile").val()) == "") {
				alert("上传文件不能为空！");
				return false;
			}  else {
			    $("#dthFUID").val($("#sel_Sub").val());
			    $("#fcontent").val(editor.html());
				document.getElementById("saveForm").submit();
			}

		};
	</script>

</body>
</html>
