<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="/wlfzjx/css/base.css" />
		
		<script language="JavaScript" src="/wlfzjx/js/public.js" type="text/javascript"></script>
        <script language="javascript">
           function examAdd()
           {
              var url="/wlfzjx/atea/exam/examAdd.jsp";
              window.location.href=url;
           }
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="/wlfzjx/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='/wlfzjx/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="13" background="/wlfzjx/images/tbg.gif">&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="20%">试题名称</td>
					<td width="10%">附件下载</td>
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



		        <%--
				<s:iterator value="#request.examList" id="exam" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#exam.mingcheng"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#exam.fujianYuanshiming"/>
						&nbsp;&nbsp;&nbsp;
						<a href="#" onclick="down1('<s:property value="#exam.fujian"/>','<s:property value="#exam.fujianYuanshiming"/>')" style="font-size: 10px;color: red">down</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a class="pn-loperator" href="/wlfzjx/examDel.action?id=<s:property value="#exam.id"/>">删除</a>
					</td>
				</tr>
				</s:iterator>
				--%>


				<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">--%>
					<%--<td bgcolor="#FFFFFF" align="center">01</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">XXX</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--XXX--%>
						<%--&nbsp;&nbsp;&nbsp;--%>
						<%--<a href="#" onclick="down1('111','222')" style="font-size: 10px;color: red">down</a>--%>
					<%--</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--<a class="pn-loperator" href="/wlfzjx/atea/exam/examMana.jsp?id=001">删除</a>--%>
					<%--</td>--%>
				<%--</tr>--%>
				<%----%>
				<%----%>
				<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">--%>
					<%--<td bgcolor="#FFFFFF" align="center">01</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">XXX</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--XXX--%>
						<%--&nbsp;&nbsp;&nbsp;--%>
						<%--<a href="#" onclick="down1('111','222')" style="font-size: 10px;color: red">down</a>--%>
					<%--</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--<a class="pn-loperator" href="/wlfzjx/atea/exam/examMana.jsp?id=001">删除</a>--%>
					<%--</td>--%>
				<%--</tr>--%>
				
				<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">--%>
					<%--<td bgcolor="#FFFFFF" align="center">01</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">XXX</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--XXX--%>
						<%--&nbsp;&nbsp;&nbsp;--%>
						<%--<a href="#" onclick="down1('111','222')" style="font-size: 10px;color: red">down</a>--%>
					<%--</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--<a class="pn-loperator" href="/wlfzjx/atea/exam/examMana.jsp?id=001">删除</a>--%>
					<%--</td>--%>
				<%--</tr>--%>
				<%----%>
				<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">--%>
					<%--<td bgcolor="#FFFFFF" align="center">01</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">XXX</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--XXX--%>
						<%--&nbsp;&nbsp;&nbsp;--%>
						<%--<a href="#" onclick="down1('111','222')" style="font-size: 10px;color: red">down</a>--%>
					<%--</td>--%>
					<%--<td bgcolor="#FFFFFF" align="center">--%>
						<%--<a class="pn-loperator" href="/wlfzjx/atea/exam/examMana.jsp?id=001">删除</a>--%>
					<%--</td>--%>
				<%--</tr>--%>
				
			</table>
			<%@ include file="/jsp/pageFile.jsp" %>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加试题" style="width: 120px;" onclick="examAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
<script>
	function examAdd() {
        //添加试题
        if(confirm("确认删除当前的试题吗?")){
            //向服务端发起请求
            location.href="${pageContext.request.contextPath}/ExamServlet?method=addExam";
        }
    }


</script>
</html>
