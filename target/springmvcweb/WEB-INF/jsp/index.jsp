<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
String path=request.getContextPath();

%>
<html>
<head>
<title>后台管理系统</title>
<meta http-equiv=Content-Type content=text/html;charset=gb2312>
</head>
<frameset rows="64,*"  frameborder="NO" border="0" framespacing="0">
	<frame src="admin_top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
  <frameset cols="200,*"  rows="560,*" id="frame">
	<frame src="left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
	<frame src="welcomeinfo" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
  </frameset>
<noframes>
    </noframes>
  <body>
  </body>
</html>
