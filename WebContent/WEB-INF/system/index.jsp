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
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
   	<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src='<%=basePath%>js/index.js'></script>
    <script type="text/javascript">
    	var _menus=null;
    
    	$.ajax({
	        type:"get",
	        url:"<%=basePath%>json/MenuJson",
	        dataType:"json",
	       async:false, 
	        success:function(data){
	     	  _menus=data;
	     	  //alert(_menus);
	        },
	        error:function(data){
	     	   
	        }
	     })
	     
		//设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }
        
        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = '<%=basePath%>sysUser/loginout';
                    }
                });
            })
        });
    </script>
  </head>
<body class="easyui-layout" fit="true" scroll="no">
	<noscript>
		<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
		    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 60px;
        background: url(images/layout-browser-hd-bg.gif);
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="padding-left:10px; font-size: 16px; float:left;"><img src="images/logo.png" height="35" align="absmiddle" style="padding-top:10px;" /></span>
        <span style="float:right; padding-right:20px;" class="head">上次登录时间：<s:date name="#session['xqdPassport'].lastLoginTime" format="yyyy-MM-dd HH:mm:ss"/> 欢迎 <s:property value="#session['xqdPassport'].userName" /> <a href="javascript:void(0)" id="editpass">修改密码</a> <a href="javascript:void(0)" id="loginOut">安全退出</a></span>
        
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">版权所有 浙江新启点信息科技有限公司</div>
    </div> 
    <div region="west" split="true" title="导航菜单" style="width:180px;" id="west">
		<div id='wnav' class="easyui-accordion" fit="true" border="false">
		</div>
    </div>
    
    <div id="mainPanle" region="center" style="background: #eee;">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;" id="home" closable="true">
				
			<iframe scrolling="auto" frameborder="0"  src="" style="width:100%;height:100%;"></iframe>

			</div>
		</div>
    </div>
    
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="Password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="Password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>


</body>
</html>
