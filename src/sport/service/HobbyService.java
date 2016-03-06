package sport.service;

import sport.dao.HobbyDao;
import sport.entity.Hobby;

public class HobbyService {
	private HobbyDao dao = new HobbyDao();

	public Hobby getHobbyByHobid(int hobid) {
		return dao.getHobbyByHobid(hobid);
	}
}
