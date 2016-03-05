package sport.service;

import java.util.List;

import sport.dao.ShopDao;
import sport.entity.Shop;
import sport.iter.Login;

public class ShopService implements Login {
	private ShopDao dao = new ShopDao();

	public ShopService() {

	}

	// -1：无此用户 -2：不是商家用户 -3：密码错误 1：登录成功
	@Override
	public int login(String name, String pwd) {
		// 1.user中查有无此name 无：没有这个用户，return -1 有：return uid
		UserService userService = new UserService();
		int uid;
		if ((uid = userService.getUidByName(name)) == -1) {
			return -1;
		}

		// 2.shop中查有无此uid 无：此用户不是商家用户,return false 有：return true
		if (!dao.hasUid(uid)) {
			return -2;
		}

		// 3.user中查密码是否匹配 是：return true 否：return false
		if (!(userService.login(name, pwd) == 1)) {
			return -3;
		}
		return 1;
	}

	public int getSidByUid(int uid) {
		return dao.getSidByUid(uid);
	}

	public Shop getShopBySid(int sid) {
		return dao.getShopBySid(sid);
	}

	public List<Shop> getAllShops() {
		return dao.getAllShops();
	}
}
