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
 NewsServiceImpl n=new NewsServiceImpl();
 request.setCharacterEncoding("utf-8");
 String pageindex =request.getParameter("pageIndex");
  if(pageindex==null){
	  pageindex="1";
  }
 int xx=Integer.parseInt(pageindex);
 if(xx<1){
	 xx=1;
 }
 Page pp=new Page();
 pp.setPageNumber(xx);
 pp.setPageTiao(6);
 n.fenYe(pp);
 List<News> lis=pp.getNewsList();
 request.setAttribute("pa", pp);
 request.setAttribute("lis", lis);
 request.getRequestDispatcher("../index.jsp").forward(request,response);
  %>
  
  
  </body>
</html>
