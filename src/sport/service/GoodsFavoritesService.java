package sport.service;

import java.util.List;

import sport.dao.GoodsFavoritesDao;
import sport.entity.Goods;

public class GoodsFavoritesService {
	private GoodsFavoritesDao dao = new GoodsFavoritesDao();

	public List<Goods> getAllGoods(int uid) {
		return dao.getAllGoods(uid);
	}
}
