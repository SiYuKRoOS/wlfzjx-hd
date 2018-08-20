<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="/wlfzjx/css/base.css" />
						
       
	</head>

	<body leftmargin="2" topmargin="2" background='/wlfzjx/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="/wlfzjx/img/tbg.gif">&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="25%">标题</td>
					<td width="10%">附件</td>
					<td width="10%">操作</td>
		        </tr>
				
			 <c:forEach items="${page.list}" var="v"  varStatus="status">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${status.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${v.vedioName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${v.vedioAttachment}
						&nbsp;&nbsp;&nbsp;
						<a href="#" onclick="down1('${v.vedioAttachment}','${v.attachmentOldName}')" style="font-size: 10px;color: red"></a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <%--取消链接的默认行为 --%>
						<a href="javascript:void(0)" onclick="delVedio(${v.vedioId})"  class="pn-loperator">删除</a>
						
					</td>
				</tr>
			  </c:forEach>
			
			</table>
			<%@ include file="/jsp/pageFile.jsp" %>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <%--<input type="button" value="添加教学视频" style="width: 120px;" onclick="addVedio()" />--%>
			    </td>
			  </tr>
		    </table>
	</body>
<script>

function delVedio(vId){
    //做删除视频之前的确认提示
    if(confirm("确认删除当前的视频吗?")){
        //向服务端发起请求，将当前正在删除的视频的编号发送到服务端
        location.href="${pageContext.request.contextPath}/VedioServlet?method=deleteVedioByTeacher&id="+vId;
    }
}
</script>	
</html>




