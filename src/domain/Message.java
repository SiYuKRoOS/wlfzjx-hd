package domain;

/**
 * @author kroos
 */
public class Message {
	//留言编号

	private int messageId;
	//留言内容

	private String content;
	//留言时间

	private String leaveWordTime;
	//当前登录在系统中的学生的编号

	private int stuId;
	//老师的回复内容

	private String replay;
	//老师的回复时间

	private String replayTime;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLeaveWordTime() {
		return leaveWordTime;
	}
	public void setLeaveWordTime(String leaveWordTime) {
		this.leaveWordTime = leaveWordTime;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getReplay() {
		return replay;
	}
	public void setReplay(String replay) {
		this.replay = replay;
	}
	public String getReplayTime() {
		return replayTime;
	}
	public void setReplayTime(String replayTime) {
		this.replayTime = replayTime;
	}
	
	
}
