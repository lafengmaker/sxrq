<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c"            uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=path %>/images/skin.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/popflow.css" rel="stylesheet" type="text/css" />
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
function addgasuse(id){
	document.getElementById("adduserfrm").src="<%=path %>/gasuse/gasaddbefore";
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
function editid(id){
location="<%=path %>/pub/addNoticeBefore?id="+id;
}
function delid(id){
	var dd=confirm("确认删除这条公告信息？");
	if(dd){
	$.ajax({
	type : "post",
	url : "pubdel",
	dataType : "text",
	data : "id="+id,
	success : function(msg){
		alert('删除成功');
		refresh();
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
	$("#userfrom").submit();
}
</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path %>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt" onclick="">公告列表</div></td>
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
        <sf:form id="userfrom" modelAttribute="noticePub" action="publist">
        <input name="currpage" type="hidden" id="currentPage"  >
        <table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
          <tr>
            <td height="27" class="bordertd" colspan="7" background="<%=path %>/images/news-title-bg.gif"><img src="<%=path %>/images/news-title-bg.gif" width="2" height="27"></td>
          </tr>
          <tr>
            <td height="14" align="center" class="bordertd" colspan="7" > 公告标题   <sf:input path="title"/> 公告内容 <sf:input path="content"/>      <input type="submit" value="搜索"> </td>
          </tr>
          <tr>
            <td height="14" align="center"  class="bordertd" valign="bottom">序号</td>
            <td height="14" align="center"  class="bordertd" valign="bottom">标题</td>
            <td height="14" align="center"	 class="bordertd" valign="bottom">排序</td>
            <td height="14" align="center"	 class="bordertd" valign="bottom">内容</td>
            <td height="14" align="center"	 class="bordertd" valign="bottom">截止日期</td>
            <td height="14" align="center"	 class="bordertd" valign="bottom">操作</td>
          </tr>
          <c:forEach items="${pageView.records}" var="pub" varStatus="status">
          <tr>
            <td height="20" align="center" class="bordertd" valign="bottom">${status.index+1}&nbsp;</td>
            <td height="20" align="center" class="bordertd" valign="bottom">${pub.title}&nbsp;</td>
            <td height="20" align="center" class="bordertd" valign="bottom">${pub.showindex}&nbsp;</td>
            <td height="20" align="center" class="bordertd" valign="bottom"> 
            <c:choose> 
            <c:when test="${fn:length(pub.content)>15}">
            	<c:out value="${fn:substring(pub.content,1,15) }"></c:out>
            </c:when>
            <c:otherwise>${pub.content}</c:otherwise>
            </c:choose>&nbsp;
	</td>
            <td height="20" align="center" class="bordertd" valign="bottom"> <fmt:formatDate pattern="yyyy-MM-dd" value="${pub.enddate}"/>&nbsp; </td>
            <td height="20" align="center" class="bordertd" valign="bottom"> 
            <input type="button" onclick="editid(${pub.id})" value="修改">   
            <input type="button" onclick="delid(${pub.id})" value="删除">   
 </td>
          </tr>
          </c:forEach>
          <tr>
            <td height="5" colspan="5">&nbsp;</td>
          </tr>
        </table>
        </sf:form>
         <div align="right" class="pageinclude"> 
         				<jsp:include page="/fenye.jsp"></jsp:include>
					  	<script language="javascript">
					  		function getPageViewUrl(currentPage){
						  		$("#currentPage").val(currentPage);
						  		$("#user").submit();
						  	}
					  	</script>
		</div> 
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