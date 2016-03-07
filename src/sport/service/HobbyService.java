package sport.service;

import java.util.List;

import sport.dao.HobbyDao;
import sport.entity.Hobby;

public class HobbyService {
	private HobbyDao dao = new HobbyDao();

	public Hobby getHobbyByHobid(int hobid) {
		return dao.getHobbyByHobid(hobid);
	}

	public int getHobidByName(String hobby) {
		// TODO Auto-generated method stub
		return dao.getHobidByName(hobby);
	}

	public List<Hobby> getAllHobbies() {
		// TODO Auto-generated method stub
		return dao.getAllHobbies();
	}
}
