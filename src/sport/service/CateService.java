package sport.service;

import java.util.List;

import sport.dao.CateDao;
import sport.entity.Cate;

public class CateService {
	private CateDao dao = new CateDao();

	public List<Cate> search() {
		return dao.search();
	}

	public String getNameByCateid(int catid) {
		return dao.getNameByCatid(catid);
	}
}
