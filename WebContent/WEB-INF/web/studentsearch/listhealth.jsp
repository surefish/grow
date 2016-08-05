<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
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
   	<script type="text/javascript">
  		var url;
       
        
        function edit(){
         var row = $('#dg').datagrid('getSelected');
         if(null==row){
          alert("请选择要查看的行!");
          return;
         }else{
         //alert("fuID:"+row.fuID);
          window.location.href = '<%=basePath%>thealth/getTStudentID?tstudentID='+row.fuID;
         }
         }
        
       	function doSearch(){
		        //alert("1111");
				
				var fuserName = $('#ss').searchbox('getValue');
			
				
				//alert(fuserName);
				window.location.href="<%=basePath%>tstudentsearch/listThealth.action?fname="
						+ fuserName;
				
				
			
			}
        
       
       
       
          
	  	$(function(){
	  	
		  	$('#dg').datagrid({ 
	        //title:'用户管理', 
	        iconCls:'icon-edit',//图标 
	        width: 'auto', 
	        height: 'auto', 
	        nowrap: false, 
	        striped: true, 
	        border: false, 
	        collapsible:false,//是否可折叠的 
	        fit: true,//自动大小 
	        url:'<%=basePath%>tstudentsearch/listhealthjson', 
	        //sortName: 'code', 
	        //sortOrder: 'desc',  
	        remoteSort:false,  
	        idField:'id', 
	        singleSelect:true,//是否单选 
	        pagination:true,//分页控件 
	        rownumbers:true,//行号 
	        frozenColumns:[[ 
	            {field:'ck',checkbox:true} 
	        ]], 
	    }); 
	    //设置分页控件 
	    var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [5,10,15],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	        /*onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');
	        }*/ 
	    	});
    	});
    	
    	
  	</script>
  </head>
  
  <body>
    <table id="dg" class="easyui-datagrid" toolbar="#toolbar">
        <thead>
            <tr>
                <th field="fuID"  hidden="true" ></th>
            	<th field="fno"  width="200">学号</th>
                <th field="fname" width="80">姓名</th>
                <th field="fleftv" width="150">视力-左眼</th>        
                <th field="frightv" width="150">视力-右眼</th>
                <th field="fheight" width="100">身高</th>
                 <th field="fweight" width="50">体重</th>
                  <th field="ftooth" width="50">牙齿</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
    	<div style="margin-top:5px;margin-bottom:5px;margin-left:25px">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">查看</a>
	        <input id="ss" class="easyui-searchbox" data-options="searcher:doSearch" style="width:300px"></input>
            
</div>
	        
	        
    		<!-- 
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="enable()">启用</a>
	        <span style="height:24px;font-weight:bold;color:#8E8E8E">|</span>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="disable()">禁用</a>
    		<span style="height:24px;font-weight:bold;color:#8E8E8E">|</span>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="role()">分配角色</a> -->
    	</div>
    </div>
    <div id="w" class="easyui-window" closed="true" title="分配角色" data-options="iconCls:'icon-save',minimizable:false" style="width:600px;height:400px;padding:10px;">
		<iframe id="myframe" scrolling="yes" frameborder="0" style="width:100%;height:100%;" src=""></iframe>
	</div>
</body>
</html>
