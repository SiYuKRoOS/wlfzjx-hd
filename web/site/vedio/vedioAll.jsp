<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" href="/wlfzjx/css/qiantai.css" type="text/css" charset="utf-8" />
	
	<style type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
    </style>
	
	
  </head>
  
  <body>
  <div id="wrapper">
      
      <div id="header"></div>
      
      <!-- left__start -->
      <div id="left">
	       <jsp:include flush="true" page="/site/left.jsp"></jsp:include>
      </div>
      <!-- left__end -->
      
      
      <div id="right">
      	  <!-- 111 -->
      	  <h2>教学视频</h2>
	      <div id="welcome">
	        <div>
	           <div class="c1-body">
					<c:forEach  items="${page.list}" var="v">
						<div class="c1-bline" style="padding:7px 0px;">
				                    <div class="f-left">
				                          <img src="/wlfzjx/img/head-mark4.gif"
				                               align="middle" 
				                               class="img-vm" border="0"/> 
				                          <a href="${pageContext.request.contextPath}/VedioServlet?method=findVedioByVid&id=${v.vedioId}">
				                             ${v.vedioName}
				                          </a>
				                     </div>
				                     <div class="f-right">${v.uploadTime}</div>
				                     <div class="clear"></div>
			             </div>
			         </c:forEach>
		            <%@ include file="/jsp/pageFile.jsp" %>
		            <%-- 
                    <div style="text-align: center;">
                    		共${page.totalPageNum}页/第${page.currentPageNum}页
                    		<a href="${pageContext.request.contextPath}/VedioServlet?method=findVedioWithPage&num=1">首页</a>
                    		<a href="${pageContext.request.contextPath}/VedioServlet?method=findVedioWithPage&num=${page.prevPageNum}">上一页</a>
                    		
                    		<c:forEach begin="${page.startPage}"  end="${page.endPage}" var="i">
                    			<a href="${pageContext.request.contextPath}/VedioServlet?method=findVedioWithPage&num=${i}">${i}</a>
                    		</c:forEach>
                    		
                    		<a href="${pageContext.request.contextPath}/VedioServlet?method=findVedioWithPage&num=${page.nextPageNum}">下一页</a>
                    		<a href="${pageContext.request.contextPath}/VedioServlet?method=findVedioWithPage&num=${page.totalPageNum}">末页</a>
                    		
                    		<input type="text" name="pagenum" id="pagenum" size="1"/>
                    		<input type="button" value="前往" onclick="jump()"/>
                    		<script type="text/javascript">
                               function jump(){
                            	   var totalPage=${page.totalPageNum};
                            	   //获取用户输入内容
                            	   var pagenum=document.getElementById("pagenum").value;
                            	   //如果用户输入的是字母，提示请输入合法的数字
                            	   var reg =/^[1-9][0-9]{0,1}$/;
	                   				if(!reg.test(pagenum)){
	                   					//不是一个有效数字
	                   					alert("请输入符合规定的数字");
	                   					return ;
	                   				}
                            	   //如果用户输入是数字，但是大于总页数，提示请输入合法的页数
	                   				if(parseInt(pagenum)>parseInt(totalpage)){
	                					//超过了总页数
	                					alert("不能大于总页数");
	                					return;
	                				}
                            	   //如果输入的是数字，而且小于总页数，跳转到指定的页数
	                   				window.location.href="${pageContext.request.contextPath}/VedioServlet&num="+pagenum;
                               }
    						</script>
                    </div>
                     --%>
  					<div class="pg-3"></div>		  
     		   </div>
	        </div>
	        
	        <%--
	        <%@include file="/jsp/pageFile.jsp" %>
	         --%>
	        
	      </div>
	      <!-- 111 -->
      </div>
      
      <div class="clear"> </div>
      
      
      <div id="footer">
	      <div id="copyright">
	        Copyright &copy;网络辅助教学系统版权所有&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/wlfzjx/login.jsp">系统后台登陆</a>
	      </div>
	      <div id="footerline"></div>
      </div>
  </div>
</body>

</html>
