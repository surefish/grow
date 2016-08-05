package com.begin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public EncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		((HttpServletResponse) response).setHeader("Pragma", "No-cache");
		((HttpServletResponse) response).setHeader("Cache-Control", "no-cache");
		((HttpServletResponse) response).setHeader("Expires", "0");
		// ServletContext
		// application=((HttpServletRequest)request).getSession().getServletContext();
		System.out.println("过滤器执行了！");
		String requestURI = ((HttpServletRequest)request).getRequestURI();
		System.out.println(requestURI);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
