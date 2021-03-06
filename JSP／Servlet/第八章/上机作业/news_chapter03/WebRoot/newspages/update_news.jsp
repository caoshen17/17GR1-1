<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type"> 修改新闻： </h1>
    <%
    request.setCharacterEncoding("utf-8");
    String id=request.getParameter("id");
    %>
    <form action="../TopServlet?id=<%=id%>" method="post">
      <p>
        <label> 主题 </label>
        <select name="ntid">
          <option value="国内">选择</option>
          <option value='国内'> 国内 </option>
          <option value='国际'> 国际 </option>
          <option value='军事'> 军事 </option>
          <option value='体育'> 体育 </option>
          <option value='娱乐'> 娱乐 </option>
          <option value='社会'> 社会 </option>
          <option value='财经'> 财经 </option>
          <option value='科技'> 科技 </option>
          <option value='健康'> 健康 </option>
          <option value='汽车'> 汽车 </option>
          <option value='教育'> 教育 </option>
          <option value='房产'> 房产 </option>
          <option value='家居'> 家居 </option>
          <option value='旅游'> 旅游 </option>
          <option value='文化'> 文化 </option>
          <option value='其他'> 其他 </option>
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" class="opt_input" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" class="opt_input" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" cols="40" rows="3"></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" cols="70" rows="10"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input" />
      </p>
      <input name="yin" type="hidden" value="xiunews"/>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
    
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
