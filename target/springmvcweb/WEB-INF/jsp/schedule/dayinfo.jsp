<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c"            uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<%
String path=request.getContextPath();

%>
<!DOCTYPE meta PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=path %>/images/skin.css" rel="stylesheet" type="text/css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
.bordertd{
	background-color:#FDFEFE;
	border-right: 1px #CCCCCC solid;
	border-bottom: 1px #CCCCCC solid;
	font-size: 13px;
}
-->
</style>
<script language="javascript" type="text/javascript" src="<%=path %>/js/datepicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
<script language="javascript" type="text/javascript" src="<%=path %>/js/flow.js"></script>
<script language="javascript" type="text/javascript" src="<%=path %>/js/iframe.js"></script>
<script type="text/javascript">
function addnewuser(id){
	if(id){
		id='?id='+id;
	}
	document.getElementById("adduserfrm").src="<%=path %>/user/addpage"+id;
	popupDiv('adduser',200);
}
function del(id){
	var dd=confirm("确认删除此用户?");
	if(dd){
	$.ajax({
	type : "post",
	url : "del",
	dataType : "text",
	data : "id="+id,
	success : function(msg){
		alert('删除成功');
		$("#currentPage").val(1);
  		$("#user").submit();
	},
	error : function(msg){
		alert("删除失败");
	}
	}
	);
	}
}
function refresh(){
	$("#currentPage").val(1);
	$("#user").submit();
}
</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path %>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt" onclick="">用户列表</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="<%=path %>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
    
      <tr>
        <td colspan="2" valign="top">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="4" valign="top">&nbsp;
       <table style="font-size: 13px;">
  <tr>
 <td colspan="4"><sf:form modelAttribute="scheduleSearch" action="day">时间: <sf:input cssClass="Wdate"  onClick="WdatePicker()" path="date"/>用户:<sf:select items="${userlist}" disabled="true" itemLabel="name" itemValue="id" path="userid"/> <input type="submit" value="刷新"> </sf:form></td>
 </tr>
 <sf:errors path="userSchedule.dayVol" cssClass="errorClass"></sf:errors>
 <sf:errors path="userSchedule.changeVol" cssClass="errorClass"></sf:errors>
  <sf:form modelAttribute="day" action="daysubmit">
 <c:choose>
 <c:when test="${!(day.id eq null)}">
 <td colspan="4"><font color="red">当日的填报截止时间是: ${deadline}</font></td>
 <tr>
 <td>用户单位:<sf:hidden path="id"/> </td>
 <td>${day.buser.name}</td>
 <td></td>
 <td></td>
 </tr>
 <tr>
 <td>指定时间</td>
 <td><fmt:formatDate value="${day.cdate}" pattern="yyyy-MM-dd"/>&nbsp;8:00 至 <fmt:formatDate value="${day1}" pattern="yyyy-MM-dd"/>&nbsp;8:00  </td>
 <td></td>
 <td></td>
 </tr>
 <tr>
 <td>计划状态</td>
 <td>
 <c:choose>
 <c:when test="${day.status=='0'}">未提交</c:when>
 <c:when test="${day.status=='1'}">已提交待审批</c:when>
 <c:when test="${day.status=='2'}">已审批</c:when>
 </c:choose>
 </td>
 <td></td>
 <td></td>
 </tr>
 <tr>
 <td>周预测量</td>
 <td>${day.weekforecast}</td>
 <td></td>
 <td></td>
 </tr>
 <c:choose>
 <c:when test="${submitable}">
 <tr>
 <td>指定气量</td>
 <td>
 	<sf:input path="dayVol"/> <sf:errors path="*" cssClass="errorClass"></sf:errors>   <sf:errors path="dayVol"></sf:errors>
</td>
 <td></td>
 <td></td>
 </tr>
 <tr>
 <td>用户备注</td>
 <td>
 	<sf:input path="description"/>
</td>
 <td></td>
 <td></td>
 </tr>
 </c:when>
 <c:otherwise>
 <tr>
 <td>指定气量</td>
 <td>
 	${day.dayVol}
</td>
 <td></td>
 <td></td>
 </tr>
 <tr>
 <td>用户备注</td>
 <td>
 	${day.description}
</td>
 <td></td>
 <td></td>
 </tr>
 </c:otherwise>
 </c:choose>
 <c:if test="${day.status=='0'}">
 <tr>
 <td colspan="4">
 <input type="hidden" value="1" name="type">
 <input type="submit" value="提交"> </td>
 </tr>
 </c:if>
 <c:if test="${changeable}">
 <tr>
 <td>变更气量</td>
 <td>
 	<sf:input path="changeVol"/>
</td>
 <td>变更备注</td>
 <td>
 <sf:input path="changedesc"/>
 </td>
 </tr>
 <tr>
 <td colspan="4"><input type="submit" value="变更"> </td>
 </tr>
 </c:if>
 </c:when>
 <c:otherwise>
 <tr>
 <td colspan="4">没有当日数据</td>
 </tr>
 </c:otherwise>
 </c:choose>
 </sf:form>	
 <tr>
 
 </tr>
 </table>
        </td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="40" colspan="4"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
          <tr>
            <td></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>
 
