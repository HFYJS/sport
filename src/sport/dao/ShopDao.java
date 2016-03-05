package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Shop;
import sport.service.CateService;
import sport.service.ShopService;
import sport.service.UserService;
import sport.util.DBConnection;

public class ShopDao {

	public ShopDao() {

	}

	public boolean hasUid(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String sql = "select uid from shop";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				if (rs.getInt(1) == uid) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return false;
	}

	public int getSidByUid(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		int sid = 0;
		String sql = "select sid from shop where uid=" + uid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				sid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sid;
	}

	public Shop getShopBySid(int sid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		Shop shop = null;
		String sql = "select * from shop where sid=" + sid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				shop = new Shop();
				shop.setSid(sid);
				shop.setUser(new UserService().getUserByUid(rs.getInt(2)));
				shop.setCate(new CateService().getCateByCatid(rs.getInt(3)));
				shop.setName(rs.getString(4));
				shop.setAddress(rs.getString(5));
				shop.setImgPath(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return shop;
	}

	public List<Shop> getAllShops() {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Shop> shops = new ArrayList<Shop>();
		String sql = "select sid from shop order by sid";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Shop shop = new ShopService().getShopBySid(rs.getInt(1));
				shops.add(shop);
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
		
		return shops;
	}
}
