package service;

import dao.MessageDao;
import domain.Message;
import domain.Student;
import utils.PageModel;

import java.sql.SQLException;
import java.util.List;



public class MessageService {

	public static Message findMessageByMid(String mId) throws SQLException {
		//调用DAO层根据视频ID获取留言对象
		MessageDao messageDao= new MessageDao();
		return messageDao.findMessageByVid(mId);

	}

	public PageModel findMessagesWithPage(int currentNum, Student stu) throws SQLException {
		//1_创建PageModel对象，计算分页参数
		MessageDao MessageDao=new MessageDao();
		//select count(*) from t_message where stuId=?
		int totalRecords=MessageDao.findTotalRecordsByStuId(stu);
		PageModel pm=new PageModel(currentNum,totalRecords,5);
		
		//2_为PageModel设置集合
		List<Message> list=MessageDao.findMessagesWithPage(pm.getStartIndex(),pm.getPageSize(),stu);
		pm.setList(list);
		//3_为PageModel设置url
		pm.setUrl("MessageServlet?method=findMessagesWithPage");
		return pm;
	}

	public void addMessage(Message msg)  throws SQLException {
		MessageDao MessageDao=new MessageDao();
		MessageDao.addMessage(msg);
	}

	public PageModel findMessagesWithPageByTeacher(int currentPageNum)  throws SQLException {
		//1_创建PageModel对象，计算分页参数信息
		MessageDao MessageDao=new MessageDao();
		int totalRecords=MessageDao.findTotalRecords();
		PageModel pm=new PageModel(currentPageNum,totalRecords,5);
		//2_为PageModel设置集合(当前页中的留言信息)
		//select * from t_message limit ? , ?
		List<Message> list=MessageDao.findMessagesWithPageByTeacher(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		//3_为PageModel设置url
		pm.setUrl("MessageServlet?method=findMessagesWithPageByTeacher");
		return pm;
	}

	public void replayMessage(String id, String replay) throws SQLException {
		//调用DAO层replayMessage,将id,replay传递给dao
		MessageDao MessageDao=new MessageDao();
		MessageDao.replayMessage(id,replay);
	}

}
