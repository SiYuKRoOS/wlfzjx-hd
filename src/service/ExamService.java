package service;

import dao.ExamDao;
import domain.Exam;
import utils.PageModel;

import java.sql.SQLException;
import java.util.List;

public class ExamService {


    public PageModel findAllExamsWithPage(int num) throws SQLException {
        //1_创建PageModel对象，计算分页参数信息
        ExamDao ExamDao=new ExamDao();
        int totalRecords=ExamDao.findTotalRecords();
        PageModel pm=new PageModel(num,totalRecords,5);
        //2_为PageModel关联集合 集合中存放的就是当前页中的视频信息
        //调用DAO层查询当前页中的视频信息 select * from tb_vedio limit  ? , ?
        List<Exam> list=ExamDao.findAllExamsWithPage((num-1)*5,5);
        pm.setList(list);
        //3.为PageModel关联url属性
        pm.setUrl("ExamServlet?method=findAllExamsWithPage");
        return pm;
    }

    public Exam findExamByEid(String eId) throws SQLException {
        ExamDao examDao= new ExamDao();
         return examDao.findExamByEid(eId);
    }

    public PageModel findExamsWithPageByTeacher(int currentPageNum) throws SQLException {
        //1_创建PageModel对象，计算分页参数
        ExamDao ExamDao=new ExamDao();
        //select count(*) from t_exam
        int totalRecords=ExamDao.findTotalRecords();
        PageModel pm=new PageModel(currentPageNum, totalRecords, 5);
        //2_为PageModel对象设置集合(当前页中的视频信息)
        //select * from t_exam limit ? , ?
        List<Exam> list=ExamDao.findExamsWithPageByTeacher(pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        //3_为PageModel对象设置url (PageFile.jsp页面所需)
        pm.setUrl("ExamServlet?method=findExamsWithPageByTeacher");
        return pm;
    }

    public void deleteExamByTeacher(String eId) throws SQLException {


        //调用DAO层，根据视频编号删除视频功能
        ExamDao ExamDao=new ExamDao();
        ExamDao.deleteExamByTeacher(eId);
    }
    public void addExam(Exam exam) throws SQLException {
        ExamDao ExamDao=new ExamDao();
        ExamDao.addExam(exam);
    }


    public List<Exam> findPrevExam() throws SQLException {

        ExamDao ExamDao=new ExamDao();
        return ExamDao.findPrevExam();
    }
}
