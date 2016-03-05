package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Goods;
import sport.service.GoodsService;
import sport.util.DBConnection;

public class GoodsFavoritesDao {

	public GoodsFavoritesDao() {

	}

	public List<Goods> getAllGoods(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Goods> goodses = new ArrayList<Goods>();
		String sql = "select gid from goods_favorites where uid=" + uid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new GoodsService().getGoodsByGid(rs.getInt(1));
				goodses.add(goods);
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

		return goodses;
	}
}
