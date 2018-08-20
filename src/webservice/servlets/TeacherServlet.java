package webservice.servlets;

import domain.Teacher;
import service.TeacherService;
import utils.PageModel;
import webservice.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TeacherServlet extends BaseServlet {
	public String teacherLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取账户和密码
		String um=request.getParameter("userName");
		String up=request.getParameter("userPw");
		//调用业务层登录功能,   返回teacher对象
		TeacherService TeacherService=new TeacherService();
		Teacher teacher=TeacherService.teacherLogin(um,up);
		if(null==teacher) {
			//如果teacher对象为空， 登录失败，向request放入提示信息 ,转发到login.jsp页面
			request.setAttribute("msg", "账户密码不匹配");
			return "/login.jsp";
		}else {
			//如果teacher对象不为空 ,登录成功，向session放入teacher对象,重定向到/atea/index.jsp
			request.getSession().setAttribute("teacher", teacher);
			response.sendRedirect("/wlfzjx/atea/index.jsp");
			return null;
		}
	}
	
	//findTeachersWithPage
	public String findTeachersWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取当前页
		int currentNum=Integer.parseInt(request.getParameter("num"));
		//调用业务层功能，返回PageModel对象
		TeacherService TeacherService=new TeacherService();
		PageModel pm=TeacherService.findTeachersWithPage(currentNum);
		//将PageModel对象放入request
		request.setAttribute("page", pm);
		//转发到/admin/tea/teaMana.jsp
		return "/admin/tea/teaMana.jsp";
	}
	
	//addTeacherUI
	public String addTeacherUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/admin/tea/teaAdd.jsp";
	}
	//addTeacher
	public String addTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//接受参数
		String teaNum=request.getParameter("teaNum");
		String teaRealName=request.getParameter("teaRealName");
		String teaSex=request.getParameter("teaSex");
		String teaAge=request.getParameter("teaAge");
		String loginName=request.getParameter("loginName");
		String loginPwd=request.getParameter("loginPwd");
		Teacher teacher=new Teacher();
		teacher.setTeaNum(teaNum);
		teacher.setTeaRealName(teaRealName);
		teacher.setTeaSex(teaSex);
		teacher.setTeaAge(teaAge);
		teacher.setLoginName(loginName);
		teacher.setLoginPwd(loginPwd);
		//调用业务层添加老师功能
		TeacherService TeacherService=new TeacherService();
		TeacherService.addTeacher(teacher);
		//重定向到查询老师信息功能
		response.sendRedirect("/wlfzjx/TeacherServlet?method=findTeachersWithPage&num=1");
		return null;
	}
	//delTeacherById
	public String delTeacherById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取待删除老师的编号
		String id=request.getParameter("id");
		//调用业务层删除老师功能
		TeacherService TeacherService=new TeacherService();
		TeacherService.delTeacherById(id);
		//重定向到/TeacherServlet?method=findTeachersWithPage
		response.sendRedirect("/wlfzjx/TeacherServlet?method=findTeachersWithPage&num=1");
		return null;
	}
	
	//findMyInfoUI
	public String findMyInfoUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return  "/atea/userinfo/userinfo.jsp";
	}
	
	//updateTeacher
	public String updateTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String num=request.getParameter("teaNum");
		String name=request.getParameter("teaRealname");
		String sex=request.getParameter("teaSex");
		String teaAge=request.getParameter("teaAge");
		String loginName=request.getParameter("loginName");
		String loginPwd=request.getParameter("loginPw");
		String teaId=request.getParameter("teaId");
		Teacher t=new Teacher();
		t.setTeaId(Integer.parseInt(teaId));
		t.setTeaNum(num);
		t.setTeaRealName(name);
		t.setTeaSex(sex);
		t.setTeaAge(teaAge);
		t.setLoginName(loginName);
		t.setLoginPwd(loginPwd);
		
		TeacherService TeacherService=new TeacherService();
		TeacherService.updateTeacher(t);
		return  "/atea/userinfo/msg.jsp";
	}
}












