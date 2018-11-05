<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.news.service.impl.*"%>
<%@ page import="org.news.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'do_update_top.jsp' starting page</title>
    
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
  int id=Integer.parseInt(request.getParameter("id"));
  String tname=request.getParameter("tname");
  Topic top=new Topic();
  top.setTid(id);
  top.setTname(tname);
  TopServiceImpl t=new TopServiceImpl();
  int count=t.updatePanDuan(top);
  if(count==1){
	  %>
	  <script>
	  alert("修改成功");
	  location.href="util/do_topic_list.jsp";
	  </script>
	  <% 
  }else{
	  %>
	  <script>
	  alert("修改失败");
	  location.href="util/do_topic_list.jsp";
	  </script>
	  <% 
  }
  %>
  
  
  </body>
</html>
