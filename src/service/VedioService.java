package service;

import dao.VedioDao;
import domain.Vedio;
import utils.PageModel;

import java.sql.SQLException;
import java.util.List;


public class VedioService {

	public List<Vedio> findPrevVidio() throws SQLException {
		//调用DAO层功能，返回一个存储着Vedio对象的集合
		VedioDao VedioDao=new VedioDao();
		return VedioDao.findPrevVidio();
		
	}

	public PageModel findVedioWithPage(int num) throws SQLException {
		//1_创建PageModel对象，计算分页参数信息
		VedioDao VedioDao=new VedioDao();
		int totalRecords=VedioDao.findTotalRecords(); 
		PageModel pm=new PageModel(num,totalRecords,5);
		//2_为PageModel关联集合 集合中存放的就是当前页中的视频信息
		//调用DAO层查询当前页中的视频信息 select * from tb_vedio limit  ? , ?
		List<Vedio> list=VedioDao.findVedioWithPage((num-1)*5,5);
		pm.setList(list);
		//3.为PageModel关联url属性
		pm.setUrl("VedioServlet?method=findVedioWithPage");
		return pm;
	}

	public Vedio findVedioByVid(String vId) throws SQLException {
		//调用DAO层根据视频ID获取视频对象
		VedioDao VedioDao=new VedioDao();
		return VedioDao.findVedioByVid(vId);
		
	}

	public PageModel findVediosWithPageByTeacher(int currentPageNum) throws SQLException {
		//1_创建PageModel对象，计算分页参数
		VedioDao VedioDao=new VedioDao();
		//select count(*) from t_vedio
		int totalRecords=VedioDao.findTotalRecords();
		PageModel pm=new PageModel(currentPageNum, totalRecords, 5);
		//2_为PageModel对象设置集合(当前页中的视频信息)
		//select * from t_vedio limit ? , ?
		List<Vedio> list=VedioDao.findVediosWithPageByTeacher(pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		//3_为PageModel对象设置url (PageFile.jsp页面所需)
		pm.setUrl("VedioServlet?method=findVediosWithPageByTeacher");
		return pm;

	}

	public void deleteVedioByTeacher(String vId) throws SQLException {
		//调用DAO层，根据视频编号删除视频功能
		VedioDao VedioDao=new VedioDao();
		VedioDao.deleteVedioByTeacher(vId);
	}

//	public void addVedio(Vedio vedio) throws SQLException {
//		VedioDao VedioDao=new VedioDao();
//		VedioDao.addVedio(vedio);
//	}

	

}
