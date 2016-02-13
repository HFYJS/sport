package sport.entity;

public class PostFavorites {
	private User user;
	private Post post;

	public PostFavorites() {

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
