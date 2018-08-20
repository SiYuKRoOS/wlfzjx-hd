package webservice.servlets;

import domain.Student;
import service.StuService;
import webservice.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StuServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	//校验用户名是否存在
    public String validateUserExist(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//获取到页面提交到服务端的数据学号
    	String um=request.getParameter("username");
   	    //调用业务层功能：验证用户是否已经存在，返回学生对象
    	StuService stuService=new StuService();
    	Student stu=stuService.validateUserExist(um);
    	//根据返回的学生是否为空判断仓库中是否有已经存在的账户
    	if(null==stu) {
    		//仓库中不存在当前学号
    		response.getWriter().print("no");
    	}else {
    		//仓库中存在当前学号
    		response.getWriter().print("yes");
    	}
    	//由于本次功能是由ajax发起的，不需要进行转发
    	return null;
    	
    }

    //学员登录功能
    public String stuLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//获取 学号
    	String um=request.getParameter("userName");
    	//获取 密码
    	String up=request.getParameter("userPw");
    	//调用业务层登录功能，返回学生对象
    	StuService StuService=new StuService();
    	Student student=StuService.stuLogin(um,up);
    	if(null!=student) {
    		//如果返回的学生不为空，说明登录成功，向session中放入学生信息 ,重定向到/site/index.jsp
    		request.getSession().setAttribute("stu", student);
    		response.sendRedirect("/wlfzjx/site/index.jsp");
    		return null;
    	}else {
        	//如果返回的学生空，说明登录失败，向request域对象放入提示信息，转发到/site/index.jsp
    		request.setAttribute("msg", "密码有误");
    		return "/site/index.jsp";
    	}
    }    
   //stuLogout
    public String stuLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//获取session,使其失效
    	request.getSession().invalidate();
    	//重新定向到首页
    	response.sendRedirect("/wlfzjx/site/index.jsp");
    	return null;
    	
    }
}
