<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>dd</title>
<script language=JavaScript>
function logout(){
	if (confirm("确认退出?"))
	top.location = "logout";
	return false;
}
</script>
<script language=JavaScript1.2>
function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}
</script>
<meta http-equiv=Content-Type content=text/html;charset=gb2312>
<meta http-equiv="refresh" content="60">
<script language=JavaScript1.2>
function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}
</script>
<base target="main">
<link href="images/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="50%" height="64"><img src="images/logo.gif" width="262" height="64"></td>
    <td width="50%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt" align="right"> 
        <c:if test="${user.role== '1'}"> 管理员: </c:if>
        <c:if test="${user.role== '0'}"> 普通用户: </c:if>
          <b>${user.name}</b>     &nbsp; &nbsp; &nbsp; &nbsp;     欢迎您使用本系统${date}</td>
        <td width="22%" ><a href="#" target="_self" onClick="logout();"><img src="images/out.gif" alt="°²È«ÍË³ö" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
