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
	
	<script type="text/javascript">
        function down1(fujianPath,fujianYuashiMing)
        {
            var url="/wlfzjx/updown/updown.jsp?fujianPath="+fujianPath+"&amp;fujianYuashiMing="+fujianYuashiMing;
            url=encodeURI(url); 
            url=encodeURI(url); 
            window.open(url,"_self");
        }
    </script>
  </head>
  
  <body>
  <div id="wrapper">
      
      <div id="header"></div>
      
      <div id="left">
	      <jsp:include flush="true" page="/site/left.jsp"></jsp:include>
      </div>
      
      
      <div id="right">
      	  <!-- 111 -->
      	  <h2>试题下载</h2>
	      <div id="welcome">
	        <div>
	           <div class="c1-body">
                   <table width="100%" border="0">
					    <tr>
					       <td align="center">试题名称：${exam.examName}<hr/></td>
					    </tr>
					    <tr>
					       <td align="center">
							   <a href="${pageContext.request.contextPath}/ExamServlet?method=downloadExam&id=${exam.examId}" style="font-size: 13px;color: red">${exam.examName}</a>
							   &nbsp;&nbsp;&nbsp;
					            <%--<a href="javascript:void(0)" onclick="down1('${exam.attachment}','${exam.examAttachmentOldName}')" style="font-size: 13px;color: red">${exam.examAttachmentOldName}</a>--%>
					            <hr/>
					       </td>
					    </tr>
					    <tr>
					       <td align="center">发布时间:${exam.uploadTime}<hr/></td>
					    </tr>
					</table>
		       </div>
	        </div>
	        <!-- <p class="more"><a href="#">more</a></p> -->
	      </div>
	      <!-- 111 -->
      </div>
      <div class="clear"> </div>
      <div id="footer">
	      <div id="copyright">
	        Copyright &copy; 网络辅助教学系统版权所有&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/wlfzjx/login.jsp">系统后台登陆</a>
	      </div>
	      <div id="footerline"></div>
      </div>
  </div>
</body>
</html>