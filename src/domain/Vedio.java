package domain;

public class Vedio {
	//视频编号

	private int vedioId;
	//视频名称

	private String vedioName;
	//视频简介

	private String vedioIntro;
	//视频附件名称

	private String vedioAttachment;
	//视频附件原始名称

	private String attachmentOldName;
	//视频上传时间

	private String uploadTime;
	//视频是否删除

	private String del;

	public int getVedioId() {
		return vedioId;
	}
	public void setVedioId(int vedioId) {
		this.vedioId = vedioId;
	}
	public String getVedioName() {
		return vedioName;
	}
	public void setVedioName(String vedioName) {
		this.vedioName = vedioName;
	}

	public String getVedioIntro() {
		return vedioIntro;
	}

	public void setVedioIntro(String vedioIntro) {
		this.vedioIntro = vedioIntro;
	}

	public String getVedioAttachment() {
		return vedioAttachment;
	}
	public void setVedioAttachment(String vedioAttachment) {
		this.vedioAttachment = vedioAttachment;
	}
	public String getAttachmentOldName() {
		return attachmentOldName;
	}
	public void setAttachmentOldName(String attachmentOldName) {
		this.attachmentOldName = attachmentOldName;
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
		return "Vedio [vedioId=" + vedioId + ", vedioName=" + vedioName + ", vedioIntro=" + vedioIntro
				+ ", vedioAttachment=" + vedioAttachment + ", attachmentOldName=" + attachmentOldName + ", uploadTime="
				+ uploadTime + ", del=" + del + "]";
	}
	
	
}
