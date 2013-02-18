<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	$("#upfile").click(function(){
		var html="<tr><td>&nbsp;</td><td  align='left'><input type='file' name='file'/>&nbsp;&nbsp;&nbsp; <span class='sec1' onclick='delfile(this)' > &nbsp;&nbsp;删除&nbsp;&nbsp;</span> </td></tr>"
		$("#filetr").before(html);
	});
});
	function delfile(obj){
		$(obj).parent().parent().remove();
	}
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

<sf:form  action="noticeadd" modelAttribute="noticePub" method="post" enctype="multipart/form-data" >
<sf:hidden path="id"/>
<table width="100%" border="0px" bordercolor="red" style="font-size: 13px; " >
<tr>
<td width="10%" align="right">标题*</td>
<td width="90%" align="left"> <sf:input path="title" maxlength="500" size="90"  /><sf:errors cssClass="errorClass" path="title"/>  </td>
</tr>
<tr>
<td align="right">发起人*</td>
<td align="left"> <sf:input path="adduser"/> <sf:errors cssClass="errorClass" path="adduser"/></td>
</tr>
<tr>
<td align="right">截止日期</td>
<td align="left"> <input id="sdate" type="text" onfocus="WdatePicker()"  class="Wdate" value="<fmt:formatDate value='${noticePub.enddate}' pattern='yyyy-MM-dd'/>"  name="enddate"/> <sf:errors cssClass="errorClass"  path="enddate"/> </td>
</tr>
<tr>
<td align="right">接收人</td>
<td align="left"> <sf:select path="touser" items="${users}" itemLabel="name" itemValue="id"></sf:select>  </td>
</tr>
<tr>
<td align="right">排序</td>
<td align="left"> <sf:input path="showindex"  />输入数字，数字越大越靠前<sf:errors path="showindex"></sf:errors>  </td>
</tr>
<tr>
<td align="right">公告内容:</td>
<td align="left"> <sf:textarea cols="90" rows="20" path="content"/> </td>
</tr>
<c:forEach items="${noticePub.vfList}" var="vf" varStatus="st">
<tr>
<td align="right">附件${st.index+1}:</td>
<td align="left"> ${vf.realFile.name} <input type="hidden" name="vfid" value="${vf.id}"/> <span class='sec1' onclick='delfile(this)' > &nbsp;&nbsp;删除&nbsp;&nbsp;</span>  </td>
</tr>
</c:forEach>
<tr id="filetr">
<td  align="left">  <input type="button" id="upfile"    value="添加附件"/>   </td>
</tr>
<tr>
<td > <input type="submit" value="保存"/></td>
</tr>
</table>
</sf:form>
</body>
</html>
