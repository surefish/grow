<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.Enumeration"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
	var query = "";
</script>

<script type="text/javascript">
<%
	Enumeration<String> parameterNames = request.getParameterNames();
	while(parameterNames.hasMoreElements()) {
		String paramName = parameterNames.nextElement();
		if (!"message".equals(paramName) && !"currentPageNO".equals(paramName)) {
			String str = "query+=\"" + paramName + "=" + request.getParameter(paramName) + "&\";";
			%><%=str%><%
		}
	}
%>
</script>
<script>
	function viewResult(page) {
		var url = "<s:property value=" + getHttpRequest().get('javax.servlet.forward.request_uri') + " />?" + query + "currentPageNO=" + page;
		window.location.href = url;
	}
</script>
<div class="page_ri">
	<span> <s:property value="#listinfo.first+1" />&nbsp;/&nbsp;<s:property
			value="#listinfo.first+#listinfo.max" />
	</span>

	<s:if test="#listinfo.currentPageNO>1">
		<img src="<%=basePath%>images/start.gif" border="0" align="texttop" style="cursor: pointer" onclick="javascript:viewResult(1)"/>
		<img src="<%=basePath%>images/previous.gif" border="0" align="texttop" onclick="javascript:viewResult(<s:property value='#listinfo.currentPageNO-1'/>)"
			style="cursor: pointer" />
	</s:if>
	<s:else>
		<img src="<%=basePath%>images/start.gif" border="0" align="texttop" onclick=""
			style="cursor: pointer" />
		<img src="<%=basePath%>images/previous.gif" border="0" align="texttop"
			onclick="" style="cursor: pointer" />
	</s:else>
			
	<s:iterator id="page" value="#listinfo.pages" status="a">
		<s:if test="#listinfo.currentPageNO==#page">
			<a href="javascript:viewResult(<s:property value="#page"/>)"><s:property value="#page" /></a>
		</s:if>
		<s:else>
			<a href="javascript:viewResult(<s:property value="#page"/>)"><s:property value="#page" /></a>
		</s:else>
	</s:iterator>	 
	<s:if
		test="#listinfo.currentPageNO!=#listinfo.maxPageNO&&#listinfo.maxPageNO!=0">
		<img src="<%=basePath%>images/next.gif" border="0" align="texttop" style="cursor: pointer" onclick="javascript:viewResult(<s:property value='#listinfo.currentPageNO+1'/>)"/>
		<img src="<%=basePath%>images/end.gif" border="0" align="texttop" style="cursor: pointer" onclick="javascript:viewResult(<s:property value='#listinfo.maxPageNO'/>)"/>
	</s:if>
	<s:else>
		<img src="<%=basePath%>images/next.gif" border="0" align="texttop"  onclick="" style="cursor:pointer"/> 
		<img src="<%=basePath%>images/end.gif" border="0" align="texttop"  onclick="" style="cursor:pointer"/>
	</s:else>
</div>