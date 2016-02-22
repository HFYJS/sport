package sport.service;

import sport.dao.UserDao;
import sport.entity.User;
import sport.iter.Login;

public class UserService implements Login {
	private UserDao dao = new UserDao();

	// -1：无此用户 -2：密码错误 1：登录成功
	@Override
	public int login(String name, String pwd) {
		User user = getUserByName(name);
		if (!(user.getName().equals(name))) {
			return -1;
		}
		if (!(user.getPassword().equals(pwd))) {
			return -2;
		}
		return 1;
	}

	public int getUidByName(String name) {
		return dao.getUidByName(name);
	}

	public User getUserByName(String name) {
		return dao.getUserByName(name);
	}

	public User getUserByUid(int uid) {
		return dao.getUserByUid(uid);
	}

}