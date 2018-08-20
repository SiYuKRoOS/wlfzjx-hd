package service;

import dao.AdminDao;
import domain.Admin;

import java.sql.SQLException;


public class AdminService {

	public Admin adminLong(String um, String up)  throws SQLException {
		//调用DAO层功能
		AdminDao AdminDao=new AdminDao();
		return AdminDao.adminLogin(um,up);
		
	}

}
