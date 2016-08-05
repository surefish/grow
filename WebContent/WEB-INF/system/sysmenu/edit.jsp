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
		function SetSubID(){
		    $("#myparentId").val($("#sel_Sub").val());
		    //alert($("#myparentId").val());
		}
	</script>
  </head>
  
<body>
	
	<form id="saveForm" action="<%=basePath%>sysMenu/createOrEditMenu" method="post" >
		<div class="formbody">
    
    	<div class="formtitle"><span>菜单信息</span></div>
    
    	<ul class="forminfo">
			<s:hidden name="sysMenu.fuID" value="%{sysMenu.fuID}"></s:hidden>
			<s:hidden name="myparentId" id="myparentId" value=""></s:hidden>
			<li>
				<label>菜单编码</label>
				<input type="text" class="dfinput" value="${sysMenu.fmenuId}" placeholder="" id="fuserId" name="sysMenu.fmenuId">
				<i>标题不能超过30个字符</i>
			</li>
			<li>
				<label>菜单名称</label>
				<input type="text" class="dfinput" value="${sysMenu.fmenuname}" placeholder="" id="fmenuname" name="sysMenu.fmenuname">
				<i class="col-4"> </i>
			</li>
            <li>
				<label>菜单路径</label>
				<input type="text" class="dfinput" value="${sysMenu.furl}" placeholder="" id="furl" name="sysMenu.furl">
				<i class="col-4"> </i>
			</li>
			 <li>
				<label>菜单图标</label>
				<input type="text" class="dfinput" value="${sysMenu.ficon}" placeholder="" id="ficon" name="sysMenu.ficon">
				<i> </i>
			</li>
			<li>
				<label></label>
				
			</li>
			
			<li>
				<label>上级栏目：</label>
				<div class="vocation">
				<select class="select1" id="sel_Sub" name="sel_Sub"
					onchange="SetSubID();">
					<!-- 显示父菜单 -->
						<s:if test="sysMenu.fname==null">
						<option selected="selected" value="" >(<s:property value="sysMenu.fmenuId" />)<s:property value="sysMenu.fmenuname" /></option>
						</s:if>
					<!--显示子菜单的父菜单 -->	
						<s:elseif test="sysMenu.fparentId!=''">
						<option selected="selected" value="<s:property value='sysMenu.fparentId'/>" >(<s:property value="sysMenu.fmId" />)<s:property value="sysMenu.fname" /></option>
						</s:elseif>
						
						<option value="">顶级菜单</option>
						<s:iterator var="menu" value="sysMenus">
							<option value="<s:property value='#menu.fuID'/>">
								(<s:property value="#menu.fmenuId" />)<s:property value="#menu.fmenuname" />
								
								
								<s:iterator var="childMenu" value="#menu.children">

									<option disabled="disabled" value="<s:property value='#childMenu.fuID'/>">
										&nbsp;├
										(<s:property value="#childMenu.fmenuId" />)<s:property value="#childMenu.fmenuname" />
								</s:iterator>
							</option>
						</s:iterator>
						

				</select>
				</div>
				<i> </i>
			</li>
			
			<li>
				<label></label>
				<input class="btn" type="button"  onclick="goSubmit();"  value="提交">
				<input class="btn" type="button" value="取消" onclick="javascript:history.back();">
				<i></i>
			</li>
		</ul>
		</div>
		</form>
		<script type="text/javascript">
		  function goSubmit(){
		  if($.trim($("#fuserId").val())==""){
					alert("菜单编码不能为空！");
					return false;
				}else if($.trim($("#fmenuname").val())==""){
					alert("菜单名称不能为空！");
					return false;
				}else if($.trim($("#furl").val())==""){
					alert("菜单路径不能为空！");
					return false;
				}else if($.trim($("#ficon").val())==""){
					alert("菜单图标不能为空！");
					return false;
				}else{
				 $("#myparentId").val($("#sel_Sub").val());
				 document.getElementById("saveForm").submit();
				}
		  
		  }
		
		
		
		</script>
	</body>
</html>
