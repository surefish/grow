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

    
    <div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
        <a href="<%=basePath%>sysMenu/goAddMenu">
        	<li><span><img src="images/t01.png" /></span>添加菜单</li>
        </a>
    	</ul>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
			<th><input type="checkbox" name="" value=""></th>
			<th>菜单编码</th>
			<th>菜单名称</th>
			<th>菜单路径</th>
			<th>菜单图标</th>
			<th>菜单级别</th>
			<th>操作</th>
		</tr>
        </thead>
        <tbody>
       		<s:iterator var="sysMenu" value="sysMenus">
			<tr id="trOrder">
				<td><input type="checkbox" name="" value=""></td>
				<td><s:property value="#sysMenu.fmenuId" /></td>
				<td><s:property value="#sysMenu.fmenuname" /></td>
				<td><s:property value="#sysMenu.furl" /></td>
				<td><s:property value="#sysMenu.ficon" /></td>
				<td>
				 <s:if test="#sysMenu.fname==null">
				 一级菜单
				 </s:if>
				 <s:else>
				<s:property value="#sysMenu.fname" />&nbsp;├&nbsp;<s:property value="#sysMenu.fmenuname" />
				 </s:else>
				
				</td>
				<td>
					<a title="编辑" href="<%=basePath%>sysMenu/getMenuID?menuID=<s:property value="#sysMenu.fuID" />"  style="text-decoration:none">编辑</a> 
					 <s:if test="#sysMenu.fname==null">
					 <a title="删除" href="<%=basePath%>sysMenu/deleteAllMenu?menuID=<s:property value="#sysMenu.fuID "/>" onclick="return confirm('你确定要删除')" >删除</a>
					 </s:if>
					  <s:else>
					  <a title="删除" href="<%=basePath%>sysMenu/deleteMenu?menuID=<s:property value="#sysMenu.fuID "/>" onclick="return confirm('你确定要删除')" >删除</a>
					  </s:else>
					
				</td>
			</tr>
			</s:iterator>       
        </tbody>
    </table>
<!--  
    <div class="pagin">
    	<div class="message">共<i class="blue"><s:property value="sysMenus.sizeOfTotalList"/></i>条记录，当前显示第&nbsp;<i class="blue"><s:property value="sysMenus.currentPageNO"/>&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:void(0)" onclick="pageFirst();">首页</a></li>
        <li class="paginItem current"><a href="javascript:void(0)" onclick="pageUp();">上一页</a></li>
        <li class="paginItem"><a href="javascript:void(0)" onclick="nextPage();">下一页</a></li>
        <li class="paginItem"><a href="javascript:void(0)" onclick="pageEnd();">末页</a></li>
        <li><input type="text" id="currentPageNO" value="<s:property value="sysUseres.currentPageNO"/>" style="width:50px"/></li>
		<li><input type="button" value="GO" onclick="gotoPage()" /></li>
		<li><input type="hidden" id="maxPage" value="<s:property value="sysUseres.maxPageNO"/>"/></li>
        </ul>
    </div>
-->
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
<script type="text/javascript">
$(function() {
		
		var tr=$('[id=trOrder]').length; 
		$("#mye").empty();
		var mye="<span id=\"mye\">每页:"+tr+"条</span>";
		$("#mye").append(mye);
		
	});

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

				window.location.href="<%=basePath%>sysUser/listSysUser.action?currentPageNO="+currentPageNO;		
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
