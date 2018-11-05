<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.news.service.impl.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete_top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  request.setCharacterEncoding("utf-8");
  int tid=Integer.parseInt(request.getParameter("id"));
  TopServiceImpl t=new TopServiceImpl();
  int count=t.delPanDuan(tid);
  if(count==1){
	  %>
	  <script>
	  alert("删除成功");
	  location.href="util/do_topic_list.jsp";
	  </script>
	  <%
  }else{
	  %>
	  <script>
	  alert("删除失败");
	  location.href="util/do_topic_list.jsp";
	  </script>
	  <%
  }
  %>
  
  </body>
</html>
