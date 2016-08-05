<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>成长快乐后台管理平台</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="all" name="robots" />
		<meta name="author" content="作者信息" />
		<meta name="Copyright" content="版权信息" />
		<meta name="description" content="站点介绍" />
		<meta name="keywords" content="站点关键词" />
		<link rel="icon" href="/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- <script language="javascript" src="http://rz.wzu.edu.cn:80/zfca/js/ukeylogin.js"></script> -->
		<script type='text/javascript' src='dwr/interface/UsermanAjax.js'></script>
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script language="javascript" src="js/BatAjax.js"></script>
		<link href="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/css/bootstrap.min.css" rel="stylesheet">
		<link href="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/css/base.css" rel="stylesheet">
		<script src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/js/jquery-1.11.0.min.js"></script>
		<script src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/js/bootstrap.min.js"></script>
		<!--[if lt IE 9]>
			<script src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/js/html5shiv.min.js"></script>
			<script src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/js/respond.min.js"></script>
		<![endif]-->
		<script type='text/javascript'>
			if (top != window) {
				top.window.location.href = '/zfca/logout?' + new Date().getTime();
			}
			
		
		
		</script>
		<style>
		.img{
		margin-top:30px;
		}
		.text
		{
		margin-top:30px;
		float:right;
		}
		</style>
	</head>

	<body style="background:#fafafa;">
		<form id="loginformis" name="fm1" class="fm-v clearfix" action="<%=basePath%>sysUser/logining" method="post">
			<input type="hidden" id="useValidateCode" name="useValidateCode" value="0" />
			<input type="hidden" id="isremenberme" name="isremenberme" value="1" />
			<input type="hidden" id="ip" name="ip" value="" />
			<div class="container container_1170">
				<div class="row sl_log_top margin-b20">
					<div class="logo_1 col-sm-6">
						<p class="pull-left col-md-6 col-sm-12 col-xs-12">统一身份认证中心</p>
					</div>
					<div class="col-xs-12 text-right visible-xs-block"><a href="#sm">登陆说明</a></div>
				</div>
				<div class="row sl_log_bor4" style="background: #fff;">
					<div class="col-sm-8 hidden-xs sl_log_lf"> <img class="img-responsive" src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/img/login_bg_pic2.jpg" /> </div>
					<div class="col-sm-4 sl_log_rt form-horizontal" style="padding: 15px;">
						<h5>用户登录</h5>
						
						<p id="msg"></p>
					
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon"><img src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/images/log_ic01.png" width="16" height="16" /></div>
								<input id="userName" name="userName" class="form-control" tabindex="1" onmouseout="setCookieValue();" onkeypress="if(event.keyCode==13||event.keyCode==9){document.getElementById('password').focus(); return false;}" onkeyup="noPermitInput();" onfocus="hideMsg();"
								accesskey="n" type="text" value="" autocomplete="false" />
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon"><img src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/images/log_ic02.png" width="16" height="16" /></div>
								<input id="passWord" name="passWord" class="form-control" tabindex="2" onkeypress="if(document.getElementById('useValidateCode').value == '1'){if(event.keyCode==13||event.keyCode==9){document.getElementById('j_captcha_response').focus();return false;}}"
								onkeyup="pwStrength(this.value);" onfocus="hideMsgOne();" accesskey="p" type="password" value="" autocomplete="off" />
							</div>
						</div>
					<div><input id="checkCode" class="form-control" name="checkCode" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码'}" onclick="if(this.value=='验证码'){this.value='';}" value="" class="logincheck">
 			<img id="imgcode" alt="点击图片换一张！" src="checkCode" onclick="refreshCheckCode();return false;" class="img"/> <a class="text" id="kanbuq" href="javascript:refreshCheckCode();">看不清，换一张</a> <s:actionmessage/></div>
	    	<button type="submit" onclick=" submitForm();" class="btn btn-primary btn-block" style="margin-top:50px">登 录</button>
	    	
 		
	    </div>
						


					</div>
					<div class="row login-about">

					<div class="col-md-4 col-sm-12">
						<div class="media">
							<a class="pull-left" name="sm">
								<img class="media-object" data-src="holder.js/90x90" alt="90x90" src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/img/login-about-1.png" style="width: 90px; height: 90px;">
							</a>
							<div class="media-body">
								<h4 class="media-heading">平台介绍</h4>成长快乐后台管理平台，提供数据录入，数据分析，图片报表能功能。
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-12">
						<div class="media">
							<a class="pull-left" href="#">
								<img class="media-object" data-src="holder.js/90x90" alt="90x90" src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/img/login-about-2.png" style="width: 90px; height: 90px;">
							</a>
							<div class="media-body">
								<h4 class="media-heading">登录提示</h4> 不同角色登录账户不同，权限不同，功能不同。
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-12">
						<div class="media">
							<a class="pull-left" href="#">
								<img class="media-object" data-src="holder.js/90x90" alt="90x90" src="http://rz.wzu.edu.cn:80/zfca/login/zfstyle_v5/img/login-about-3.png" style="width: 90px; height: 90px;">
							</a>
							<div class="media-body">
								<h4 class="media-heading">温馨提示</h4> 为保障您的密码安全，请不要设置过短的密码				
							</div>
						</div>
					</div>
				</div>
				</div>
				

				<!-- <div class="sl_log_ewm hidden-xs"><img src="../../img/login_ewm.gif" width="90" height="90"/>&nbsp;&nbsp;<span>用手机扫一扫,<br />安全、便捷登陆</span></div> -->

			</div>
			</div>
			<div class="footer" style="margin-top: 60px;">
				<p>技术支持：浙江新启点信息科技有限公司</p>
			</div>


	<div class="sxsj" style="display: none">
							<label for="">
								失效时间：
							</label>
							<input id="losetime" name="losetime" tabindex="4" type="text" value=""/>
							分钟
						</div>
				



	

			</form>
			<script type="text/javascript">		
			
			function refreshCheckCode(){
			$("#imgcode").attr("src","<%=basePath%>sysUser/checkCode?id="+new Date().getTime());
		}
		function submitForm() {		
			var userName = $("#userName").val();
			var userPass = $("#passWord").val();
			var checkCode = $("#checkCode").val();
			
			if(userName.length==0){
			 alert("请输入用户名！");
			 return false;
			}
			if(userPass.length==0){
			 alert("请输入密码！");
			 return false;
			}
			if(checkCode.length==0){
			 alert("请输入验证码！");
			 return false;
			}else {
			 document.getElementById("loginformis").submit();
			}
		}
					
			
			
	
           



     
   
   
   
	
	
 </script>
	
	</body>
</html>