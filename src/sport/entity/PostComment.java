package sport.entity;

import java.util.Date;

public class PostComment {
	private int p_comid;
	private Post post;
	private User user;
	private Date date;
	private String content;
	private PostComment postComment;
	private int isLast;

	public PostComment() {

	}

	public int getP_comid() {
		return p_comid;
	}

	public void setP_comid(int p_comid) {
		this.p_comid = p_comid;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public PostComment getPostComment() {
		return postComment;
	}

	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}

	public int getIsLast() {
		return isLast;
	}

	public void setIsLast(int isLast) {
		this.isLast = isLast;
	}

}
