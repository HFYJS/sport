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
		String sql = "select * from shoppingcart where uid=" + uid
				+ " order by cartid";

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

	public void updateShoppingCart(int cartid, int count) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		String sql = "update shoppingcart set count=" + count
				+ " where cartid=" + cartid;

		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	}

	public void deleteShoppingCartByCartid(int cartid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		String sql = "delete from shoppingcart where cartid=" + cartid;

		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteShoppingCartsByCartids(int[] cartids) {
		// TODO Auto-generated method stub
		for (int cartid : cartids) {
			deleteShoppingCartByCartid(cartid);
		}
	}

}
