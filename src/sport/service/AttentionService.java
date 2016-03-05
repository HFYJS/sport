package sport.service;

import java.util.List;

import sport.dao.AttentionDao;
import sport.entity.User;

public class AttentionService {
	private AttentionDao dao = new AttentionDao();

	public List<User> getAllFans(int aid) {
		return dao.getAllFans(aid);
	}
}
