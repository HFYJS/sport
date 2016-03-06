package sport.service;

import java.util.List;

import sport.dao.GoodsFavoritesDao;
import sport.entity.Goods;

public class GoodsFavoritesService {
	private GoodsFavoritesDao dao = new GoodsFavoritesDao();

	public List<Goods> getAllGoodsesByUid(int uid) {
		return dao.getAllGoodsesByUid(uid);
	}
}
