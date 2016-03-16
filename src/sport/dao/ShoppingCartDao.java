package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sport.entity.ShoppingCart;
import sport.util.DBConnection;

public class ShoppingCartDao {

	public ShoppingCartDao() {

	}

	public List<ShoppingCart> getShoppingCartByUid(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
		String sql = "select * from shoppingcart where uid=" + uid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setCartid(rs.getInt(1));
				shoppingCart.setUid(uid);
				shoppingCart.setGid(rs.getInt(3));
				shoppingCart.setCount(rs.getInt(4));
				shoppingCart.setDate(new Date(rs.getDate(5).getTime()));
				shoppingCarts.add(shoppingCart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}

		return shoppingCarts;
	}

}
