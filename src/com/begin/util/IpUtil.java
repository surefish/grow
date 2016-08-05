package com.begin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 * 
 * @author
 * 
 */
public class IpUtil {

	/**
	 * 获取登录用户IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf("0:") != -1) {
			ip = "本地";
		}
		return ip;
	}
	
	public static String getAddressByIP(String ip){ 
	  try
	  {
	    String strIP = ip;
	    URL url = new URL( "http://ip.qq.com/cgi-bin/searchip?searchip1=" + strIP); 
	    URLConnection conn = url.openConnection(); 
	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK")); 
	    String line = null; 
	    StringBuffer result = new StringBuffer(); 
	    while((line = reader.readLine()) != null)
	    { 
	      result.append(line); 
	    } 
	    reader.close(); 
	    strIP = result.substring(result.indexOf( "该IP所在地为：" ));
	    strIP = strIP.substring(strIP.indexOf( "：") + 1);
	    String province = strIP.substring(6, strIP.indexOf("省"));
	    String city = strIP.substring(strIP.indexOf("省") + 1, strIP.indexOf("市"));
	    String rs=province+city;
	    //System.out.println(rs);
	   return rs;
	  }
	  catch( IOException e)
	  { 
	    return "读取失败"; 
	  }
	}
	
	public static void main(String[] args) {
		
		 new IpUtil().getAddressByIP("123.157.239.50");
	}

}
