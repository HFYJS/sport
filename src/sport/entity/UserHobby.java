package sport.entity;

public class UserHobby {
	private int u_hid;
	private User user;
	private Hobby hobby;

	public UserHobby() {

	}

	public int getU_hid() {
		return u_hid;
	}

	public void setU_hid(int u_hid) {
		this.u_hid = u_hid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

}
