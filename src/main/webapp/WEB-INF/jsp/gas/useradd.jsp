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
<script language="javascript" type="text/javascript" src="<%=path %>/js/datepicker/WdatePicker.js"></script>
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

<sf:form  action="gasadd" modelAttribute="gasUseView" method="post" >
<sf:hidden path="id"/>
<table width="100%" border="0px" bordercolor="red" style="font-size: 13px; " >
<tr>
<td width="30%" align="right">用户*</td>
<td width="30%"> <sf:select path="userid" items="${users}" itemLabel="name" itemValue="id"></sf:select></td>
<td width="40%"><sf:errors cssClass="errorClass" path="userid"/></td>
</tr>
<tr>
<td align="right">日期*</td>
<td> <input id="sdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  class="Wdate" value="${gasUseView.addtime}"  name="addtime"/> </td>
<td><sf:errors cssClass="errorClass" path="addtime"/></td>
</tr>
<tr>
<td align="right">*用气量</td>
<td> <sf:input path="gasvol"/> </td>
<td><sf:errors cssClass="errorClass"  path="gasvol"/></td>
</tr>
<tr>
<td align="right">备注</td>
<td> <sf:textarea path="description"/> </td>
<td></td>
</tr>
<tr>
<td colspan="3"> <input type="submit" value="保存"/></td>
</tr>
</table>
</sf:form>
</body>
</html>
