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
   	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
</head>

<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">角色管理</a></li>
	    </ul>
	 </div>
		<form id="menuForm" action="<%=basePath%>sysRole/assignAccredit"
			method="post" class="form form-horizontal">
		    <div class="formbody">
    		<div class="formtitle"><span>用户信息</span></div>
   			<ul class="forminfo">
			<s:hidden name="sysRole.fuID" value="%{sysRole.fuID}"></s:hidden>
			<input type="hidden" id="menuIDs" name="ids" />
			<input type="hidden" id="menuIDse" name="idse"/>
			<li>
				<label>角色名称：</label>
				<input type="text" class="dfinput" value="${sysRole.frolename}"
						placeholder="" id="fuserId" name="sysRole.frolename">
				<i></i>
			</li>
			<li>
				<label>备注</label>
				<input type="text" class="dfinput" value="${sysRole.fdesc}"
						placeholder="" id="fuserName" name="sysRole.fdesc">
				<i></i>
			</li>

			<li>
				<label>所有菜单：</label>
					<div class="vocation">

						<s:iterator var="menu" value="sysMenus">
							<tr>
								<td>【父-<input type="checkbox" name="childMenus"
									value="<s:property value='#menu.fuID'/>"><s:property value="#menu.fmenuname" />】:<br><br></td>
							</tr>

							<s:iterator var="childMenu" value="#menu.children">
								<input type="checkbox" name="childMenus"
									value="<s:property value='#childMenu.fuID'/>">
								<s:property value="#childMenu.fmenuname" /><br>
							</s:iterator>
							<br>
						</s:iterator>

					</div>

			</li>
			<li>
				<label></label>
				<input class="btn" type="button"
						onclick="assignMenu()" value="授权">
				<input class="btn" type="button"
						value="取消" onclick="javascript:history.back();">
				<i></i>
			</li>
			</ul>
			</div>
		</form>
	<script type="text/javascript">
		$(function() {
			//var my=$("#sel_Sub").val();
			//alert(my);

		});

		function assignMenu() {

			var ids = new Array();

			jQuery("input:checkbox[name=childMenus]:checked").each(function() {
				ids.push(jQuery(this).val());
			});

			jQuery("#menuIDs").val(ids.join(","));
			alert("选中："+jQuery("#menuIDs").val());
			var y = 0;
			var id = new Array();
			var parentIDes = $("input:checkbox[name=childMenus]").not(
					"input:checked");
			for (y; y < parentIDes.length; y++) {
				id[y] = parentIDes[y].value;
			}
			jQuery("#menuIDse").val(id.join(","));
			alert("没选中："+jQuery("#menuIDse").val());
			document.getElementById("menuForm").submit();
		}

		function SetSubID() {
			$("#myparentId").val($("#sel_Sub").val());
			// alert($("#myparentId").val());
		}

		$(function() {
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});
			$("#saveForm").Validform({
				tiptype : 2,
				callback : function(form) {
					form[0].submit();
					var index = parent.layer.getFrameIndex(window.name);
					parent.$('.btn-refresh').click();
					parent.layer.close(index);
				}
			});
		});
	</script>
</body>
</html>
