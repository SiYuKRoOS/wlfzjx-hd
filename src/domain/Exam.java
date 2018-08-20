package domain;

public class Exam {
    //试卷编号

    private  int examId;
    //试卷名称

    private String examName;
    //试卷附件名称

    private  String attachment;
    //试卷附件原始名称

    private String examAttachmentOldName;
    //试卷上传时间

    private String uploadTime;
    //试卷是否删除

    private String del;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getExamAttachmentOldName() {
        return examAttachmentOldName;
    }

    public void setExamAttachmentOldName(String examAttachmentOldName) {
        this.examAttachmentOldName = examAttachmentOldName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }
    public String getDel() {
        return del;
    }
    public void setDel(String del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", attachment='" + attachment + '\'' +
                ", examAttachmentOldName='" + examAttachmentOldName + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", del='" + del + '\'' +
                '}';
    }
}
