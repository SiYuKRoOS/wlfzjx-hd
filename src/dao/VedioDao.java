package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Vedio;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

public class VedioDao {

	public List<Vedio> findPrevVidio() throws SQLException {
		String sql="SELECT * FROM t_vedio ORDER BY uploadTime DESC LIMIT 0 , 5";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Vedio>(Vedio.class));
	}

	
	public List<Vedio> findVedioWithPage(int i, int j) throws SQLException {
		String sql="SELECT * FROM t_vedio LIMIT ? , ? ";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Vedio>(Vedio.class),i,j);
		
	}
	public int findTotalRecords() throws SQLException {
		String sql="SELECT COUNT(*) FROM t_vedio";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Long num=(Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}


	public Vedio findVedioByVid(String vId) throws SQLException {
		String sql="select * from t_vedio where vedioId=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Vedio>(Vedio.class),vId);
	}


	public List<Vedio> findVediosWithPageByTeacher(int startIndex, int pageSize) throws SQLException {
		String sql="select * from t_vedio limit ? , ?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Vedio>(Vedio.class),startIndex,pageSize);
		
	}


	public void deleteVedioByTeacher(String vId) throws SQLException {
		String sql="delete from t_vedio where vedioId=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,vId);
	}


	public void addVedio(Vedio v) throws SQLException {
		String sql="INSERT INTO t_vedio VALUES(NULL , ? ,  ? ,  ? ,  ? ,  ? ,  ? )";
		Object[] params= {v.getVedioName(),v.getVedioIntro(),v.getVedioAttachment(),v.getAttachmentOldName(),v.getUploadTime(),v.getDel()};
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,params);
	}


	
}
