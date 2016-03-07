package sport.service;

import java.util.List;

import sport.dao.UserHobbyDao;
import sport.entity.Hobby;

public class UserHobbyService {
	private UserHobbyDao dao = new UserHobbyDao();

	public List<Hobby> getAllHobbiesByUid(int uid) {
		return dao.getAllHobbiesByUid(uid);
	}

	public boolean updateHobbiesByUid(int uid, List<String> hobbies) {
		// TODO Auto-generated method stub
		return dao.updateHobbiesByUid(uid, hobbies);
	}

	public void deleteAllHobbiesByUid(int uid) {
		// TODO Auto-generated method stub
		dao.deleteAllHobbiesByUid(uid);
	}

	public void addHobbyByUid(int uid, int hobid) {
		// TODO Auto-generated method stub
		dao.addHobbyByUid(uid, hobid);
	}
}
