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

	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
	  
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户管理</a></li>
    </ul>
    </div>
    
    <form id="saveForm" action="<%=basePath%>sysUser/createOrEditUser" method="post" >
    <div class="formbody">
    
    <div class="formtitle"><span>用户信息</span></div>
    
    <ul class="forminfo">
    <s:hidden name="sysUser.fuID" value="%{sysUser.fuID}"></s:hidden>
    <s:hidden name="userRoleId" id="dthFUID" value=""></s:hidden>
    <li>
    	<label>用户ID：</label>
    	<input type="text" value="${sysUser.fuserId}" placeholder="" id="fuserId" name="sysUser.fuserId" class="dfinput">
    	<i></i>
    </li>
    <li>
    	<label>用户名：</label>
    	<input type="text" value="${sysUser.fuserName}" placeholder="" id="fuserName" name="sysUser.fuserName" class="dfinput">
   		<i></i>
   	</li>
    <li>
    	<label>密码：</label>
    	<input type="password" placeholder="" autocomplete="off" value="${sysUser.fpassWord}" id="fpassWord" name="sysUser.fpassWord" class="dfinput">
    </li>
    <li>
    	<label>手机号：</label>
    	<input type="text" value="${sysUser.fphone}" placeholder="" id="fphone" name="sysUser.fphone" class="dfinput">
    </li>
    <li>
    	<label>电子邮箱：</label>
    	<input type="text" value="${sysUser.femail}" placeholder="" id="femail" name="sysUser.femail" class="dfinput">
    </li>
    <li>
					<label>所属角色：</label>
					<div class="vocation">
						<select class="select1" id="sel_Sub" name="sel_Sub"
						onchange="SetSubID();">
							<option value="0">请选择</option>
							<s:iterator var="sysRole" value="sysRoles.currentList">
								<option value="<s:property value='#sysRole.fuID'/>">
									<s:property value="#sysRole.frolename" />
								</option>
							</s:iterator>

					</select>
					</div>
					<i> </i>
				</li>
				
    
    
   
    <li>
    	<label>&nbsp;</label>
    	<input class="btn" type="button" onclick="goSubmit();" value="提交">
		<input class="btn" type="button" value="取消" onclick="javascript:history.back();">
    </li>
    </ul>
    </div>
    </form>
<script type="text/javascript">

function SetSubID() {
			$("#dthFUID").val($("#sel_Sub").val());//选择的角色
		}
        function goSubmit(){
				if($.trim($("#fuserId").val())==""){
					alert("用户ID不能为空！");
					return false;
				}else if($.trim($("#fuserName").val())==""){
					alert("用户名不能为空！");
					return false;
				}else if($.trim($("#fpassWord").val())==""){
					alert("用户密码不能为空！");
					return false;
				}else if($.trim($("#fphone").val())==""){
					alert("手机号不能为空！");
					return false;
				}else if(!isEmail()){
					return false;
				}else if ($.trim($("#sel_Sub").val()) == "0") {
				alert("请选择角色！");
				return false;
			} else{
				
				document.getElementById("saveForm").submit();
				
				}
				
			};



         /** 
		 *邮箱验证
		 */
		function isEmail(){
	   		var str = jQuery("#femail").val();
	   		var regEx = /^[A-Za-z\d]+([-_\.\+]*[A-Za-z\d])*@([A-Za-z\d][A-Za-z\d-]{0,61}[A-Za-z\d]\.)+[A-Za-z\d]{2,6}$/;
	   		if($("#email").val()==""){
				alert("邮箱地址不能为空");
				return false;
			}else if (!regEx.test(str)) {
	    		alert("邮箱地址不正确");
	        	return false;
	    	}
	   		return true;
	   	}


</script>
</body>



</html>
