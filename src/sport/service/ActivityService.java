package sport.service;

import java.util.List;

import sport.dao.ActivityDao;
import sport.entity.Activity;

public class ActivityService {
	private ActivityDao dao = new ActivityDao();

	public List<Activity> search() {
		return dao.search();
	}

	public Activity getActivityByActid(int actId) {
		return dao.getActivityByActid(actId);
	}
}
