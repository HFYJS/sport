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

	public Goods getGoodsByGid(int gid) {
		return dao.getGoodsByGid(gid);
	}

	public List<Goods> getAll() {
		return dao.getAll();
	}

	public void modify(Goods goods) {
		dao.modify(goods);
	}

	public void remove(int[] gids) {
		dao.remove(gids);
	}

	public List<Goods> getPagedGoodses(int curPage, int pageSize) {
		return dao.getPagedGoodses(curPage, pageSize);
	}

	public int getCount() {
		return dao.getCount();
	}
	
	public List<Goods> getAllGoodsBySid(int sid) {
		return dao.getAllGoodsBySid(sid);
	}
}
