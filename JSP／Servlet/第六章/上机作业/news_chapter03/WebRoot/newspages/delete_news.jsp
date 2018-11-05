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
    
    <title>My JSP 'delete.jsp' starting page</title>
    
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
  String id=(String)request.getParameter("id");
  NewsServiceImpl nn=new NewsServiceImpl();
  String yuju=nn.delPanDuan(Integer.parseInt(id));
  if(yuju.equals("删除成功")){
	 %>
	 <script>
	 alert("删除成功");
	 location.href="newspages/admin.jsp";
	 </script>
	  <% 
	 //request.getRequestDispatcher("admin.jsp").forward(request,response);
  }else if(yuju.equals("删除失败")){
	  %>
		 <script>
		 alert("删除失败");
		 location.href="newspages/admin.jsp";
		 </script>
		  <% 
  }
  %>
 
  </body>
</html>
