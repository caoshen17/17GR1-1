<%@page import="org.news.service.impl.NewsServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.news.dao.impl.*"%>
<%@ page import="org.news.util.*"%>
<%@ page import="org.news.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news_control.jsp' starting page</title>
    
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
int nid=Integer.parseInt(request.getParameter("nid"));
NewsServiceImpl n=new NewsServiceImpl();
News news=n.panDuanNews(nid);
request.setAttribute("news", news);
if(news==null){
	response.sendRedirect("../index.jsp");
}else{
request.getRequestDispatcher("../newspages/news_read.jsp").forward(request,response);
}
%>

  
  </body>
</html>
