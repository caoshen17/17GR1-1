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
    
    <title>My JSP 'do_upadte.jsp' starting page</title>
    
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
   String xiala=request.getParameter("ntid");
   String biaoti=request.getParameter("ntitle");
   String zuozhe=request.getParameter("nauthor");
   String zaiyao=request.getParameter("nsummary");
   String neirong=request.getParameter("ncontent");
   Object ob[]={xiala,biaoti,zuozhe,zaiyao,neirong};
   NewsServiceImpl n=new NewsServiceImpl();
   int count=n.upPanDuan(id, ob);
   if(count==1){
	   //response.sendRedirect("../newspages/admin.jsp");
	   %>
	   <script>
	   alert("修改成功");
	   location.href="newspages/admin.jsp";
	   </script>
	   <%
   }else{
	  // response.sendRedirect("../newspages/admin.jsp");
	   %>
	   <script>
	   alert("修改失败");
	   location.href="newspages/admin.jsp";
	   </script>
	   <%
   }
   %>
  </body>
</html>
