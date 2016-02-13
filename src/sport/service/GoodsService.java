package sport.service;

import sport.dao.GoodsDao;
import sport.entity.Goods;

public class GoodsService {
	private GoodsDao dao = new GoodsDao();

	public GoodsService() {

	}

	public void add(Goods goods) {
		dao.add(goods);
	}
}
