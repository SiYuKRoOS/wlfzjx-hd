package dao;

import java.sql.SQLException;

import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;


public class StuDao {

	public Student validateUserExist(String um) throws SQLException {
		String sql="SELECT *  FROM t_stu WHERE stuNum=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Student>(Student.class),um);
		
	}

	public Student stuLogin(String um, String up) throws SQLException {
		String sql="SELECT *  FROM t_stu WHERE stuNum=? AND loginPw=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Student>(Student.class),um,up);
	}

	

}
