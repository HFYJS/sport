package sport.service;

import java.util.List;

import sport.dao.GoodsDao;
import sport.entity.Goods;

public class GoodsService {
	private GoodsDao dao = new GoodsDao();

	public GoodsService() {

	}

	public void add(Goods goods) {
		dao.add(goods);
	}

	public List<Goods> getAll() {
		return dao.getAll();
	}
}