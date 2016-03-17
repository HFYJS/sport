package sport.iter;

import sport.entity.User;

public interface Login {
	public int login(String name, String pwd);
	
	public User userlogin(String name, String pwd);
}
