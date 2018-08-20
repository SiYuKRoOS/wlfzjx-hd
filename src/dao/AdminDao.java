package dao;

import java.sql.SQLException;

import domain.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;


public class AdminDao {

	public Admin adminLogin(String um, String up) throws SQLException {
		String sql="SELECT * FROM t_admin WHERE userName= ? AND userPw=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Admin>(Admin.class),um,up);
		
	}

}
