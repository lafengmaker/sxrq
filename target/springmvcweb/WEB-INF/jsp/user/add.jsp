<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%
String path=request.getContextPath();

%>
<!DOCTYPE meta PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=path %>/images/skin.css" rel="stylesheet" type="text/css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(document).ready( function() {
	$("#pwdshow").click(function(){
		if($(this).attr("checked")){
			$(".pwdtd").show();
		}else{
			$(".pwdtd").hide();
		}
	});
});
</script>
<style type="text/css">
 
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	/* background-color: #EEF2FB; 
	border: 1px red solid; */
}
-->
</style>
</head>
<body style="text-align: center;">

<sf:form  action="adduser" modelAttribute="userView" method="post" >
<sf:hidden path="id"/>
<table width="100%" border="0px" bordercolor="red" style="font-size: 13px; " >
<tr>
<td width="30%" align="right">用户名*</td>
<td width="30%"><sf:input path="username"/></td>
<td width="40%"><sf:errors cssClass="errorClass" path="username"/></td>
</tr>
<tr>
<td align="right">姓名*</td>
<td><sf:input path="name"/></td>
<td><sf:errors cssClass="errorClass" path="name"/></td>
</tr>
<tr>
<td align="right"></td>
<td><input type="checkbox" id="pwdshow" />修改密码</td>
</tr>
<tr  class="pwdtd" style="display: none;">
<td align="right">密码</td>
<td> <sf:password path="password1"/> </td>
<td><sf:errors cssClass="errorClass" path="password1"/></td>
</tr>
<tr   class="pwdtd"  style="display: none;">
<td align="right">确认密码</td>
<td><sf:password path="password2"/></td>
<td><sf:errors cssClass="errorClass" path="password2"/></td>
</tr>
<tr>
<td align="right">账户类型</td>
<td><sf:select  items="${rolelist}"  path="role">
	</sf:select></td>
<td><sf:errors cssClass="errorClass"  path="role"/></td>
</tr>
<tr>
<td align="right">账户状态</td>
<td><sf:select  items="${statuslist}" path="status">
	</sf:select> </td>
<td><sf:errors cssClass="errorClass" path="status"/></td>
</tr>
<tr>
<td colspan="3"> <input type="submit" value="保存"/> 带*号为必填项,新增时密码栏为空表示使用默认密码</td>
</tr>
</table>
</sf:form>
</body>
</html>
