<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
   	<link href="<%=basePath%>css/select.css" rel="stylesheet" type="text/css" />
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
	    <li><a href="#">老师信息管理</a></li>
	    </ul>
	 </div>
		<form id="saveForm" action="<%=basePath%>teacher/createOrEditTeacher" method="post" >
			<div class="formbody">
         <s:hidden name="teacher.fuID" value="%{teacher.fuID}"></s:hidden>
         <s:hidden name="tclass.fuID" id="dthFUID" value="%{tclass.fuID}"></s:hidden>
    			<div class="formtitle"><span>老师信息</span></div>
    			<ul class="forminfo">
				<li>
					<label>姓名</label>
					<input type="text" class="dfinput" value="${teacher.fname}" id="fname" name="teacher.fname" >
					<i> </i>
				</li>
				<li>
					<label>性别</label>
					<input type="text" class="dfinput" value="${teacher.fgender}" placeholder="" id="fgender" name="teacher.fgender">
					<i> </i>
				</li>
	            <li>
					<label>电话</label>
					<input type="text" class="dfinput" value="${teacher.fphone}" placeholder="" id="fphone" name="teacher.fphone">
					<i> </i>
				</li>
				<li>
					<label>账号</label>
					<input type="text" class="dfinput" value="${teacher.faccount}" placeholder="" id="faccount" name="teacher.faccount">
					<i> </i>
				</li>
              <li>
					<label>密码</label>
					<input type="text" class="dfinput" value="${teacher.fpw}" placeholder="" id="fpw" name="teacher.fpw">
					<i> </i>
				</li>
				<li>
					<label>组织机构</label>
					<input type="text" class="dfinput" value="${teacher.forgcode}" placeholder="" id="forgcode" name="teacher.forgcode">
					<i> </i>
				</li>
				<li><label>所属班级：</label>
					<div class="vocation">
						<select class="select1" id="sel_Sub" name="sel_Sub"
							onchange="SetSubID();">
							<option value="0">请选择</option>
							<s:iterator var="tClass" value="listTclass.currentList">
								<option value="<s:property value='#tClass.fuID'/>">
									<s:property value="#tClass.fname" />
								</option>
							</s:iterator>


						</select>
					</div> <i> </i></li>
				<li>
					<label></label>
					<input class="btn" type="button"  onclick="goSubmit();" value="提交">
					<input class="btn" type="button" value="取消" onclick="javascript:history.back();">
				</li>
				</ul>
				</div>
			</form>
	<script type="text/javascript">
          function SetSubID() {
			$("#dthFUID").val($("#sel_Sub").val());//选择的班级
		    }

        function goSubmit(){
				if($.trim($("#fname").val())==""){
					alert("姓名不能为空！");
					return false;
				}else if($.trim($("#fgender").val())==""){
					alert("性别不能为空！");
					return false;
				}else if($.trim($("#fphone").val())==""){
					alert("电话不能为空！");
					return false;
				}else if($.trim($("#faccount").val())==""){
					alert("账号不能为空！");
					return false;
				}else if($.trim($("#fpw").val())==""){
					alert("密码不能为空！");
					return false;
				}else if ($.trim($("#sel_Sub").val()) == "0") {
				   alert("请选择班级！");
				   return false;
			   } else{
				
				//alert($("#fname").val());
				document.getElementById("saveForm").submit();
				}
				
			};
			</script>
			
	</body>
</html>
