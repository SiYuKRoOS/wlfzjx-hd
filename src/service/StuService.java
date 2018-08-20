package service;

import dao.StuDao;
import domain.Student;

import java.sql.SQLException;


public class StuService {

	public Student validateUserExist(String um) throws SQLException {
		// 调用DAO层功能
		StuDao stuDao = new StuDao();
		return stuDao.validateUserExist(um);

	}

	public Student stuLogin(String um, String up) throws SQLException {
		// 调用DAO层功能
		StuDao stuDao = new StuDao();
		return stuDao.stuLogin(um,up);
	}

}
