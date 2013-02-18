<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c"            uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="fmt"            uri="http://java.sun.com/jsp/jstl/fmt"%>  
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
<script language="javascript" type="text/javascript" src="<%=path %>/js/jquery.form.js"></script>
<script language="javascript" type="text/javascript" src="<%=path %>/js/regexval.js"></script>
<script language="javascript" type="text/javascript" src="<%=path %>/js/printpage.js"></script>
<script type="text/javascript">
function submitweekdata(){
	var forc=$(".weekforecast");
	var desc=$(".description");
	var accvol=$(".accVol");
	var f=true
	var json="[";
	$(".ids").each(function(index){
		if(index!=0){
			json=json+","
		}
		json=json+"{'"+$(this).attr("name")+"':'"+$(this).val()+"',";
		var x=$(forc[index]).val();
		if(!x||numberchechk('m',x)){
			json=json+"'"+$(forc[index]).attr("name")+"':'"+x+"',";
		}else{
			alert('预测量'+x+'数字格式不正确！')
			f= false;
			return false ;
		}
		if($(accvol[index]).attr("name")){
			var y=$(accvol[index]).val();
			if(!y||numberchechk('m',y)){
				json=json+"'"+$(accvol[index]).attr("name")+"':'"+y+"',";
			}else{
				alert('审批量:'+y+'数字格式不正确！')
				f= false;
				return false ;
			}
		}
		if($(desc[index]).attr("name")){
			json=json+"'"+$(desc[index]).attr("name")+"':'"+$(desc[index]).val()+"'";
		}
		json+="}";
	});
	json=json+"]";
	if(f){
	$.ajax({
		   type : 'post',
		   url: "weeklistsubmit",
		   dataType:'text',
		   data :"p="+ json,
		   success: function(data){
		           alert(data);
		   },
		   error:function(e){
			   alert('失败'+e);
		   }
		});
	}
}
</script>
<script language="VBScript">
dim hkey_root,hkey_path,hkey_key
hkey_root="HKEY_CURRENT_USER"
hkey_path="\Software\Microsoft\Internet Explorer\PageSetup"
'//设置网页打印的页眉页脚为空
function pagesetup_null()
on error resume next
Set RegWsh = CreateObject("WScript.Shell")
hkey_key="\header"
RegWsh.RegWrite hkey_root+hkey_path+hkey_key,""
hkey_key="\footer"
RegWsh.RegWrite hkey_root+hkey_path+hkey_key,""
end function
'//设置网页打印的页眉页脚为默认值
function pagesetup_default()
on error resume next
Set RegWsh = CreateObject("WScript.Shell")
hkey_key="\header"
RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&w&b页码，&p/&P"
hkey_key="\footer"
RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&u&b&d"
end function
</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path %>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt" onclick="">周列表</div></td>
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
        <table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
          <tr class="title">
            <td height="27" class="bordertd" colspan="3" background="<%=path %>/images/news-title-bg.gif"><img src="<%=path %>/images/news-title-bg.gif" width="2" height="27"></td>
          </tr>
          <tr>
            <td height="14" align="center" class="bordertd" colspan="5" > <sf:form modelAttribute="scheduleSearch" action="weeklist">时间: <sf:input cssClass="Wdate"  onClick="WdatePicker()" path="date"/>用户:<sf:select disabled="${userdiable}" items="${userlist}" itemLabel="name" itemValue="id" path="userid"/> <input type="submit" value="刷新"> </sf:form></td>
          </tr>
          <tr>
            <td height="14" align="center" class="bordertd" colspan="5" >  <font color="red">该周计划填报的截止时间是: <fmt:formatDate value="${weekdead}"/> </font> </td>
          </tr>
          <sf:form action="weeklistsubmit" id="listform" modelAttribute="scheduleList">
          <tr>
            <td height="14" align="center"  class="bordertd" valign="bottom">时间</td>
            <td height="14" align="center"  class="bordertd" valign="bottom">预测量</td>
            <c:choose><c:when test="${userdiable}">&nbsp</c:when><c:otherwise><td height="14" align="center"	 class="bordertd" valign="bottom">审批量</td></c:otherwise>  </c:choose> 
          </tr>
          <c:forEach items="${scheduleList}" var="sch" varStatus="stutus">
          <tr>
            <td height="20" align="center" class="bordertd" valign="bottom"> <fmt:formatDate value="${sch.cdate}" pattern="yyyy-MM-dd"/>  </td>
            <td height="20" align="center" class="bordertd" valign="bottom"> <input type="hidden" class="ids" name="id" value="${sch.id}"> 
             <input type="text" class="weekforecast" <c:if test="${!(subable&&userdiable)}"> disabled="disabled" </c:if> name="weekforecast" value="${sch.weekforecast}">万方 </td>
            
            <c:choose><c:when test="${userdiable}">
           <%--  <input type="text" class="description" name="description" value="${sch.description}"> --%>
            </c:when><c:otherwise>
           <td height="20" align="center" class="bordertd" valign="bottom"> <input type="text" class="accVol" name="accVol" value="${sch.weekplan}">万方   </td>
            </c:otherwise> </c:choose>
           
            </tr>
          </c:forEach>
          <tr class="np">
           <td height="15" colspan="5">
           <c:if test="${subable&&userdiable}">
           &nbsp;&nbsp;<span class="sec1" onclick="submitweekdata()"> 提交&nbsp;&nbsp;&nbsp;&nbsp;</span>
           </c:if>
           <c:if test="${!userdiable}">
           &nbsp;&nbsp;<span class="sec1" onclick="printTure()"> 打印&nbsp;&nbsp;&nbsp;&nbsp;</span>
           &nbsp;&nbsp;<span class="sec1" onclick="submitweekdata()"> 审批&nbsp;&nbsp;&nbsp;&nbsp;</span>
           </c:if>
           </td>
          </tr> 
        </sf:form>
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
<div id='adduser' style="width: 700px;height: 400px; display:none" class="pop-box">
			<div class='tit'>
				<span class="tittext"></span><img src="<%=path %>/images/pic22.gif"  class="shutbut" onclick="hideDiv('adduser')"/>
			</div>
			<div class="pop-box-body">
				<div id="cusinfoslist"  style="width: 100%;" class="div">
					<iframe name="adduserfrm" id="adduserfrm"  height="400px" class="divif1"  frameborder=0  width="100%"></iframe>
				</div>
			</div>
</div>
<input type="hidden" name="qingkongyema" id="qingkongyema" class="tab" value="清空页码" onclick="pagesetup_null()">&nbsp;&nbsp;
<input type="hidden" class="tab" value="恢复页码" onclick="pagesetup_default()">
<div id="print" style="width:950px; border:0px red solid; display:none">
</div>
</body>
</html>