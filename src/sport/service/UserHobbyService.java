package sport.service;

import java.util.List;

import sport.dao.UserHobbyDao;
import sport.entity.Hobby;

public class UserHobbyService {
	private UserHobbyDao dao = new UserHobbyDao();

	public List<Hobby> getAllHobbiesByUid(int uid) {
		return dao.getAllHobbiesByUid(uid);
	}
}
