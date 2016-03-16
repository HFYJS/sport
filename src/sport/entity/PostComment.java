package sport.entity;

import java.util.Date;

public class PostComment {
	private int pComid;
	private int pid;
	private int uid;
	private Date date;
	private String content;
	private int prePComid;
	private int isLast;

	public PostComment() {

	}

	public int getpComid() {
		return pComid;
	}

	public void setpComid(int pComid) {
		this.pComid = pComid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrePComid() {
		return prePComid;
	}

	public void setPrePComid(int prePComid) {
		this.prePComid = prePComid;
	}

	public int getIsLast() {
		return isLast;
	}

	public void setIsLast(int isLast) {
		this.isLast = isLast;
	}

}
