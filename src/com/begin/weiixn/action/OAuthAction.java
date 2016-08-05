package com.begin.weiixn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.weiixn.util.AccessTokenVO;
import com.begin.weiixn.util.GOauth2Core;
import com.begin.weiixn.util.ParamesAPI;
import com.begin.weiixn.util.WeixinUtil;

public class OAuthAction extends BaseAction{
	
	
	public String GoOAuth2() throws IOException, ServletException{
		
		
		  String url1=GOauth2Core.GetCode();
		  response.sendRedirect(url1);
		   
		  
		  
		  return null;
		}
	
	public String GoOAuth()throws IOException, ServletException{
		
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8"); 
		  
		  PrintWriter out = response.getWriter();
		  String code = request.getParameter("code");
		  System.out.println("code="+code);
		  String access_token="";
		
			   AccessTokenVO am=(AccessTokenVO) getHttpSession().getAttribute("MYACTOKEN");
			   if(null!=am){
				   
				   //access_token= am.getToken();
				   out.print("Code="+code+"  UserID="+am.getUserID()+"  access_token="+am.getToken());
			   }else{
				    access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
				    String UserID = GOauth2Core.GetUserID(access_token, code, "10");
				    
				    HttpSession ht=ServletActionContext.getRequest().getSession();
				    ht.setMaxInactiveInterval(7200);//设置过期时间
					AccessTokenVO avo=new AccessTokenVO();
					
					avo.setToken(access_token);//tok
					avo.setCode(code);//cod
					avo.setUserID(UserID);//user ID
					
					ht.setAttribute("MYACTOKEN", avo);//放入session*/
					out.print("Code="+code+"  UserID="+UserID+"  access_token="+access_token);
			   }
		  //agentid 跳转链接时所在的企业应用ID 管理员须拥有agent的使用权限；agentid必须和跳转链接时所在的企业应用ID相同
		  //String UserID = GOauth2Core.GetUserID(access_token, code, "10");
		  //out.print("Code="+code+"  UserID="+UserID+"  access_token="+access_token);
		
		
		 return null;
	}
		
		
	
}
