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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">信息管理</a></li>
    <li><a href="#">老师信息管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <a href="<%=basePath%>teacher/goAddTeacher">
        	<li><span><img src="images/t01.png" /></span>添加老师</li>
        </a>
        </ul>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
			<th><input type="checkbox" name="" value=""></th>
			<th>姓名</th>
			<th>性别</th>
			<th>电话</th>
			<th>账号</th>
			<th>密码</th>
			
			<th>所属班级</th>
			<th>操作</th>
		</tr>
        </thead>
        <tbody>
       		<s:iterator var="teacher" value="listTeachers.currentList">
			<tr>
				<td><input type="checkbox" name="" value=""></td>
				<td><s:property value="#teacher.fname" /></td>
				<td><s:property value="#teacher.fgender" /></td>
				<td><s:property value="#teacher.fphone" /></td>
				<td ><s:property value="#teacher.faccount" /></td>
				<td ><s:property value="#teacher.fpw"/></td>
				
				<td ><s:property value="#teacher.fclassName"/></td>
				<td>
				<a href="<%=basePath%>teacher/getTeacherID?tTeacherID=<s:property value="#teacher.fuID" />"  class="tablelink">修改</a> 
				<a href="<%=basePath%>teacher/deleteTeacher?tTeacherID=<s:property value="#teacher.fuID "/>" onclick="return confirm('你确定要删除')" class="tablelink">删除</a>
				</td>
			</tr>
			</s:iterator>       
        </tbody>
    </table>
		
    <div class="pagin">
    	<div class="message">共<i class="blue"><s:property value="listTeachers.sizeOfTotalList"/></i>条记录，当前显示第&nbsp;<i class="blue"><s:property value="listTeachers.currentPageNO"/>&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:void(0)" onclick="pageFirst();">首页</a></li>
        <li class="paginItem current"><a href="javascript:void(0)" onclick="pageUp();">上一页</a></li>
        <li class="paginItem"><a href="javascript:void(0)" onclick="nextPage();">下一页</a></li>
        <li class="paginItem"><a href="javascript:void(0)" onclick="pageEnd();">末页</a></li>
        <li><input type="text" id="currentPageNO" value="<s:property value="listTeachers.currentPageNO"/>" style="width:50px"/></li>
		<li><input type="button" value="GO" onclick="gotoPage()" /></li>
		<li><input type="hidden" id="maxPage" value="<s:property value="listTeachers.maxPageNO"/>"/></li>
        </ul>
    </div>
    

  
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
<script type="text/javascript">


//首页
	function pageFirst(){
	 	//alert("首页");
		$("#currentPageNO").val(1);
		gotoPage();
	};
	//上一页
	function pageUp(){
		var currentPageNO=$("#currentPageNO").val();
		if(currentPageNO>1){
			$("#currentPageNO").val(parseInt(currentPageNO)-1);
		}
		gotoPage();
	}
	//下一页
	function nextPage(){
		var currentPageNO=$("#currentPageNO").val();
		var maxPage=$("#maxPage").val();
		if(parseInt(currentPageNO)<parseInt(maxPage)){
			$("#currentPageNO").val(parseInt(currentPageNO)+1);
		}
		gotoPage();
	};
	//最后一页
	function pageEnd(){
		var maxPage=$("#maxPage").val();
		$("#currentPageNO").val(parseInt(maxPage));
		gotoPage();
	};

	function gotoPage(){
		var maxPage=$("#maxPage").val();//共几页
		var currentPageNO=$("#currentPageNO").val();//第几页
		var reg = /^\d+$/;
		if(!reg.test(maxPage)){
			alert("每页记录数只能是数字");
			return;
		}else if(!reg.test(currentPageNO)){
			alert("第几页只能是数字");
			return;
		}else{
			if(currentPageNO>maxPage){//共几页
				alert("没有第"+currentPageNO+"页");
				return;
			}else{
				//alert(currentPageNO);

				window.location.href="<%=basePath%>teacher/listTeacher.action?currentPageNO="+currentPageNO;		
			}
		}
	}
</script> 
</body>

</html>

	
