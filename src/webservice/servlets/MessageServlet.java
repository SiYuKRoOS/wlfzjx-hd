package webservice.servlets;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Exam;
import domain.Message;
import domain.Student;
import service.ExamService;
import service.MessageService;
import utils.PageModel;
import webservice.base.BaseServlet;

public class MessageServlet extends BaseServlet {



	private static final long serialVersionUID = 1L;
       
	//查看当前学生的师生交流内容带分页功能

	public  String findMessagesWithPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, UnsupportedEncodingException {

		//获取当前页
		int currentNum=Integer.parseInt(request.getParameter("num"));
		//获取在session中的学生信息
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		Student stu = (Student)(request.getSession().getAttribute("stu"));
		//调用业务层功能，返回PageModel (1_当前页的分页参数2_当前页的留言信息3_url)
		MessageService messageService=new MessageService();
		PageModel pm=messageService.findMessagesWithPage(currentNum,stu);
		//将PageModel放入request
		request.setAttribute("page", pm);
		//转发到/site/message/messageAll.jsp
		return "/site/message/messageAll.jsp";
	}
	//findMessageByVid

	public String findMessageByMid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取留言ID参数
		String mId=request.getParameter("id");
		//调用业务层功能：根据视频ID查询对应的视频对象
		MessageService messageService=new MessageService();
		Message message=MessageService.findMessageByMid(mId);
		//将查询到的留言对象放入request
		request.setAttribute("message", message);
		//转发到/site/exam/examDtail.jsp
		return "/site/message/messageDetail.jsp";
	}


	//addMessageUI

	public  String addMessageUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
	    //仅仅是一个空跳转  1_mvc 2_有时候只能转发过来
		return "/site/message/messageAdd.jsp";
	}
	
	//addMessage

	public  String addMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		//接受参数问题
		String content = request.getParameter("content");
		//获取session中的学生信息
		Student stu=(Student)(request.getSession().getAttribute("stu"));
		//创建Message对象
		Message msg=new Message();
		//为Message对象的content,leaveWordTime属性赋予值
		msg.setContent(content);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		msg.setLeaveWordTime(sdf.format(new Date()));
		msg.setStuId(stu.getStuId());
		//调用业务层添加Message功能
		MessageService MessageService=new MessageService();
		MessageService.addMessage(msg);
		//转发到分页查询全部message模块
		response.sendRedirect("/wlfzjx/MessageServlet?method=findMessagesWithPage&num=1");
        System.out.println(content);

		return null;

	}
	//
	public  String findMessagesWithPageByTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
	    //获取当前页
		int currentPageNum=Integer.parseInt(request.getParameter("num"));
		//调用业务层功能，返回PageModel对象(1_第1页留言信息 2_分页参数信息 3_url)
		MessageService MessageService=new MessageService();
		PageModel pm=MessageService.findMessagesWithPageByTeacher(currentPageNum);
		//将PageModel放入request域对象
		request.setAttribute("page", pm);
		//转发到 /atea/message/messageMana.jsp
		return "/atea/message/messageMana.jsp";
	}
	//replayUI
	public  String replayUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		//接受正在回复问题的编号
		String msgId=request.getParameter("id");
		//将编号放入request
		request.setAttribute("msgId", msgId);
		//转发到messageReplay.jsp
		return "/atea/message/messageReplay.jsp";
	}
	
	//replayMessage  回复学生问题
	public  String replayMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//接受回复内容参数
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		String replay=request.getParameter("replay");
		//接受问题的id
		String id=request.getParameter("id");
		//调用业务层功能：回复内容
		MessageService MessageService=new MessageService();
		MessageService.replayMessage(id,replay);
		//重定向到/MessageServlet?method=findMessagesWithPageByTeacher&num=1
		response.sendRedirect("/wlfzjx/MessageServlet?method=findMessagesWithPageByTeacher&num=1");
		return null;
	}


}
