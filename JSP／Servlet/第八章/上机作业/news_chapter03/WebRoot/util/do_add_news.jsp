<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.news.service.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'do_add_news.jsp' starting page</title>
    
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
   String xiala=request.getParameter("ntid");
   String biaoti=request.getParameter("ntitle");
   String zuozhe=request.getParameter("nauthor");
   String zaiyao=request.getParameter("nsummary");
   String neirong=request.getParameter("ncontent");
   Object ob[]={xiala,biaoti,zuozhe,zaiyao,neirong};
   NewsServiceImpl n=new NewsServiceImpl();
   int count=n.addPanDuan(ob);
   if(count==1){
	   %>
	   <script>
	   alert('添加成功');
	   location.href="newspages/admin.jsp";
	   </script>
	   
  <%}%>
  </body>
</html>
