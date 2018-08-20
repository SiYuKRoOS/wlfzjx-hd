package dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import domain.Message;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import javax.servlet.ServletResponse;

public class MessageDao {

	private ServletResponse request;
	private ServletResponse response;
	public Message findMessageByVid(String mId) throws SQLException {

		String sql="select * from t_message where messageId=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Message>(Message.class),mId);
	}


	public int findTotalRecordsByStuId(Student stu) throws SQLException {
		String sql="select count(*) from t_message where stuId=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Long num=(Long)qr.query(sql, new ScalarHandler(),stu.getStuId());
		return num.intValue();
	}


	public List<Message> findMessagesWithPage(int startIndex, int pageSize,Student stu) throws SQLException {
		String sql="SELECT * FROM t_message  WHERE stuId=?  ORDER BY leaveWordTime DESC LIMIT  ? , ?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Message>(Message.class),stu.getStuId(),startIndex,pageSize);
		
	}

	public void addMessage(Message msg) throws SQLException {

		String sql="INSERT INTO t_message(content,leaveWordTime,stuId) VALUES( ? ,  ? ,  ? )";
		Object[] params= {msg.getContent(),msg.getLeaveWordTime(),msg.getStuId()};
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,params);

	}

	public int findTotalRecords() throws SQLException {
		String sql="select count(*) from t_message";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Long num=(Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}

	public List<Message> findMessagesWithPageByTeacher(int startIndex, int pageSize) throws SQLException {
		String sql="select * from t_message  ORDER BY leaveWordTime DESC  limit ? , ?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Message>(Message.class),startIndex,pageSize);
	}

	public void replayMessage(String id, String replay) throws SQLException {
		String sql="update t_message set replay =? , replayTime = ? where messageId=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String replayTime=sdf.format(new Date());
		Object[] params= {replay,replayTime,id};
		qr.update(sql,params);
	}

}
