package sport.service;

import java.util.List;

import sport.dao.ShoppingCartDao;
import sport.entity.ShoppingCart;

public class ShoppingCartService {
	private ShoppingCartDao dao = new ShoppingCartDao();

	public ShoppingCartService() {

	}

	public List<ShoppingCart> getShoppingCartByUid(int uid) {
		// TODO Auto-generated method stub
		return dao.getShoppingCartByUid(uid);
	}

}
