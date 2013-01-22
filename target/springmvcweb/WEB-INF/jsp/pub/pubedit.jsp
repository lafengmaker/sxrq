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

<sf:form  action="noticeadd" modelAttribute="noticePub" method="post" >
<sf:hidden path="id"/>
<table width="100%" border="0px" bordercolor="red" style="font-size: 13px; " >
<tr>
<td width="10%" align="right">标题*</td>
<td width="90%"> <sf:input path="title" maxlength="500" size="90"  /><sf:errors cssClass="errorClass" path="title"/>  </td>
</tr>
<tr>
<td align="right">发起人*</td>
<td> <sf:input path="adduser"/> <sf:errors cssClass="errorClass" path="adduser"/></td>
</tr>
<tr>
<td align="right">截止日期</td>
<td> <input id="sdate" type="text" onfocus="WdatePicker()"  class="Wdate" value="${noticePub.enddate}"  name="enddate"/> <sf:errors cssClass="errorClass"  path="enddate"/> </td>
</tr>
<tr>
<td align="right">排序</td>
<td> <sf:input path="showindex"  />输入数字，数字越大越靠前<sf:errors path="showindex"></sf:errors>  </td>
</tr>
<tr>
<td align="right">公告内容:</td>
<td> <sf:textarea cols="90" rows="25" path="content"/> </td>
</tr>
<tr>
<td colspan="3"> <input type="submit" value="保存"/></td>
</tr>
</table>
</sf:form>
</body>
</html>
