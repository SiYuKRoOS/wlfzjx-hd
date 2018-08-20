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
		
        <script language="javascript">
           function stuDel(stuId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="/wlfzjx/stuDel.action?stuId="+stuId;
               }
           }
           
           function stuAdd()
           {
                 var url="/wlfzjx/admin/stu/stuAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='/wlfzjx/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="/wlfzjx/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="11%">学号</td>
					<td width="11%">姓名</td>
					<td width="11%">性别</td>
					<td width="11%">年龄</td>
					<td width="11%">密码</td>
					<td width="11%">操作</td>
		        </tr>
		        <%--	
				<s:iterator value="#request.stuList" id="stu" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#stu.stuXuehao"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#stu.stuRealname"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#stu.stuSex"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#stu.stuAge"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#stu.loginPw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center"><a href="#" onclick="stuDel(<s:property value="#stu.stuId"/>)" class="pn-loperator">删除</a></td>
				</tr>
				</s:iterator>
				--%>
		        
		        <!-- 1001___start -->
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">
					   <a href="#" onclick="stuDel('111')" class="pn-loperator">删除</a></td>
				</tr>
				<!-- 1001___end -->
				
				<!-- 1001___start -->
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">
					   <a href="#" onclick="stuDel('111')" class="pn-loperator">删除</a></td>
				</tr>
				<!-- 1001___end -->
				
				<!-- 1001___start -->
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">
					   <a href="#" onclick="stuDel('111')" class="pn-loperator">删除</a></td>
				</tr>
				<!-- 1001___end -->
				
				<!-- 1001___start -->
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">
					   <a href="#" onclick="stuDel('111')" class="pn-loperator">删除</a></td>
				</tr>
				<!-- 1001___end -->
				
				<!-- 1001___start -->
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">XX</td>
					<td bgcolor="#FFFFFF" align="center">
					   <a href="#" onclick="stuDel('111')" class="pn-loperator">删除</a></td>
				</tr>
				<!-- 1001___end -->
				
				
				 
				 
			</table>
	</body>
</html>
