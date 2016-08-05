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
		   // alert($("#myparentId").val());
		}
	</script>
  </head>
  
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">组织管理</a></li>
	    </ul>
	 </div>
		<form id="saveForm" action="<%=basePath%>sysOrg/createOrEditOrg" method="post" >
			<div class="formbody">
    
    			<div class="formtitle"><span>组织信息</span></div>
    
    			<ul class="forminfo">
				<s:hidden name="sysOrg.fuID" value="%{sysOrg.fuID}"></s:hidden>
				<s:hidden name="myparentId" id="myparentId" value=""></s:hidden>
				<li>
					<label>组织编码：</label>
					<input type="text" class="dfinput" value="${sysOrg.forgId}" placeholder="" id="fuserId" name="sysOrg.forgId">
					<i> </i>
				</li>
				<li>
					<label>组织代码</label>
					<input type="text" class="dfinput" value="${sysOrg.forgcode}" placeholder="" id="forgcode" name="sysOrg.forgcode">
					<i> </i>
				</li>
	            <li>
					<label>组织名字</label>
					<input type="text" class="dfinput" value="${sysOrg.forgname}" placeholder="" id="forgname" name="sysOrg.forgname">
					<i> </i>
				</li>
               <li>
					<label>上级栏目：</label>
					<div class="vocation">
						<select class="select1" id="sel_Sub" name="sel_Sub"
						onchange="SetSubID();">
							<option value="0"  selected="selected" >顶级菜单</option>
							<s:iterator var="sysOrge" value="sysOrges">
								<option value="<s:property value='#sysOrge.fuID'/>">
									<s:property value="#sysOrge.forgname" />
									<s:iterator var="childMenu" value="#sysOrge.children">

										<option disabled="disabled" value="<s:property value='#childMenu.fuID'/>">
											&nbsp;├
											<s:property value="#childMenu.forgname" />
									</s:iterator>
								</option>
							</s:iterator>

					</select>
					</div>
					<i> </i>
				</li>
				<li>
					<label></label>
					<input class="btn" type="button"  onclick="goSubmit();" value="提交">
					<input class="btn" type="button" value="取消" onclick="javascript:history.back();">
				</li>
				</ul>
				</div>
			</form>
	<script type="text/javascript">


        function goSubmit(){
				if($.trim($("#fuserId").val())==""){
					alert("组织编码不能为空！");
					return false;
				}else if($.trim($("#forgcode").val())==""){
					alert("组织代码不能为空！");
					return false;
				}else if($.trim($("#forgname").val())==""){
					alert("组织名字不能为空！");
					return false;
				}else{
				document.getElementById("saveForm").submit();
				
				}
				
			};
			</script>
			
	</body>
</html>
