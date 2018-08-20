package webservice.servlets;
/**
 * @author kroos
 */

import domain.Exam;

import domain.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import service.ExamService;

import utils.DownLoadUtils;
import utils.PageModel;
import utils.UploadUtils;
import webservice.base.BaseServlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@WebServlet(name = "ExamServlet")
public class ExamServlet extends BaseServlet {
    private static final long serialVersionUID = 2L;
    //findExamWithPage
    public String findPrevExam(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1_调用业务层功能，返回存储着Vedio对象的集合
        ExamService ExamService=new ExamService();
        //查询5个最新视频,返回集合
        List<Exam> list=ExamService.findPrevExam();
        //2_将集合放入request域对象内
        request.setAttribute("list", list);
        //3_转发到/site/vedio/vedioPrev.jsp
        return "/site/exam/ExamPrev.jsp";
    }
    public String findAllExamsWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
      //1_接受当前页参数

        int num=Integer.parseInt(request.getParameter("num"));

        //2_调用业务层功能，返回PageModel

        ExamService examService=new ExamService();
        PageModel pm=examService.findAllExamsWithPage(num);
        //  为什么是PageModel?:
        //   由于当前的功能时分页查询，除了查询当前页中的试卷信息之外，还需要货到分页参数信息
        //   如果仅仅是当前页中的试卷，用一个集合就可以实现。但是分页参数比较繁杂，所以用PageModel工具类携带这类数据
        //3_将PageModel放入request
        request.setAttribute("page", pm);
        //4_转发到vedioAll.jsp
        return "/site/exam/examAll.jsp";
    }
    //findVedioByVid

    public String findExamByEid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取试卷ID参数

        String eId=request.getParameter("id");
        //调用业务层功能：根据试卷ID查询对应的试卷对象

        ExamService ExamService=new ExamService();
        Exam exam=ExamService.findExamByEid(eId);
        //将查询到的试卷对象放入request
        request.setAttribute("exam", exam);
        //转发到/site/exam/examDtailQian.jsp
        return "/site/exam/examDetailQian.jsp";
    }
    //downloadExam

    public String downloadExam(HttpServletRequest request, HttpServletResponse response) throws Exception {

//接受客户端试卷的id
        String id=request.getParameter("id");
        //调用service功能，根据视频的id获取试卷对象
        ExamService ExamService=new ExamService();
        Exam exam=ExamService.findExamByEid(id);
        //获取到项目下upload目录的绝对路径
        String realPath = getServletContext().getRealPath("/upload/");
        //实例化一个File代表，代表待下载的视频。
        File file=new File(realPath,exam.getAttachment());

        DownLoadUtils.setConentType(request, exam.getAttachment(), response);

        //通过File获取输入流

        InputStream is=new FileInputStream(file);
        //通过response获取到输出流
        OutputStream os = response.getOutputStream();
        //将输入流中的数据刷出到输出流中
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
        //由于当前功能是在实现下载，是不需要转发到任意页面。数据直接从服务端的servlet通过response获取到的字节输出流将数据发送到客户端即可。
        return null;
    }


    //findExamsWithPageByTeacher

    public String findExamsWithPageByTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前页
        int currentPageNum=Integer.parseInt(request.getParameter("num"));
        //调用业务层功能:带分页形式查询试卷信息，返回PageModel(1_当前页中的试卷信息2_计算好的分页参数3_url)
        ExamService ExamService=new ExamService();
        PageModel pm=ExamService.findExamsWithPageByTeacher(currentPageNum);
        //将PageModel放入reqest
        request.setAttribute("page", pm);
        //转发到shitiMana.jsp
        return "/atea/exam/examMana.jsp";
    }

    //deleteExamByTeacher

    public String deleteExamByTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取待删除试卷的编号
        String eId=request.getParameter("id");
        //调用业务层功能，根据视频编号删除视频
        ExamService ExamService=new ExamService();
        ExamService.deleteExamByTeacher(eId);
        //重定向到查询全部商品路径
        response.sendRedirect("/wlfzjx/ExamServlet?method=findExamsWithPageByTeacher&num=1");
        return null;
    }
    //addExamUI
    public String addExamUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/atea/exam/examAdd.jsp";
    }
    //addExam
    public String addExam(HttpServletRequest request, HttpServletResponse response) throws Exception {

//携带表单名称以及表单参数
        Map<String,String> map=new HashMap<String,String>();
        //携带Exam数据，向 service,dao进行传递
        Exam exam=new Exam();

        //1_创建DiskFiletemFactory对象设置允许上传文件大小
        DiskFileItemFactory fac=new DiskFileItemFactory();
        //允许上传文件的最大为200MB
        fac.setSizeThreshold(1024*1024*200);
        //2_创建ServletFileUpload upload
        ServletFileUpload upload=new ServletFileUpload(fac);
        //3_通过upload解析request,得到集合<FileItem>
        // FileItem代表什么？工具就将请求体中每对分割线中间的内容封装为一个FileItem对象
        List<FileItem> list=upload.parseRequest(request);
        //4_遍历集合

        for (FileItem item : list) {
            if(item.isFormField()) {

                String name=item.getFieldName();
                String value=item.getString();

                map.put(item.getFieldName(), item.getString());
            }else {
                //如果是上传项：在服务端指定目录/upload/ 创建一个文件，将上传项中文件的二进制数据输出到创建好的文件中
                //获取到文件名称
                String fName=item.getName();
                //获取服务端upload真实路径
                String realPath=getServletContext().getRealPath("/upload/");
                String uuidName=UploadUtils.getUUIDName(fName);

                //在服务端指定路径下创建文件
                File f=new File(realPath,uuidName);
                if(!f.exists()) {
                    f.createNewFile();
                    //创建文件此时其中没有内容
                }
                //将上传到服务端的文件中的二进制数据输出到文件中
                item.write(f);
                map.put("attachment", uuidName);
                map.put("examAttachmentOldName", fName);
            }
        }
        //将MAP中的数据封装在Exam对象上
        BeanUtils.populate(exam, map);
        System.out.println(exam);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        exam.setUploadTime(sdf.format(new Date()));
        exam.setDel("no");
        ExamService ExamService=new ExamService();
        ExamService.addExam(exam);
        response.sendRedirect("/wlfzjx/ExamServlet?method=findExamsWithPageByTeacher&num=1");
        return null;
    }


}
