package dao;

import domain.Exam;
import domain.Vedio;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ExamDao {
    public  List<Exam> findAllExamsWithPage(int i, int j) throws SQLException {
        String sql="SELECT * FROM t_exam LIMIT ? , ? ";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Exam>(Exam.class),i,j);
    }

    public  List<Exam> findExamsWithPageByTeacher(int startIndex, int pageSize) throws SQLException {
        String sql="select * from t_exam limit ? , ?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Exam>(Exam.class),startIndex,pageSize);

    }

    public List<Exam> findPrevExam() throws SQLException {
        String sql="SELECT * FROM t_exam ORDER BY uploadTime DESC LIMIT 0 , 5";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Exam>(Exam.class));
    }

    public int findTotalRecords() throws SQLException {
        String sql="SELECT COUNT(*) FROM t_exam";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        Long num=(Long)qr.query(sql, new ScalarHandler());
        return num.intValue();
    }

    public Exam findExamByEid(String eId) throws SQLException {
        String sql="select * from t_exam where examId=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<Exam>(Exam.class),eId);
    }
    public void addExam(Exam e) throws SQLException {
        String sql="INSERT INTO t_exam VALUES(NULL , ? ,  ? ,  ? ,  ? ,  ? )";
        Object[] params= {e.getExamName(),e.getAttachment(),e.getExamAttachmentOldName(),e.getUploadTime(),e.getDel()};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,params);
    }

    public void deleteExamByTeacher(String eId) throws SQLException {
        String sql="delete from t_exam where examId=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,eId);
    }
}
