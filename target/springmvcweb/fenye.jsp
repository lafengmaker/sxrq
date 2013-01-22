<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	 <input type="hidden" id="pagetotale" value="${pageView.totalpage}" >
  	 <table class="fenyetab"><tr><td>总记录数:${pageView.totalrecord}条&nbsp;共${pageView.totalpage}页&nbsp;</td>
  	  <td><a href="javascript:gotoPage(1)" style="text-decoration:none">首页</a></td>
  	  <td style="display: none">
  	  <input class="tiaoshu" id="tiaoshu" value="${pageView.totalrecord}" /></td>
  	  <td>
  	  <c:choose>
	   <c:when test="${pageView.currentpage gt 1}">
	    <a href="javascript:gotoPage(${pageView.currentpage - 1})" style="text-decoration:none">上一页</a>
	   </c:when>
	   <c:otherwise> <span style="color: gray">上一页</span> </c:otherwise>
	  </c:choose></td>
  	  <td style="padding-left: 5px; padding-right: 5px; margin-right:-3px; display:inline;float: left;" valign="bottom">
  	 <div style="float: left;  height: 100%"><%--
  	 <c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="page">
  	 --%>
  	 <c:choose>
  	 <c:when test="${pageView.currentpage > 2}">
  	 	<c:choose>
  	 	<c:when test="pageView.pageindex.endindex lt pageView.currentpage+2">
  	 	<c:choose>
  	 		<c:when test="pageView.pageindex.endindex lt 6">
  	  <c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="page">
  	  <c:choose>
	   <c:when test="${pageView.currentpage eq page }">
	   <span style="width: 15px; text-align: center;color: red;position: relative; ">${page}</span>
	   </c:when>
	   <c:otherwise> <span style="width: 25px; text-align: center; red;position: relative;"><a href="javascript:gotoPage(${page})" style="text-decoration:none">${page} &nbsp;</a></span> </c:otherwise>
	  </c:choose>
  	  </c:forEach>
  	 		</c:when>
  	 		<c:otherwise>
  	  	<c:forEach begin="${pageView.pageindex.endindex-4}" end="${pageView.pageindex.endindex}" var="page">
  	  <c:choose>
	   <c:when test="${pageView.currentpage eq page }">
	   <span style="width: 15px; text-align: center;color: red;position: relative; ">${page}</span>
	   </c:when>
	   <c:otherwise> <span style="width: 25px; text-align: center; position: relative;"><a href="javascript:gotoPage(${page})" style="text-decoration:none">${page} &nbsp;</a></span> </c:otherwise>
	  </c:choose>
  	  </c:forEach>
  	 		</c:otherwise>
  	  	</c:choose>
  	  </c:when>
  	  <c:otherwise>
  	   <c:forEach begin="${pageView.currentpage-2}" end="${pageView.pageindex.endindex}" var="page">
  	  <c:choose>
	   <c:when test="${pageView.currentpage eq page }">
	   <span style="width: 15px; text-align: center;color: red;position: relative; ">${page}</span>
	   </c:when>
	   <c:otherwise> <span style="width: 25px; text-align: center; position: relative;"><a href="javascript:gotoPage(${page})" style="text-decoration:none">${page} &nbsp;</a></span> </c:otherwise>
	  </c:choose>
  	  </c:forEach>
  	 </c:otherwise>
  	  </c:choose>
  	  </c:when>
  	  <c:otherwise>
  	  	<c:choose>
  	  	<c:when test="pageView.pageindex.endindex lt #pageView.pageindex.startindex+9">
  	    <c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="page">
  	  <c:choose>
	   <c:when test="${pageView.currentpage eq page }">
	   <span style="width: 15px; text-align: center;color: red;position: relative; ">${page}</span>
	   </c:when>
	   <c:otherwise> <span style="width: 25px; text-align: center; position: relative;"><a href="javascript:gotoPage(${page})" style="text-decoration:none">${page} &nbsp;</a></span> </c:otherwise>
	  </c:choose>
  	  </c:forEach>
  	  	</c:when>
  	  	<c:otherwise>
  	   <c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="page">
  	  <c:choose>
	   <c:when test="${pageView.currentpage eq page }">
	   <span style="width: 15px; text-align: center;color: red;position: relative; ">${page}</span>
	   </c:when>
	   <c:otherwise><span style="width: 25px; text-align: center; red;position: relative;"><a href="javascript:gotoPage(${page})" style="text-decoration:none">${page} &nbsp;</a></span> </c:otherwise>
	  </c:choose>
  	  </c:forEach>
  	  	</c:otherwise>
  	  	</c:choose>
  	  </c:otherwise>
  	  </c:choose>
  	  </div>
  	 <div style="color:white;border: 1px solid; float: left;"></div>
  	  </td>
  	  <td><c:choose>
	   <c:when test="${pageView.currentpage lt pageView.totalpage}">
	    <a href="javascript:gotoPage(${pageView.currentpage+1})" style="text-decoration:none">下一页</a>
	   </c:when>
	   <c:otherwise><span style="color: gray">下一页 </span></c:otherwise>
	  </c:choose></td>
	  
	  <td><a href="javascript:gotoPage(${pageView.totalpage})" style="text-decoration:none">末页</a></td>
	
	<td>转到&nbsp;<input type="text" maxlength="4" id="curP" style="width: 25px;" /> <input type="button" value="确认" onclick="javascript:turntoPage();"/></td>
	</tr></table>
	  <script type="text/javascript"> 

	  function ltrim(s){     
		    return s.replace(/(^\s*)/, "");  
		 }   
		 //去右空格;   
		function rtrim(s){   
		  return s.replace(/(\s*$)/, "");  
		}   
		 //去左右空格;   
		 function trim(s){  
		   //s.replace(/(^\s*)|(\s*$)/, "");  
		  return rtrim(ltrim(s));   
		 
		 }   
			  
	  	function turntoPage(){
		  	var pageNum=document.getElementById("curP").value;
		  	pageNum=trim(pageNum);
			  	if(pageNum==''){
			  		alert('请选择页码');
			  	}else{
			  		gotoPage(pageNum);
			  	}
	  	} 
		 function gotoPage(pageNum){
			    if( isNaN(pageNum) ){ // not a number
					alert("必须输入数字");
					document.getElementById('curP').focus();
					return false;
				}
				if( pageNum < 1 ) pageNem = 1;
				var ptotal=document.getElementById('pagetotale').value;
				if(!ptotal){
					ptotal=0;
				}
				if( pageNum > ptotal ){
					alert("请输入正确的页码，范围为 1-${pageView.totalpage}");
					document.getElementById('curP').focus();
					return false;
				}
			getPageViewUrl( pageNum );
		 }
	  </script>
