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
   	<link href="<%=basePath%>css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
  </head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统设置</a></li>
    <li><a href="#">菜单管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
        	<li><a href="<%=basePath%>sysRole/goAddRole"><span><img src="images/t01.png" /></span>添加角色</a></li>
        </ul>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
			<th width="25"><input type="checkbox" name="" value=""></th>					
			<th width="80">角色名称</th>
			<th width="80">角色描述</th>
			<th>角色拥有菜单</th>
			<th width="100">操作</th>
		</tr>
        </thead>
        <tbody>
       		  <s:iterator var="sysRole" value="sysRoles.currentList">
				<tr>
					<td><input type="checkbox" name="" value=""></td>
					<td><s:property value="#sysRole.frolename" /></td>
					<td><s:property value="#sysRole.fdesc" /></td>
					<td>
					<s:iterator var="menu" value="rolesit">
					[<s:property value="#menu.fmenuname" />]:
						<s:iterator var="childMenu" value="#menu.children">
							<s:property value="#childMenu.fmenuname" />
						</s:iterator>	
						
						</s:iterator>			
					</td>
					<td>
					<a title="编辑" href="<%=basePath%>sysRole/getRoleID?roleID=<s:property value="#sysRole.fuID" />" >编辑</a> 
					<a title="删除" href="<%=basePath%>sysRole/deleteMenuByRole?roleID=<s:property value="#sysRole.fuID "/>" onclick="return confirm('你确定要删除')">删除</a>
					<a title="授权" href="<%=basePath%>sysRole/goAccredit?roleID=<s:property value="#sysRole.fuID" />" >授权</a> 
					</td>
				</tr>
				</s:iterator>     
        </tbody>
    </table>
		
    <div class="pagin">
    	<div class="message">共<i class="blue"><s:property value="sysRoles.sizeOfTotalList"/></i>条记录，当前显示第&nbsp;<i class="blue"><s:property value="sysRoles.currentPageNO"/>&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:void(0)" onclick="pageFirst();">首页</a></li>
        <li class="paginItem current"><a href="javascript:void(0)" onclick="pageUp();">上一页</a></li>
        <li class="paginItem"><a href="javascript:void(0)" onclick="nextPage();">下一页</a></li>
        <li class="paginItem"><a href="javascript:void(0)" onclick="pageEnd();">末页</a></li>
        <li><input type="text" id="currentPageNO" value="<s:property value="sysRoles.currentPageNO"/>" style="width:50px"/></li>
		<li><input type="button" value="GO" onclick="gotoPage()" /></li>
		<li><input type="hidden" id="maxPage" value="<s:property value="sysRoles.maxPageNO"/>"/></li>
        </ul>
    </div>
    
    
    
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
<script type="text/javascript">
/*
$(function() {
		
		var tr=$('[id=trOrder]').length; 
		$("#mye").empty();
		var mye="<span id=\"mye\">每页:"+tr+"条</span>";
		$("#mye").append(mye);
		
	});*/

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

				window.location.href="<%=basePath%>sysRole/listSysRole.action?currentPageNO="+currentPageNO;		
			}
		}
	}

	function searchByCompany(){
	
	
			var fuserName =$.trim($("#SearchCompanyName").val());
			//alert("fuserName="+fuserName);
			if(fuserName=="请输入用户名"){
			  fuserName="";
			}
			window.location.href="<%=basePath%>sysUser/searchByname.action?fuserName="
					+ fuserName;
		
		}
</script> 
<script type="text/javascript">
	function searchByCompany(){
			var fuserName = document.getElementById("SearchCompanyName").value;
			
			if(fuserName=="请输入用户名"){
				fuserName="";
			}
			//window.location.href="<%=basePath%>sysUser/searchByname.action?fuserName="
					//+ fuserName;
		
		}
</script> 
</body>
</html>
